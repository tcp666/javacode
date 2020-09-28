package tcp.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class CalculatorImp extends UnicastRemoteObject implements Calculator {

    private static final long serialVersionUID = 1L;
    public CalculatorImp() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException{
        return a + b;
    }
    public int sub(int a, int b) throws RemoteException{
        return a - b;
    }
    public int mul(int a, int b) throws RemoteException{
        return a * b;
    }
    public double div(int a, int b) throws RemoteException{
        return a / b;
    }
    public int fac(int a) throws RemoteException{
        int res=1;
        for (;a!=0;a--){
            res*=a;
        }
        return res;
    }
    public int pow(int a, int b) throws RemoteException{
        int res=1;
        for (;b!=0;b--){
            res*=a;
        }
        return res;
    }
    public long facFibonacci(int a) throws RemoteException{
        if(a == 0)
            return 0;
        else if(a == 1)
            return 1;
        else
            return facFibonacci (a-1) + facFibonacci (a-2);
    }
}