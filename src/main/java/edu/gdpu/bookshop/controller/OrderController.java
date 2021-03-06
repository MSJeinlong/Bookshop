package edu.gdpu.bookshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.gdpu.bookshop.entity.*;
import edu.gdpu.bookshop.service.BookService;
import edu.gdpu.bookshop.service.MyCartService;
import edu.gdpu.bookshop.service.OrderService;
import edu.gdpu.bookshop.utils.KeyUtil;
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
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private MyCartService myCartService;

    @Resource
    private BookService bookService;

    @RequestMapping("/toMyOrder")
    public String toMyOrder(HttpSession session){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        //判断用户是否登录
        if(user == null){
            session.setAttribute("loginToStatus", 2);
            return "userLogin";
        } else {
            //读出全部订单
            List<OrderMaster> orderMasterList = orderService.findOrderMasterByUserId(user.getUserId());
            session.setAttribute("orderMasterList", orderMasterList);
            //全部订单数
            session.setAttribute("countAllOrder", (long)orderMasterList.size());
            //待支付订单数
            long countUnpaid = orderService.countUnpaidOrder(user.getUserId());
            //待发货订单数
            long countUnDelivery = orderService.countUnDelivery(user.getUserId());
            //待收货订单数
            long countUnreceived = orderService.countUnreceived(user.getUserId());
            //已收货订单数
            long countReceived = orderService.countReceived(user.getUserId());

            session.setAttribute("countUnPaid", countUnpaid);
            session.setAttribute("countUnDelivery", countUnDelivery);
            session.setAttribute("countUnReceived", countUnreceived);
            session.setAttribute("countReceived", countReceived);

            return "myOrder";
        }
    }

    /*把购物车的商品转为新订单*/
    @RequestMapping("/myCartToOrder")
    public String confirmMyOrder(Model model, HttpSession session, String address, String payWay){
        //读出用户的信息
        BsUser user = (BsUser)session.getAttribute("bsUser");
        //设置 orderMaster
        BigDecimal totalPrice = (BigDecimal)session.getAttribute("totalPrice");     //读出总额
        OrderMaster orderMaster = new OrderMaster();
        //设置唯一orderId
        String orderId = KeyUtil.genUniqueKey();
        orderMaster.setOrderId(orderId);
        orderMaster.setUserId(user.getUserId());
        orderMaster.setUserName(user.getNickname());
        orderMaster.setUserPhone(user.getCellphone());
        orderMaster.setUserAddress(address);
        orderMaster.setTotalPrice(totalPrice);
        //订单状态默认为新下单未支付
        orderMaster.setOrderStatus((byte)0);
        orderMaster.setPayWay(Byte.valueOf(payWay));
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        //保存 orderMaster
        orderService.addOrderMaster(orderMaster);

        //读出用户的订单信息
        List<MyCart> readyOrders = (List<MyCart>)session.getAttribute("readyOrders");
        List<Integer> ids = new ArrayList<>();
        //设置orderDetail
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (MyCart order: readyOrders) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setBookId(order.getBookId());
            orderDetail.setBookName(order.getBookName());
            orderDetail.setBookPrice(order.getBookPrice());
            orderDetail.setBookImage(order.getBookImage());
            //扣库存
            if(bookService.decreaseNumbers(order.getBookId(), order.getBookAmount()) == false){
                //库存不足，
                model.addAttribute("orderTips", "抱歉，《"+order.getBookName()+"》库存不足!");
                return "toMyCart";
            }
            orderDetail.setAmount(order.getBookAmount());
            orderDetail.setCreateTime(new Date());
            orderDetail.setUpdateTime(new Date());
            orderDetailList.add(orderDetail);
            ids.add(order.getCartId());
        }
        //把 orderDetailList保存到数据库
        orderService.addOrderDetailList(orderDetailList);

        //同时删除相关的购物车记录
        myCartService.deleteByCartIds(user.getUserId(), ids);
        Long cartCount = (Long)session.getAttribute("cartCount");
        cartCount -= ids.size();
        Long countAllOrder = (Long)session.getAttribute("countAllOrder");
        //订单数加1
        countAllOrder += 1;

        //更新购物车记录数和我的订单记录数
        session.setAttribute("cartCount", cartCount);
        session.setAttribute("countAllOrder", countAllOrder);

        session.setAttribute("orderMaster", orderMaster);
        //session.setAttribute("orderDetailList", orderDetailList);
        //session.removeAttribute("readyOrders");
        model.addAttribute("orderMasterID", orderMaster.getOrderId());
        return "confirmPayPassword";
    }

    @RequestMapping("/updateOrderStatus")
    public String updateOrderStatus(Model model, HttpSession session, String orderId, String orderStatus){
        //OrderMaster orderMaster = (OrderMaster)session.getAttribute("orderMaster");
        BsUser user = (BsUser)session.getAttribute("bsUser");
        OrderMaster orderMaster = orderService.findOrderMasterByOrderId(orderId);
        orderMaster.setOrderStatus(Byte.valueOf(orderStatus));
        orderMaster.setUpdateTime(new Date());
        //保存更新信息到数据库
        orderService.updateOrderMaster(orderMaster);

        //读出全部订单

        List<OrderMaster> orderMasterList = orderService.findOrderMasterByUserId(user.getUserId());
        session.setAttribute("orderMasterList", orderMasterList);
        //全部订单数
        session.setAttribute("countAllOrder", (long)orderMasterList.size());
        //待支付订单数
        long countUnpaid = orderService.countUnpaidOrder(user.getUserId());
        //待发货订单数
        long countUnDelivery = orderService.countUnDelivery(user.getUserId());
        //待收货订单数
        long countUnreceived = orderService.countUnreceived(user.getUserId());
        //已收货订单数
        long countReceived = orderService.countReceived(user.getUserId());

        session.setAttribute("countUnPaid", countUnpaid);
        session.setAttribute("countUnDelivery", countUnDelivery);
        session.setAttribute("countUnReceived", countUnreceived);
        session.setAttribute("countReceived", countReceived);

        if(orderStatus.equals("1")){
            model.addAttribute("updateOrderTips", "订单支付成功！");
        } else if(orderStatus.equals("3")){
            model.addAttribute("updateOrderTips", "确认收货成功！");
        } else if(orderStatus.equals("4")){
            model.addAttribute("updateOrderTips", "评价成功！");
        }
        return "myOrder";
    }

    /*查看订单详情，role: 用户或管理员*/
    @RequestMapping("/toOrderDetail")
    public String toOrderDetail(HttpSession session, String orderId, String role){
        OrderMaster orderMaster = orderService.findOrderMasterByOrderId(orderId);
        List<OrderDetail> orderDetailList = orderService.findOrderDetailByOrderId(orderId);
        session.setAttribute("thisOrder", orderMaster);
        session.setAttribute("orderDetailList", orderDetailList);
        session.setAttribute("role", Integer.valueOf(role));
        return "orderDetail";
    }

    @RequestMapping("/confirmDelivery")
    public String confirmDelivery(HttpSession session,  Model model, String orderId, String password){
        Admin admin = (Admin) session.getAttribute("admin");
        if(!admin.getPassword().equals(password)){
            model.addAttribute("deliveryTips", "密码错误！");
            session.setAttribute("nav_link", 1);
            return "adminManage";
        }
        else{
            List<OrderMaster> orderMasterList = (List<OrderMaster>)session.getAttribute("orderMasterList");
            for (OrderMaster order: orderMasterList) {
                if(order.getOrderId().equals(orderId)){
                    order.setOrderStatus((byte)2);
                    order.setUpdateTime(new Date());
                    orderService.updateOrderMaster(order);
                    break;
                }
            }
            session.setAttribute("orderMasterList", orderMasterList);
            session.setAttribute("nav_link", 1);
            return "adminManage";
        }
    }

    @RequestMapping("/toOrderPage")
    public String toFirstOrder(HttpSession session, String pageNum){
        String orderId = (String)session.getAttribute("orderId");
        String userName = (String)session.getAttribute("userName");
        if(orderId == null)
            orderId = "";
        if(userName == null)
            userName = "";
        Integer num = Integer.valueOf(pageNum);
        List<OrderMaster> orderMasterList = orderService.findByUnameOrderId(userName, orderId, num);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderMasterList);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("nav_link", 1);
        session.setAttribute("pageNum", num);
        return "adminManage";
    }

    @RequestMapping("/adminUpdateOrder")
    public String adminUpdateOrder(HttpSession session, Model model, String orderId){
        Integer pageNum = (Integer)session.getAttribute("pageNum");
        if(pageNum == null){
            pageNum = 1;
        }
        OrderMaster order = orderService.findOrderMasterByOrderId(orderId);
        order.setOrderStatus((byte)2);
        order.setUpdateTime(new Date());
        orderService.updateOrderMaster(order);
        PageHelper.startPage(pageNum, 10);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderService.findAllOrder());
       // pageInfo_orders.getTotal();
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        model.addAttribute("updateOrderTips", "发货成功！");
        session.setAttribute("nav_link", 1);
        return "adminManage";
    }

    @RequestMapping("/findByOrderIdAndUserName")
    public String findByOrderAndUserName(HttpSession session, String orderId, String userName){
        Integer pageSize = (Integer)session.getAttribute("pageSize");
        Integer pageNum = (Integer)session.getAttribute("pageNum");
        List<OrderMaster> orderMasterList = orderService.findByUnameOrderId(userName, orderId, pageNum);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderMasterList);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("orderId", orderId);
        session.setAttribute("userName", userName);
        session.setAttribute("nav_link", 1);
        return "adminManage";
    }

    @RequestMapping("/allOrders")
    public String allOrders(HttpSession session){
        PageHelper.startPage(1, 10);
        List<OrderMaster> orderMasterList = orderService.findAllOrder();
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderMasterList);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("pills_nav_link_actived", 1);
        session.setAttribute("nav_link", 1);

        return "adminManage";
    }

    @RequestMapping("/findUnpaidOrder")
    public String findUnpaidOrder(HttpSession session){
        String orderId = (String)session.getAttribute("orderId");
        String userName = (String)session.getAttribute("userName");
        if(orderId == null){
            orderId = "";
        }
        if(userName == null)
            userName = "";
        List<OrderMaster> orderUnpaid = orderService.findOrderUnpaid(userName, orderId, 1);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderUnpaid);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("pills_nav_link_actived", 2);
        session.setAttribute("pageNum", 1);
        session.setAttribute("nav_link", 1);
        return "adminManage";
    }

    @RequestMapping("/findUnDeliveryOrder")
    public String findUnDeliveryOrder(HttpSession session){
        String orderId = (String)session.getAttribute("orderId");
        String userName = (String)session.getAttribute("userName");
        if(orderId == null){
            orderId = "";
        }
        if(userName == null)
            userName = "";
        //PageHelper.startPage(pageNum, pageSize);
        List<OrderMaster> orderUnpaid = orderService.findOrderUnDelivery(userName, orderId, 1);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderUnpaid);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("pills_nav_link_actived", 3);
        session.setAttribute("nav_link", 1);
        session.setAttribute("pageNum", 1);
        return "adminManage";
    }

    @RequestMapping("/findUnReceivedOrder")
    public String findUnReceivedOrder(HttpSession session){
        String orderId = (String)session.getAttribute("orderId");
        String userName = (String)session.getAttribute("userName");
        if(orderId == null){
            orderId = "";
        }
        if(userName == null)
            userName = "";
        List<OrderMaster> orderUnpaid = orderService.findOrderUnReceived(userName, orderId, 1);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderUnpaid);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("pills_nav_link_actived", 4);
        session.setAttribute("pageNum", 1);
        session.setAttribute("nav_link", 1);
        return "adminManage";
    }

    @RequestMapping("/OrderByTime")
    public String OrderByTime(HttpSession session){
        String orderId = (String)session.getAttribute("orderId");
        String userName = (String)session.getAttribute("userName");
        if(orderId == null){
            orderId = "";
        }
        if(userName == null)
            userName = "";
        //PageHelper.startPage(pageNum, pageSize);
        List<OrderMaster> orderMasterList = orderService.findOrderByTime(userName, orderId, 1);
        PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(orderMasterList);
        session.setAttribute("pageInfo_orders", pageInfo_orders);
        session.setAttribute("pills_nav_link_actived", 5);
        session.setAttribute("pageNum", 1);
        session.setAttribute("nav_link", 1);
        return "adminManage";
    }
}
