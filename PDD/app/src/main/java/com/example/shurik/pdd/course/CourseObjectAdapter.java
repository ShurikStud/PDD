package com.example.shurik.pdd.course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shurik.pdd.R;

import java.util.List;

/**
 * Created by shurik on 17.11.2017.
 */

public class CourseObjectAdapter extends BaseAdapter{

    List<CourseObject>  listCourses;
    Context context;

    public CourseObjectAdapter(List<CourseObject> listCourses, Context context) {
        this.listCourses = listCourses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCourses.size();
    }

    @Override
    public Object getItem(int position) {
        return listCourses.get(position);
    }

    @Override
    public long getItemId(int position) {

        //return listCourses.get(position).getId();
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CourseObject courseObject = listCourses.get(position);

        View row = convertView;
        ViewHolder  viewHolder  = new ViewHolder();

        if (row == null){

            LayoutInflater layoutInflater   = LayoutInflater.from(context);
            row = layoutInflater.inflate(R.layout.course_object_adapter_item, parent, false);

            viewHolder   = new ViewHolder();
            viewHolder.textId   = (TextView) row.findViewById(R.id.course_object_adapter_item_text_view_id);
            viewHolder.textName   = (TextView) row.findViewById(R.id.course_object_adapter_item_text_view_name);

            row.setTag(viewHolder);
        } else {

            viewHolder  = (ViewHolder) convertView.getTag();
        }

        viewHolder.textId.setText(courseObject.getId() + "");
        viewHolder.textName.setText(courseObject.getName());

        return row;
    }


    class ViewHolder{
        TextView    textId;
        TextView    textName;
    }

}
