package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class DrawThing implements ActionListener {
    private int height;
    private int width;
    private Panel panel;
    private JFrame window = new JFrame("number");
    private Pixel[][] pixels;

    public  DrawThing(int height, int width){
        this.height = height;
        this.width = width;
        this.pixels = new Pixel[height][width];



        for(int row = 0; row < height; row++){
            for(int col = 0;col < width; col++){
                pixels[row][col] = new Pixel();
                pixels[row][col].addActionListener(this);

                window.add(pixels[row][col]);
            }
        }
        window.setSize(new Dimension(1000,800));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(height,width+1));
        window.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Pixel tempVal = (Pixel) e.getSource();
       tempVal.setBackground(Color.PINK);
    }


    class Pixel extends JButton{
        private Color color;
        private final JButton button = new JButton();

        public Pixel(){

            this.setBorderPainted(true);
            this.setOpaque(true);
            this.setBackground(Color.BLACK);
            this.setVisible(true);

        }
        public void updateColor(Color color){
            this.setForeground(color);
            this.color = color;

        }
        public void updateColorViaDistance(int distance){
            Color newColor = this.color;
            for(int i = 0; i < distance; i++){
                newColor = newColor.brighter();
            }
            this.color = newColor;
            this.setBackground(newColor);
        }
    }
}

