package com.wenjie.case1;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributClient {
    private static final    String connectionString="192.168.12.132:2181";
    private static final int sessionTimeout=4000;
    private ZooKeeper zooKeeper;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributClient client = new DistributClient();
//        获取zk连接
        client.getconnection();
//        监听/servers下面子节点的增加和删除
        client.getServersList();

//        业务逻辑
        client.business();
        System.in.read();
    }
    private void business() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void getServersList() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/servers", true);

        List<String> list=new ArrayList<>();
        for (String child: children) {
            byte[] data = zooKeeper.getData("/servers/" + child, false, null);
            if (data==null){

            }else {
                list.add(new String(data).intern());
            }


        }
        System.out.println(list);
    }

    private void getconnection() throws IOException {
        zooKeeper = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getServersList();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
