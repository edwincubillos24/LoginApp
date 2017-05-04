package com.edwinacubillos.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    TextView tName, tCorreo, tUid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tName =  (TextView) findViewById(R.id.tName);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        tUid = (TextView) findViewById(R.id.tUid);

    /*    Bundle bundle = getIntent().getExtras();
        tName.setText(bundle.getString("name"));
        tId.setText(bundle.getString("ID"));*/

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        tName.setText (user.getDisplayName());
        tCorreo.setText((user.getEmail()));
        tUid.setText(user.getUid());


     /*   if (AccessToken.getCurrentAccessToken() == null){
            goMainActivity();
        }*/
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        goMainActivity();
    }

    private void goMainActivity() {
        Intent intent = new Intent (Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
