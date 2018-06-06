package com.wchstife.umind.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wchstife.umind.dao.UserDao;
import com.wchstife.umind.entity.User;
import com.wchstife.umind.util.UMindUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     */
    public User findUserByIdAndPassword(String username, String password){
        User user = userDao.findByUsernameAndPassword(username, password);

        return user;
    }

}
