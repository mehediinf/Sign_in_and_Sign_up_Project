package com.example.sign_in_and_sign_up_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper databaseHelper;

    private Button signInButton,signUpHereButton;
    private EditText usernameEditText,passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButton_Id);
        signUpHereButton = findViewById(R.id.signUpHereButton_Id);

        usernameEditText = findViewById(R.id.signInUsernameEditText_Id);
        passwordEditText = findViewById(R.id.signInPasswordEditText_Id);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        signInButton.setOnClickListener(this);
        signUpHereButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (v.getId()==R.id.signInButton_Id)
        {

            Boolean result = databaseHelper.findPassword(username,password);

            if (result==true)
            {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"Username and Password didn't match",Toast.LENGTH_SHORT).show();

            }


        }
        else if (v.getId()==R.id.signUpHereButton_Id)
        {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }


    }
}