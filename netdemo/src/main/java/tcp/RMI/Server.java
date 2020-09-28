package tcp.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Server {

    Calculator calculator;

    public static void main(String[] args) throws AlreadyBoundException, RemoteException, MalformedURLException {
        Server server = new Server();
        server.server();
    }

    public void server() throws RemoteException, MalformedURLException, AlreadyBoundException {
        calculator = new CalculatorImp ();

        LocateRegistry.createRegistry(8000);

        Naming.bind("rmi://localhost:8000/Cal", calculator);
        System.out.println("server:对象绑定成功！");
    }

}