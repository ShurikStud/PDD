package com.example.shurik.pdd;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.shurik.pdd.exam.Exam;
import com.example.shurik.pdd.graphPDD.GraphPDD;
import com.example.shurik.pdd.graphPDD.Point;
import com.example.shurik.pdd.users_PDD.Login;
import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.ArrayList;

/**
 * Created by shurik on 09.02.2018.
 */

public class GraphActivity extends AppCompatActivity {

    private GraphPDD graphPDD;

    private LinearLayout linearLayoutUsers;
    private ListView listViewUsers;
    private boolean isAdmin = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        graphPDD = (GraphPDD) findViewById(R.id.activity_graph_graphPDD);
        linearLayoutUsers = (LinearLayout) findViewById(R.id.activity_graph_linear_layout_users);
        listViewUsers = (ListView) findViewById(R.id.activity_graph_list_view);

        graphPDD.setCountX(1);
        graphPDD.setCountY(5);

        UserPDD userPDD = Login.getInstance().getCurrentUser();
        isAdmin = Login.getInstance().isAdmin();

        if (isAdmin) {
            linearLayoutUsers.setVisibility(View.VISIBLE);
        } else {
            linearLayoutUsers.setVisibility(View.GONE);
        }



        ArrayList<Exam> completeExams = userPDD.getCompleteExams();
        graphPDD.setCountX(completeExams.size());

        ArrayList<Point> pointArrayList = new ArrayList<>();

        int x = 1;
        for (Exam exam: completeExams){
            pointArrayList.add(new Point(x, exam.getCountTrueQuestions(), exam.getDate()));
            x++;
        }

        graphPDD.setPointList(pointArrayList);

        graphPDD.invalidate();


    }
}
