package com.example.loginforuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView username = findViewById(R.id.username);
                TextView pwd = findViewById(R.id.password);
                if(username.getText().toString().equals("COMP6442") && pwd.getText().toString().equals("123456")){
                    Intent intent = new Intent(getApplicationContext(), HelloActivity.class);
                    startActivity(intent);
                }else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Alert")
                            .setMessage("Wrong username or password")
                            .setPositiveButton("close", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // do noting
                                }
                            }).show();
                }
            }
        });
    }

}