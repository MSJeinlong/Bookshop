package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.bean.BookCategory;
import edu.gdpu.bookshop.bean.BookCategoryExample;
import edu.gdpu.bookshop.mapper.BookCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookCategoryService {

    @Resource
    private BookCategoryMapper bookCategoryMapper;

    //添加图书类型
    public boolean addBookCategory(BookCategory bookCategory){
       int res =  bookCategoryMapper.insert(bookCategory);
       if(res > 0)
           return true;
       else
           return false;
    }

    //通过图书类型名称查询图书类型
    public BookCategory findBookCategoryByName(String categoryName){
        BookCategoryExample categoryExample = new BookCategoryExample();
        BookCategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andCategoryNameEqualTo(categoryName);

        List<BookCategory> categoryList = bookCategoryMapper.selectByExample(categoryExample);
        if(categoryList.size() > 0)
            return categoryList.get(0);
        else
            return null;
    }
}
