package com.edwinacubillos.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class Main2Activity extends AppCompatActivity {

    TextView tName, tId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tName =  (TextView) findViewById(R.id.tName);
        tId = (TextView) findViewById(R.id.tCorreo);

        Bundle bundle = getIntent().getExtras();
        tName.setText(bundle.getString("name"));
        tId.setText(bundle.getString("ID"));

     /*   if (AccessToken.getCurrentAccessToken() == null){
            goMainActivity();
        }*/
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goMainActivity();
    }

    private void goMainActivity() {
        Intent intent = new Intent (Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
