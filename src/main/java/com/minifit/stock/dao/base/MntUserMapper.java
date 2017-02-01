package com.minifit.stock.dao.base;

import com.minifit.stock.vo.base.MntUser;
import com.minifit.stock.vo.base.MntUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MntUserMapper {

  long countByExample(MntUserExample example);

  int deleteByExample(MntUserExample example);

  int deleteByPrimaryKey(Integer userIdx);

  int insert(MntUser record);

  int insertSelective(MntUser record);

  List<MntUser> selectByExample(MntUserExample example);

  MntUser selectByPrimaryKey(Integer userIdx);

  int updateByExampleSelective(@Param("record") MntUser record,@Param("example") MntUserExample example);

  int updateByExample(@Param("record") MntUser record,@Param("example") MntUserExample example);

  int updateByPrimaryKeySelective(MntUser record);

  int updateByPrimaryKey(MntUser record);
}