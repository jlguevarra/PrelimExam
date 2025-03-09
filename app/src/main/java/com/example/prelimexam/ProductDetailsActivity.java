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
            case "Espresso":
                imgProduct.setImageResource(R.drawable.prod1);
                txtProductDescription.setText("A strong and rich shot of pure espresso, perfect for a quick caffeine boost.");
                price = 80.00;
                break;
            case "Cappuccino":
                imgProduct.setImageResource(R.drawable.prod2);
                txtProductDescription.setText("A classic blend of espresso, steamed milk, and frothy foam for a creamy delight.");
                price = 120.00;
                break;
            case "Latte":
                imgProduct.setImageResource(R.drawable.prod3);
                txtProductDescription.setText("Smooth espresso mixed with steamed milk, topped with a light foam layer.");
                price = 130.00;
                break;
            case "Mocha":
                imgProduct.setImageResource(R.drawable.prod4);
                txtProductDescription.setText("A delicious combination of espresso, chocolate syrup, and steamed milk.");
                price = 140.00;
                break;
            case "Americano":
                imgProduct.setImageResource(R.drawable.prod5);
                txtProductDescription.setText("Espresso diluted with hot water for a smooth and balanced taste.");
                price = 90.00;
                break;
            case "Macchiato":
                imgProduct.setImageResource(R.drawable.prod6);
                txtProductDescription.setText("An espresso with a small amount of milk, offering a bold yet creamy experience.");
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
