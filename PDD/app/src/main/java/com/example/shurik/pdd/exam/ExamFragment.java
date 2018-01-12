package com.example.shurik.pdd.exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shurik.pdd.R;
import com.example.shurik.pdd.users_PDD.Login;
import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.ArrayList;

/**
 * Created by shurik on 10.01.2018.
 */

public class ExamFragment extends Fragment {

    Integer currentPosition;
    Exam    exam;
    ArrayList<CheckBox> arrayCheckBox;

    public static ExamFragment newInstance(int position){
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    public ExamFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // чтение параметров из Bundle
        currentPosition = getArguments() != null ? getArguments().getInt("position") : 1;

        arrayCheckBox   = new ArrayList<CheckBox>();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view   = (View) inflater.inflate(R.layout.fragment_test, null);

        UserPDD userPDD = Login.getInstance().getCurrentUser();
        exam    = userPDD.getCurrentExam();
        ArrayList<Integer> answers  = exam.getAnswers(currentPosition);


        MyListener myListener   = new MyListener();

        // инициализация переменных - элементов управления

        LinearLayout linearLayout   = (LinearLayout) view.findViewById(R.id.fragment_test_linear_layout);

        TextView textViewDescription = view.findViewById(R.id.fragment_test_text_view_description);
        textViewDescription.setText(userPDD.getCurrentExam().getQuestion(currentPosition).getDescription());


        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);


        // сформируем чекбоксы для ответов
        for (int i = 0; i < exam.getQuestion(currentPosition).getVariantCount(); i++) {

            CheckBox checkBoxVariant = new CheckBox(getContext());
            checkBoxVariant.setLayoutParams(checkBoxParams);
            checkBoxVariant.setId(View.generateViewId());
            checkBoxVariant.setText(exam.getQuestion(currentPosition).getVariant(i));
            if ( !(answers == null) ) {
                checkBoxVariant.setChecked(answers.contains(i));
            }

            checkBoxVariant.setOnClickListener(myListener);

            linearLayout.addView(checkBoxVariant);

            arrayCheckBox.add(checkBoxVariant);

        }

        return view;

    }

    @Override
    public void onPause() {
        super.onPause();

        //Toast.makeText(getContext(), exam.getQuestion(currentPosition).getDescription(), Toast.LENGTH_SHORT).show();


    }

    private void saveResult(){

        ArrayList<Integer> answers  = exam.getAnswers(currentPosition);

        answers.clear();

        int index = 0;
        for (CheckBox checkBox: arrayCheckBox) {

            if (checkBox.isChecked()){
                answers.add(index);
            }

            index++;

        }
    }

    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            saveResult();

        }
    }

}
