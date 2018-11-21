package com.git.wuqf.rpcserver;

import com.git.wuqf.HelloService;
import com.git.wuqf.Person;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        return "hello " + msg;
    }

    public Person grow(Person person) {
        person.setAge(person.getAge() + 1);
        return person;
    }
}
