package com.git.wuqf;

import java.net.Socket;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class EventHandler {

    public static class Request {
        public Socket socket;
        public String serviceName;
        public String serviceVersion;
        public String methodName;
        public Object[] args;
    }
    public static void eventHandler(){
        while(true){

        }
    }
}
