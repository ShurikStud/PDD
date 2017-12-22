package com.example.shurik.pdd.result_test;

import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 16.12.2017.
 */

public class ResultTestAdapter {
    private List<ResultTest> resultTests;
    private int currentTest = -1;
    private UserPDD userPDD; // ссылка на владельца. будет использована для сохранения в SharedPreferences объекта Юзер

    public ResultTestAdapter(UserPDD userPDD) {
        this.resultTests = new ArrayList<ResultTest>();
        this.userPDD    = userPDD;
    }

    public ResultTest newTest(){
        ResultTest newTest  = new ResultTest();
        resultTests.add(newTest);
        currentTest = resultTests.indexOf(newTest);
        return newTest;
    }

    private int findNotCompleteTest(){

        for (ResultTest currentResult: resultTests) {

            if ( !(currentResult.isComplete) ){
                return resultTests.indexOf(currentResult);
            }

        }

        return -1;
    }

    public void saveCurrentTest(){

        if (currentTest == -1){
            return;
        }

        // TODO здесь необходимо реализовать запись юзера в SharedPreferences

    }

    public ResultTest continueOrNewTest(){

        saveCurrentTest();

        int indexNotCompleteTest = findNotCompleteTest();

        if (indexNotCompleteTest >= 0){
            currentTest = indexNotCompleteTest;
            return resultTests.get(currentTest);
        } else {
            return newTest();
        }
    }
}
