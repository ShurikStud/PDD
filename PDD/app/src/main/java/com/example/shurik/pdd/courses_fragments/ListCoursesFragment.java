package com.example.shurik.pdd.courses_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shurik.pdd.R;

/**
 * Created by shurik on 17.11.2017.
 */

public class ListCoursesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_courses, null);


        return  view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
