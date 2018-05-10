package com.kvittoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import receiptcode.GroceryItem;
import receiptcode.Receipt;

public class NoReceiptActivity extends AppCompatActivity
        implements AddReceiptRowFragment.OnItemAddedListener {

    private Receipt receipt;
    private ArrayList<GroceryItem> items;
    private ItemAdapter itemAdapter;


    // When the user clicks to add a receipt item, this method adds it to the receipt.
    @Override
    public void onItemAdded(GroceryItem groceryItem) {
        items.add(groceryItem);
        ArrayList<GroceryItem> itemsCheck = items;
        itemAdapter.notifyDataSetChanged();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_receipt_list);
        items = new ArrayList<>();
        final Button addItemButton = (Button) findViewById(R.id.add_item_button);
        final Button saveReceiptButton = (Button) findViewById(R.id.save_receipt_button);
        ListView itemsReceiptListview = (ListView) findViewById(R.id.items_receipt_listview);
        itemAdapter = new ItemAdapter(this, R.id.receipt_row, items);
        itemsReceiptListview.setAdapter(itemAdapter);



        /* When the addItemButton is clicked, an AddReceiptRowFragment is started.
           Also, the addItemButton and saveReceiptButton are set to disabled. */
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = AddReceiptRowFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.no_receipt_list, fragment).commit();
                addItemButton.setEnabled(false);
                saveReceiptButton.setEnabled(false);
            }
        });
    }


}


