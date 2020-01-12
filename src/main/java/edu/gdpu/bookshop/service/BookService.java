package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.entity.Book;
import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BookCategoryExample;
import edu.gdpu.bookshop.entity.BookExample;
import edu.gdpu.bookshop.mapper.BookCategoryMapper;
import edu.gdpu.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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

    /*根据书名模糊查询*/
    public List<Book> findBookByBookNameBlur(String bookName){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookNameLike("%"+bookName+"%");
        return bookMapper.selectByExample(bookExample);
    }

    /*根据图书名称及最低价和最高价进行模糊查询*/
    public List<Book> findBookByAuthorBlur(String author){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andAuthorLike("%"+author+"%");
        return bookMapper.selectByExample(bookExample);
    }

    /*根据图书名称及最低价和最高价进行模糊查询*/
    public List<Book> findBookByBookNameAndPriceBlur(String bookName, BigDecimal lowestPrice, BigDecimal highestPrice){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookNameLike("%"+bookName+"%");
        criteria.andPriceBetween(lowestPrice, highestPrice);
        return bookMapper.selectByExample(bookExample);
    }

    /*根据图书名称及最低价和最高价进行模糊查询*/
    public List<Book> findBookByAuthorAndPriceBlur(String author, BigDecimal lowestPrice, BigDecimal highestPrice){
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andAuthorLike("%"+author+"%");
        criteria.andPriceBetween(lowestPrice, highestPrice);
        return bookMapper.selectByExample(bookExample);
    }

    /*根据 bookId 和购买数量 amount 扣库存*/
    public boolean decreaseNumbers(Integer bookId, Integer amount){
        Book book = this.findBookByBookId(bookId);
        /*库存不足*/
        if(book.getNumbers() < amount){
            return false;
        }
        else {
            //库存足够
            book.setNumbers(book.getNumbers() - amount);
            //设置销量
            book.setSales(book.getSales() + amount);
            //更新到数据库
            book.setUpdateTime(new Date());
            bookMapper.updateByPrimaryKey(book);
            return true;
        }
    }

    /*根据 bookId 和购买数量 amount 检查库存是否足够*/
    public boolean isNumbersEnough(Integer bookId, Integer amount){
        Book book = this.findBookByBookId(bookId);
        /*库存不足*/
        if(book.getNumbers() < amount)
            return false;
        else
            return true;
    }
}
