package com.example.shurik.pdd.result_test;

import android.support.annotation.NonNull;

import com.example.shurik.pdd.test.TestObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 15.12.2017.
 */

public class ResultTest {

    class TestAndAnswers {
        TestObject testObject;
        List<Integer> Answers;

        public TestAndAnswers(@NonNull TestObject testObject){
            this.testObject = testObject;
            this.Answers = new ArrayList<Integer>(testObject.getVariantCount());
        }

    }

    List<TestAndAnswers> testObjectList; // список вопросов в этом конкретном тесте
    boolean isComplete = false;

}
