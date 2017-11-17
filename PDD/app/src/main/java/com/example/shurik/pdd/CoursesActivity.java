package com.example.shurik.pdd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.shurik.pdd.courses_fragments.CourseDetailFragment;
import com.example.shurik.pdd.courses_fragments.ListCoursesFragment;

/**
 * Created by shurik on 17.11.2017.
 */

public class CoursesActivity extends AppCompatActivity {

    private ListCoursesFragment     listCoursesFragment;
    private CourseDetailFragment    courseDetailFragment;

    private FragmentTransaction     fragmentTransaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        listCoursesFragment     = new ListCoursesFragment();
        courseDetailFragment    = new CourseDetailFragment();

        replaceFragment(listCoursesFragment);
    }

    private void replaceFragment(Fragment fragment){

        if (fragment != null && !fragment.isAdded()) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.activity_courses_frame_layout, fragment);
            fragmentTransaction.commit();
        }

    }

}
