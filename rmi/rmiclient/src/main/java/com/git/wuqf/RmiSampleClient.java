package com.git.wuqf;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;

/**
 * Hello world!
 *
 */
public class RmiSampleClient
{
    public static void main( String[] args ) throws Exception
    {
        //********************** jdk1.3及以下版本**************************//
        // RmiSample client=(RmiSample) Naming.lookup(url);
        //********************** jdk1.3及以下版本**************************//

        //**********************高版本jdk**************************//
        Context context=new InitialContext();
        RmiSample client= (RmiSample) context.lookup(Url.SAMPLE);
        //**********************高版本jdk**************************//

        int result=client.sum(1,3);
        System.out.print(result);
    }
}
