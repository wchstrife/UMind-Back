package com.wchstife.umind.contorller;

import com.alibaba.fastjson.JSONObject;
import com.wchstife.umind.entity.User;
import com.wchstife.umind.service.UserService;
import com.wchstife.umind.util.UMindUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    public JSONObject login(@RequestBody JSONObject data, HttpSession session){
        String username = data.getString("username");
        String password = data.getString("password");
        User user = userService.findUserByIdAndPassword(username, password);
        if (null == user){

            return UMindUtil.getFailResponseJo();
        }else {
            /*写session*/
            session.setAttribute("user", user);

            return UMindUtil.getSuccessResponseJoWithData(user);
        }

    }
}
