package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.entity.MyCart;
import edu.gdpu.bookshop.entity.MyCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyCartMapper {
    long countByExample(MyCartExample example);

    int deleteByExample(MyCartExample example);

    int deleteByPrimaryKey(Integer cartId);

    int insert(MyCart record);

    int insertSelective(MyCart record);

    List<MyCart> selectByExample(MyCartExample example);

    MyCart selectByPrimaryKey(Integer cartId);

    int updateByExampleSelective(@Param("record") MyCart record, @Param("example") MyCartExample example);

    int updateByExample(@Param("record") MyCart record, @Param("example") MyCartExample example);

    int updateByPrimaryKeySelective(MyCart record);

    int updateByPrimaryKey(MyCart record);
}