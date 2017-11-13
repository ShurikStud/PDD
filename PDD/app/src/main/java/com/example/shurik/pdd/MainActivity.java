package com.example.shurik.pdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shurik.pdd.users_PDD.UserPDD;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserPDD> listUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillUsers();

    }

    protected void fillUsers(){

        listUsers = Utils.loadUsersPDD(this);
    }
}
