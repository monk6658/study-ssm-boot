package com.study.pattern.proxy.jdkproxy;

import com.study.pattern.proxy.HelloWorld;
import com.study.pattern.proxy.HelloWorldImpl;

public class Test {

    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系,
        HelloWorld helloWorld = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        helloWorld.sayHelloWorld();
    }
}
