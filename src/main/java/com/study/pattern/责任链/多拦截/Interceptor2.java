package com.study.pattern.责任链.多拦截;


import com.study.pattern.责任链.Interceptor;

import java.lang.reflect.Method;

public class Interceptor2 implements Interceptor {


    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器2】的before方法");
        return true;//不反射被代理对象原有方法
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器2】的after方法");
    }

}
