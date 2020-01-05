package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.bean.OrderLine;
import edu.gdpu.bookshop.bean.OrderLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLineMapper {
    long countByExample(OrderLineExample example);

    int deleteByExample(OrderLineExample example);

    int deleteByPrimaryKey(Integer lineId);

    int insert(OrderLine record);

    int insertSelective(OrderLine record);

    List<OrderLine> selectByExample(OrderLineExample example);

    OrderLine selectByPrimaryKey(Integer lineId);

    int updateByExampleSelective(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    int updateByExample(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    int updateByPrimaryKeySelective(OrderLine record);

    int updateByPrimaryKey(OrderLine record);
}