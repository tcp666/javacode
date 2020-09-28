package os.ff;

public class DynamicStoreAlgorithmImpl implements DynamicStoreAlgorithm{
	
	private MNode mHeadNode;
	
	public DynamicStoreAlgorithmImpl()
	{
		mHeadNode = new MNode();
	}

	//分配分区
	@Override
	public boolean allocatePartition(Process process) {
		boolean flag = false;
		MNode Node = mHeadNode;
		while(Node.getNextNode() != null){
			Node = Node.getNextNode();
			if(Node.getSize()>process.getpSize()){  //当进程所需的大小小于空闲内存分区时；
				flag = true;
				//申请新的内存空间，并进行初始化
				MNode mNode = new MNode();
				mNode.setSize(process.getpSize());
				mNode.setStartIndex(Node.getStartIndex());
				mNode.setFree(false);
				mNode.setProcessName(process.getpName());
				
				//修改原来结点的数据结构
				Node.setSize(Node.getSize()-process.getpSize());
				Node.setStartIndex(Node.getStartIndex()+process.getpSize());
				
				//改变当前链表指针的指向
				MNode m = Node.getPreNode();
				mNode.setPreNode(m);
				Node.getPreNode().setNextNode(mNode);
				Node.setPreNode(mNode);
				mNode.setNextNode(Node);
				break;
			}else if(Node.getSize()== process.getpSize()){
				flag = true;
				Node.setProcessName(process.getpName());
				Node.setFree(false);
				break;
			}
			
		}
		//若flag为真，则找到分区分配给进程；若为假则没有适当的空闲分区可以分配给该进程
		if(flag){
			return true;
		}
		else
			return false;
	}
 
	@Override
	public void init(int size) {
		// TODO Auto-generated method stub	
		MNode mNode = new MNode();
		mNode.setNextNode(null);
		mNode.setPreNode(mHeadNode);
		mNode.setStartIndex(0);
		mNode.setSize(size);
		mNode.setFree(true);
		
		mHeadNode.setPreNode(null);
		mHeadNode.setNextNode(mNode);
		
	}
 //回收分区
	@Override
	public boolean recoverPartition(Process process) {

		boolean flag = false;
		MNode node = mHeadNode;
		while(node.getNextNode()!= null){
			node = node.getNextNode();
			if(node.getProcessName()!=null && node.getProcessName().equals(process.getpName())){
				node.setFree(true);
				node.setProcessName(null);
				unitPartition(node);
				flag=true;
				break;
			}
		}
		return flag;
	}
 
	@Override
	public void unitPartition(MNode mnode) {
		// TODO Auto-generated method stub
		MNode preNode = mnode.getPreNode();
		MNode nextNode = mnode.getNextNode();
		
		if(preNode.isFree()&&nextNode.isFree()){
			int size = preNode.getSize()+mnode.getSize()+nextNode.getSize();
			preNode.setSize(size);
			preNode.setNextNode(nextNode.getNextNode());
		}else if(!preNode.isFree() && nextNode.isFree()){
			int size = mnode.getSize()+nextNode.getSize();
			mnode.setSize(size);
			mnode.setNextNode(nextNode.getNextNode());
		}else if(preNode.isFree() && !nextNode.isFree()){
			int size = preNode.getSize()+mnode.getSize();
			preNode.setSize(size);
			preNode.setNextNode(nextNode);
		}
	}
 
	@Override
	public void show() {
		// TODO Auto-generated method stub
		MNode node = mHeadNode;
		System.out.println("分区号"+"\t"+"开始地址"+"\t"+"分区大小"+"\t"+"状态(t空 f忙)"+"\t"+"运行进程");
		int i=1;
		while(node.getNextNode()!= null){
			node = node.getNextNode();
			System.out.println(i+"\t\t"+node.getStartIndex()+"\t\t"+node.getSize()+"\t\t"+node.isFree()+"\t\t"+node.getProcessName());
			i++;
		}
	}
	
}