package com.example.prelimexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private int quantity = 1; // Default quantity
    private double price = 0.0; // Product base price
    private TextView txtQuantity, txtPrice;
    private String productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Get product name from intent
        Intent intent = getIntent();
        productName = intent.getStringExtra("PRODUCT_NAME");

        // Find Views
        TextView txtProductName = findViewById(R.id.txtProductName);
        TextView txtProductDescription = findViewById(R.id.txtProductDescription);
        ImageView imgProduct = findViewById(R.id.imgProduct);
        txtPrice = findViewById(R.id.txtPrice);
        txtQuantity = findViewById(R.id.txtQuantity);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnAddToCart = findViewById(R.id.btnAddToCart);
        Button btnBuyNow = findViewById(R.id.btnBuyNow);

        // Set Product Name
        txtProductName.setText(productName);

        // Set Image, Description, and Price
        switch (productName) {
            case "Bioflu":
                imgProduct.setImageResource(R.drawable.prod1);
                txtProductDescription.setText("Bioflu (Phenylephrine HCI + Chlorphenamine Maleate + Paracetamol)");
                price = 90.00;
                break;
            case "Biogesic":
                imgProduct.setImageResource(R.drawable.prod2);
                txtProductDescription.setText("Biogesic Paracetamol 500mg ");
                price = 100.00;
                break;
            case "Cetirizine":
                imgProduct.setImageResource(R.drawable.prod3);
                txtProductDescription.setText("Cetirizine hydrochloride 10mg");
                price = 130.00;
                break;
            case "Neozep":
                imgProduct.setImageResource(R.drawable.prod4);
                txtProductDescription.setText("NEOZEP Z+ TAB X500");
                price = 140.00;
                break;
            case "Medicol":
                imgProduct.setImageResource(R.drawable.prod5);
                txtProductDescription.setText("Ibuprofen Advance 200mg Softgel Capsule");
                price = 70.00;
                break;
            case "Decolgen":
                imgProduct.setImageResource(R.drawable.prod6);
                txtProductDescription.setText("Phenylephrine HCl 10mg Paracetamol 500mg Chlorphenamine maleate 2mg");
                price = 110.00;
                break;
            default:
                txtProductDescription.setText("Delicious coffee to brighten your day!");
                price = 0.00;
                break;
        }

        // Set Initial Values
        updatePriceDisplay();

        // Quantity Increase
        btnPlus.setOnClickListener(v -> {
            quantity++;
            updatePriceDisplay();
        });

        // Quantity Decrease
        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updatePriceDisplay();
            }
        });

        // Add to Cart Button
        btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(this, productName + " added to cart!", Toast.LENGTH_SHORT).show();
        });

        // Buy Now Button
        btnBuyNow.setOnClickListener(v -> {
            Toast.makeText(this, "Proceeding to checkout for " + productName, Toast.LENGTH_SHORT).show();
        });
    }

    // Method to update quantity and price display
    private void updatePriceDisplay() {
        txtQuantity.setText(String.valueOf(quantity));
        txtPrice.setText("Price: ₱" + String.format("%.2f", price * quantity));
    }
}
