package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Admin;
import edu.gdpu.bookshop.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

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
        return "adminLogin";
    }
}
