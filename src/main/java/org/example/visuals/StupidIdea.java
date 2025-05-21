package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class StupidIdea extends JButton {
    private Runnable method;
    private int xCor, yCor, height,width;
    private Color color;
    private String text;
    private static HashMap<Object, ButtonPanel> panel;
    private Object objectAttached;

    public StupidIdea(int xCor, int yCor, Color color, String text, int width, int height, Object called){

        this.color = color;
        this.xCor = xCor;
        this.yCor = yCor;
        this.text = text;
        this.width = width;
        this.height = height;
        this.objectAttached = called;

        setSize(new Dimension(width, height));
        setLocation(xCor,yCor);
        setText(this.text);
        setBackground(this.color);


        if(panel.containsKey(called)){
            panel.get(this.objectAttached).add(this);
        }
        else{
            panel.put(this.objectAttached, new ButtonPanel());
            panel.get(this.objectAttached).add(this);

            objectAttached.getClass().getDeclaredMethod();
        }
    }

    private class ButtonPanel extends JPanel{
        public ButtonPanel(){
            setLayout(new GridLayout());
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
