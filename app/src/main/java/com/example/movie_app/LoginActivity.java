package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, email, password;
    Button login, Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);
        Button Register = (Button) findViewById(R.id.Register);

        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);

        final User user = new User(LoginActivity.this);

        rememberMe.setChecked(user.isRemembeedForLogin());

        if (rememberMe.isChecked()){
            username.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        } else {
            username.setText("", TextView.BufferType.EDITABLE);
            password.setText("", TextView.BufferType.EDITABLE);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View focusView) {

                boolean cancel = false;
                focusView = null;

                if (!Validation.isUsernameValid(username.getText().toString())) {
                    username.setError(getString(R.string.login_invalid_username));
                    cancel = true;
                }

                if (!Validation.isPasswordValid(password.getText().toString())) {
                    password.setError(getString(R.string.login_invalid_password));
                    cancel = true;
                }

                if (cancel) { // turime klaidų
//                    focusView.requestFocus();
                } else { // praėjome autentifikacija
                    user.setUsernameForLogin(username.getText().toString());
                    user.setPasswordForLogin(password.getText().toString());
                    if (rememberMe.isChecked()){
                        user.setRemembermeKeyForLogin(true);
                    } else {
                        user.setRemembermeKeyForLogin(false);
                    }

                    Toast.makeText(LoginActivity.this, username.getText().toString() + "\n" + password.getText().toString(),

                            Toast.LENGTH_LONG).show();

                    //perform action on click
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);

//                    Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
//                    startActivity(goToRegisterActivity);

                }//else


            }//onClick
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    Toast.makeText(LoginActivity.this, username.getText().toString() + "\n" + email.getText().toString() + "\n" + password.getText().toString(),
//                            Toast.LENGTH_LONG).show();

                    Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(goToRegisterActivity);
                }
        });


    }


}
