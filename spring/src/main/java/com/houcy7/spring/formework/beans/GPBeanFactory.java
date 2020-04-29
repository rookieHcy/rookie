package com.houcy7.spring.formework.beans;

/**
 * @InterfaceName GPBeanFactory
 * @Description TODO
 * @Author hou
 * @Date 2020/4/26 9:55 下午
 * @Version 1.0
 **/
public interface GPBeanFactory {

    // 根据名字从IOC容器获取一个bean对象
    Object getBean(String beanName) throws Exception;
}
