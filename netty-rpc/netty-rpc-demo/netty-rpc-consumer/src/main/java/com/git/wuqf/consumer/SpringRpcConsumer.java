package com.git.wuqf.consumer;

import com.git.wuqf.HelloService;
import com.git.wuqf.Person;
import com.git.wuqf.client.RpcProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wuqf on 2016/12/13.
 */
public class SpringRpcConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-client.xml");
        RpcProxy rpcProxy = (RpcProxy) context.getBean("rpcProxy");
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        System.out.println(result);

        Person person = new Person("wuqf", 1);
        person = helloService.grow(person);
        System.out.println(person);
    }
}
