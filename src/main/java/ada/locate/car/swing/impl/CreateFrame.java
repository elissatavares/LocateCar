package ada.locate.car.swing.impl;

import javax.swing.*;

import java.awt.*;

public class CreateFrame {
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static JFrame execute(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SCREEN_SIZE.width, SCREEN_SIZE.height);
        return frame;
    }
}