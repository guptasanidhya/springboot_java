package com.onlyjavatech.sanidhya;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {

    @RequestMapping(path="/test", method = RequestMethod.GET)
    public String firstHandler(){
        return "just for testing";
    }
}
