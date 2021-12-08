package com.example.application_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    private EditText email2, pass2;
    private Button Bt2;
    private ProgressBar progressbar2;
    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        email2 = findViewById(R.id.email2);
        pass2 = findViewById(R.id.pass2);
        progressbar2 = findViewById(R.id.progressbar2);
        Bt2 = findViewById(R.id.signin_btn);
        auth = FirebaseAuth.getInstance();

        Bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_2 = email2.getText().toString();
                String pass_2 = pass2.getText().toString();
                if (TextUtils.isEmpty(email_2) || TextUtils.isEmpty(pass_2)) {
                    Toast.makeText(SigninActivity.this, "enter email and password both", Toast.LENGTH_SHORT).show();
                } else {
                    login_method(email_2, pass_2);
                }
            }
        });
    }

    private void login_method(String em2, String pas2) {
        auth.signInWithEmailAndPassword(em2, pas2).addOnSuccessListener(SigninActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SigninActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SigninActivity.this,movie_main.class));
            }
        });
    }
}