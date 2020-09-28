import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/file/{name}")
public class FileServer {

    Session session=null;
    String name=null;
    @OnOpen
    public void onOpen(Session session,@PathParam("name")String name){
        System.out.println(name);
        this.session=session;
        this.name=name;
    }
    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("message");
        System.out.println(message);
        session.getBasicRemote().sendText(message);
    }
    @OnError
    public void OnError(Session session,Throwable error){

        System.out.println("error");
    }
    @OnClose
    public void onClose(){
        System.out.println(111111111);
    }
}
