package com.git.wuqf.netty.transport.api.client;


import com.git.wuqf.netty.transport.api.exchange.Request;
import com.git.wuqf.netty.transport.api.exchange.Response;

import java.net.InetSocketAddress;

public interface Client {

    void connect(InetSocketAddress socketAddress);

    Response sent(Request request);

    InetSocketAddress getRemoteAddress();

    void close();
}
