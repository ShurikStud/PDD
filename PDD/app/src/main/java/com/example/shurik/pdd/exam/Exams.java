package com.example.shurik.pdd.exam;

import com.example.shurik.pdd.test.TestObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 06.01.2018.
 */

public class Exams {

    private List<Exam> arrayExam;   // список всех экзаменов пользователя с вопросами и ответами
    private Exam current_exam;      // текущий экзамен (может быть null)


    public Exams() {
        arrayExam   = new ArrayList<Exam>();
    }

    public Exam getCurrentExam(){
        return current_exam;
    }

    public void startNewExam(List<TestObject> testObjectList){
        Exam newExam = new Exam(testObjectList);
        arrayExam.add(newExam);
        current_exam    = newExam;
    }

    public void completeCurrentExam(){
        current_exam.setComplete(true);
        current_exam    = null;
    }

    public ArrayList<Exam> getCompleteExams(){

        ArrayList<Exam> result = new ArrayList<Exam>();


        for (Exam exam: arrayExam) {

            if (exam.isComplete()) {
                result.add(exam);
            }

        }

        return result;

    }

}
