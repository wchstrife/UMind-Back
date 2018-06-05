package com.wchstife.umind.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index")
    public String hellotHtml(){
        return "/index.html";
    }
}
