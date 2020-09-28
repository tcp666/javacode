package weather;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ReadClass {
    public void getClasses(File jarfile){
        try {
            JarFile jarFile=new JarFile(jarfile);
            Enumeration<JarEntry> enumerations=jarFile.entries();
            FileOutputStream fileOutputStream=new FileOutputStream(new File("classses.txt"));
            while ( enumerations.hasMoreElements()) {
                JarEntry jarEntry =  enumerations.nextElement();
              String string=  jarEntry.getName()+'\n';
              fileOutputStream.write(string.getBytes());
            }
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
      new ReadClass().getClasses(new File("D:\\SpringDemos\\javacode\\out\\production\\javacode\\threads\\uitl\\javax.mail.jar"));
    }
}
