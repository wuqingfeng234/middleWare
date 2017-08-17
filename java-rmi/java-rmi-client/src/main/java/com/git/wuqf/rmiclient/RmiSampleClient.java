package com.git.wuqf.rmiclient;

import com.git.wuqf.Person;
import com.git.wuqf.RmiSample;
import com.git.wuqf.Url;

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

        Person person=new Person("wuqf",1);
        person=client.grow(person);
        System.out.println(person);
    }
}
