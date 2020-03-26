package com.git.wuqf;

import com.git.wuqf.annotation.RpcService;

/**
 * Created by wuqf on 2016/12/13.
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        return "hello" + msg;
    }

    public Person grow(Person person) {
        person.setAge(person.getAge() + 1);
        return person;
    }
}
