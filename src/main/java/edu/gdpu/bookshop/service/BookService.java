package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BookCategoryExample;
import edu.gdpu.bookshop.entity.BookExample;
import edu.gdpu.bookshop.mapper.BookCategoryMapper;
import edu.gdpu.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookCategoryMapper bookCategoryMapper;

    public List<Book> findAllBooks(){
        return bookMapper.selectByExample(new BookExample());
    }

    public List<BookCategory> findAllBookcategorys(){
        return bookCategoryMapper.selectByExample(new BookCategoryExample());
    }

    public boolean addBook(Book book){
        if(bookMapper.insert(book) > 0)
            return true;
        else
            return false;
    }

    /*根据bookId查询*/
    public Book findBookByBookId(Integer bookId){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        List<Book> books = bookMapper.selectByExample(bookExample);
        if(books.size() > 0){
            return books.get(0);
        }
        else
            return null;
    }

    /*根据bookName精确查询*/
    public Book findBookByBookName(String bookName){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookNameEqualTo(bookName);

        List<Book> books = bookMapper.selectByExample(bookExample);
        if(books.size() > 0)
            return books.get(0);
        else
            return null;
    }

    /*根据图书名称进行模糊查询*/
    public List<Book> findBookByBookNameBlur(String bookName){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookNameLike("%"+bookName+"%");
        return bookMapper.selectByExample(bookExample);
    }

    /*根据图书名称进行模糊查询*/
    public List<Book> findBookByAuthorBlur(String author){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andAuthorLike("%"+author+"%");
        return bookMapper.selectByExample(bookExample);
    }

    //图书按照价格,且基于关键字进行升序
//    public List<Book> ascOrderByPrice(String keyName){
//        BookExample bookExample1 = new BookExample();
//        BookExample bookExample2 = new BookExample();
//        BookExample.Criteria criteria1 = bookExample1.createCriteria();
//        BookExample.Criteria criteria2 = bookExample2.createCriteria();
//        criteria1.andBookNameLike("%"+keyName+"%");
//    }
}
