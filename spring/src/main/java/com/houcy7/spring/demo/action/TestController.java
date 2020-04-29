package com.houcy7.spring.demo.action;

import com.houcy7.spring.demo.service.TestService;
import com.houcy7.spring.formework.annotation.GPAutowired;
import com.houcy7.spring.formework.annotation.GPController;
import com.houcy7.spring.formework.annotation.GPService;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author hou
 * @Date 2020/4/28 1:05 上午
 * @Version 1.0
 **/
@GPController
public class TestController {

    @GPAutowired
    public TestService testService;

}