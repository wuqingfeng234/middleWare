package com.git.wuqf.rmiserver;

import com.git.wuqf.Person;
import com.git.wuqf.RmiSample;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by wuqf on 2016/12/13.
 */
public class RmiSampleImpl extends UnicastRemoteObject implements RmiSample {

    public RmiSampleImpl() throws RemoteException {
        super();
    }

    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    public Person grow(Person person) throws RemoteException {
        person.setAge(person.getAge() + 1);
        return person;
    }
}
