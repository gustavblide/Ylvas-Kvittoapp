package com.kvittoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.vision.text.Line;
import com.kvittoapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

import receiptcode.Receipt;

public class MainActivity extends AppCompatActivity {
Button scanReceiptButton;
Button noReceiptButton;
Button manageReceiptButton;

public static String capitalize(String input) {
    if (!(input==null)) {
    return input.substring(0, 1).toUpperCase() + input.substring(1); }
    return null;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanReceiptButton = (Button) findViewById(R.id.scan_receipt_button);     // "Skanna kvitto"-button
        noReceiptButton = (Button) findViewById(R.id.without_receipt_button);    // "Mata in utan kvitto"-button
        manageReceiptButton = (Button) findViewById(R.id.manage_receipt_button); // "Hantera kvitton"-button

        scanReceiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO implement onClick method
            }
        });

        // When the noReceiptButton is clicked, the noReceiptActivity starts.
        noReceiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NoReceiptActivity.class);
                startActivity(intent);
            }
        });

        manageReceiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO implement onClick method
            }
        });
    }
}
