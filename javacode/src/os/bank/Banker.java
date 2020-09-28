package os.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
/**
 * 
 * 银行家算法类
 *
 */
public class Banker {
	private final static int[] total = { 10, 5, 7 };// A资源数量为10，B资源的数量为5，C资源的数量为7	 
 
	public List<Person> addProcess() { //控制台输入进程信息
		List<Person> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			Person p = new Person();
			System.out.println("请输入进程" + (i + 1) + "的名字");
			String name = sc.next();
			p.setName(name);
			System.out.println("请输入进程" + (i + 1) + "的最大占有资源Max");
			int[] max = inputArray(sc);
			p.setMax(max);
			System.out.println("请输入进程" + (i + 1) + "的当前占有资源Allocation");
			int[] allocation = inputArray(sc);
			p.setAllocation(allocation);
			int[] need = inputNeed(p);
			p.setNeed(need);
			list.add(p);
		}
		return list;
	}
 
	public int[] getAvailable(List<Person> list) { //根据输入的进程来计算剩下的可分配资源
		int[] available = new int[3];
		List<Person> ls = new ArrayList<>(list);
		available[0] = total[0];
		available[1] = total[1];
		available[2] = total[2];
		for (Person p : ls) {
			available[0] = available[0] - p.getAllocation()[0];
			available[1] = available[1] - p.getAllocation()[1];
			available[2] = available[2] - p.getAllocation()[2];
		}
		return available;
 
	}
 
	public List<Person> bankerAlgor(List<Person> list, int[] available) { //银行家算法
		List<Person> listProcess = new ArrayList<>(list);
		List<Person> ls = new ArrayList<>();
		List<Person> newList = new ArrayList<>();
		System.out.println("----------------------------------------------------------------");
		System.out.println("   |   Work    |    Need   | Allocation|   Work +  |  Finish ");
		System.out.println("   |           |           |           | Allocation|        ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("   | [A, B, C] | [A, B, C] | [A, B, C] | [A, B, C] |     ");
		System.out.println("----------------------------------------------------------------");
		while (!listProcess.isEmpty()) {
			Iterator<Person> iterator = listProcess.iterator();
			while (iterator.hasNext()) {
				Person p = iterator.next();
				if ((p.getNeed()[0] <= available[0])
						&& (p.getNeed()[1] <= available[1])
						&& (p.getNeed()[2] <= available[2])) {
					ls.add(p);
				}
			}
			if(ls.isEmpty()){
				iterator = listProcess.iterator();
				while(iterator.hasNext()){
					Person p =iterator.next();
					p.setFinish(false);
					p.printSafetyProcess();
					iterator.remove();
				}
				System.out.println("可用资源不满足任何进程的需要，系统进入不安全状态");
				return null;
			}
			Person p = getNeedMax(ls);
			listProcess.remove(p);
			p.setWork(Arrays.copyOf(available, available.length));	
			for(int i=0;i<3;i++){
				available[i] +=p.getAllocation()[i];
			}
			p.setWAndAllocation(Arrays.copyOf(available, available.length));
			p.setFinish(true);
			newList.add(p);
			p.printSafetyProcess();			
			ls.clear();
		}
		return newList;
	}
 
	public Person getNeedMax(List<Person> list) { //优先算法，优先选择需求资源大的进程
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i).getNeed()[0] + list.get(i).getNeed()[1]
					+ list.get(i).getNeed()[2];
		}
		int j = 0;
		if (a.length != 1) {
			for (int k = 1; k < a.length; k++) {
				if (a[j] <= a[k]) {
					j = k;
				}
			}
		}
		return list.get(j);
	}
	
	public void request(List<Person> list, String name, int[] req){ //进程发起请求资源算法
		int[] available=getAvailable(list);
		List<Person> rList = new ArrayList<>(list);
		for(int i=0;i<rList.size();i++){
			if(rList.get(i).getName().equals(name)){
				Person p = rList.get(i);
				if(judgeProcessRequest(p, req, available)){
					int[] allocation = new int[3];
					allocation[0]=p.getAllocation()[0]+req[0];
					allocation[1]=p.getAllocation()[1]+req[1];
					allocation[2]=p.getAllocation()[2]+req[2];
					int[] need = new int[3];
					need[0]=p.getNeed()[0]-req[0];
					need[1]=p.getNeed()[1]-req[1];
					need[2]=p.getNeed()[2]-req[2];
					p.setNeed(need);
					p.setAllocation(allocation);	
					break;
				}else{
					System.out.println("申请资源大于需要资源或者大于可分配资源，不能分配");
					return;
				}
			}
		}
		available=Arrays.copyOf(getAvailable(rList), available.length);
		rList=bankerAlgor(rList, available);
		if(rList!=null){
			System.out.println("所申请的资源可以立即分配给"+name);
		}else{
			System.out.println("系统不分配资源");
		}
		
	}
	
	public boolean judgeProcessRequest(Person p, int[] request, int[] available){
		for(int i=0;i<3;i++){
			if(request[i]>p.getNeed()[i]||request[i]>available[i]){
				return false;
			}
		}
		return true;
	}
	
	public List<Person> show() { //显示进程的信息
		List<Person> list = addProcess();
		System.out.println("----------------------------------------");
		System.out.println("   |    Max    | Allocation|    Need   |");
		System.out.println("----------------------------------------");
		System.out.println("   | [A, B, C] | [A, B, C] | [A, B, C] |");
		System.out.println("----------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			p.printProcess();
		}
		System.out.println("Available : " + Arrays.toString(getAvailable(list)));
		System.out.println();
		return list;
	}
 
	public int[] inputArray(Scanner sc) { //控制台输入数组信息
		int[] array = new int[3];
		for (int i = 0; i < 3; i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}
 
	public int[] inputNeed(Person p) { //计算进程的需要资源
		int[] need = new int[3];
		need[0] = p.getMax()[0] - p.getAllocation()[0];
		need[1] = p.getMax()[1] - p.getAllocation()[1];
		need[2] = p.getMax()[2] - p.getAllocation()[2];
		return need;
	}
}