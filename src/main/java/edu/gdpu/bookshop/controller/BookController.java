package edu.gdpu.bookshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.ArrayList;
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
    public String addNewBook(Model model, HttpSession session, String bookName, String author, String translator, String ISBN,
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
            Integer cid = Integer.valueOf(categoryId);
            book.setCategoryId(cid);
            book.setImage(image);
            book.setIsEbook(Integer.valueOf(isEbook));
            book.setSales(0);
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            if(bookService.addBook(book)){
                model.addAttribute("addNewBookTips", "图书添加成功！");
            } else {
                model.addAttribute("addNewBookTips", "图书添加失败！原因：服务器内部错误！");
            }
            model.addAttribute("categoryId", cid);
            PageHelper.startPage(1, 10);
            List<Book> bookList = bookService.findAllBooks();
            PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
            session.setAttribute("pageInfo_books", pageInfo_books);
            session.setAttribute("nav_link", 2);
            session.setAttribute("book_nav_link_actived", 1);
            return "adminManage";
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
        //session.setAttribute("keyName", keyName);
        logger.info("搜索关键字 "+keyName+" 的图书信息列表:{}", bookList);
      /*  for (Book b: bookList) {
            System.out.println(b);
        }*/
        //保存用户的搜索关键字
        session.setAttribute("keyName", keyName);
        session.setAttribute("activeCode", 1);
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
        session.setAttribute("activeCode", 2);
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
        session.setAttribute("activeCode", 3);
        return "bookshop";
    }

    @RequestMapping("/descSortBookBySales")
    public String descSortBookBySales(HttpSession session){
        //根据图书价格进行升序
        List<Book> books = (List<Book>)session.getAttribute("books");
        List<Book> bookSortList = books.stream().sorted(Comparator.comparing(Book::getSales).reversed()).collect(Collectors.toList());
        logger.info("按价格降序的图书列表:{}", bookSortList);
        session.setAttribute("books", bookSortList);
        session.setAttribute("activeCode", 4);
        return "bookshop";
    }

    /*根据最高价及最低价，且及搜索关键字进行查询*/
    @RequestMapping("/findBookByLHPrice")
    public String findBookByLHPrice(HttpSession session, String lowestPrice, String highestPrice){
        //检查lowestPrice，highestPrice是否为空
        if(lowestPrice.equals(""))
            lowestPrice = "0.00";
        if(highestPrice.equals(""))
            highestPrice = "99999999.99";
        String keyName = (String)session.getAttribute("keyName");
        //当关键字为空时
        if(keyName == null)
            keyName = "";
        List<Book> bookList1 = bookService.findBookByAuthorAndPriceBlur(keyName, new BigDecimal(lowestPrice), new BigDecimal(highestPrice));
        List<Book> bookList2 = bookService.findBookByBookNameAndPriceBlur(keyName,  new BigDecimal(lowestPrice), new BigDecimal(highestPrice));
        //搜索结果合并
        bookList1.addAll(bookList2);
        //搜索结果去重
        List<Book> books = bookList1.stream().distinct().collect(Collectors.toList());
        session.setAttribute("books", books);
        return "bookshop";
    }

    /*按出版时间降序*/
    @RequestMapping("/publishDateSort")
    public String publishDateSort(HttpSession session){
        //根据图书价格进行升序
        List<Book> books = (List<Book>)session.getAttribute("books");
        List<Book> bookSortList = books.stream().sorted(Comparator.comparing(Book::getPublishDate).reversed()).collect(Collectors.toList());
        logger.info("按价格降序的图书列表:{}", bookSortList);
        session.setAttribute("books", bookSortList);
        session.setAttribute("activeCode", 5);
        return "bookshop";
    }

    /*综合排序*/
    @RequestMapping("/comprehensiveSort")
    public String comprehensive(HttpSession session){
        String keyName =(String) session.getAttribute("keyName");
        if(keyName != null){
            List<Book> books1 = bookService.findBookByBookNameBlur(keyName);
            List<Book> books2 = bookService.findBookByAuthorBlur(keyName);
            //将book2的结果加入book1
            books1.addAll(books2);
            //对结果进行去重
            List<Book> bookList = books1.stream().distinct().collect(Collectors.toList());
            if(books1.size() == 0)
                System.out.println("book1为空**************");
            session.setAttribute("books", bookList);
        } else {
            //关键字为空
            List<Book> books = bookService.findAllBooks();
            session.setAttribute("books", books);
            session.setAttribute("activeCode", 1);
        }
        return "bookshop";
    }

    /*仅看有货或者无货*/
    @RequestMapping("/isEnoughStock")
    public String hasNumberOrNot(HttpSession session, String stockStatus) {
        List<Book> bookList = (List<Book>) session.getAttribute("books");
        List<Book> books = new ArrayList<>();
        session.setAttribute("stockStatus", stockStatus);
        //仅看有货
        if (stockStatus.equals("1")) {
            session.setAttribute("EnounghStock", bookList);
            for (Book book : bookList) {
                if (book.getNumbers() > 0) {
                    books.add(book);
                }
            }
        } else {
           books = (List<Book>) session.getAttribute("EnounghStock");
            session.removeAttribute("EnounghStock");
            System.out.println("看全部");
        }
        session.setAttribute("books", books);
        return "bookshop";
    }

    @RequestMapping("/findAllProduct")
    public String findAllProduct(HttpSession session){
        session.setAttribute("activeCode", 0);
        List<Book> bookList = bookService.findAllBooks();
        session.setAttribute("books", bookList);
        return "bookshop";
    }

    @RequestMapping("/adminBookInfo")
    public String adminBookInfo(HttpSession session, String bookId){
        Book book = bookService.findBookByBookId(Integer.valueOf(bookId));
        session.setAttribute("admin_book", book);
        session.setAttribute("nav_link", 2);
        return "admin_bookInfo";
    }

    @RequestMapping("/toBookPage")
    public String toBookPage(HttpSession session, String book_pageNum){
        Integer pageNum = Integer.valueOf(book_pageNum);
        System.out.println("toBookPage:"+book_pageNum);
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        String orderBy = (String)session.getAttribute("orderBy");
        if(orderBy == null)
            orderBy = "book_id asc";
        List<Book> bookList = bookService.findBookByBookNameAuthorPublisher(bookName, author, publisher, orderBy, pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("book_pageNum", pageNum);
        session.setAttribute("nav_link", 2);
        return "adminManage";
    }

    /**
     * @Description:全部订单
     * @Param:
     * @return:
     * @Author: 池俊龙
     * @Date:
     */
    @RequestMapping("/adminFindAllBooks")
    public String adminFindAllBooks(HttpSession session){
        PageHelper.startPage(1, 10);
        List<Book> bookList = bookService.findAllBooks();
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("book_nav_link_actived", 1);
        return "adminManage";
    }

    /** 
     * @Description: 销量↑
     * @Param: 
     * @return: 
     * @Author: 池俊龙
     * @Date: 
     */
    @RequestMapping("/sortSecNumbers")
    public String sortSecNumbers(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortAscNumbers(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "numbers asc");
        session.setAttribute("book_nav_link_actived", 4);
        return "adminManage";
    }

    @RequestMapping("/sortDesNumbers")
    public String sortDesNumbers(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortDescNumbers(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "numbers desc");
        session.setAttribute("book_nav_link_actived", 5);
        return "adminManage";
    }

    @RequestMapping("/sortSecSales")
    public String sortSecSales(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortAscSales(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "sales asc");
        session.setAttribute("book_nav_link_actived", 2);
        return "adminManage";
    }

    @RequestMapping("/sortDesSales")
    public String sortDesSales(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortDescSales(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "sales desc");
        session.setAttribute("book_nav_link_actived", 3);
        return "adminManage";
    }

    @RequestMapping("/sortSecPrice")
    public String sortSecPrice(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortAscPrice(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "price asc");
        session.setAttribute("book_nav_link_actived", 6);
        return "adminManage";
    }

    @RequestMapping("/sortDesPrice")
    public String sortDesPrice(HttpSession session){
        Integer book_pageNum = (Integer)session.getAttribute("book_pageNum");
        String bookName = (String)session.getAttribute("bookName");
        String author = (String)session.getAttribute("author");
        String publisher = (String)session.getAttribute("publisher");
        if(bookName == null)
            bookName = "";
        if(author == null)
            author = "";
        if(publisher == null)
            publisher = "";
        List<Book> bookList = bookService.findBookByBAPSortDescPrice(bookName, author, publisher, book_pageNum);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("orderBy", "price desc");
        session.setAttribute("book_nav_link_actived", 7);
        return "adminManage";
    }

    @RequestMapping("/findBookByBAP")
    public String findBookByBAP(HttpSession session, String bookName, String author, String publisher){
        String orderBy = "book_id asc";
        List<Book> bookList = bookService.findBookByBookNameAuthorPublisher(bookName, author, publisher, orderBy, 1);
        PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("bookName", bookName);
        session.setAttribute("author", author);
        session.setAttribute("publisher", publisher);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        session.setAttribute("book_nav_link_actived", 1);
        return "adminManage";
    }

    @RequestMapping("/deleteBookByBookId")
    public String deleteBookByBookId(HttpSession session, String bookId){
        Integer bid= Integer.valueOf(bookId);
        bookService.deleteBook(bid);
        PageInfo<Book> pageInfo_books = (PageInfo<Book>)session.getAttribute("pageInfo_books");
        List<Book> bookList = pageInfo_books.getList();
        for (Book book: bookList) {
            if(book.getBookId() == bid) {
                bookList.remove(book);
            }
        }
        pageInfo_books = new PageInfo<>(bookList);
        session.setAttribute("pageInfo_books", pageInfo_books);
        session.setAttribute("nav_link", 2);
        return "adminManage";
    }

    @RequestMapping("/adminUpdateBook")
    public String adminUpdateBook(Model model, HttpSession session, String bookName, String author, String translator, String ISBN,
                                  String publisher, String publishDate, String price, String numbers, String description
            , String categoryId, String image, String pages, String isEbook){

        Book book = (Book)session.getAttribute("book");
        book.setBookName("bookName");
        //书名重复，修改失败
        if(bookService.isBookNameRepeated(book)){
            model.addAttribute("updateBookTips", "书名重复！");
            return  "updateBookInfo";
        } else {
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setTranslator(translator);
            book.setIsbn(ISBN);
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
            Integer cid = Integer.valueOf(categoryId);
            book.setCategoryId(cid);
            book.setImage(image);
            book.setIsEbook(Integer.valueOf(isEbook));
            bookService.updateBook(book);
            model.addAttribute("updateBookTips", "图书信息更新成功！");
            PageHelper.startPage(1, 10);
            session.setAttribute("book_pageNum", 1);
            List<Book> bookList = bookService.findAllBooks();
            PageInfo<Book> pageInfo_books = new PageInfo<>(bookList);
            session.setAttribute("pageInfo_books", pageInfo_books);
            session.setAttribute("nav_link", 2);
            Integer book_nav_link_actived = (Integer)session.getAttribute("book_nav_link_actived");
            session.setAttribute("book_nav_link_actived", book_nav_link_actived);
            return "adminManage";
        }
    }
}
