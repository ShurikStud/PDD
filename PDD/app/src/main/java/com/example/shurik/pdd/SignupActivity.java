package com.example.shurik.pdd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by shurik on 10.11.2017.
 */

public class SignupActivity extends AppCompatActivity {

    EditText    editTextName;
    EditText    editTextLogin;
    EditText    editTextPassword;
    EditText    editTextRePassword;
    Button      buttonOk;
    Button      buttonBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextName        = (EditText) findViewById(R.id.activity_signup_edit_text_fio);
        editTextLogin       = (EditText) findViewById(R.id.activity_signup_edit_text_login);
        editTextPassword    = (EditText) findViewById(R.id.activity_signup_edit_text_password);
        editTextRePassword  = (EditText) findViewById(R.id.activity_signup_edit_text_repassword);

        buttonOk            = (Button) findViewById(R.id.activity_signup_button_ok);
        buttonBack          = (Button) findViewById(R.id.activity_signup_button_back);

        MyListener  myListener  = new MyListener();

        buttonOk.setOnClickListener(myListener);
        buttonBack.setOnClickListener(myListener);


    }


    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.activity_signup_button_back:
                    onBackPressed();
                    break;
                case R.id.activity_signup_button_ok:

                    if (editTextName.toString() == ""){

                    }

                    break;
            }

        }

    }


}
