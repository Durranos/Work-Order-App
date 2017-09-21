package com.wordorder.kearney.workorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView clientNameLabel;
    private EditText clientNameText;
    private TextView projectNameLabel;
    private EditText projectNameText;
    private TextView changeOrderLabel;
    private EditText changeOrderText;
    private TextView requestedByLabel;
    private EditText requestedByText;
    private TextView subcontractorNameLabel;
    private EditText subcontractorNameText;
    private TextView dateRequestedLabel;
    private EditText dateRequestedText;
    private TextView dateScheduledLabel;
    private EditText dateScheduledText;

    private AdapterViewFlipper viewFlipper;

    private Button submitBtn;
    private String subject;
    private String body;
    private String emailSend;
    private String emailReceive;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        start();
    }

    private void initialize(){
        clientNameLabel        = (TextView) findViewById(R.id.clientNameLabel);
        clientNameText         = (EditText) findViewById(R.id.clientNameText);
        projectNameLabel       = (TextView) findViewById(R.id.projectNameLabel);
        projectNameText        = (EditText) findViewById(R.id.projectNameText);
        changeOrderLabel       = (TextView) findViewById(R.id.changeOrderLabel);
        changeOrderText        = (EditText) findViewById(R.id.changeOrderText);
        requestedByLabel       = (TextView) findViewById(R.id.requestedByLabel);
        requestedByText        = (EditText) findViewById(R.id.requestedByText);
        subcontractorNameLabel = (TextView) findViewById(R.id.subcontractorNameLabel);
        subcontractorNameText  = (EditText) findViewById(R.id.subcontractorNameText);
        dateRequestedLabel     = (TextView) findViewById(R.id.dateRequestedLabel);
        dateRequestedText      = (EditText) findViewById(R.id.dateRequestedText);
        dateScheduledLabel = (TextView) findViewById(R.id.dateScheduledLabel);
        dateScheduledText      = (EditText) findViewById(R.id.dateScheduledText);

        viewFlipper = (AdapterViewFlipper) findViewById(R.id.viewFlipper);


        submitBtn = (Button) findViewById(R.id.submitButton);
    }

    private void start(){
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Email Subject
                subject = "Work Order";

                // Email Body
                body = clientNameLabel.getText().toString() + ": ";
                body += clientNameText.getText().toString() + System.getProperty("line.separator");
                body += projectNameLabel.getText().toString() + ": ";
                body += projectNameText.getText().toString() + System.getProperty("line.separator");
                body += changeOrderLabel.getText().toString() + ": ";
                body += changeOrderText.getText().toString() + System.getProperty("line.separator");
                body += requestedByLabel.getText().toString() + ": ";
                body += requestedByText.getText().toString() + System.getProperty("line.separator");
                body += subcontractorNameLabel.getText().toString() + ": ";
                body += subcontractorNameText.getText().toString() + System.getProperty("line.separator");
                body += dateRequestedLabel.getText().toString() + ": ";
                body += dateRequestedText.getText().toString() + System.getProperty("line.separator");
                body += dateScheduledLabel.getText().toString() + ": ";
                body += dateScheduledText.getText().toString() + System.getProperty("line.separator");

                // Email Recipient
                emailSend = "jbwa.workorder@gmail.com";

                // Email Sender
                emailReceive = "david.kearney@webbengr.com";
                password = "jbwaworkorder";

                // Debugging Purposes
                Log.d("Subject: ", subject);
                Log.d("Body: ", body);
                Log.d("Email Send: ", emailSend);
                Log.d("Email Receive: ", emailReceive);
                Log.d("Password: ", password);

                try {
                    GMailSender sender = new GMailSender(emailSend, password);
                    sender.sendMail(subject, body, emailSend, emailReceive);
                } catch (Exception e){
                    Log.e("SendMail External", e.getMessage(), e);
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
