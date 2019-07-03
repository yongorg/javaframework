package org.yong.controller;


import org.apache.commons.beanutils.BeanUtils;
import org.yong.pojo.User;
import org.yong.service.UserService;
import org.yong.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserController extends BaseServlet {

    UserService userService = new UserServiceImpl();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.findAll();
        writeValue(list, resp);
    }

    public void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("uid");

        User user = userService.findById(id);

        writeValue(user, resp);
    }

    public void updateOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        // 获取from表单集合
        Map<String, String[]> map = req.getParameterMap();

        User user = new User();
        // 把map封装成user对象
        BeanUtils.populate(user, map);

        Integer update = userService.update(user);

        writeValue(update, resp);
    }

    public void deleteOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String id = req.getParameter("uid");

        Integer delete = userService.deleteById(Integer.parseInt(id));

        writeValue(delete, resp);
    }

    public void addOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        // 获取from表单集合
        Map<String, String[]> map = req.getParameterMap();

        User user = new User();
        // 把map封装成user对象
        BeanUtils.populate(user, map);

        logger.info(user);

        Integer insert = userService.insert(user);

        writeValue(insert, resp);
    }
}
