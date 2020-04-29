package com.houcy7.spring.formework.beans.config;

/**
 * @ClassName GPBeanWrapper
 * @Description TODO
 * @Author hou
 * @Date 2020/4/28 12:23 上午
 * @Version 1.0
 **/
public class GPBeanWrapper {
    private Object wrappedInstance;

    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrappedInstance, Class<?> aClass) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance() {
        return this.wrappedInstance;
    }

    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }
}