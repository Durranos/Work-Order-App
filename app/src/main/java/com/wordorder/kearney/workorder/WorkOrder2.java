package com.wordorder.kearney.workorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by David on 11/29/2017.
 */

public class WorkOrder2 extends AppCompatActivity{

    private Button submitBtn;
    private String subject;
    private String body;
    private String emailSend;
    private String emailReceive;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_2);

        initialize();
        start();
    }

    private void initialize(){
        submitBtn = (Button) findViewById(R.id.submitBtn);

        Intent intent = getIntent();
        body = intent.getStringExtra(WorkOrder.EXTRA_MESSAGE);
    }

    private void start(){

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Email Subject
                subject = "Work Order";

                // Email Sender
                emailSend = "jbwa.workorder@gmail.com";

                // Email Recipient
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
}
