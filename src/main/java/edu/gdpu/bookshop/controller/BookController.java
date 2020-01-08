package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @RequestMapping("/toBookInfo")
    public String toBookInfo(HttpSession session, Integer bookId){
        Book book = bookService.findBookByBookId(bookId);
        session.setAttribute("book", book);
        logger.info("图书信息列表:", book);
        return "bookInfo";
    }

    @RequestMapping("/findBook")
    public String findBook(HttpSession session, String keyName){
        List<Book> books1 = bookService.findBookByBookNameBlur(keyName);
        List<Book> books2 = bookService.findBookByAuthorBlur(keyName);
        //将book2的结果加入book1
        books1.addAll(books2);
        //对结果进行去重
        List<Book> bookList = books1.stream().distinct().collect(Collectors.toList());
        if(books1.size() == 0)
            System.out.println("book1为空**************");
        session.setAttribute("books", bookList);
        logger.info("搜索关键字 "+keyName+" 的图书信息列表:{}", bookList);
        for (Book b: bookList) {
            System.out.println(b);
        }
        //保存用户的搜索关键字
        session.setAttribute("keyName", keyName);
        return "bookshop";
    }

    @RequestMapping("/ascSortBookByPrice")
    public String ascSortBook(HttpSession session){
        //根据图书价格进行升序
        List<Book> books = (List<Book>)session.getAttribute("books");
        List<Book> bookSortList = books.stream().sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
      /*  System.out.println("按价格升序");
        for (Book b: bookSortList) {
            System.out.println(b);
        }*/
        logger.info("按价格升序的图书列表:{}", bookSortList);
        session.setAttribute("books", bookSortList);
        return "bookshop";
    }

    @RequestMapping("/descSortBookByPrice")
    public String descSortBook(HttpSession session){
        //根据图书价格进行升序
        List<Book> books = (List<Book>)session.getAttribute("books");
        List<Book> bookSortList = books.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).collect(Collectors.toList());
      /*  System.out.println("按价格升序");
        for (Book b: bookSortList) {
            System.out.println(b);
        }*/
        logger.info("按价格降序的图书列表:{}", bookSortList);
        session.setAttribute("books", bookSortList);
        return "bookshop";
    }

    @RequestMapping("/descSortBookBySales")
    public String descSortBookBySales(HttpSession session){
        //根据图书价格进行升序
        List<Book> books = (List<Book>)session.getAttribute("books");
        List<Book> bookSortList = books.stream().sorted(Comparator.comparing(Book::getSales).reversed()).collect(Collectors.toList());
      /*  System.out.println("按价格升序");
        for (Book b: bookSortList) {
            System.out.println(b);
        }*/
        logger.info("按价格降序的图书列表:{}", bookSortList);
        session.setAttribute("books", bookSortList);
        return "bookshop";
    }
}
