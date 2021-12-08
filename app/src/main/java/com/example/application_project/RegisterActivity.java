package com.example.application_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText email1, pass1;
    private Button Bt;
    private ProgressBar progressbar;
    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        email1 = findViewById(R.id.email1);
        pass1 = findViewById(R.id.pass1);
        progressbar = findViewById(R.id.progressbar1);
        Bt = findViewById(R.id.register_btn2);
        auth = FirebaseAuth.getInstance();

        Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString();
                String pass = pass1.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(RegisterActivity.this, "enter email and password both", Toast.LENGTH_SHORT).show();
                } else {
                    regis(email, pass);
                }
            }
        });
    }

    private void regis(String em, String pas) {
        auth.createUserWithEmailAndPassword(em, pas).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}