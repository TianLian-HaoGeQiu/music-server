package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//@RestController将方法返回的对象直接在浏览器上展示成json格式.
@RestController
//@Controller控制器，处理http请求。
@Controller
//允许跨域，因为前后端分离
public class AdminController {
    //@Autowired注解可以实现Bean的自动注入
    @Autowired
    private AdminServiceImpl adminService;//注入业务对象

//   判断是否登录成功，实现页面的跳转
//@ResponseBody通过HttpMessageConverter读取Request Body并反序列化为Object（泛指）对象
//@RequestMapping:将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上
    @ResponseBody
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)//注意value中的路径一定要与前端发送请求的路径一致
    public Object loginStatus(HttpServletRequest req, HttpSession session){
        /*
        使用JSONObject类用put方法给json对象添加元素。JSONObject可以很方便的转换成字符串，也可以很方便的把其他对象转换成JSONObject对象。
*/
        JSONObject jsonObject = new JSONObject();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //获取用户是否登录成功的方法
        boolean res = adminService.veritypasswd(name, password);
        if (res) {
            //创建一个json的数据对象，并进行传递
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }

    }
}
