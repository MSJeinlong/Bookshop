package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.entity.MyCart;
import edu.gdpu.bookshop.service.BookService;
import edu.gdpu.bookshop.service.MyCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MyCartController {

    @Resource
    private MyCartService myCartService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BookService bookService;

    @RequestMapping("/toMyCart")
    public String toMyCart(HttpSession session){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        session.setAttribute("loginToStatus", 1);
        //查看购物车前，判断用户是否已经登录
        if(user == null){
            return "userLogin";
        }
        else {
            //读出用户的购物车记录
            List<MyCart> myCartList = myCartService.findMyCartByUserId(user.getUserId());
            //检查库存
            for (MyCart myCart: myCartList) {
               if (bookService.isNumbersEnough(myCart.getBookId(), myCart.getBookAmount()))
                   myCart.setStatus((byte)1);
               else
                   myCart.setStatus((byte)0);
            }
            session.setAttribute("myCartList", myCartList);
            return "myCart";
        }
    }

    /*添加商品到购物车*/
    @RequestMapping("/addToMyCart")
    public String addToMyCart(Model model, HttpSession session, String bookId, String amount, String flag){

        //检查用户是否已经登录
        BsUser user = (BsUser)session.getAttribute("bsUser");
        //如果用户未登录，则让用户先登录
        if(user == null){
            return "userLogin";
        }
        Integer bid = Integer.valueOf(bookId);
        Integer am = Integer.valueOf(amount);
        //先检查购物车有无该商品
        MyCart myCart = myCartService.findMyCartByBookId(user.getUserId(), bid);
        //原购物车已经添加过该商品，只需将商品数量加 1
        if(myCart != null){
            myCart.setBookAmount(myCart.getBookAmount() + am);
            //设置更新时间
            myCart.setUpdateTime(new Date());
            myCartService.updateMyCart(myCart);
        } else {
            //原购物车中没有添加过该商品
            myCart = new MyCart();
            myCart.setUserId(user.getUserId());
            //拿到商品信息
            Book book = bookService.findBookByBookId(bid);
            myCart.setBookId(bid);
            myCart.setBookName(book.getBookName());
            myCart.setBookImage(book.getImage());
            myCart.setBookPrice(book.getPrice());
            myCart.setBookAmount(am);
            myCart.setStatus((byte)1);
            myCart.setCreateTime(new Date());
            myCart.setUpdateTime(new Date());

            myCartService.addToMyCart(myCart);
        }
        //更新购物车记录数
        long cartCount = myCartService.getCartCount(user.getUserId());
        session.setAttribute("cartCount", cartCount);
        model.addAttribute("addToMyCartTips", "商品已成功加入购物车！");
        //根据flag 判断跳转到哪个页面
        if(flag.equals("1")) {
            return "bookshop";
        } else {
            return "bookInfo";
        }
    }

    /*根据userId 和 bookName查询购物车记录*/
    @RequestMapping("/findMyCartByBookName")
    public String findMyCartByBookName(HttpSession session,  String bookName){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        List<MyCart> myCartList = myCartService.findMyCartByBookName(user.getUserId(), bookName);
        session.setAttribute("myCartList", myCartList);
        session.setAttribute("cartCount", myCartList.size());
        return "myCart";
    }

    @RequestMapping("/clearMyCart")
    public String clearMyCart(Model model, HttpSession session){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        boolean res = myCartService.deleteAllByUserId(user.getUserId());
        //model.addAttribute("deleteMyCartTips", "已清空购物车的商品！");
        logger.info("全部清空购物车结果：", res);
        List<MyCart> myCartList = myCartService.findMyCartByUserId(user.getUserId());
        session.setAttribute("myCartList", myCartList);
        session.setAttribute("cartCount", myCartList.size());

        return "myCart";
    }

    @RequestMapping("/deleteMyCart")
    public String deleteMyCart( HttpSession session,  String cartIds){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        String [] ctIds = cartIds.split(",");
        List<Integer> ids = new ArrayList<>();
        for(int i = 0; i < ctIds.length; i++){
             ids.add(Integer.valueOf(ctIds[i]));
            /*System.out.printf(ctIds[i]+" ");*/
        }
        logger.info("删除的ids:{}", ids);
       /* System.out.println();*/
        myCartService.deleteByCartIds(user.getUserId(), ids);
        //model.addAttribute("deleteMyCartTips", "已成功删除选中的商品！");
        List<MyCart> myCartList = myCartService.findMyCartByUserId(user.getUserId());
        session.setAttribute("myCartList", myCartList);
        session.setAttribute("cartCount", myCartList.size());
        return "myCart";
    }

    //根据 cartIds, amount 进行结算
    @RequestMapping("/settlement")
    public String settlement(HttpSession session, String cartIds){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        /*准备下单的 ids */
        String [] ctIds = cartIds.split(",");
        List<Integer> ids = new ArrayList<>();
        for(int i = 0; i < ctIds.length; i++){
            ids.add(Integer.valueOf(ctIds[i]));
            /*System.out.printf(ctIds[i]+" ");*/
        }
        logger.info("准备下单的ids:{}", ids);
        List<MyCart> readyOrders = myCartService.findMyCartByCartIds(user.getUserId(), ids);
        /*计算总金额*/
        BigDecimal totalPrice = new BigDecimal(0.00);
        for (MyCart order: readyOrders) {
            BigDecimal multi = (order.getBookPrice().multiply(new BigDecimal(order.getBookAmount())));
            totalPrice = totalPrice.add(multi);
            System.out.println("multi="+multi+", totalPrice="+totalPrice);
        }
        logger.info("订单总额：", totalPrice);
        logger.info("订单列表：{}", readyOrders);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("readyOrders", readyOrders);
        return "confirmOrderInfo";
    }

    /*用户立即购买*/
    @RequestMapping("/buyNow")
    public String buyNow(HttpSession session, String bookId, String amount){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        Integer bid = Integer.valueOf(bookId);
        Book book = bookService.findBookByBookId(bid);

        MyCart myCart = new MyCart();
        myCart.setUserId(user.getUserId());
        myCart.setBookId(bid);
        myCart.setBookName(book.getBookName());
        myCart.setBookImage(book.getImage());
        myCart.setBookPrice(book.getPrice());
        myCart.setBookAmount(Integer.valueOf(amount));
        myCart.setStatus((byte)1);
        myCart.setCreateTime(new Date());
        myCart.setUpdateTime(new Date());

        //准备下单的orders
        List<MyCart> readyOrders = new ArrayList<>();
        readyOrders.add(myCart);
        //计算总额
        BigDecimal totalPrice = myCart.getBookPrice().multiply(new BigDecimal(myCart.getBookAmount()));
        logger.info("订单总额：", totalPrice);
        logger.info("订单列表：{}", readyOrders);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("readyOrders", readyOrders);
        return "confirmOrderInfo";
    }
}
