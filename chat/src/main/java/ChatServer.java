import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ServerEndpoint("/chat/{param}")
public class ChatServer {
    final static Object object=new Object();
    /**
     * 保存所有会话  map
     * 保存当前会话
     *  session
     */
public static Map<String,Session> map=new HashMap<String, Session>();
   private Session session=null;
   private String name=null;
public static List<Session> list=new LinkedList();
    /**
     * 带参建立连接
     * @param session
     * @param param 会话name
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("param")String param){

       synchronized (object){
           System.out.println("onOpen....."+session+":"+param);
           this.session=session;
           System.out.println(param);
           this.name=param;
           if (!list.contains(session))
                list.add(session);
       }
    }
    @OnMessage
    public void onMessage(String message) throws IOException {
    synchronized (object){

        System.out.println(list.size());
        System.out.println(message);
        for (Session s:list){
            System.out.println(s);
                s.getBasicRemote().sendText("<font size='45px' color='green'>"+name+"</font>"+":"+message);
        }

    }


    }
    @OnClose
    public void onClose(Session session) throws IOException {
//        map.remove(name);

synchronized (object) {
    list.remove(session);

    for (Session s : list) {
        if (!s.equals(session))
            s.getBasicRemote().sendText(name + ":退出了");
    }
}
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }



}
