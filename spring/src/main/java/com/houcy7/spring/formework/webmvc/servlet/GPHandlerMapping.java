package com.houcy7.spring.formework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @ClassName GPHandlerMapping
 * @Description TODO
 * @Author hou
 * @Date 2020/4/28 10:04 下午
 * @Version 1.0
 **/
@Data
public class GPHandlerMapping {
    private Object controller;	//保存方法对应的实例
    private Method method;		//保存映射的方法
    private Pattern pattern;    //URL的正则匹配

    public GPHandlerMapping(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }
}