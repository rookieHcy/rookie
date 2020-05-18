package com.houcy7.testspringbootstarter;

import com.houcy7.starter.HelloFormatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author hou
 * @Date 2020/5/17 11:05 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private HelloFormatTemplate helloFormatTemplate;

    @GetMapping("user")
    public String user() {
        User user = new User();
        user.setAge(26);
        user.setName("houcy7");
        return helloFormatTemplate.doFormat(user);
    }
}