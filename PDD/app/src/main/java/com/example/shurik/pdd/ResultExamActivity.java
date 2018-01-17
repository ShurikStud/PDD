package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by shurik on 12.01.2018.
 */

public class ResultExamActivity extends AppCompatActivity implements View.OnClickListener{

    private Activity activity;

    TextView textViewCountQuestions;
    TextView textViewCountTrueAnswers;
    TextView textViewPercentTrueAnswers;
    Button buttonClose;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity    = this;

        Intent intent = getIntent();

        int count_questions = intent.getIntExtra("count_questions", -1);
        int count_true_answers = intent.getIntExtra("count_true_answers", -1);

        setContentView(R.layout.activity_result_exam);

        textViewCountQuestions  = (TextView) findViewById(R.id.activity_result_exam_text_view_count_questions);
        textViewCountTrueAnswers  = (TextView) findViewById(R.id.activity_result_exam_text_view_count_true_answers);
        textViewPercentTrueAnswers  = (TextView) findViewById(R.id.activity_result_exam_text_view_percent_true_answers);
        buttonClose  = (Button) findViewById(R.id.activity_result_exam_button_close);


        buttonClose.setOnClickListener(this);

        textViewCountQuestions.setText(Integer.toString(count_questions));
        textViewCountTrueAnswers.setText(Integer.toString(count_true_answers));
        textViewPercentTrueAnswers.setText(Integer.toString(100 * count_true_answers / count_questions) + "%");

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
