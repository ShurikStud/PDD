package com.example.shurik.pdd.courses_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shurik.pdd.CoursesActivity;
import com.example.shurik.pdd.R;
import com.example.shurik.pdd.course.CourseObjectAdapter;
import com.example.shurik.pdd.course.CourseObjectList;

/**
 * Created by shurik on 17.11.2017.
 */

public class ListCoursesFragment extends Fragment {

    ListView    listView;
    MyListener  myListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_courses, null);

        listView    = (ListView) view.findViewById(R.id.fragment_list_courser_list_view);

        CourseObjectList courseObjectList   = CourseObjectList.getInstance(getContext());

        listView.setAdapter(new CourseObjectAdapter(courseObjectList.getListCourseObjects(), getContext()));

        myListener  = new MyListener();

        //listView.setOnClickListener(myListener);
        listView.setOnItemClickListener(myListener);

        return  view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    class MyListener implements AdapterView.OnItemClickListener{


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            CoursesActivity coursesActivity = (CoursesActivity) getActivity();
            coursesActivity.showDetailCouse(position);

        }
    }

}
