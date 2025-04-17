package org.example;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    public double xAxis;
    public double yAxis;
    public double step;
    private ArrayList<Point> points;
    private int screenWidth;
    private int screenHeight;
    private JFrame screen;
    private Panels panel;
    private int xGraphTicks;
    private int yGraphTicks;



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
    public Graph(double yAxis, double xAxis, double step, int screenWidth, int screenHeight,Tuple<Double, Double>[] data){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.step =  step;
        for(Tuple cord: data){
            this.points.add(new Point((int)cord.x,(int)cord.y));
        }
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
        this.xGraphTicks = (int)(screenWidth -100)/10;
        this.yGraphTicks = (int)(screenHeight -100)/10;

        System.out.println("no");
        this.panel = new Panels();

        this.screen = new JFrame("Graph");

        this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.screen.add(this.panel);

        this.screen.setSize(this.screenWidth,this.screenHeight);
        this.screen.setVisible(true);


    }

    private class Point{
        public double xCor;
        public double yCor;
        private double reltiveX;
        private double reltiveY;

        public Color color;
        public Point(double xCor, double yCor){
            this.xCor = xCor;
            this.yCor = yCor;
            this.reltiveX = (Graph.this.screenWidth - 100)/step;
            this.color = Color.black;
        }

    }

    class Panels extends JPanel{

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int yAxisXcor = Graph.this.screenHeight-50;
            int xAxisYCor =Graph.this.screenHeight-50;

            g.drawLine(50, xAxisYCor, Graph.this.screenWidth-50,Graph.this.screenHeight-50 );
            g.drawLine(50, 25, 50,Graph.this.screenHeight-50 );//y axis


            for(int i  = 50 + xGraphTicks; i < Graph.this.screenWidth-50; i += xGraphTicks){
                g.drawLine(i,xAxisYCor -2 , i, xAxisYCor + 2 );
            }


        }
    }
}


