package os.bank;

import java.util.Arrays;

/** 
 * 进程类
 */

public class Person {
	private String name; //进程名字
	
	private int[] max;  //进程的最大需求资源
	
	private int[] allocation; //进程的当前占有资源
	
	private int[] need; //进程的需要资源
	
	private int[] work; //进程当前可分配的资源
	
	private int[] wAndAllocation; // work + allocation
		
	private boolean isFinish; //进程是否能完成

	public String getName() {
		return name;
	}

	public int[] getMax() {
		return max;
	}

	public int[] getAllocation() {
		return allocation;
	}

	public int[] getNeed() {
		return need;
	}

	public int[] getWork() {
		return work;
	}

	public int[] getWAndAllocation() {
		return wAndAllocation;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMax(int[] max) {
		this.max = max;
	}

	public void setAllocation(int[] allocation) {
		this.allocation = allocation;
	}

	public void setNeed(int[] need) {
		this.need = need;
	}

	public void setWork(int[] work) {
		this.work = work;
	}

	public void setWAndAllocation(int[] wAndAllocation) {
		this.wAndAllocation = wAndAllocation;
	}

	public void setFinish(boolean finish) {
		isFinish = finish;
	}

	public void printProcess(){ //打印出输入的进程信息
		System.out.println(this.getName()+" | "
				+Arrays.toString(this.getMax())+" | "
				+Arrays.toString(this.getAllocation())+" | "
				+Arrays.toString(this.getNeed())+" | ");
	}
	public void printSafetyProcess(){ //打印出银行家算法分析后的进程情况
		System.out.println(this.getName()+" | "
				+Arrays.toString(this.getWork())+" | "
				+Arrays.toString(this.getNeed())+" | "
				+Arrays.toString(this.getAllocation())+" | "
				+Arrays.toString(this.getWAndAllocation())+" | "
				+this.isFinish());
	}
}
 