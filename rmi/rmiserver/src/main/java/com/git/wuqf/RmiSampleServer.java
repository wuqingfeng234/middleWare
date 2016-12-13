package com.git.wuqf;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Hello world!
 *
 */
public class RmiSampleServer
{
    public static void main( String[] args ) throws Exception
    {
        LocateRegistry.createRegistry(8808);
        RmiSampleImpl server=new RmiSampleImpl();
        Naming.rebind("//localhost:8808/SAMPLE-SERVER",server);
    }
}
