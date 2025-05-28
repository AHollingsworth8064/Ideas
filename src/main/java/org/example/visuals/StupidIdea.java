package org.example.visuals;

import org.example.Tuple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class StupidIdea extends JButton{
    private Runnable method;
    private int xCor, yCor, height,width;
    private Color color;
    private String text;
    private static Tuple<String, String> callerID;
    private static final HashMap<Tuple<String, String>, ButtonPanel> panel = new HashMap<>();

    public StupidIdea(int xCor, int yCor, Color color, String text, int width, int height){

        this.color = color;
        this.xCor = xCor;
        this.yCor = yCor;
        this.text = text;
        this.width = width;
        this.height = height;
        Object objectAttached = getCaller();

        setSize(new Dimension(this.width, this.height));
        setLocation(xCor,yCor);
        setText(this.text);
        setBackground(this.color);




        if(panel.containsKey(objectAttached)){
            panel.get(objectAttached).add(this);
        }
        else{

        }

    }

    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }

    public void newLocation(int xCor, int yCor){
        this.xCor = xCor;
        this.yCor = yCor;

        this.setLocation(this.xCor, this.yCor);
    }

    public void changeSize(int height, int width){
        this.height = height;
        this.width = width;

        this.setSize(width, height);
    }

    public void changeText(String text){
        this.text = text;
        this.setText(this.text);
    }

    public static Tuple<String, String> getCaller(){
        StackTraceElement[] thing = Thread.currentThread().getStackTrace();
        for(StackTraceElement stack: thing){
            System.out.println("File :" + stack.getFileName()+ ", Class: " + stack.getClassName() + " , Method: " +stack.getMethodName()  + ", Line : " +stack.getLineNumber());
            if(!stack.getClassName().equals(StupidIdea.class.getName()) && !stack.getClassName().equals(java.lang.Thread.class.getName()) ){//checking to see if its this calling it or the thread


                return new Tuple<>(stack.getFileName(), stack.getMethodName());
            }
        }

        return null;
    }

    public static Tuple<String, String> getCaller(Object object){
        StackTraceElement[] thing = Thread.currentThread().getStackTrace();
        boolean found = false;

        for(StackTraceElement stack: thing){
            System.out.println("File :" + stack.getFileName()+ ", Class: " + stack.getClassName() + " , Method: " +stack.getMethodName()  + ", Line : " +stack.getLineNumber());
            
//            if(!stack.getClassName().equals(StupidIdea.class.getName()) && !stack.getClassName().equals(java.lang.Thread.class.getName()) ){
//                return new Tuple<>(stack.getFileName(), stack.getMethodName());
//            }
        }

        return null;
    }

    public static void setUp(JFrame jframe){
        panel.put(getCaller(jframe), new ButtonPanel());
        jframe.add(panel.get(getCaller(jframe)));
    }

    public static void setUp(JPanel jPanel){
        panel.put(getCaller(jPanel), new ButtonPanel());
        jPanel.add(panel.get(getCaller(jPanel)));
    }

    private static class ButtonPanel extends JPanel {
        private Tuple<String, String> panelID;

        public ButtonPanel() {
            setLayout(new GridLayout());
        }

        public static Tuple<String, String> getPanelID(){
            String first = " ", second = "";
            Tuple<String,String> callerID = new Tuple<>(first, second) ;
            return callerID;
        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
        }

    }
    public static class Maybe extends JLayeredPane{
        private HashMap<Tuple<String, String>,Maybe> allPanels;

        public Maybe(ButtonPanel buttons, JPanel mainPanel){
            this.add(mainPanel, 1);
            this.add(buttons, 0);
           // allPanels.put();
        }


    }

}
