package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.entity.OrderMaster;
import edu.gdpu.bookshop.service.BookService;
import edu.gdpu.bookshop.service.OrderService;
import edu.gdpu.bookshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GuideController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

    @Resource
    private OrderService orderService;

    @RequestMapping("/toUserLogin")
    public String toLogin(HttpSession session){
        session.setAttribute("loginToStatus", 0);
        return "userLogin";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toClause")
    public String toClause(){
        return "clause";
    }

    @RequestMapping("/toAddress")
    public String toAddress(){
        return "address";
    }

    @RequestMapping("/toBookshop")
    public String toBookShop(HttpSession session){
        List<Book> books = bookService.findAllBooks();
        //销量排行前10
        List<Book> salesSort = books.stream().sorted(Comparator.comparing(Book::getSales)).collect(Collectors.toList());
        List<Book> salesTop10 = new ArrayList<>();
        for (int i = 0; i < 10 && i < salesSort.size(); i++)
            salesTop10.add(salesSort.get(i));
        //最新上架前10
        List<Book> newSort = books.stream().sorted(Comparator.comparing(Book::getCreateTime).reversed()).collect(Collectors.toList());
        List<Book> newTop10 = new ArrayList<>();
        for (int i = 0; i < 10 && i < newSort.size(); i++) {
            newTop10.add(newSort.get(i));
        }
        session.setAttribute("books", books);
        session.setAttribute("salesTop10", salesTop10);
        session.setAttribute("newTop10", newTop10);
        session.setAttribute("activeCode", 0);
        return "bookshop";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(HttpSession session){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        //用户没登录
        if(user == null)
            return "userLogin";
        else
            return "userInfo";
    }

    @RequestMapping("/toTest")
    public String toTest(){
        return "test";
    }

    @RequestMapping("/toTest1")
    public String toTest1(){
        return "test1";
    }

    @RequestMapping("/findAllUsers")
    @ResponseBody
    public List<BsUser> findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping("/toUpdateUserPassword")
    public String toUpdateUserPassword(){
        return "updateUserPasswd";
    }

    @RequestMapping("/toUpdateAddress")
    public String toUpdateAddress(){
        return "updateUserAddress";
    }

    @RequestMapping("/toAddBookCategory")
    public String toAddBookCategory(){
        return "addBookCategory";
    }

    @RequestMapping("/toAdminManage")
    public String toAdminManage(){
        return "adminManage";
    }

    @RequestMapping("/toAdminLogin")
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(HttpSession session){
        //查找所有的图书类型
        List<BookCategory> bookCategories = bookService.findAllBookcategorys();
        session.setAttribute("bookCategories", bookCategories);
        session.setAttribute("nav_link", 2);
        return "addBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(HttpSession session, String bookId){
        Book book = bookService.findBookByBookId(Integer.valueOf(bookId));
        //查找所有的图书类型
        List<BookCategory> bookCategories = bookService.findAllBookcategorys();
        session.setAttribute("bookCategories", bookCategories);
        session.setAttribute("book", book);
        session.setAttribute("nav_link", 2);
        return "updateBookInfo";
    }

    @RequestMapping("/switchNavLink")
    public String switchNavLink(HttpSession session, String nav_link){
        Integer nav_link_actived = Integer.valueOf(nav_link);
        session.setAttribute("nav_link", nav_link_actived);
        return "adminManage";
    }

    @RequestMapping("/buyNowOrAdd2Cart")
    public String buyNowOrAdd2Cart(HttpSession session, String isBuyNow){

        //判断用户是否已经登录
        BsUser user = (BsUser)session.getAttribute("bsUser");

        //用户未登录，跳转到登录页面
        if(user == null){
            session.setAttribute("loginToStatus", 3);
            logger.info("用户尚未登录");
            return "userLogin";
        }
        //表示用户加入购物车
        if(isBuyNow.equals("0")){
           // return "/addToMyCart?bookId="+bookId+"&amount="+amount+"&flag="+flag;
            return "/addToMyCart";
        }
        //表示用户立即购买
        else {
            return "buyNow";
        }
    }

    @RequestMapping("/toUserInfoAdmin")
    public String adminUserInfo(HttpSession session, String userId){
        Integer uid = Integer.valueOf(userId);
        BsUser user = userService.findUserById(uid);
        //根据userId 拿到用户的订单数据
        List<OrderMaster> userOrders = orderService.findOrderMasterByUserId(uid);
        session.setAttribute("userOrders", userOrders);
        session.setAttribute("bsUser", user);
        session.setAttribute("nav_link", 3);
        return "userInfoAdmin";
    }
}
