package os.ff;

public interface DynamicStoreAlgorithm {
	 void init(int size);   //初始化分区链表
	 boolean allocatePartition(Process process);  //分配分区
	 boolean recoverPartition(Process process);   //回收分区
	 void unitPartition(MNode mnode);  //合并空闲分区
	 void show(); //显示当前的内存状态	
}
