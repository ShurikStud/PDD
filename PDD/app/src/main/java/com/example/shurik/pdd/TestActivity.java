package com.example.shurik.pdd;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.shurik.pdd.test.TestObjectAdapter;
import com.example.shurik.pdd.test.TestObjectList;

/**
 * Created by shurik on 11.12.2017.
 */

public class TestActivity extends AppCompatActivity {

    private Activity activity;
    ViewPager   pager;

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

        TestObjectAdapter testObjectAdapter = new TestObjectAdapter(getSupportFragmentManager());
        testObjectAdapter.setListTests(testObjectList.getListTestObjects());

        pager   = (ViewPager) findViewById(R.id.activity_test_view_pager);
        pager.setAdapter(testObjectAdapter);
    }
}
