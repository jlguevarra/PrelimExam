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
        setProductClickListener(R.id.product1, "Bioflu");
        setProductClickListener(R.id.product2, "Biogesic");
        setProductClickListener(R.id.product3, "Cetirizine");
        setProductClickListener(R.id.product4, "Neozep");
        setProductClickListener(R.id.product5, "Medicol");
        setProductClickListener(R.id.product6, "Decolgen");
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
