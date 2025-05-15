package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

//pivot
public class ScreenThing {
    private int height;
    private int width;
    private Panel panel;
    private static final JFrame window = new JFrame("number");
    private DrawThing.Pixel[][] pixels;

    public ScreenThing(){
        window.setSize(new Dimension(1000,800));

    }
    private class Panel extends  JPanel{
        public Pixel[][] pixels;
        public HashMap<Color, ArrayList<Pixel>> thingsToColor;


        public Panel(int width, int height){
            pixels = new Pixel[height][width];
            ArrayList<Pixel> temp = new ArrayList<>();
            thingsToColor.put(Color.white, temp);
            temp = new ArrayList<>();
            thingsToColor.put(Color.black, temp);
            temp = new ArrayList<>();
            thingsToColor.put(Color.gray, temp);

            int screenWidth = ScreenThing.window.getWidth();
            int reltiveSideLength = screenWidth /width;
            int ycor = 0, xcor = 0;

            for(int row = 0; row < height; row++){
                ycor += (int) reltiveSideLength;
                xcor = 0;
                for(int col = 0; col < width; col++){
                    pixels[row][col] = new Pixel(xcor, ycor, reltiveSideLength, reltiveSideLength);
                    xcor += reltiveSideLength;
                    thingsToColor.get(pixels[row][col].color).add(pixels[row][col]);
                }
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            for(Map.Entry< Color, ArrayList<Pixel>> set: thingsToColor.entrySet()){
                g.setColor(set.getKey());
                for(set.getValue())
            }
        }


    }
    public class Pixel extends Rectangle{
        private int height;
        private int width;
        private Color color;
        public int xcor;
        public int ycor;

        public Pixel(int xcor, int ycor, int width, int height){
            super(xcor, ycor, width, height);
            this.xcor = xcor;
            this.ycor = ycor;
            this.color = Color.WHITE;

        }

    }
}
