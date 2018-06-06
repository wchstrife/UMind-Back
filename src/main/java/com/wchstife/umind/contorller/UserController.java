package com.wchstife.umind.contorller;

import com.alibaba.fastjson.JSONObject;
import com.wchstife.umind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param data
     * @return
     */
    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject data){
        String username = data.getString("username");
        String password = data.getString("password");
        JSONObject jsonObject = userService.findUserByIdAndPassword(username, password);

        return jsonObject;
    }
}
