package com.git.wuqf.rpcrpcframework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author wuqf
 * @date 2018/11/21
 */
public class DynamicProxy implements InvocationHandler {
    private String host;
    private int port;
    public DynamicProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        Socket socket = new Socket(host, port);
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            try {
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(arguments);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                try {
                    Object result = input.readObject();
                    if (result instanceof Throwable) {
                        throw (Throwable) result;
                    }
                    return result;//返回结果
                } finally {
                    input.close();
                }
            } finally {
                output.close();
            }
        } finally {
            socket.close();
        }
    }
}
