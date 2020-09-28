package newiodemo.chat;

import java.io.IOException;
import java.util.Scanner;

public class TestChat {

    public static void main(String[] args) throws IOException {
        ChatClient chatClient=new ChatClient();

        new Thread(){
            @Override
            public void run() {
               while (true){
                   try {
                       chatClient.receiveMsg();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start();

        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNextLine()){
            String msg=scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }



}
