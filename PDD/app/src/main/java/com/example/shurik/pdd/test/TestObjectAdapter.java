package com.example.shurik.pdd.test;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shurik.pdd.test_fragment.TestObjectFragment;

import java.util.List;

/**
 * Created by shurik on 11.12.2017.
 */

/*
public class TestObjectAdapter extends BaseAdapter {

    List<TestObject> listTests;
    Context context;

    public TestObjectAdapter(List<TestObject> listTests, Context context) {
        this.listTests = listTests;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listTests.size();
    }

    @Override
    public Object getItem(int position) {
        return listTests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TestObject testObject   = listTests.get(position);



    }

    class ViewHolder{
        TextView textId;
        TextView    textName;
    }
}
*/

public class TestObjectAdapter extends FragmentPagerAdapter{

    //private TestObjectList testObjectList;
    List<TestObject> listTests;
    //Context context;



    public TestObjectAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }

    @Override
    public Fragment getItem(int position) {

        return (TestObjectFragment.newInstance(position));
    }

    @Override
    public int getCount() {
        //return listTests.size();
        if (!(listTests == null)){
            return listTests.size();
        } else {
            return 0;
        }
    }

    public void setListTests(List<TestObject> listTests){
        this.listTests  = listTests;
    }
}
