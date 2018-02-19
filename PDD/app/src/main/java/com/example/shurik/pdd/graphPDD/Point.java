package com.example.shurik.pdd.graphPDD;

import java.util.Date;

/**
 * Created by shurik on 03.02.2018.
 */

public class Point {

    private int x;
    private int y;
    private Date date;

    public Point(int x, int y, Date date) {
        this.x = x;
        this.y = y;
        this.date = date;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
