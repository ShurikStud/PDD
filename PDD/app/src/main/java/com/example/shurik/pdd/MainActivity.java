package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shurik.pdd.course.CourseObjectList;
import com.example.shurik.pdd.users_PDD.Login;
import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Login login;

    private CourseObjectList listCourseObject;

    private MyListener  myListener;

    private Button  buttonCourses;
    private Button  buttonExam;
    private Button  buttonReports;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity    = this;

        listCourseObject    = CourseObjectList.getInstance(activity);

//        Resources resources = activity.getResources();
//        listCourseObject    = new CourseObjectList(resources.getStringArray(R.array.courses_array));


        login   = Login.getInstance();

        setTitle("PDD (" + login.getCurrentUser().getName() + ")");

        myListener  = new MyListener();

        buttonCourses   = (Button) findViewById(R.id.activity_main_button_courses);
        buttonExam      = (Button) findViewById(R.id.activity_main_button_exam);
        buttonReports   = (Button) findViewById(R.id.activity_main_button_reports);

        buttonCourses.setOnClickListener(myListener);
        buttonExam.setOnClickListener(myListener);
        buttonReports.setOnClickListener(myListener);


//        login.setContext(this);
//        login.loadUsers();

    }

    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.activity_main_button_courses:

                    startActivity(new Intent(activity, CoursesActivity.class));

                    break;

                case R.id.activity_main_button_exam:

                    break;

                case R.id.activity_main_button_reports:

                    break;


            }


        }
    }


}
