package com.example.shurik.pdd.exam;

import com.example.shurik.pdd.test.TestObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 06.01.2018.
 */

public class Exam {

    List<QuestionAndAnswers> items; // массив вопросов текущего экзамена с ответами на каждый вопрос
    private boolean complete;       // true - экзамен пройден, false - экзамен не окончен

    private int countQuestions;
    private int countTrueQuestions;

    public Exam(List<TestObject> testObjectList) {

        if (testObjectList == null){
            return;
        }

        items   = new ArrayList<QuestionAndAnswers>();

        for (TestObject testObject: testObjectList) {

            items.add(new QuestionAndAnswers(testObject));

        }

        countQuestions  = items.size();

    }

    public int size(){
        return items.size();
    }

    public TestObject getQuestion(int index){

        if (index < 0 || index >= size()){
            return null;
        }

        return items.get(index).getQuestion();

    }

    public ArrayList<Integer> getAnswers(int index){

        if (index < 0 || index >= size()){
            return null;
        }

        return items.get(index).getAnswers();
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {

        countTrueQuestions = 0;
        for (QuestionAndAnswers item: items) {
            if (item.isAnswersTrue()){
                countTrueQuestions++;
            }
        }

        this.complete = complete;
    }

    public boolean allQuestionHasAnswers(){

        for (QuestionAndAnswers item: items) {
            if (item.getAnswers().size() == 0){
                return false;
            }
        }
        return true;

    }

    public int getCountQuestions() {
        return countQuestions;
    }

    public int getCountTrueQuestions() {
        return countTrueQuestions;
    }
}
