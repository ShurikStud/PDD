package com.example.shurik.pdd;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by shurik on 13.11.2017.
 */

public class SignupActivityDialog extends Dialog implements View.OnClickListener {

    private SignupActivity activity;
    private Button buttonOk;
    private TextView textViewMessage;

    private String message;

    public SignupActivityDialog(@NonNull Context context) {
        super(context);

        activity    = (SignupActivity) context;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        setContentView(R.layout.activity_signup_dialog);

        buttonOk    = (Button) findViewById(R.id.activity_singup_dialog_button_ok);
        textViewMessage = (TextView) findViewById(R.id.activity_singup_dialog_text_view_message);

        buttonOk.setOnClickListener(this);

        textViewMessage.setText(message);

    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
