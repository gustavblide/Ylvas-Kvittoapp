package com.kvittoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import receiptcode.GroceryItem;

import static android.content.ContentValues.TAG;
import static com.kvittoapp.MainActivity.capitalize;


public class AddReceiptRowFragment extends Fragment {

    OnItemAddedListener mCallback;

    // Container Activity (NoReceiptActivity) must implement this interface
    public interface OnItemAddedListener {
        void onItemAdded(GroceryItem groceryItem);
    }

   @Override
    public void onAttach(Context context) {
        super.onAttach(getContext());
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnItemAddedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnItemAddedListener");
        }
    }

    Button addReceiptRowButton;
    EditText addItemEditText;
    // Spinner addCategorySpinner;
    EditText addPriceEditText;
    EditText addCategoryEditText;

    String itemName;
    String itemCategory;
    int itemPrice;

    public static ArrayList<String> categoryList = new ArrayList<String>();


    // checks if a string is a positive integer number, in order to use parseInt on it
    private boolean isPositiveInteger(String s) {
        if (s.matches("[0-9]+"))
            return true;
        else return false;
    }

    public static Fragment newInstance() {
        AddReceiptRowFragment myFragment = new AddReceiptRowFragment();
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_add_receipt_row, container, false);


        return rootview;
    }

    // Graphical elements for the user to fill in itemName, itemCategory and itemPrice.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {



        // setting up the fields and button to add an item
        addItemEditText = (EditText) getView().findViewById(R.id.add_item_edittext);
        addCategoryEditText = (EditText) getView().findViewById(R.id.add_category_edittext);
        // addCategorySpinner = (Spinner) getView().findViewById(R.id.add_category_spinner);
        addPriceEditText = (EditText) getView().findViewById(R.id.add_price_edittext);
        addReceiptRowButton = (Button) getView().findViewById(R.id.add_row_fragment_button);


        // Populating the addCategorySpinner with item categories from categoryList
        /* ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                        categoryList);
        addCategorySpinner.setAdapter(spinnerArrayAdapter);

        addCategorySpinner.setOnItemSelectedListener(this); */

        /*
         * When user clicks addReceiptRow Button,
         * this method reads the input from the EditTexts for itemName, itemCategory and itemPrice.
         * Only adding item with those parameters if:
         *  - the itemName is NOT an empty string (showing toast with message if it is)
         *  - the itemPrice is a positive integer (showing toast with message if it is not)
         */
        addReceiptRowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (!addItemEditText.getText().toString().equals("") &&
                            !addCategoryEditText.getText().toString().equals("") &&
                            !addPriceEditText.getText().toString().equals("") &&
                            isPositiveInteger(addPriceEditText.getText().toString())) {

                        itemName = capitalize(addItemEditText.getText().toString());
                    itemCategory = capitalize(addCategoryEditText.getText().toString());
                    itemPrice = Integer.parseInt(addPriceEditText.getText().toString()); }

                    else {
                        itemName = "";
                        itemCategory = "";
                        itemPrice = 0;
                    }


                    // If the category is valid and not already in the category list, add it to the list.
                    if (!categoryList.contains(itemCategory) && !itemCategory.equals("")) {
                        categoryList.add(itemCategory);
                    }

                    // If all the inputs are valid, create new GroceryItem and call NoReceiptActivity to add it,
                    // otherwise show toast with message.
                    if (!itemName.equals("") && !itemCategory.equals("") && itemPrice>0) {
                    GroceryItem groceryItem = new GroceryItem(itemName, itemCategory, itemPrice);
                    addItemEditText.setText(""); addCategoryEditText.setText(""); addPriceEditText.setText("");
                    mCallback.onItemAdded(groceryItem); }
                    else {
                        Toast.makeText(getActivity(),"Något gick fel, försök igen",Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
    /*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected: Hallå eller");
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // do nothing
    } */
}
