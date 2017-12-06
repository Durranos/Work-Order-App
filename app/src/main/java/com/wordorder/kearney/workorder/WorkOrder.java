package com.wordorder.kearney.workorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by David on 11/1/2017.
 */

public class WorkOrder extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.workorder.kearney.workorder.MESSAGE";

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

    private Button nextBtn;
    private String body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order);

        initialize();

        if (savedInstanceState != null) {
            clientNameText.setText(savedInstanceState.getString("clientName"));
            projectNameText.setText(savedInstanceState.getString("projectName"));
            changeOrderText.setText(savedInstanceState.getString("changeOrder"));
            requestedByText.setText(savedInstanceState.getString("requestedBy"));
            subcontractorNameText.setText(savedInstanceState.getString("subcontractorName"));
            dateRequestedText.setText(savedInstanceState.getString("dateRequested"));
            dateScheduledText.setText(savedInstanceState.getString("dateScheduled"));
        }

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

        nextBtn = (Button) findViewById(R.id.nextButton);
    }

    private void start(){

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

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

                // Start the next activity for the form
                Intent intent = new Intent(v.getContext(), WorkOrder2.class);
                intent.putExtra(EXTRA_MESSAGE, body);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("clientName", clientNameText.getText().toString());
        savedInstanceState.putString("projectName", projectNameText.getText().toString());
        savedInstanceState.putString("changeOrder", changeOrderText.getText().toString());
        savedInstanceState.putString("requestedBy", requestedByText.getText().toString());
        savedInstanceState.putString("subcontractorName", subcontractorNameText.getText().toString());
        savedInstanceState.putString("dateRequested", dateRequestedText.getText().toString());
        savedInstanceState.putString("dateScheduled", dateScheduledText.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        clientNameText.setText(savedInstanceState.getString("clientName"));
        projectNameText.setText(savedInstanceState.getString("projectName"));
        changeOrderText.setText(savedInstanceState.getString("changeOrder"));
        requestedByText.setText(savedInstanceState.getString("requestedBy"));
        subcontractorNameText.setText(savedInstanceState.getString("subcontractorName"));
        dateRequestedText.setText(savedInstanceState.getString("dateRequested"));
        dateScheduledText.setText(savedInstanceState.getString("dateScheduled"));
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

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
    protected void onStop(){
        super.onStop();

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
