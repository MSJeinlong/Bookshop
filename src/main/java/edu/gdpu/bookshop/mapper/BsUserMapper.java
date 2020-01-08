package edu.gdpu.bookshop.mapper;

import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.entity.BsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsUserMapper {
    long countByExample(BsUserExample example);

    int deleteByExample(BsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(BsUser record);

    int insertSelective(BsUser record);

    List<BsUser> selectByExample(BsUserExample example);

    BsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") BsUser record, @Param("example") BsUserExample example);

    int updateByExample(@Param("record") BsUser record, @Param("example") BsUserExample example);

    int updateByPrimaryKeySelective(BsUser record);

    int updateByPrimaryKey(BsUser record);
}