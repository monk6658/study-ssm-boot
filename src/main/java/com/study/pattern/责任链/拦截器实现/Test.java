package com.study.pattern.责任链.拦截器实现;

import com.study.pattern.proxy.HelloWorld;
import com.study.pattern.proxy.HelloWorldImpl;
import com.study.pattern.责任链.InterceptorJdkProxy;

public class Test {
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.study.pattern.责任链.拦截器实现.MyInterceptor");
        helloWorld.sayHelloWorld();
    }
}
