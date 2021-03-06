package edu.gdpu.bookshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.service.MyCartService;
import edu.gdpu.bookshop.service.OrderService;
import edu.gdpu.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private MyCartService myCartService;

    @Resource
    private OrderService orderService;

    //用户登录
    //status: 表示登录后要跳转到的页面, 默认跳转到bookshop, 1-到购物车，2-到我的订单，3-到图书bookInfo
    @RequestMapping("/loginUser")
    public String loginUser(Model model, HttpSession session, String userName, String password){
        Integer loginToStatus = (Integer) session.getAttribute("loginToStatus");
        session.removeAttribute("loginToStatus");
        BsUser bsUser = null;
        //1.先根据手机号码和密码查询
        bsUser = userService.findUserByCellphone(userName, password);
       // System.out.printf(bsUser.toString());
        //2.根据手机号码和密码查询失败，再根据邮箱和密码查询用户
        if(bsUser == null)
            bsUser = userService.findUserByEmail(userName, password);
        //3.根据邮箱和密码查询用户失败，最后根据用户昵称和密码用户
        if(bsUser == null)
            bsUser = userService.findUserByNickName(userName, password);
        //3次查询都无法查找该用户，
        if(bsUser == null){
            model.addAttribute("loginTips", "账号或密码错误!");
            //返回到登录页面
            return "toUserLogin";
        } else {
            //查询用户成功，即登录成功
            //更新用户登录状态
            bsUser.setLoginTime(new Date());
            bsUser.setStatus((byte)1);
            userService.updateUser(bsUser);
            session.setAttribute("bsUser", bsUser);
           // System.out.printf(bsUser.toString());
            //model.addAttribute("loginTips", "登录成功！");
            //计算用户购物车记录数
            long cartCount = myCartService.getCartCount(bsUser.getUserId());
            session.setAttribute("cartCount", cartCount);
            //计算用户订单数
            long countOrder = orderService.countAllOrder(bsUser.getUserId());
            session.setAttribute("countAllOrder", countOrder);
            if(loginToStatus == null){
                return "toBookshop";
            }
            else if(loginToStatus == 1){
                return "toMyCart";
            } else if(loginToStatus == 2){
                return "toMyOrder";
            } else if(loginToStatus == 3){
                return "bookInfo";
            }
            else
                return "toBookshop";
        }
    }

    //用户注册
    @RequestMapping("/userRegister")
    public String register(Model model, String userName, String cellphone, String password, String province, String city, String district, String street1, String cardno){
        //查看 cellphone是否已经被注册了
        BsUser bsUser = userService.findUserByTel(cellphone);
        if(bsUser != null) {
            model.addAttribute("registerTips", "该手机号码已经被注册了!");
            return "toRegister";
        }
        else {


            // cellphone 没有被注册
            // 允许用户进行注册
            bsUser = new BsUser();
            bsUser.setNickname(userName);
            //判断用户名是否重复
            if(userService.isRepeatNickName(bsUser)){
                model.addAttribute("registerTips", "该用户名称已存在，请换一个!");
                return "toRegister";
            }
            bsUser.setCellphone(cellphone);
            bsUser.setPassword(password);
            bsUser.setProvince1(province);
            bsUser.setCity1(city);
            bsUser.setDistrict1(district);
            bsUser.setStreet1(street1);
            bsUser.setCardno(cardno);
            //保存用户的基本信息
            userService.addUser(bsUser);


            model.addAttribute("registerTips", "注册成功！");
            return "userLogin";
        }
    }

    //用户退出
    @RequestMapping("/userExit")
    public String userExit(HttpSession session){
        BsUser user = (BsUser) session.getAttribute("bsUser");
        if(user != null) {
            user.setStatus((byte) 0);
            user.setSignOutTime(new Date());
            //更新用户状态
            userService.updateUser(user);
        }
            //清除与用户有关的session信息
            session.removeAttribute("cartCount");
            session.removeAttribute("bsUser");
            session.removeAttribute("myCartList");
            session.removeAttribute("countAllOrder");
            session.removeAttribute("orderMasterList");
            session.removeAttribute("countUnPaid");
            session.removeAttribute("countUnDelivery");
            session.removeAttribute("countUnreceived");
            session.removeAttribute("countReceived");
            session.removeAttribute("readyOrders");
            //session.removeAttribute("addToMyCartTips");

        return "toBookshop";
    }

    //保存用户修改信息
    @RequestMapping("/updateUserInfo")
    public String userInfo(Model model, HttpSession session, String nickname, String gender, String birthday, String qq, String wechat, String email){

        //System.out.println("birthday:"+birthday);
        BsUser user = (BsUser)session.getAttribute("bsUser");
        user.setNickname(nickname);
        user.setGender(gender);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(date);
        user.setQq(qq);
        user.setWechat(wechat);
        user.setEmail(email);
        //1.先判断昵称是否和其他用户的昵称重复了
        if(userService.isRepeatNickName(user)){
            model.addAttribute("updateUserInfo", "此昵称已经被使用了，请换一个!");
            //恢复用户信息
           // user = (BsUser) session.getAttribute("bsUser");
            return "userInfo";
        } else if(userService.isRepeatEmail(user)){
            //2.判断邮箱是否和其他用户的邮箱重复了
            model.addAttribute("updateUserInfo","此邮箱已经被其他用户使用，请换一个!");
            //恢复用户信息
            //user = (BsUser) session.getAttribute("bsUser");
            return "userInfo";
        }
        //3.邮箱和昵称没有冲突,保存用户的更新信息
        //保存信息到数据库
        userService.updateUser(user);
        //保存信息到session
        session.setAttribute("bsUser", user);
        model.addAttribute("updateUserInfo","修改信息已保存！");
        return "userInfo";
    }

    @RequestMapping("/updateUserPassword")
    public String updateUserPassword(Model model,  HttpSession session, String newPassword, String oldPassword){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        if(!user.getPassword().equals(oldPassword)){
            //旧密码输入错误
            model.addAttribute("updateUserInfo", "旧密码错误！");
            return "updateUserPasswd";
        }
        user.setPassword(newPassword);
        userService.updateUser(user);
        session.setAttribute("bsUser", user);
        model.addAttribute("updateUserInfo","密码修改成功！");
        return "userInfo";
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(Model model, HttpSession session, String province1, String city1, String district1, String street1, String province2, String city2, String district2, String street2){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        user.setProvince1(province1);
        user.setCity1(city1);
        user.setDistrict1(district1);
        user.setStreet1(street1);
        user.setProvince2(province2);
        user.setCity2(city2);
        user.setDistrict2(district2);
        user.setStreet2(street2);
        userService.updateUser(user);
        session.setAttribute("bsUser", user);
        model.addAttribute("updateUserInfo", "地址修改信息已就保存！");
        return "userInfo";
    }

    @RequestMapping("/delAddr2")
    public String delAddr2(Model model, HttpSession session){
        BsUser user = (BsUser) (session).getAttribute("bsUser");
        user.setProvince2(null);
        user.setCity2(null);
        user.setDistrict2(null);
        user.setStreet2(null);
        userService.updateUser(user);
        session.setAttribute("bsUser", user);
        model.addAttribute("updateAddressTips", "地址2已经成功删除!");
        return "updateUserAddress";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpSession session, String userId){
        Integer uid = Integer.valueOf(userId);
        Integer user_pageNum = (Integer)session.getAttribute("user_pageNum");
        PageHelper.startPage(user_pageNum, 10);
        List<BsUser> userList = userService.findAllUsers();
        PageInfo<BsUser> pageInfo_users = new PageInfo<>(userList);
        session.setAttribute("pageInfo_users", pageInfo_users);
        session.setAttribute("nav_link", 3);
        return "adminManage";
    }

    @RequestMapping("/adminFindUser")
    public String adminFindUser(HttpSession session,  String nickname, String cellphone){
        if(nickname == null){
            nickname = "";
        }
        if(cellphone == null){
            cellphone = "";
        }
        List<BsUser> userList = userService.findUserBynicknameAndTel(nickname, cellphone,  1);
        PageInfo<BsUser> pageInfo_users = new PageInfo<>(userList);
        session.setAttribute("nickname", nickname);
        session.setAttribute("cellphone", cellphone);
        session.setAttribute("pageInfo_users", pageInfo_users);
        session.setAttribute("nav_link", 3);
        return "adminManage";
    }

    @RequestMapping("/toUserPage")
    public String toUserPage(HttpSession session, String user_pageNum){
        Integer pageNum = Integer.valueOf(user_pageNum);
        String nickname = (String)session.getAttribute("nickName");
        String cellphone = (String)session.getAttribute("cellphone");
        if(nickname == null){
            nickname = "";
        }
        if(cellphone == null){
            cellphone = "";
        }
        List<BsUser> userList = userService.findUserBynicknameAndTel(nickname, cellphone,  pageNum);
        PageInfo<BsUser> pageInfo_users = new PageInfo<>(userList);
        session.setAttribute("pageInfo_users", pageInfo_users);
        session.setAttribute("nav_link", 3);
        session.setAttribute("user_pageNum", pageNum);
        return "adminManage";
    }

    @RequestMapping("/adminFindAllUsers")
    public String adminFindAllUsers(HttpSession session){
        //获取所有的用户数据
        PageHelper.startPage(1, 10);
        List<BsUser> userList = userService.findAllUsers();
        PageInfo<BsUser> pageInfo_users = new PageInfo<>(userList);
        session.setAttribute("pageInfo_users", pageInfo_users);
        session.setAttribute("user_pageNum", 1);
        session.setAttribute("nav_link", 3);
        return "adminManage";
    }
}
