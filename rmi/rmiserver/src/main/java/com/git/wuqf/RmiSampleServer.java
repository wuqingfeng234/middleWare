package com.git.wuqf;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Hello world!
 */
public class RmiSampleServer {
    public static void main(String[] args) throws Exception {

        LocateRegistry.createRegistry(8808);
        RmiSampleImpl server = new RmiSampleImpl();


        //**********************高版本jdk**************************//
        Context context = new InitialContext();
        context.rebind(Url.SAMPLE, server);
        //**********************高版本jdk**************************//

        //********************** jdk1.3及以下版本**************************//
        //Naming.rebind("rmi://192.168.0.198:8808/SAMPLE-SERVER",server);
        //********************** jdk1.3及以下版本**************************//
    }
}
