package os.bank;

import java.util.List;
import java.util.Scanner;
 
/**
 * 
 * 测试类
 *
 */
public class TestMain {
 
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Banker banker = new Banker();
		List<Person> list =banker.show();
		List<Person> newList=banker.bankerAlgor(list,banker.getAvailable(list));
		if(newList!=null){
			StringBuilder name = new StringBuilder();
			for(int i=0;i<newList.size();i++){
				name.append(newList.get(i).getName()).append(" ");
			}
			System.out.println("存在安全序列有："+name.toString());
			System.out.println("---------------------------------------------");
			System.out.println("是否发出资源请求？  1、是         2、否");
			Scanner sc = new Scanner(System.in);			
			int i =sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("输入申请资源的进程名");
				String processName = sc.next();
				System.out.println("输入申请的资源");
				int[] request = banker.inputArray(sc);
				banker.request(list, processName, request);
				break;
			default:
				break;
			}
			
			
			
		}
	
	}
 
}
