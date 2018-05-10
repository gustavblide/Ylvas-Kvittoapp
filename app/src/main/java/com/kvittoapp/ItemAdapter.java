package com.kvittoapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import receiptcode.GroceryItem;

/**
 * Created by Gustav on 2018-04-29.
 */

public class ItemAdapter extends ArrayAdapter<GroceryItem> {

    private final Context context;
    private final ArrayList<GroceryItem> itemList;
    private final int layoutResourceId;

    public ItemAdapter(Context context, int layoutResourceId, ArrayList<GroceryItem> itemList)
    {
        super(context, layoutResourceId, itemList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.itemList = itemList;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row==null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.itemNameView = (TextView) row.findViewById(R.id.item_view);
            holder.itemCategoryView = (TextView) row.findViewById(R.id.category_view);
            holder.itemPriceView = (TextView) row.findViewById(R.id.price_view);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        GroceryItem groceryItem = itemList.get(position);

        holder.itemNameView.setText(groceryItem.getName());
        holder.itemCategoryView.setText(groceryItem.getCategory());
        holder.itemPriceView.setText(String.valueOf(groceryItem.getPrice()));

        return row;
    }

    static class ViewHolder {
        TextView itemNameView;
        TextView itemCategoryView;
        TextView itemPriceView;
    }

}
