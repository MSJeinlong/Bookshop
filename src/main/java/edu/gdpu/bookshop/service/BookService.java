package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.bean.Book;
import edu.gdpu.bookshop.bean.BookCategory;
import edu.gdpu.bookshop.bean.BookCategoryExample;
import edu.gdpu.bookshop.bean.BookExample;
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
}
