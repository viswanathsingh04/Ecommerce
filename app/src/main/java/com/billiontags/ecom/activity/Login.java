package com.billiontags.ecom.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.billiontags.ecom.R;
import com.billiontags.ecom.utility.Constant;
import com.billiontags.ecom.utility.GlobalActivity;

import java.net.URL;

public class Login extends GlobalActivity implements View.OnClickListener {

    Button signup;
    TextView new_user, lost_password, txt_orwith;
    EditText u_name, pass_code;
    ImageView fb, tw;
    String User_name, Password;
    private static SharedPreferences preferences;
    public String id, name, email, gender, birthday, profile;
    public String n1 = "btag";
    URL profile_pic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences(Constant.PrefManager.PREF_NAME, 0);
        u_name = (EditText) findViewById(R.id.u_name);
        pass_code = (EditText) findViewById(R.id.pass_code);

        txt_orwith = (TextView) findViewById(R.id.txt_orwith);
        new_user = (TextView) findViewById(R.id.new_user);
        lost_password = (TextView) findViewById(R.id.lost_password);
        u_name.setTypeface(Light);
        pass_code.setTypeface(Light);
        new_user.setTypeface(Light, Typeface.BOLD);
        lost_password.setTypeface(Light);

        signup = (Button) findViewById(R.id.submit);
        signup.setTypeface(Light);

        signup.setOnClickListener(this);
        new_user.setOnClickListener(this);
        lost_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.new_user) {
            startActivity(new Intent(getApplicationContext(), Register.class));
            //Toast.makeText(getApplicationContext(), "new_user", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.lost_password) {
            Toast.makeText(getApplicationContext(), "You just Clicked Forget Password Link. This link may lead you to get resetpassword link in your mail. Please Check your mail", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.submit) {
            if (u_name.getText().toString().trim().equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter User Name", Toast.LENGTH_SHORT).show();
            } else if (u_name.getText().toString().trim().length() < 2) {
                Toast.makeText(getApplicationContext(), "Please Enter more then 4 character for User Name", Toast.LENGTH_SHORT).show();
            } else if (pass_code.getText().toString().trim().equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_SHORT).show();
            } else if (pass_code.getText().toString().trim().length() < 2) {
                Toast.makeText(getApplicationContext(), "Please set password more then six charter", Toast.LENGTH_SHORT).show();
            } else {
                hideKeyBoard(Login.this);
                User_name = u_name.getText().toString().trim();
                Password = pass_code.getText().toString().trim();
                if (isInternetAvailable) {
                    if (n1.equals(u_name.getText().toString()) && (pass_code.getText().toString()).equals("123456")) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please check your login details...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Check with your internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
