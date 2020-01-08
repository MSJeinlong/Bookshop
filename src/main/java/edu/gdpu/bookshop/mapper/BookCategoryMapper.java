package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.entity.BookCategory;
import edu.gdpu.bookshop.entity.BookCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCategoryMapper {
    long countByExample(BookCategoryExample example);

    int deleteByExample(BookCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    List<BookCategory> selectByExample(BookCategoryExample example);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByExample(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}