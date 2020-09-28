package TcpTestDemo;




import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo implements Runnable {

    private int port;

    public ClientDemo(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        Scanner sc=new Scanner(System.in);

        try {
            socket=new Socket("127.0.0.1",port);
            byte[] bytes=new byte[1024];
            is=socket.getInputStream();
            int length=is.read(bytes);
            System.out.println(new String(bytes));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new ClientDemo(8878)).start();
    }
}
