package com.example.sign_in_and_sign_up_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,emailEditText,usernameEditText,passwordEditText;
    private Button signUpButton;
    DatabaseHelper databaseHelper;

    UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = findViewById(R.id.nameSignUpEditText_Id);
        emailEditText = findViewById(R.id.emailSignUpEditText_Id);
        usernameEditText = findViewById(R.id.usernameSignUpEditText_Id);
        passwordEditText = findViewById(R.id.passwordSignUpEditText_Id);
        signUpButton = findViewById(R.id.signUpButton_Id);

        databaseHelper =new DatabaseHelper(this);

        userDetails = new UserDetails();

        signUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);

        if (rowId>0)
        {
            Toast.makeText(getApplicationContext(),"Row "+rowId+" is successfully inserted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Row insertion failed",Toast.LENGTH_SHORT).show();

        }

    }
}