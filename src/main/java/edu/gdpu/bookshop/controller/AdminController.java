package edu.gdpu.bookshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.gdpu.bookshop.entity.*;
import edu.gdpu.bookshop.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private BookService bookService;

    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private BookCategoryService bookCategoryService;

    @RequestMapping("/loginAdmin")
    public String loginAdmin(Model model, HttpSession session, String adminName, String password) {
        Admin admin = adminService.findAdmin(adminName, password);
        if (admin == null) {
            //登录失败
            model.addAttribute("adminLoginTips", "账号或密码错误!");
            return "adminLogin";
        } else{
            //model.addAttribute("adminLoginTips", "登录成功！");
            //登录成功
            admin.setLoginStatus(true);
            admin.setLastestLoginTime(new Date());
            //更新管理员登录时间
            adminService.updateAdmin(admin);

            //获取所有的订单数据
            PageHelper.startPage(1, 10);
            List<OrderMaster> admin_orderList = orderService.findAllOrder();
            PageInfo<OrderMaster> pageInfo_orders = new PageInfo<>(admin_orderList);
            session.setAttribute("pageInfo_orders", pageInfo_orders);
            session.setAttribute("nav_link", 1);
            session.setAttribute("pageNum", 1);
            session.setAttribute("pageSize", 10);
            session.setAttribute("pills_nav_link_actived", 1);


            //获取所有的商品数据
            PageHelper.startPage(1, 10);
            List<Book> bookList = bookService.findAllBooks();
            PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
            session.setAttribute("pageInfo_books", pageInfo_books);
            session.setAttribute("book_pageNum", 1);
            session.setAttribute("book_pagSize", 10);

            //获取所有的商品类目
            List<BookCategory> bookCategoryList = bookCategoryService.findAllBookCategories();

            //获取所有的用户数据
            PageHelper.startPage(1, 10);
            List<BsUser> userList = userService.findAllUsers();
            PageInfo<BsUser> pageInfo_users = new PageInfo<>(userList);
            session.setAttribute("pageInfo_users", pageInfo_users);
            session.setAttribute("user_pageNum", 1);
            session.setAttribute("admin", admin);
            return "adminManage";
        }
    }

    @RequestMapping("/adminExit")
    public String adminExit(HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        admin.setLoginStatus(false);
        admin.setSignOutTime(new Date());
        adminService.updateAdmin(admin);
        session.removeAttribute("admin");
        session.removeAttribute("pageInfo_orders");
        session.removeAttribute("pageInfo_books");
        session.removeAttribute("pageInfo_users");
        session.removeAttribute("pageNum");
        session.removeAttribute("book_pageNum");
        session.removeAttribute("user_pageNum");
        session.removeAttribute("nav_link");
        session.removeAttribute("pills_nav_link_actived");
        return "adminLogin";
    }
}
