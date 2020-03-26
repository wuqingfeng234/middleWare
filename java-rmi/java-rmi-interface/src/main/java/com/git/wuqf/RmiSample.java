package com.git.wuqf;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by wuqf on 2016/12/13.
 */
public interface RmiSample extends Remote {
    int sum(int a, int b) throws RemoteException;

    Person grow(Person person) throws RemoteException;
}
