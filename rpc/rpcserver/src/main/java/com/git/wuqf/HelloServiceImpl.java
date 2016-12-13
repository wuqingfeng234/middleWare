package com.git.wuqf;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        return "hello "+msg;
    }
}
