package org.lvzr.fast.bigdata.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {

	public static void main(String[] args) throws Exception {

		// ����һ��Zookeeperʵ������һ������ΪĿ���������ַ�Ͷ˿ڣ��ڶ�������ΪSession��ʱʱ�䣬
		//  ������Ϊ�ڵ�仯ʱ�Ļص�����
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 500000, new Watcher() {
			// ������б��������¼�
			public void process(WatchedEvent event) {
				System.out.println("�¼�---"+event.getType());
			}
		});
		
		// ����һ���ڵ�root��������mydata,������ACLȨ�޿��ƣ��ڵ�Ϊ�����Ե�(���ͻ���shutdown��Ҳ������ʧ)
		zk.create("/root", "mydata".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		// ��root���洴��һ��childone znode,����Ϊchildone,������ACLȨ�޿��ƣ��ڵ�Ϊ�����Ե�
		zk.create("/root/childone", "childone".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		// ȡ��/root�ڵ��µ��ӽڵ�����,����List<String>
		zk.getChildren("/root", true);

		// ȡ��/root/childone�ڵ��µ�����,����byte[]
		zk.getData("/root/childone", true, null);

		// �޸Ľڵ�/root/childone�µ����ݣ�����������Ϊ�汾�������-1���ǻ����ӱ��޸ĵ����ݰ汾��ֱ�Ӹĵ�
		zk.setData("/root/childone", "childonemodify".getBytes(), -1);

		// ɾ��/root/childone����ڵ㣬�ڶ�������Ϊ�汾����1�Ļ�ֱ��ɾ�������Ӱ汾
		zk.delete("/root/childone", -1);

		// �ر�session
		zk.close();

	}

}