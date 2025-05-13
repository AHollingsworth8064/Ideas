package org.example.visuals;

import javax.swing.*;
import java.awt.*;

//pivot
public class ScreenThing {
    private int height;
    private int width;
    private Panel panel;
    private final JFrame window = new JFrame("number");
    private DrawThing.Pixel[][] pixels;

    public ScreenThing(){
        window.setSize(new Dimension(1000,800));

    }
    private class Panel extends  JPanel{
        public Panel(int width, int height){
            ;
        }

    }
}
