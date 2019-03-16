package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddPortalActivity extends AppCompatActivity {
    private TextView mUrl;
    private TextView mTitlePortal;
    private Button mAddPortalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        mUrl = findViewById(R.id.urlEditText);
        mTitlePortal = findViewById(R.id.portalText);
        mAddPortalButton = findViewById(R.id.addPortalButton);

        mAddPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = mTitlePortal.getText().toString();
                String urlText = mUrl.getText().toString();

                if (!TextUtils.isEmpty(titleText) && !TextUtils.isEmpty(urlText) && !TextUtils.equals(urlText, getString(R.string.UrlPlaceholder))) {
                    Portal portal = new Portal(titleText,urlText);
                    Intent intent = new Intent();
                    intent.putExtra(MainActivity.ADD_PORTAL,portal);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }

        });
    }

}
