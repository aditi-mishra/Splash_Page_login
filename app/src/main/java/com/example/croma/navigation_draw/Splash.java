package com.example.croma.navigation_draw;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences mSharedPreferences;
    Boolean flag;
     public EditText email;
     public EditText phone;
     public Button mButton;
     private ProgressDialog mProgressDialog;
     Handler mHandler;
     private FirebaseAuth mFirebaseAuth;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
       flag = mSharedPreferences.getBoolean("flag",true);
       if(flag){
           mFirebaseAuth = FirebaseAuth.getInstance();
           email =(EditText)findViewById(R.id.email);
           mProgressDialog = new ProgressDialog(this);
           phone = (EditText)findViewById(R.id.phone);
           mButton=(Button)findViewById(R.id.register);
           mButton.setOnClickListener(this);
           new Handler().post(new Runnable() {
               @Override
               public void run() {
                   if(flag == false) {
                       Intent i = new Intent(Splash.this, MainActivity.class);
                       startActivity(i);
                       finish();
                   }
               }
           });
       }else{
           Intent i = new Intent(Splash.this, MainActivity.class);
           startActivity(i);
           finish();
       }


    }
  public void registerUser(){
        String emailAddress = email.getText().toString().trim();
        String phoneNo = phone.getText().toString().trim();
        if(TextUtils.isEmpty(emailAddress)){
            Toast.makeText(this,"Please Enter E-mail",Toast.LENGTH_SHORT).show();
            return;
        }
      if(TextUtils.isEmpty(phoneNo)){
          Toast.makeText(this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show();
          return;
      }
//      mProgressDialog.setMessage("registering User !!");
//      mProgressDialog.show();

      mFirebaseAuth.createUserWithEmailAndPassword(emailAddress,phoneNo).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()) {
                  Toast.makeText(Splash.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                 flag = false;
                 SharedPreferences.Editor editor = mSharedPreferences.edit();
                 editor.putBoolean("flag",flag);
                 editor.apply();
                  Intent i = new Intent(Splash.this, MainActivity.class);
                  startActivity(i);
                  finish();
                  // FirebaseUser user = mFirebaseAuth.getCurrentUser();
                 // updateUI(user);
              }
              else{
                  Toast.makeText(Splash.this,"Failed To register !! Please Try Again !!",Toast.LENGTH_SHORT).show();
              }
          }
      });
  }
    @Override
    public void onClick(View view) {
        if(view == mButton){
            registerUser();
        }
    }
}
