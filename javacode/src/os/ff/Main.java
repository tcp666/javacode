package os.ff;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		DynamicStoreAlgorithmImpl dsa = new DynamicStoreAlgorithmImpl();
		dsa.init(1024);
		String operation=null;
		System.out.println("'add'添加进程 'delete'删除进程 'view'查看内存当前状态 'end'结束程序");
		do{
			operation = input.next();
			if("add".equals(operation)){
				System.out.println("请输入要添加的进程名和所需的内存大小。");
				Process process = new Process();
				String name = input.next();
				int size = input.nextInt();
				process.setpName(name);
				process.setpSize(size);
				dsa.allocatePartition(process);
				System.out.println("进程正在运行...");
			}else if("delete".equals(operation)){
				System.out.println("请输入要删除的进程名。");
				Process process = new Process();
				String name = input.next();
				process.setpName(name);
				if(dsa.recoverPartition(process)){
					System.out.println("进程已撤销...");
				}else{
					System.out.println("进程不存在...");
				}
			}else if("view".equals(operation)){
				System.out.println("当前的内存状态");
				dsa.show();
			}
			
		}while(!("end").equals(operation));
		
	}
}
