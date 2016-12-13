package com.git.wuqf;

import java.rmi.Naming;

/**
 * Hello world!
 *
 */
public class RmiSampleClient
{
    public static void main( String[] args ) throws Exception
    {
        String url = "//localhost:8808/SAMPLE-SERVER";
        RmiSample client=(RmiSample) Naming.lookup(url);
        int result=client.sum(1,3);
        System.out.print(result);
    }
}
