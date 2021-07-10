package com.trial;

import java.awt.*;

public class Rectangle {
    private int width, height;

    public Rectangle( int width, int height) {
        this.width = width;
        this.height = height;



    }



    public Rectangle(){
        this.width =0;
        this.height=0;

    }

    public double computeArea(){
        return width*height;
    }
    public double computePerimeter(){
        return 2*(width+height);
    }

    public int getWidth() {

        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>0)
            this.height = height;
    }
}
