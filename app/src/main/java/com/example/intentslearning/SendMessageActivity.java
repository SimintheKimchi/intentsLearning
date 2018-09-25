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
    }

    private void wireWidgets() {
        sendMessage = findViewById(R.id.button_sendMessage_send);
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
    }
}
