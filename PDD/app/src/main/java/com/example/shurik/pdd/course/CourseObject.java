package com.example.shurik.pdd.course;

/**
 * Created by shurik on 17.11.2017.
 */

public class CourseObject {

    private int id;
    private String name;
    private String detail;

    public CourseObject() {}

    public CourseObject(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseObject that = (CourseObject) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

}
