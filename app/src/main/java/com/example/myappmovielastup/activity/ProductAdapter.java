package com.example.myappmovielastup.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappmovielastup.R;

import java.util.ArrayList;

public class ProductAdapter {
    private Context context;
    private ArrayList<Product> productList;

    public ProductAdapter(Context context, ArrayList<Product> productList) {
        super();
        this.context = context;
        this.productList = productList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.list_item_product, parent, false);
        }

        Product currentProduct = getItem(position);

        // Populate the views with data from the current product
        ImageView productImage = listItemView.findViewById(R.id.productImage);
        productImage.setImageResource(currentProduct.getImageResource());

        TextView productName = listItemView.findViewById(R.id.productName);
        productName.setText(currentProduct.getProductName());

        TextView productType = listItemView.findViewById(R.id.productType);
        productType.setText(currentProduct.getProductType());

        Button editButton = listItemView.findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle edit button click
                Toast.makeText(context, "Edit clicked for: " + currentProduct.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button deleteButton = listItemView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
                Toast.makeText(context, "Delete clicked for: " + currentProduct.getProductName(), Toast.LENGTH_SHORT).show();
                // Remove the product from the list and notify the adapter
                productList.remove(currentProduct);
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }

    private void notifyDataSetChanged() {
    }

    private Product getItem(int position) {
        return null;
    }
}
