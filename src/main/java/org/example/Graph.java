package org.example;

import javax.swing.*;
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
        System.out.println("no");
        this.panel = new Panels();

        this.screen = new JFrame("Graph");

        this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.screen.add(this.panel);

        this.screen.setSize(500,500);
        this.screen.setVisible(true);


    }

    private class Point{
        double xCor;
        double yCor;
        Color color;
        public Point(double xCor, double yCor){
            this.xCor = xCor;
            this.yCor = yCor;
            this.color = Color.black;


        }

    }
}
class Panels extends JPanel{


    public void paintComponent(Graphics g) {
            System.out.println("ees");
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            int drawCounter = 0; // counters for all the while statements
            int drawCounter2 = 0;
            int drawCounter3 = 0;
            int drawCounter4 = 0;


            int x1 = 0; // cords change with the while statemetns
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;
            while (drawCounter <= 15) { // counter
                y2 = 250;
                g.drawLine(x1, y1, x2, y2);
                x2 = x2 + 15;
                y1 = y1 + 15;
                drawCounter++;
            }


            int u1 = 0;
            int u2 = 0;
            int v1 = 0;
            int v2 = 0;
            while (drawCounter2 <= 15) {
                u2 = 250;
                g.drawLine(u1, v1, u2, v2);
                u1 = u1 + 15;
                v2 = v2 + 15;
                drawCounter2++;
            }

            int a1 = 0;
            int a2 = 0;
            int b1 = 0;
            int b2 = 0;

            while (drawCounter3 <= 15) {
                a2 = 250;
                g.drawLine(a1, b1, a2, b2);
                b1 = b1 + 15;
                a2 = a2 - 15;
                drawCounter3++;

            }
        }
}


