package com.git.wuqf.registry;

import com.git.wuqf.constant.ZKConstant;
import com.github.zkclient.IZkClient;
import com.github.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class ServiceRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ServiceRegistry.class);
    private String registryAddress;
    private ZookeeperUtil zookeeperUtil;

    public ServiceRegistry(String registryAddress) {
        this.registryAddress = registryAddress;
        zookeeperUtil=new ZookeeperUtil(registryAddress);
    }

    public void register(String data) {
        zookeeperUtil.createNode(ZKConstant.ZK_DATA_PATH,data);
    }
}
