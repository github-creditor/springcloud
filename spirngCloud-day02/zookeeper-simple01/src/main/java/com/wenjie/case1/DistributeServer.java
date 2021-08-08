package com.wenjie.case1;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {

    static final String connetionString = "192.168.12.132:2181";
    static final int sessionTimeout = 20000;
    private ZooKeeper zooKeeper;


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//  获取zk连接
        DistributeServer server = new DistributeServer();
        server.getConnetion();

//        注册服务器到zk集群
        server.regist(args[0]);

//        启动业务逻辑
        server.business();


    }

    private void business() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zooKeeper.create("/servers/" + hostname, hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + "已经上线了");


    }

    private void getConnetion() throws IOException {



        zooKeeper = new ZooKeeper(connetionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {


            }
        });
    }


}
