package com.git.wuqf;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        String hello = service.hello("World");
        System.out.println(hello);

        Person person=new Person("wuqf",1);
        person=service.grow(person);
        System.out.println(person);
    }
}
