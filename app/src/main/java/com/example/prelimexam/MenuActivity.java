package com.example.prelimexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnProducts = findViewById(R.id.btnProducts);
        Button btnOrders = findViewById(R.id.btnOrders);
        Button btnCart = findViewById(R.id.btnCart);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnLogout = findViewById(R.id.btnLogout);

        // Open Profile Page
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Open Products Page
        btnProducts.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ProductsActivity.class);
            startActivity(intent);
        });

        // Open Orders Page
        btnOrders.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, OrdersActivity.class);
            startActivity(intent);
        });

        // Open Cart Page
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Open Settings Page
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Logout and go back to LoginActivity
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
