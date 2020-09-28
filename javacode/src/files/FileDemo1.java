package files;

import java.io.File;

public class FileDemo1 {
        public static int i=1;
    public static void moveTo(File file){


        if (file!=null&&file.isFile()&&file.getName().endsWith(".doc")){
            System.out.println(file.getAbsolutePath());
        }
        else
        {
            File[] files=file.listFiles();
                if (files!=null)
            for (File file1:files) {
                moveTo(file1);
            }
        }


    }
    public static void main(String[] args) {
            File file=new File("C:\\");

            moveTo(file);
    }
}
