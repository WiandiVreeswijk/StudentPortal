package com.example.studentportal;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {
    private Button mAddPortalButton;
    private EditText mUrlText;
    private MainActivity mainActivity;
    private Portal portal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        mAddPortalButton = findViewById(R.id.addPortalButton);
        mUrlText = findViewById(R.id.urlEditText);
        final Button button = new Button(this);

    }

}
