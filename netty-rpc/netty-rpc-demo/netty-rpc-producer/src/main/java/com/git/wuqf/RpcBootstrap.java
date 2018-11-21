package com.git.wuqf;

import com.git.wuqf.server.RpcServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class RpcBootstrap {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-server.xml");
        RpcServer server = (RpcServer) context.getBean("rpcServer");
    }
}
