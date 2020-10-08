package com.study.pattern.proxy.cglib;

import com.study.pattern.proxy.HelloWorld;
import com.study.pattern.proxy.HelloWorldImpl;
import com.study.pattern.proxy.ReflectServiceImpl;

public class Test {
    public static void main(String[] args) {

        CglibProxyExample cglibProxyExample = new CglibProxyExample();

        ReflectServiceImpl reflectService = (ReflectServiceImpl) cglibProxyExample.getProxy(ReflectServiceImpl.class);

        reflectService.sayHelloWorld();
    }
}
