package com.billiontags.ecom.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.billiontags.ecom.R;
import com.billiontags.ecom.utility.GlobalActivity;

public class Register extends GlobalActivity implements View.OnClickListener {

    Button signup;
    TextView top, bottom_signup, Already_account;
    EditText u_name, mobile_number;
    String User_name, Mobile;
    private static SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        top = (TextView) findViewById(R.id.top);
        bottom_signup = (TextView) findViewById(R.id.bottom_signup);
        Already_account = (TextView) findViewById(R.id.bottom_already_account);
        u_name = (EditText) findViewById(R.id.u_name);
        mobile_number = (EditText) findViewById(R.id.mobile_number);
        top.setTypeface(Light);
        u_name.setTypeface(Light);
        mobile_number.setTypeface(Light);
        bottom_signup.setTypeface(Light);
        Already_account.setTypeface(Light);

        signup = (Button) findViewById(R.id.submit);
        signup.setTypeface(Light);
        signup.setOnClickListener(this);
        Already_account.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.new_user) {
            Toast.makeText(getApplicationContext(), "new_user", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.lost_password) {
            Toast.makeText(getApplicationContext(), "lost_password", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bottom_already_account) {
            Intent intent = new Intent(Register.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else if (view.getId() == R.id.submit) {
            if (u_name.getText().toString().trim().equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter User Name", Toast.LENGTH_SHORT).show();
            } else if (u_name.getText().toString().trim().length() < 2) {
                Toast.makeText(getApplicationContext(), "Please Enter more then 4 character for User Name", Toast.LENGTH_SHORT).show();
            } else if (mobile_number.getText().toString().trim().equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
            } else if (mobile_number.getText().toString().trim().length() < 10) {
                Toast.makeText(getApplicationContext(), "Please enter  ten digit Mobile Number", Toast.LENGTH_SHORT).show();
            } else {
                hideKeyBoard(Register.this);
                User_name = u_name.getText().toString().trim();
                Mobile = mobile_number.getText().toString().trim();
                if (isInternetAvailable) {
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Check with your internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
