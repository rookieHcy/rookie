package com.houcy7.spring.formework.beans.config;

import lombok.Data;

/**
 * @ClassName GPDefinition
 * @Description 实际是一个接口
 * @Author hou
 * @Date 2020/4/27 11:00 下午
 * @Version 1.0
 **/
@Data
public class GPBeanDefinition {
    private String beanClassName;

    private boolean lazyInit = false;

    private String factoryBeanName;

    // 默认就是单例
    private boolean isSingleton = true;
}