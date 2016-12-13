package com.git.wuqf;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
