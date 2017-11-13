package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by shurik on 10.11.2017.
 */

public class LoginActivity extends AppCompatActivity{

    private EditText editTextLogin;
    private EditText editTextPassword;

    private CheckBox checkBox;

    private Button buttonSignIn;
    private Button buttonSignUp;

    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        activity    = this;

        editTextLogin   = (EditText) findViewById(R.id.activity_login_edit_text_login);
        editTextLogin   = (EditText) findViewById(R.id.activity_login_edit_text_password);

        checkBox    = (CheckBox) findViewById(R.id.activity_login_check_box);

        buttonSignIn    = (Button) findViewById(R.id.activity_login_button_signin);
        buttonSignUp    = (Button) findViewById(R.id.activity_login_button_signup);

        MyListener myListener   = new MyListener();

        buttonSignIn.setOnClickListener(myListener);
        buttonSignUp.setOnClickListener(myListener);

    }

    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.activity_login_button_signin:
                    break;

                case R.id.activity_login_button_signup:
                    startActivity(new Intent(activity, SignupActivity.class));
                    break;
            }

        }

    }

}

