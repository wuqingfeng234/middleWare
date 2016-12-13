package com.git.wuqf;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class RmiSampleImpl extends UnicastRemoteObject implements  RmiSample {

    public RmiSampleImpl() throws RemoteException {
        super();
    }
    public int sum(int a, int b) throws RemoteException {
        return a+b;
    }
}
