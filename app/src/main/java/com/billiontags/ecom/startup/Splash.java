package com.billiontags.ecom.startup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.billiontags.ecom.R;
import com.billiontags.ecom.activity.Login;
import com.billiontags.ecom.intro.WelcomeActivity;
import com.billiontags.ecom.utility.Constant;
import com.billiontags.ecom.utility.GlobalActivity;

public class Splash extends GlobalActivity {
    SharedPreferences preferences;
    private ProgressBar mProgressBar;
    String user_id;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences = getSharedPreferences(Constant.PrefManager.PREF_NAME, MODE_PRIVATE);
        user_id = preferences.getString(Constant.PrefManager.USER_STATUS, "empty");
        initView();

    }

    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        //mTextView = (TextView) findViewById(R.id.textView);
        //mTextView.setTypeface(Regular);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (isNetAvailable) {
                    if (user_id.equals("empty")) {
                        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                        finish();
                    } else if (user_id.equals("1")) {
                        startActivity(new Intent(getApplicationContext(), Login.class));
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Interet Connection Not Available", Toast.LENGTH_SHORT).show();
                }

            }
        }, Constant.PrefManager.SPLASH_DISPLAY_LENGTH);
    }
}
