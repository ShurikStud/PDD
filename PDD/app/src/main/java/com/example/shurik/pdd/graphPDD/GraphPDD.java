package com.example.shurik.pdd.graphPDD;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.shurik.pdd.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shurik on 03.02.2018.
 */

public class GraphPDD extends View {

    private static final int ORIGIN_X   = 10;
    private static final int ORIGIN_Y   = 90;

    private Context context;

    private int scaleX;
    private int scaleY;

    private int stepX;
    private int stepY;

    private Paint paintAxes;
    private Paint paintAxesArrow;
    private Paint paintLine;
    private Paint paintDot;
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

        paintLine   = new Paint();
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setColor(Color.GREEN);
        paintLine.setStrokeWidth(6);

        paintDot  = new Paint();
        paintDot.setStyle(Paint.Style.FILL_AND_STROKE);
        paintDot.setColor(Color.RED);
        paintDot.setStrokeWidth(5);

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

    private int toCoordinateX(int value){

        if ( (value < 1) || (value > countX) ){
            return -1;
        } else {
            return ORIGIN_X + value * stepX;
        }

    }

    private int toCoordinateY(int value){

        if ( (value < 1) || (value > countY) ){
            return -1;
        } else {
            return ORIGIN_Y - value * stepY;
        }

    }

    public void setPointList(ArrayList<Point> pointList){
        for(Point point: pointList){

            // преобразуем координаты в пиксели

            this.pointList.add(new Point(toCoordinateX(point.getX()), toCoordinateY(point.getY()), point.getDate()));

        }
    }

    private float toPixelX(int coord){
        return coord * scaleX;
    }

    private float toPixelY(int coord){
        return coord * scaleY;
    }

    public void setCountX(int countX) {
        this.countX = countX;
        stepX = 75 / (countX + 1); // +1 для того, чтобы выводить график по центру
    }

    public void setCountY(int countY) {
        this.countY = countY;
        stepY = 75 / countY;
    }

    private void drawAxes(Canvas canvas){

        //TODO вывод координатных осей

        canvas.drawLine(toPixelX(ORIGIN_X), toPixelY(ORIGIN_Y), toPixelX(ORIGIN_Y), toPixelY(ORIGIN_Y), paintAxes);
        canvas.drawLine(toPixelX(ORIGIN_Y - 3), toPixelY(ORIGIN_Y - 2), toPixelX(ORIGIN_Y), toPixelY(ORIGIN_Y), paintAxesArrow);
        canvas.drawLine(toPixelX(ORIGIN_Y - 3), toPixelY(ORIGIN_Y + 2), toPixelX(ORIGIN_Y), toPixelY(ORIGIN_Y), paintAxesArrow);

        canvas.drawLine(toPixelX(ORIGIN_X), toPixelY(ORIGIN_Y), toPixelX(ORIGIN_X), toPixelY(ORIGIN_X), paintAxes);
        canvas.drawLine(toPixelX(ORIGIN_X - 2), toPixelY(ORIGIN_X  + 3), toPixelX(ORIGIN_X), toPixelY(ORIGIN_X), paintAxes);
        canvas.drawLine(toPixelX(ORIGIN_X + 2), toPixelY(ORIGIN_X + 3), toPixelX(ORIGIN_X), toPixelY(ORIGIN_X), paintAxes);

        if ( (countX <= 0) || (countY <= 0) ) {

            canvas.drawText("ERROR::не установлены границы координат", toPixelX(2), toPixelY(50), paintText);

        } else {
            // нарисуем координатную сетку

            for (int i = ORIGIN_X; i <= 75 + ORIGIN_X; i += stepX){
                canvas.drawLine(toPixelX(i), toPixelY(ORIGIN_Y - 2), toPixelX(i), toPixelY(ORIGIN_Y + 2), paintAxesArrow);
            }

            int counter = 0;
            for (int i = ORIGIN_Y; i >= ORIGIN_Y - 75; i -= stepY){
                canvas.drawLine(toPixelX(ORIGIN_X - 2), toPixelY(i), toPixelX(ORIGIN_X + 2), toPixelY(i), paintAxesArrow);
                canvas.drawText(Integer.toString(counter), toPixelX(ORIGIN_X - 7), toPixelY(i), paintText);
                counter++;
            }

        }

    }

    private void drawText(){

        //TODO вывод текста

    }

    private void drawGraph(Canvas canvas){

        //TODO вывод графика

        for (int i = 0; i < pointList.size(); i++){
            if (i == 0){
                canvas.drawLine(toPixelX(pointList.get(i).getX())
                        , toPixelY(pointList.get(i).getY())
                        , toPixelX(pointList.get(i).getX())
                        , toPixelY(pointList.get(i).getY())
                        , paintLine);
            } else {
                canvas.drawLine(toPixelX(pointList.get(i-1).getX())
                        , toPixelY(pointList.get(i-1).getY())
                        , toPixelX(pointList.get(i).getX())
                        , toPixelY(pointList.get(i).getY())
                        , paintLine);
            }

        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate;
        String text = "";

        for(int i = 0; i < pointList.size(); i++){

            canvas.drawCircle(toPixelX(pointList.get(i).getX())
                    , toPixelY(pointList.get(i).getY())
                    , 6, paintDot);

            currentDate = pointList.get(i).getDate();
            if (currentDate == null) {
                text = "";
            } else {
                text = sdf.format(currentDate);
            }

            if ( (i % 2) == 0 ) {
                canvas.drawText(text, toPixelX(pointList.get(i).getX() - 8), toPixelY(pointList.get(i).getY() - 1), paintText);
            } else {
                canvas.drawText(text, toPixelX(pointList.get(i).getX() - 8), toPixelY(pointList.get(i).getY() - 3), paintText);
            }

        }

    }

}
