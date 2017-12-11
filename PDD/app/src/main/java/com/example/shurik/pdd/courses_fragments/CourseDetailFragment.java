package com.example.shurik.pdd.courses_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shurik.pdd.R;

/**
 * Created by shurik on 17.11.2017.
 */

public class CourseDetailFragment extends Fragment {

    TextView textViewDetail;

    String  stringDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_detail, null);

        textViewDetail  = (TextView) view.findViewById(R.id.fragment_course_detail_text_view_detail);

        textViewDetail.setText(stringDetail);




        return view;


    }

    public void setStringDetail(String stringDetail) {
        this.stringDetail = stringDetail;
    }
}
