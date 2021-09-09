package com.hp.dao;

import com.hp.bean.Human;
import com.hp.bean.HumanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HumanDAO {
    //所有的dao  单表：   增--增加一条数据   删--根据id删除，条件删除，（动态SQL） 改：根基主键，条件修改（动态SQL）
    // 查-- 按主键id 查对象，，查总条数（动态），

    long countByExample(HumanExample example);// 用Example类查总条数, 动态的SQL查询总条数
    //当Example类为null的时候  sql语句的 等于如下
    //select count(*) from human
    //当example 类不为 null的时候，SQL语句等于如下
    //select count(*) from human  where gender = 2  ||参数如何传递呢


    int deleteByExample(HumanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Human record);

    int insertSelective(Human record);

    List<Human> selectByExample(HumanExample example);

    Human selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Human record, @Param("example") HumanExample example);

    int updateByExample(@Param("record") Human record, @Param("example") HumanExample example);

    int updateByPrimaryKeySelective(Human record);

    int updateByPrimaryKey(Human record);
}