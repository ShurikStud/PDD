package com.example.shurik.pdd.exam;

import com.example.shurik.pdd.test.TestObject;

import java.util.ArrayList;

/**
 * Created by shurik on 06.01.2018.
 */

public class QuestionAndAnswers {

    private TestObject  question;
    private ArrayList<Integer> answers;

    public QuestionAndAnswers(TestObject question) {
        this.question = question;
        this.answers = new ArrayList<Integer>();
    }

    public TestObject getQuestion(){
        return question;
    }

    public ArrayList<Integer> getAnswers(){
        return answers;
    }

    public boolean isAnswersTrue(){
        return question.isTrueAllAnswers(answers);
    }
}
