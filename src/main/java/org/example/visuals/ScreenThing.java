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
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel(32,32);
        //window.add(panel);
        window.repaint();
        window.setVisible(true);
    }
    private class Panel extends  JPanel{
        public Pixel[][] pixels;
        public HashMap<Color, ArrayList<Pixel>> thingsToColor= new HashMap<>();
        private int reltiveSideLength;

        public Panel(int width, int height){

            ArrayList<Pixel> e = new ArrayList<>();
            thingsToColor.put(colors.black.color,new ArrayList<>());
            thingsToColor.put(colors.white.color, new ArrayList<>());
            thingsToColor.put(colors.gray.color, new ArrayList<>());

            int screenWidth = ScreenThing.window.getWidth();
            reltiveSideLength = screenWidth /width;
            int ycor = 0, xcor = 0;

            for(int row = 0; row < height; row++){
                ycor += (int) reltiveSideLength;
                xcor = 0;
                for(int col = 0; col < width; col++){
                    xcor += reltiveSideLength;
                    thingsToColor.get(colors.white.color).add(new Pixel(xcor, ycor, reltiveSideLength, reltiveSideLength));
                }
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            for(Map.Entry< Color, ArrayList<Pixel>> set: thingsToColor.entrySet()){
                g.setColor(set.getKey());
                for(Pixel pixel: set.getValue()){
                    g.fillRect(pixel.x,pixel.y,reltiveSideLength,reltiveSideLength);
                }
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
enum colors{
    white(Color.white),
    black(Color.BLACK),
    gray(Color.gray);


    public final Color color;
    colors(Color color) {
        this.color = color;
    }
}