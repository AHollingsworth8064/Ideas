package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

public class Button extends JButton {
    private Runnable method;
    private int xCor, yCor, height,width;
    private Color color;
    private String text;

    public Button(int xCor, int yCor, Color color, String text, int width, int height){


        this.color = color;
        this.xCor = xCor;
        this.yCor = yCor;
        this.text = text;
        this.width = width;
        this.height = height;

        move(xCor,yCor);
        setSize(new Dimension(200, 200));

    }
}
