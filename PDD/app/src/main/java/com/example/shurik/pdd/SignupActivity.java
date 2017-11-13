package com.example.shurik.pdd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shurik.pdd.users_PDD.Login;

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

                    String nameStr = editTextName.getText().toString();
                    String loginStr = editTextLogin.getText().toString();
                    String passwordStr = editTextPassword.getText().toString();
                    String repasswordStr = editTextRePassword.getText().toString();


                    if (nameStr.equals("")){
                        SignupActivityDialog signupActivityDialog  = new SignupActivityDialog(SignupActivity.this);
                        signupActivityDialog.setMessage(getString(R.string.activity_signup_dialog_message_name));
                        signupActivityDialog.show();
                    } else if (loginStr.equals("")){
                        SignupActivityDialog signupActivityDialog  = new SignupActivityDialog(SignupActivity.this);
                        signupActivityDialog.setMessage(getString(R.string.activity_signup_dialog_message_login));
                        signupActivityDialog.show();
                    } else if (passwordStr.equals("")){
                        SignupActivityDialog signupActivityDialog  = new SignupActivityDialog(SignupActivity.this);
                        signupActivityDialog.setMessage(getString(R.string.activity_signup_dialog_message_password));
                        signupActivityDialog.show();
                    } else if (repasswordStr.equals("")){
                        SignupActivityDialog signupActivityDialog  = new SignupActivityDialog(SignupActivity.this);
                        signupActivityDialog.setMessage(getString(R.string.activity_signup_dialog_message_repassword));
                        signupActivityDialog.show();
                    } else if (!passwordStr.equals(repasswordStr)){
                        SignupActivityDialog signupActivityDialog  = new SignupActivityDialog(SignupActivity.this);
                        signupActivityDialog.setMessage(getString(R.string.activity_signup_dialog_message_wrong_password));
                        signupActivityDialog.show();
                    } else {
                        // Все хорошо, можно попытаться зарегистрировать нового пользователя

                        Login login = Login.getInstance();
                        login.addUser(nameStr, loginStr, passwordStr);

                    }

                    onBackPressed();

                    break;
            }

        }

    }


}
