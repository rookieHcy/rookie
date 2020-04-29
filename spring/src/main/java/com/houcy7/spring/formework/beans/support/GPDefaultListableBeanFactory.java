package com.houcy7.spring.formework.beans.support;

import com.houcy7.spring.formework.beans.config.GPBeanDefinition;
import com.houcy7.spring.formework.context.support.GPAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName GPDefaultListableBeanFactory
 * @Description TODO
 * @Author hou
 * @Date 2020/4/27 10:56 下午
 * @Version 1.0
 **/
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext{

    // 存储注册信息的BeanDefinition
    protected final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();



}