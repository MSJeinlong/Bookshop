package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.bean.PayWay;
import edu.gdpu.bookshop.bean.PayWayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayWayMapper {
    long countByExample(PayWayExample example);

    int deleteByExample(PayWayExample example);

    int deleteByPrimaryKey(Integer paywayId);

    int insert(PayWay record);

    int insertSelective(PayWay record);

    List<PayWay> selectByExample(PayWayExample example);

    PayWay selectByPrimaryKey(Integer paywayId);

    int updateByExampleSelective(@Param("record") PayWay record, @Param("example") PayWayExample example);

    int updateByExample(@Param("record") PayWay record, @Param("example") PayWayExample example);

    int updateByPrimaryKeySelective(PayWay record);

    int updateByPrimaryKey(PayWay record);
}