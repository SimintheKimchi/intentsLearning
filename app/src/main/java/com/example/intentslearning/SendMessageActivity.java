package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button sendMessage;
    private EditText editTextMessage;
    private Button shareMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                Intent intentSendMessage = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, message);
                startActivity(intentSendMessage);
            }
        });

        shareMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextMessage.getText().toString());
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        sendMessage = findViewById(R.id.button_sendMessage_send);
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        shareMessage = findViewById(R.id.button_sendmessage_share);
    }
}
