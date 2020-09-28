package tcp.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Calculator extends Remote {

    public int add(int a, int b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
    public int mul(int a, int b) throws RemoteException;
    public double div(int a, int b) throws RemoteException;
    public int fac(int a) throws RemoteException;
    public int pow(int a, int b) throws RemoteException;
    public long facFibonacci(int a) throws RemoteException;

}