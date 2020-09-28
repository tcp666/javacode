package clientcode;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame("hello,world");
        frame.setSize(1000,800);
        frame.setBackground(Color.CYAN);
        frame.setLocation(0,0);
        frame.setVisible(true);

    }
}
