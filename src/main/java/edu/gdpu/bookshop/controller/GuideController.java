package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.bean.BsUser;
import edu.gdpu.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GuideController {

    @Resource
    private UserService userService;

    @RequestMapping("/toUserLogin")
    public String toLogin(){
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
    public String toBookShop(){
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
}
