package com.test.bootdevtool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @RequestMapping("test")
    @ResponseBody
public String Test(){
    int a = 20;
    int b = 30;
    int c = 1100;
    return "This is testing striung sum of a and b and c "+ (a+b+c);
}
}
