package com.example.demo.service.impl;

import com.example.demo.dao.ConsumerMapper;
import com.example.demo.domain.Consumer;
import com.example.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {


    @Autowired
    private ConsumerMapper consumerMapper;
    //addUser()新增一名用户
    @Override
    public boolean addUser(Consumer consumer) {
        return consumerMapper.insertSelective(consumer) >0 ?true:false;
    }

    //updateUserMsg()修改用户信息
    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return consumerMapper.updateUserMsg(consumer) >0 ?true:false;
    }

    //updateUserAvator()修改用户头像路径
    @Override
    public boolean updateUserAvator(Consumer consumer) {

        return consumerMapper.updateUserAvator(consumer) >0 ?true:false;
    }

    //existUser()返回用户名相同的用户数量
    @Override
    public boolean existUser(String username) {
        return consumerMapper.existUsername(username)>0 ? true:false;
    }

    //veritypasswd()验证用户登录是否成功
    @Override
    public boolean veritypasswd(String username, String password) {

        return consumerMapper.verifyPassword(username, password)>0?true:false;
    }

//    删除用户
    @Override
    public boolean deleteUser(Integer id) {
        return consumerMapper.deleteUser(id) >0 ?true:false;
    }

    //allUser()返回所有用户
    @Override
    public List<Consumer> allUser() {
        return consumerMapper.allUser();
    }

    //userOfId()返回某一位用户的所有信息(根据ID)
    @Override
    public List<Consumer> userOfId(Integer id) {

        return consumerMapper.userOfId(id);
    }

    //loginStatus()返回某一位用户的所有信息（根据用户名）
    @Override
    public List<Consumer> loginStatus(String username) {

        return consumerMapper.loginStatus(username);
    }
}
