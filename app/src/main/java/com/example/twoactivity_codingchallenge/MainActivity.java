package com.example.twoactivity_codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchText(View view) {
        Button textbtn = (Button) (view);
        String text = textbtn.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        String message = "";
        //if btn text matches, displays the text passage by comparing to the string name
        if(text == getString(R.string.text_one)){
            message = getString(R.string.passageonetext);
        }
        else if (text == getString(R.string.text_two)){
            message = getString(R.string.passagetwotext);
        }
        else if (text == getString(R.string.text_three)){
            message = getString(R.string.passagethreetext);
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}