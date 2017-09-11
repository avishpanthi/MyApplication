package com.example.android.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btnSignup;
    private Button btnlgn;
    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        progress = new ProgressDialog(signUp.this);
        username = (EditText)findViewById(R.id.usrn);
        password = (EditText)findViewById(R.id.passw);
        btnSignup = (Button)findViewById(R.id.btnsgn);
        btnlgn = (Button)findViewById(R.id.btnlgn);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             registerUser();
            }
        });
        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUp.this,MainActivity.class));
            }
        });


    }
    public void registerUser(){
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(user)){
            Toast.makeText(signUp.this,"Please enter your email",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(signUp.this,"PLease enter your password",Toast.LENGTH_LONG).show();
            return;
        }
        progress.setMessage("Registering user...");
        progress.show();

        mAuth.createUserWithEmailAndPassword(user,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signUp.this,"Registration successful",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(signUp.this,"Registration failed, please try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
