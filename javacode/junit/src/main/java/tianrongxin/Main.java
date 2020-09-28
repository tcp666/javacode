package tianrongxin;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
            int n;
            int m;
            n=sc.nextInt();
            m=sc.nextInt();
            double sum=0.0;
            double n1=n*1.0;
            for(int i=0;i<m;i++){

                double t= Math.sqrt(n1*1.0);
                sum+=t;
                n1=t;

            }
            System.out.println(sum+n);
        }
    }
}