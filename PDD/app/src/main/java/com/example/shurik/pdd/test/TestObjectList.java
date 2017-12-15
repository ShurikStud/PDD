package com.example.shurik.pdd.test;

import android.content.Context;
import android.content.res.Resources;

import com.example.shurik.pdd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 11.12.2017.
 */

public class TestObjectList {

    static TestObjectList instance = null;

    private List<TestObject> listTestObjects;
    private int currentIndex = -1;

    private TestObjectList(Context context){ // конструктор делаем приватным - невозможно будет вызвать
        listTestObjects = new ArrayList<TestObject>();

        Resources resources = context.getResources();
        String[] testsArray    = resources.getStringArray(R.array.tests_array);
        String[] answersArray   = null;
        int[] answersTrueArray   = null;

        //String description   = "";
        TestObject testObject;
        int idTest = -1;
        int idAnswer    = -1;
        int idAnswerTrue    = -1;

        int resourceId  = -1;

        for (String description: testsArray) {

            testObject = new TestObject(++idTest, description);

            resourceId  = resources.getIdentifier("answer" + idTest + "_array", "array", context.getPackageName());
            answersArray    = resources.getStringArray(resourceId);

            idAnswer = -1;

            for (String answerDescription: answersArray) {

                testObject.addVariant(++idAnswer, answerDescription);

            }

            resourceId  = resources.getIdentifier("answer" + idTest + "_true_array", "array", context.getPackageName());
            answersTrueArray    = resources.getIntArray(resourceId);

            idAnswer = -1;

            for (int idTrue: answersTrueArray) {

                testObject.addTrueVariant(idTrue);

            }

            //testObject
            listTestObjects.add(testObject);
        }

    }

    public static TestObjectList getInstance(Context context){

        if (instance == null)
            instance = new TestObjectList(context);

        return instance;
    }

    public List<TestObject> getListTestObjects() {
        return listTestObjects;
    }

    public void setCurrentIndex(int currentIndex) {
        if (currentIndex >= 0 && currentIndex <= listTestObjects.size()) {
            this.currentIndex   = currentIndex;
        } else {
            this.currentIndex   = -1;
        }
    }

    public TestObject getCurrentTestObject(){

        if (currentIndex == -1){
            return null;
        } else {
            return listTestObjects.get(currentIndex);
        }
    }

}
