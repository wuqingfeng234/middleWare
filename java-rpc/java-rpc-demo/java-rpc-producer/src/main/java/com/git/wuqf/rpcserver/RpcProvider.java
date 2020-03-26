package com.git.wuqf.rpcserver;

import com.git.wuqf.HelloService;
import com.git.wuqf.rpcrpcframework.RpcFramework;

/**
 * Created by wuqf on 2016/12/13.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
