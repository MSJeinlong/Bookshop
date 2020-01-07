package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.bean.Book;
import edu.gdpu.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping("/addNewBook")
    public String addNewBook(Model model, String bookName, String author, String translator, String ISBN,
                             String publisher, String publishDate, String price, String numbers, String description
    , String categoryId, String image, String pages, String isEbook){
        //检查书名是否重复
        if(bookService.findBookByBookName(bookName)!=null){
            model.addAttribute("addNewBookTips", "图书添加失败！原因：图书名称重复！");
            return "addBook";
        } else {
            Book book = new Book();
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setIsbn(ISBN);
            book.setTranslator(translator);
            book.setPublisher(publisher);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = format.parse(publishDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            book.setPublishDate(date);
            BigDecimal pri = new BigDecimal(price);
            book.setPrice(pri);
            book.setPages(Integer.valueOf(pages));
            book.setNumbers(Integer.valueOf(numbers));
            book.setDescription(description);
            book.setCategoryId(Integer.valueOf(categoryId));
            book.setImage(image);
            book.setIsEbook(Integer.valueOf(isEbook));
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            if(bookService.addBook(book)){
                model.addAttribute("addNewBookTips", "图书添加成功！");
            } else {
                model.addAttribute("addNewBookTips", "图书添加失败！原因：服务器内部错误！");
            }
            return "addBook";
        }
    }
}
