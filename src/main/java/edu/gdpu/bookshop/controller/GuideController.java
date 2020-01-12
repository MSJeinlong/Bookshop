package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.service.BookService;
import edu.gdpu.bookshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GuideController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

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
    public String toBookShop(HttpSession session){
        List<Book> books = bookService.findAllBooks();
        session.setAttribute("books", books);
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
        return "addBook";
    }



    @RequestMapping("/buyNowOrAdd2Cart")
    public String buyNowOrAdd2Cart(HttpSession session, String isBuyNow){

        //判断用户是否已经登录
        BsUser user = (BsUser)session.getAttribute("bsUser");

        //用户未登录，跳转到登录页面
        if(user == null){
            session.setAttribute("loginToStatus", "3");
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


}
