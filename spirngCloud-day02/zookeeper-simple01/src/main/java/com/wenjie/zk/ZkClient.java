package com.wenjie.zk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {

    private String connectionString = "192.168.12.132:2181";
    //    这个值不要设置的太小了，否则的话会创建失败
    private int SessionTimeout = 20000;
    private ZooKeeper zooKeeper;

    @Before
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectionString, SessionTimeout, new Watcher() {

            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("-----------");
                List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/a", true);
                    System.out.println("------------");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/c", "true".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }


    @Test
    public void create1() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/b", "true".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(s);
    }

    @Test
    public void getChildern() throws KeeperException, InterruptedException, IOException {
//                                         设置为ture，代表会走初始化时的监听器
//                                          也可以自己new一个监听器
        List<String> children = zooKeeper.getChildren("/a", true);
        children.stream().forEach(s -> {
            System.out.println(s);
        });

        Thread.sleep(Long.MAX_VALUE);
    }


}
