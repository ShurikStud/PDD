package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shurik.pdd.exam.Exam;
import com.example.shurik.pdd.test.TestObjectAdapter;
import com.example.shurik.pdd.test.TestObjectList;
import com.example.shurik.pdd.users_PDD.Login;
import com.example.shurik.pdd.users_PDD.UserPDD;

/**
 * Created by shurik on 11.12.2017.
 */

public class TestActivity extends AppCompatActivity {

    private Activity activity;
    ViewPager   pager;
    Button  buttonFinish;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.activity_test);
//
//        activity    = this;
//
////        pager   = (ViewPager) findViewById(R.id.activity_test_view_pager);
////        pager.setAdapter(new TestObjectAdapter(getSupportFragmentManager()));
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        activity    = this;

        TestObjectList testObjectList    = TestObjectList.getInstance(activity);
        Login   login   = Login.getInstance();

        TestObjectAdapter testObjectAdapter = new TestObjectAdapter(getSupportFragmentManager());
//        testObjectAdapter.setListTests(login.getCurrentUser().continueOrNewTest(testObjectList));
//        testObjectAdapter.setListTests(login.getCurrentUser().getCurrentExam());
        testObjectAdapter.setExam(login.getCurrentUser().getCurrentExam());

        MyListener myListener   = new MyListener();

        pager   = (ViewPager) findViewById(R.id.activity_test_view_pager);
        pager.setAdapter(testObjectAdapter);

        buttonFinish    = (Button) findViewById(R.id.activity_test_button_finish);
        buttonFinish.setOnClickListener(myListener);

    }

    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // т.к. у нас всего одна кнопка, то преверять на какую кнопку нажали - не будем

            UserPDD userPDD = Login.getInstance().getCurrentUser();
            Exam exam    = userPDD.getCurrentExam();

            if (exam.allQuestionHasAnswers()){
                // если на все вопросы были проставлены ответы, то пометим экзамен выполненым и очистим текущий экзамен
                userPDD.completeCurrentExam();

                Utils.updateCurrentUser(getBaseContext(), userPDD);

                Intent newIntent    = new Intent(activity, ResultExamActivity.class);
                newIntent.putExtra("count_questions", exam.getCountQuestions());
                newIntent.putExtra("count_true_answers", exam.getCountTrueQuestions());

                startActivity(newIntent);

                finish();

            } else {

                Toast.makeText(activity, R.string.test_activity_not_complete, Toast.LENGTH_SHORT).show();
            }

        }
    }

}
