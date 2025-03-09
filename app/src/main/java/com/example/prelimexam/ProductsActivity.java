package com.example.prelimexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        // Cart Button
        Button btnGoToCart = findViewById(R.id.btnGoToCart);
        btnGoToCart.setOnClickListener(v -> {
            Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Product Click Listeners
        setProductClickListener(R.id.product1, "Espresso");
        setProductClickListener(R.id.product2, "Cappuccino");
        setProductClickListener(R.id.product3, "Latte");
        setProductClickListener(R.id.product4, "Mocha");
        setProductClickListener(R.id.product5, "Americano");
        setProductClickListener(R.id.product6, "Macchiato");
    }

    private void setProductClickListener(int productId, String productName) {
        ImageView productImage = findViewById(productId);
        productImage.setOnClickListener(v -> {
            Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            intent.putExtra("PRODUCT_NAME", productName);
            startActivity(intent);
        });
    }
}
