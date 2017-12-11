package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shurik.pdd.users_PDD.Login;

/**
 * Created by shurik on 10.11.2017.
 */

public class LoginActivity extends AppCompatActivity{

    private Login login;

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
        editTextPassword   = (EditText) findViewById(R.id.activity_login_edit_text_password);

        checkBox    = (CheckBox) findViewById(R.id.activity_login_check_box);

        buttonSignIn    = (Button) findViewById(R.id.activity_login_button_signin);
        buttonSignUp    = (Button) findViewById(R.id.activity_login_button_signup);

        MyListener myListener   = new MyListener();

        buttonSignIn.setOnClickListener(myListener);
        buttonSignUp.setOnClickListener(myListener);

        login   = Login.getInstance();
        login.setContext(this);
        login.loadUsers();

        if (! (login.getCurrentUser() == null)){

            editTextLogin.setText(login.getCurrentUser().getLogin());
            editTextPassword.setText(login.getCurrentUser().getPassword());
            checkBox.setChecked(true);

        }


    }

    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.activity_login_button_signin:

                    String loginStr = editTextLogin.getText().toString();
                    String passwordStr  = editTextPassword.getText().toString();

                    if (login.signin(loginStr, passwordStr)){
                        //TODO успешно авторизовались

                        login.setCurrentUser(loginStr);

                        if (checkBox.isChecked())
                            login.setRemember(true);

                        login.saveUsers();

                        startActivity(new Intent(activity, MainActivity.class));

                    } else {
                        //TODO неудача при авторизации
                        showErrorLogin();
                    }
                    break;

                case R.id.activity_login_button_signup:
                    startActivity(new Intent(activity, SignupActivity.class));
                    break;

                case R.id.activity_login_check_box:

            }

        }

    }

    private void showErrorLogin(){

        Toast.makeText(LoginActivity.this, R.string.activity_login_error_login, Toast.LENGTH_LONG).show();

    }

}

