package com.git.wuqf.rpcrpcframework;

import java.io.IOException;
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
    private final String host;
    private final int port;

    public DynamicProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws IOException {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(arguments);

            return input.readObject();//返回结果

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
