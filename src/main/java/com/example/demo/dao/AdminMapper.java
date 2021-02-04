package com.example.demo.dao;

import com.example.demo.domain.Admin;
import org.springframework.stereotype.Repository;
//@Repository持久层此注解式持久层组件，用于标注数据访问组件，即DAO组件
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    //定义
    int verifyPassword(String username, String password);
}
