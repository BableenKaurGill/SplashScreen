package com.example.reitindiadistributions.reitsecurity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.login)
    Button login;

    @BindView(R.id.register)
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onClick(View v) {
        if(new AppConstants().checkConnection(Splash.this)){
            switch (v.getId()) {

                case R.id.login:
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);

                    break;
                case R.id.register:
                  //  signOut();
                    break;
            }
        }
        else
        {

            new AppConstants().centralToast(Splash.this,"Please connect to the internet.");}
    }

}

