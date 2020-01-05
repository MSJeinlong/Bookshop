package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.bean.OrderStatus;
import edu.gdpu.bookshop.bean.OrderStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusMapper {
    long countByExample(OrderStatusExample example);

    int deleteByExample(OrderStatusExample example);

    int deleteByPrimaryKey(Integer statusId);

    int insert(OrderStatus record);

    int insertSelective(OrderStatus record);

    List<OrderStatus> selectByExample(OrderStatusExample example);

    OrderStatus selectByPrimaryKey(Integer statusId);

    int updateByExampleSelective(@Param("record") OrderStatus record, @Param("example") OrderStatusExample example);

    int updateByExample(@Param("record") OrderStatus record, @Param("example") OrderStatusExample example);

    int updateByPrimaryKeySelective(OrderStatus record);

    int updateByPrimaryKey(OrderStatus record);
}