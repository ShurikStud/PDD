package com.example.shurik.pdd.exam;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shurik.pdd.R;
import com.example.shurik.pdd.users_PDD.Login;
import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.ArrayList;
import java.util.List;

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

        LinearLayout linearLayout   = (LinearLayout) view.findViewById(R.id.fragment_test_linear_layout_parent);

        // получим картинку, если она есть

        LinearLayout linearLayoutImage  = (LinearLayout) view.findViewById(R.id.fragment_test_linear_layout_image);

        Resources resources = getContext().getResources();
        int resourceId  = resources.getIdentifier(userPDD.getCurrentExam().getQuestion(currentPosition).getImagePath(), null, getContext().getPackageName());

        if (resourceId != 0) {
            Drawable drawable = (Drawable) resources.getDrawable(resourceId, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.fragment_test_imageView);
            imageView.setImageDrawable(drawable);

            linearLayoutImage.setVisibility(View.VISIBLE);
        } else {
            linearLayoutImage.setVisibility(View.GONE);

        }

        // Выведем вопрос
        TextView textViewDescription = view.findViewById(R.id.fragment_test_text_view_description);
        textViewDescription.setText(userPDD.getCurrentExam().getQuestion(currentPosition).getDescription());


        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);

        arrayCheckBox.clear();

        // сформируем чекбоксы для ответов

//        ListView listView   = (ListView) view.findViewById(R.id.fragment_test_list_view);

        //LinearLayout linearLayoutScroll = (LinearLayout) view.findViewById(R.id.fragment_test_linear_layout_scroll);

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
            //linearLayoutScroll.addView(checkBoxVariant);

            arrayCheckBox.add(checkBoxVariant);

        }

        return view;

    }

    @Override
    public void onPause() {
        super.onPause();

        //Toast.makeText(getContext(), exam.getQuestion(currentPosition).getDescription(), Toast.LENGTH_SHORT).show();

        //Toast.makeText(getContext(), currentPosition, Toast.LENGTH_SHORT).show();


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
