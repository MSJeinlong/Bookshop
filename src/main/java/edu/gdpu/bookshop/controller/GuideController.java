package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.service.BookService;
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

    @RequestMapping("/toMyCart")
    public String toMyCart(HttpSession session){
        BsUser user = (BsUser)session.getAttribute("bsUser");
        //查看购物车前，判断用户是否已经登录
        if(user == null){
            return "userLogin";
        }
        else
            return "shoppingCart";
    }
}
