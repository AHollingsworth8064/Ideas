package org.example.unOrganized;

import sun.misc.OSEnvironment;

import javax.swing.*;
import java.awt.*;

public class Screen {
    static final JFrame screenManger = new JFrame();
    private final Container pane = screenManger.getContentPane();
    private JPanel renderingPanel;
    private JSlider verticalRotation;
    private JSlider horizontalRotation;


    public Screen(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pane.setLayout(new BorderLayout());


    }


}
