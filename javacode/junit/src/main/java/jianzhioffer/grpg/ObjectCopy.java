package jianzhioffer.grpg;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.omg.CORBA.Object;

import java.io.*;

public class ObjectCopy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User(1, "lisi");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(user);
        ByteArrayInputStream bai = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bai);
        User user1 = (User) ois.readObject();
        System.out.println(user1 + ":\n" + user);


    }

    static class User extends OutputStream implements Serializable {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public void write(int b) throws IOException {

        }
    }
}
