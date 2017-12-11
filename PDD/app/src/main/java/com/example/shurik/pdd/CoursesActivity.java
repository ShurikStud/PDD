package com.example.shurik.pdd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.shurik.pdd.course.CourseObjectList;
import com.example.shurik.pdd.courses_fragments.CourseDetailFragment;
import com.example.shurik.pdd.courses_fragments.ListCoursesFragment;

/**
 * Created by shurik on 17.11.2017.
 */

public class CoursesActivity extends AppCompatActivity {

    private Activity activity;
    private ListCoursesFragment     listCoursesFragment;
    private CourseDetailFragment    courseDetailFragment;

    private FragmentTransaction     fragmentTransaction;

    private CourseObjectList listCourseObject;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        activity    = this;

        listCourseObject    = CourseObjectList.getInstance(activity);


        listCoursesFragment     = new ListCoursesFragment();
        courseDetailFragment    = new CourseDetailFragment();

        replaceFragment(listCoursesFragment);
    }

    public void showDetailCouse(int index){
        // вызывается из ListCoursesFragment для отображения деталей выбранного в списке курса.ы

        listCourseObject.setCurrentIndex(index);
        courseDetailFragment.setStringDetail(listCourseObject.getCurrentCourse().getDetail());
        replaceFragment(courseDetailFragment);

    }

    @Override
    public void onBackPressed() {

        if (courseDetailFragment.isAdded()){

            replaceFragment(listCoursesFragment);

        } else {

            super.onBackPressed();
        }

    }

    private void replaceFragment(Fragment fragment){

        if (fragment != null && !fragment.isAdded()) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.activity_courses_frame_layout, fragment);
            fragmentTransaction.commit();
        }

    }

}
