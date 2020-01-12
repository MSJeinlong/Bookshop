package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.entity.OrderMaster;
import edu.gdpu.bookshop.entity.OrderMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMasterMapper {
    long countByExample(OrderMasterExample example);

    int deleteByExample(OrderMasterExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    List<OrderMaster> selectByExample(OrderMasterExample example);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderMaster record, @Param("example") OrderMasterExample example);

    int updateByExample(@Param("record") OrderMaster record, @Param("example") OrderMasterExample example);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}