package threads.files;

import java.io.File;

public class SearforCrx {
    static void search(File file){
        if (file!=null&&file.getName().endsWith(".jpg")||file.getName().endsWith(".png"))
            System.out.println(file.getAbsolutePath());
        else{
            File[] files=file.listFiles();
            if (files!=null) {
                for (File f:files){
                   search(f);
                }
            }
        }

    }

    public static void main(String[] args) {
        File file=new File("D:\\");
        search(file);
    }
}
