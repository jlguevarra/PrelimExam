package com.example.prelimexam;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {
    private RecyclerView recyclerOrders;
    private OrdersAdapter ordersAdapter;
    private List<OrderItem> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        // Initialize RecyclerView
        recyclerOrders = findViewById(R.id.recyclerOrders);
        recyclerOrders.setLayoutManager(new LinearLayoutManager(this));

        // Load sample orders
        loadOrders();

        // Set up adapter
        ordersAdapter = new OrdersAdapter(this, orderList);
        recyclerOrders.setAdapter(ordersAdapter);
    }

    private void loadOrders() {
        orderList = new ArrayList<>();

        // Sample data (Replace with real data from database)
        orderList.add(new OrderItem("Bioflu", R.drawable.prod1, "Shipped", "2025-03-09", 90.00));
        orderList.add(new OrderItem("Biogesic", R.drawable.prod2, "Delivered", "2025-03-07", 100.00));
        orderList.add(new OrderItem("Cetirizine", R.drawable.prod3, "Processing", "2025-03-08", 130.00));
        orderList.add(new OrderItem("Neozep", R.drawable.prod4, "Shipped", "2025-03-05", 140.00));

        // You can fetch real order data from a database later
    }
}
