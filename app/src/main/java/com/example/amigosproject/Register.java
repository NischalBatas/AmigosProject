package com.example.amigosproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG1 = "TAG";
    public static final String TAG = "TAG";
    TextView nLogin;
    EditText nUsername, nEmail, nAddress, nPhone, nPassword;
    Button nRegister;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    ProgressBar nProgress;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nUsername = findViewById(R.id.username);
        nEmail = findViewById(R.id.uemail);
        nAddress = findViewById(R.id.uaddress);
        nPhone = findViewById(R.id.uphone);
        nPassword = findViewById(R.id.password);
        nRegister = findViewById(R.id.register);
        nLogin = findViewById(R.id.login);
        nProgress = findViewById(R.id.progress);

        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        nRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = nEmail.getText().toString().trim();
                String password = nPassword.getText().toString().trim();
                final String username =nUsername.getText().toString();
                final String address=nAddress.getText().toString();
                final String phone =nPhone.getText().toString();

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

                //add to firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fstore.collection("User").document(userID);
                            Map<String, Object> user =new HashMap<>();

                            user.put("Username",username);
                            user.put("Email",email);
                            user.put("Address",address);
                            user.put("Phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: Profie is created"+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"OnFailue: "+ e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "NotRegistered" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            nProgress.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        nLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });
    }
}
