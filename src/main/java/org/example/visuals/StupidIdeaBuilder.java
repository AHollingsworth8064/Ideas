package org.example.visuals;

import java.awt.*;

public class StupidIdeaBuilder {
    private int xCor;
    private int yCor;
    private Color color = colors.white.color;
    private String text = "";
    private int width;
    private int height;
    private Object called;

    public StupidIdeaBuilder setxCor(int xCor) {
        this.xCor = xCor;
        return this;
    }

    public StupidIdeaBuilder setyCor(int yCor) {
        this.yCor = yCor;
        return this;
    }

    public StupidIdeaBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public StupidIdeaBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public StupidIdeaBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public StupidIdeaBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public StupidIdeaBuilder setCalled(Object called) {
        this.called = called;
        return this;
    }

    public StupidIdea createStupidIdea() {
        return new StupidIdea(xCor, yCor, color, text, width, height, called);
    }
}