package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

//pivot
public class ScreenThing {

    private int height;
    private int width;
    private Panel panel;
    private static final JFrame window = new JFrame("number");
    private DrawThing.Pixel[][] pixels;
    boolean mouseHeld;


    public ScreenThing(){
        window.setSize(new Dimension(1000,800));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel(28,28);
        window.add(panel);
        window.repaint();
        window.setVisible(true);
        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.updateColor(e.getX(), e.getY());
                window.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {


            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        window.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panel.updateColor(e.getX(), e.getY());
                window.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
    private class Panel extends  JPanel{
        public Pixel[][] pixels;
        public HashMap<Color, ArrayList<Pixel>> thingsToColor= new HashMap<>();
        private final int reltiveSideLength;
        private final int screenHeight;


        public Panel(int width, int height){

            this.pixels = new Pixel[height][width];
            ArrayList<Pixel> e = new ArrayList<>();
            thingsToColor.put(colors.black.color,new ArrayList<>());
            thingsToColor.put(colors.white.color, new ArrayList<>());
            thingsToColor.put(colors.gray.color, new ArrayList<>());

            this.screenHeight = ScreenThing.window.getHeight()-20;

            reltiveSideLength = screenHeight /height;
            int ycor = 10, xcor = 10;

            for(int row = 0; row < height; row++){
                xcor = 10;
                for(int col = 0; col < width; col++){
                    Pixel tempPixel = new Pixel(xcor, ycor, reltiveSideLength, reltiveSideLength);
                    thingsToColor.get(colors.black.color).add(tempPixel);
                    xcor += reltiveSideLength;
                    pixels[row][col] = tempPixel;

                }
                ycor += (int) reltiveSideLength;
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(Map.Entry< Color, ArrayList<Pixel>> set: thingsToColor.entrySet()){
                g2.setColor(set.getKey());
                for(Pixel pixel: set.getValue()){
                    g2.fillRect(pixel.x,pixel.y,reltiveSideLength,reltiveSideLength);
                }
            }
        }

        public void updateColor(int x, int y){
            if(!(x > 10 && x < screenHeight) || !(y > 10 && y < screenHeight)){
                return;
            }
            try {
                int tempX = x / reltiveSideLength, tempY = y / reltiveSideLength;
                Pixel tempClickedPixel = pixels[tempY - 1][tempX];
                thingsToColor.get(tempClickedPixel.color).remove(tempClickedPixel);
                thingsToColor.get(colors.white.color).add(tempClickedPixel);
                tempClickedPixel.color = colors.white.color;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.print(x + ",");
                System.out.println(y);
            }

           // Pixel tempXPixel = null, tempYPixel = null;
  //          Color tempXPixelColor = null, tempYPixelColor = null;
//
//            if(x < tempClickedPixel.getCenterX()-5 && !pixels[tempY][tempX-1].color.equals(colors.white.color)){
//                tempXPixel = pixels[tempY][tempX -1 ];
//                tempXPixelColor = colors.gray.color;
//            } else if (x > tempClickedPixel.getCenterX()+5 && !pixels[tempY][tempX + 1].color.equals(colors.white.color)) {
//                tempXPixel = pixels[tempY][tempX + 1];
//                tempXPixelColor = colors.gray.color;
//            }
//            if(y < tempClickedPixel.getCenterY()-5 && !pixels[tempY-1][tempX].color.equals(colors.white.color)){
//                tempYPixel = pixels[tempY-1][tempX];
//                tempYPixelColor = colors.gray.color;
//            } else if (y > tempClickedPixel.getCenterY()+5 && !pixels[tempY+1][tempX ].color.equals(colors.white.color)) {
//                tempYPixel = pixels[tempY+1][tempX];
//                tempYPixelColor = colors.gray.color;
//            }
//            if(tempYPixel != null){
//                thingsToColor.get(tempYPixel.color).remove(tempYPixel);
//                thingsToColor.get(tempYPixelColor).add(tempYPixel);
//                tempYPixel.color = tempYPixelColor;
//
//            }
//            if(tempXPixel != null){
//                thingsToColor.get(tempXPixel.color).remove(tempXPixel);
//                thingsToColor.get(tempXPixelColor).add(tempXPixel);
//                tempXPixel.color = tempXPixelColor;
//
//            }

        }
        public void clearScreen(){
            for(int i = 0; i < thingsToColor.get(colors.black.color).size(); i ++){
               thingsToColor.get(colors.black.color).get(i).color = colors.white.color;
               thingsToColor.get(colors.black.color).add( thingsToColor.get(colors.black.color).remove(i));
            }
            for(int i = 0; i < thingsToColor.get(colors.black.color).size(); i ++){
                thingsToColor.get(colors.gray.color).get(i).color = colors.white.color;
                thingsToColor.get(colors.gray.color).add( thingsToColor.get(colors.gray.color).remove(i));
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
            this.color = colors.black.color;

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