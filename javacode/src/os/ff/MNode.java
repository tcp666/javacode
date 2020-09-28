package os.ff;

public class MNode {
	private String processName; //正在使用的进程号
	private MNode preNode;      //前驱结点
	private MNode nextNode;		//后继结点
	private int startIndex;		//开始地址
	private boolean free;		//分区状态 1.true表示空闲 2.false表示使用
	private int size;           //分区大小
	
	public String getProcessName() {

		return processName;
	}
	public void setProcessName(String processName)
	{

		this.processName = processName;
	}
	public MNode getPreNode() {

		return preNode;
	}
	public void setPreNode(MNode preNode) {

		this.preNode = preNode;
	}
	public MNode getNextNode()
	{

		return nextNode;
	}
	public void setNextNode(MNode nextNode)
	{

		this.nextNode = nextNode;
	}
	public int getStartIndex()

	{
		return startIndex;
	}
	public void setStartIndex(int startIndex) {

		this.startIndex = startIndex;
	}
 
	public boolean isFree() {

		return free;
	}
	public void setFree(boolean free) {

		this.free = free;
	}
	public int getSize() {

		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	
	
}

