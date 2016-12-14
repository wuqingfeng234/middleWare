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

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRegistry.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private String registryAddress;

    public ServiceRegistry(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public void register(String data) {
        if (data != null) {
            IZkClient zk = connectServer();
            if (zk != null) {
                createNode(zk, data);
            }
        }
    }

    private IZkClient connectServer() {

        IZkClient zkClient = new ZkClient(registryAddress);
        zkClient.connect(10000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    latch.countDown();
                }
            }
        });
        return zkClient;
    }

    private void createNode(IZkClient zk, String data) {

        byte[] bytes = data.getBytes();
        zk.createPersistent(ZKConstant.ZK_DATA_PATH,true);
        zk.writeData(ZKConstant.ZK_DATA_PATH, bytes);
        LOGGER.debug("create zookeeper node ({} => {})", ZKConstant.ZK_DATA_PATH, data);

    }
}
