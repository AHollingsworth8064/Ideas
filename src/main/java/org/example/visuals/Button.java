package org.example.visuals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Button {
    private int xCor;
    private int yCor;
    private Color color = colors.white.color;
    private String text = "";
    private int width;
    private int height;
    private Object called;
    private static HashMap<Object, ArrayList<ButtonPanel>> buttons;

    private class ButtonPanel extends JPanel{
        public ButtonPanel(){
            this.setLayout(new GridLayout());
        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
        }
    }
}
