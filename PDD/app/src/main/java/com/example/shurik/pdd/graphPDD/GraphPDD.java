package com.example.shurik.pdd.graphPDD;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.shurik.pdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 03.02.2018.
 */

public class GraphPDD extends View {

    private Context context;

    private int scaleX;
    private int scaleY;

    private int stepX;
    private int stepY;

    private Paint paintAxes;
    private Paint paintAxesArrow;
    private Paint paintText;

//    private List<Point> pointListAxisX;
//    private List<Point> pointListAxisY;

    private List<Point> pointList;


    private int countX;
    private int countY;

    public GraphPDD(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.GraphPDD);

        countX = attributes.getInt(R.styleable.GraphPDD_countX, 0);
        countY = attributes.getInt(R.styleable.GraphPDD_countX, 0);


//        pointListAxisX = new ArrayList<>();
//        pointListAxisY = new ArrayList<>();
        pointList   = new ArrayList<Point>();

        paintAxes   = new Paint();
        paintAxes.setStyle(Paint.Style.STROKE);
        paintAxes.setColor(Color.BLUE);
        paintAxes.setStrokeWidth(10);

        paintAxesArrow   = new Paint();
        paintAxesArrow.setStyle(Paint.Style.STROKE);
        paintAxesArrow.setColor(Color.BLUE);
        paintAxesArrow.setStrokeWidth(6);

        paintText   = new Paint();
        paintText.setTextSize(40);
        paintText.setColor(Color.DKGRAY);

    }

//    public void fresh(){
//        drawAxes();
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        scaleY  = getHeight() / 100;
        scaleX  = getWidth() / 100;

        drawAxes(canvas);
        drawText();
        drawGraph(canvas);
    }

    public void setPointList(ArrayList<Point> pointList){
        for(Point point: pointList){

            // преобразуем координаты в пиксели

            this.pointList.add(new Point(point.getX() * stepX, point.getY() * stepY));

        }
    }

    private float toCoordinateX(int coord){
        return coord * scaleX;
    }

    private float toCoordinateY(int coord){
        return coord * scaleY;
    }

    public void setCountX(int countX) {
        this.countX = countX;
    }

    public void setCountY(int countY) {
        this.countY = countY;
    }

    private void drawAxes(Canvas canvas){

        //TODO вывод координатных осей

        canvas.drawLine(toCoordinateX(10), toCoordinateY(90), toCoordinateX(90), toCoordinateY(90), paintAxes);
        canvas.drawLine(toCoordinateX(87), toCoordinateY(88), toCoordinateX(90), toCoordinateY(90), paintAxesArrow);
        canvas.drawLine(toCoordinateX(87), toCoordinateY(92), toCoordinateX(90), toCoordinateY(90), paintAxesArrow);

        canvas.drawLine(toCoordinateX(10), toCoordinateY(90), toCoordinateX(10), toCoordinateY(10), paintAxes);
        canvas.drawLine(toCoordinateX(8), toCoordinateY(13), toCoordinateX(10), toCoordinateY(10), paintAxes);
        canvas.drawLine(toCoordinateX(12), toCoordinateY(13), toCoordinateX(10), toCoordinateY(10), paintAxes);

        if ( (countX <= 0) || (countY <= 0) ) {

            canvas.drawText("ERROR::не установлены границы координат", toCoordinateX(2), toCoordinateY(50), paintText);

        } else {
            // нарисуем координатную сетку

            stepX = 75 / (countX + 1); // +1 для того, чтобы выводить график по центру
            stepY = 75 / countY;

            for (int i = 10; i <= 75 + 10; i += stepX){
                canvas.drawLine(toCoordinateX(i), toCoordinateY(88), toCoordinateX(i), toCoordinateY(92), paintAxesArrow);
            }

            int counter = 0;
            for (int i = 90; i >= 90 - 75; i -= stepY){
                canvas.drawLine(toCoordinateX(8), toCoordinateY(i), toCoordinateX(12), toCoordinateY(i), paintAxesArrow);
                canvas.drawText(Integer.toString(counter), toCoordinateX(3), toCoordinateY(i), paintText);
                counter++;
            }

        }

    }

    private void drawText(){

        //TODO вывод текста

    }

    private void drawGraph(Canvas canvas){

        //TODO вывод графика

        for(Point point:pointList){

            canvas.drawLine(toCoordinateX(10), toCoordinateY(10), toCoordinateX(point.getX()), toCoordinateY(
                    point.getY()), paintAxesArrow);

        }


    }


}
