package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph extends JPanel {
    public double xAxis;
    public double yAxis;
    public double step;
    private ArrayList<Point> points;
    private int screenWidth;
    private int screenHeight;
    private JFrame screen;
    private panel panels;


    public Graph(double xAxis, double yaxis, double step){
        this.xAxis = xAxis;
        this.yAxis = yaxis;
        this.step =  step;
        createScreen();

    }
    public Graph(double yAxis, double xAxis, double step, Point[] data){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.step =  step;
        this.points.addAll(Arrays.asList(data));
        createScreen();

    }
    public Graph(double yAxis, double xAxis, double step, Point[] data, int screenWidth, int screenHeight){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.step =  step;
        this.points.addAll(Arrays.asList(data));
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        createScreen();

    }
    public Graph(double yAxis, double xAxis, double step, int screenWidth, int screenHeight){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.step =  step;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        createScreen();
    }

    public List<Point> getPoints() {
       return points;
    }
    public void addPoint(double xCor, double yCor){
        points.add(new Point(xCor, yCor));
    }


    private void createScreen(){
        this.panels = new panel();

        this.screen = new JFrame("Graph");
        this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.screen.add(this.panels);

        this.screen.setSize(new Dimension(this.screenWidth, this.screenHeight));
        this.screen.setVisible(true);


    }

    class Point{
        double xCor;
        double yCor;
        Color color;
        public Point(double xCor, double yCor){
            this.xCor = xCor;
            this.yCor = yCor;
            this.color = Color.black;


        }

    }
    static class panel extends JPanel{
        @Override
        public void paintComponents(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.drawLine(0, 0,0,0);

        }
    }


}
