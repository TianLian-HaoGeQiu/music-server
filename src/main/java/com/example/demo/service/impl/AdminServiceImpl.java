package com.example.demo.service.impl;

import com.example.demo.dao.AdminMapper;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//业务层，核心做三件事：处理业务逻辑，控制事务，调用Dao
/*@Service    -- service标注业务层组件
        这个注解是写在类上面的，标注将这个类交给Spring容器管理，spring容器要为他创建对象*/
@Service
public class AdminServiceImpl implements AdminService {
//@Autowired这个注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get。
    @Autowired
    private AdminMapper adminMapper;
//@Override注解是伪代码，用于表示被标注的方法是一个重写方法。
    //@Configuration()验证管理员登录
    @Override
    public boolean veritypasswd(String name, String password) {
        //实现接口中没有实现的方法
        //将数据传给对应的Mapper
        return adminMapper.verifyPassword(name, password)>0?true:false;
    }
}
