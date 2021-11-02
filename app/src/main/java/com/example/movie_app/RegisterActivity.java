package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, email, password;
    Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = (EditText) findViewById(R.id.rUsername);
        final EditText email = (EditText) findViewById(R.id.rEmail);
        final EditText password = (EditText) findViewById(R.id.rPassword);

        Button Register = (Button) findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View focusView) {
                boolean cancel = false;
                focusView = null;

                if (!Validation.isUsernameValid(username.getText().toString())) {
                    username.setError("Wrong username");
                    cancel = true;
                }

                if (!Validation.isEmailValid(email.getText().toString())) {
                    email.setError("Wrong email");
                    cancel = true;
                }

                if (!Validation.isPasswordValid(password.getText().toString())) {
                    password.setError("Wrong password");
                    cancel = true;
                }

                if (cancel) { // turime klaidų
//                    focusView.requestFocus();
                } else { // praėjome autentifikacija
                    Toast.makeText(RegisterActivity.this, username.getText().toString() + "\n" + email.getText().toString() + "\n" + password.getText().toString(),
                            Toast.LENGTH_LONG).show();

                    //perfom action on click
                    Intent goToLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToLoginActivity);
                }
            }
        });
    }

}