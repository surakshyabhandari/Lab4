package com.example.twoactivities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText messageText;
    private TextView replyheader;
    private TextView replytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageText = findViewById(R.id.messageTextbar);

        Intent intenti = getIntent();
        String message = intenti.getStringExtra(SecondActivity.EXTRA_REPLY);
        //connecting to xml components
        replyheader = findViewById(R.id.replyheader);
        replytext = findViewById(R.id.replytext);
        replytext.setText(message);

    }

    public void secondActivity(View view) {
        //debugging to see if the button is clicked
        Log.d(LOG_TAG, "Button clicked!");
        //taking to new activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //taking the message
        String message = messageText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                //making the text visible when reply is passed from second activity
                replyheader.setVisibility(View.VISIBLE);
                //setting up the text
                replytext.setText(reply);
                replytext.setVisibility(View.VISIBLE);
            }
        }
    }
}