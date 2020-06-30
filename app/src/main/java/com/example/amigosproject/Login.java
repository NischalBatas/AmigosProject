package com.example.amigosproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText nEmail, nPassword;
    Button nLogin;
    TextView nCreate, nForgetPassword;
    ProgressBar nProgress;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nEmail =findViewById(R.id.uemail);
        nPassword =findViewById(R.id.password);
        nLogin=findViewById(R.id.login);
        nCreate=findViewById(R.id.create);
        nProgress=findViewById(R.id.progress);
        fAuth=FirebaseAuth.getInstance();
        nForgetPassword= findViewById(R.id.forgetpassword);

        nLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = nEmail.getText().toString().trim();
                String password = nPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    nEmail.setError("Email is empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    nPassword.setError("Password is empty");
                    return;
                }
                if (password.length() < 8) {
                    nPassword.setError("Password should be more than 8 character");
                    return;
                }

                nProgress.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Fragmentmain.class));
                        } else {
                            Toast.makeText(Login.this, "UnSuccessful" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            nProgress.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        nCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        nForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail =new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog =new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Forget Password");
                passwordResetDialog.setMessage("Enter Your Email");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get email
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Check your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "There is no such email", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close
                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }
}
