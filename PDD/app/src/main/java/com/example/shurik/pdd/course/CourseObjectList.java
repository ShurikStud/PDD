package com.example.shurik.pdd.course;

import android.content.Context;
import android.content.res.Resources;

import com.example.shurik.pdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 17.11.2017.
 */

public final class CourseObjectList {

    static CourseObjectList instance = null;

    private List<CourseObject> listCourseObjects;
    private int currentIndex = -1;

    private CourseObjectList(Context context){ // конструктор делаем приватным - невозможно будет вызвать

        listCourseObjects   = new ArrayList<CourseObject>();

        Resources resources = context.getResources();
        String[] coursesArray    = resources.getStringArray(R.array.courses_array);

        String id       = "";
        String name     = "";
        String detail   = "";

        int index_from  =0;
        int index_to    =0;

        for (String course: coursesArray) {
            index_from  = 0;
            index_to    = course.indexOf("~");
            id = course.substring(index_from, index_to);
            index_from  = index_to + 1;
            index_to    = course.indexOf("~", index_from);
            name    = course.substring(index_from, index_to);
            index_from  = index_to + 1;
            index_to    = course.length();
            detail    = course.substring(index_from, index_to);
            listCourseObjects.add(new CourseObject(Integer.parseInt(id), name, detail));
        }




    }

    public static CourseObjectList getInstance(Context context){

        if (instance == null)
            instance = new CourseObjectList(context);

        return instance;
    }

  /*  public CourseObjectList(String[] coursesArray) {

        String id       = "";
        String name     = "";
        String detail   = "";

        int index_from  =0;
        int index_to    =0;

        for (String course: coursesArray) {
            index_from  = 0;
            index_to    = course.indexOf(";") - 1;
            id = course.substring(index_from, index_to);
            index_from  = index_to + 2;
            index_to    = course.indexOf(";", index_from);
            name    = course.substring(index_from, index_to);
            index_from  = index_to + 2;
            index_to    = course.indexOf(";", index_from);
            detail    = course.substring(index_from, index_to);
            listCourseObjects.add(new CourseObject(Integer.getInteger(id), name, detail));
        }

    }
*/
    public List<CourseObject> getListCourseObjects() {
        return listCourseObjects;
    }

    public void setCurrentIndex(int currentIndex) {
        if (currentIndex >= 0 && currentIndex <= listCourseObjects.size()) {
            this.currentIndex   = currentIndex;
        } else {
            this.currentIndex   = -1;
        }
    }

    public CourseObject getCurrentCourse(){

        if (currentIndex == -1){
            return null;
        } else {
            return listCourseObjects.get(currentIndex);
        }


    }
}
