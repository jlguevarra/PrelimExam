package com.example.prelimexam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerCart;
    private TextView txtTotalPrice, txtShippingFee, txtGrandTotal, txtUserName, txtUserContact, txtUserAddress;
    private ImageView imgEditAddress;
    private Button btnProceedPayment;
    private List<CartItem> cartItems;
    private CartAdapter cartAdapter;

    private static final double SHIPPING_FEE = 50.00; // Fixed shipping fee
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); // Format currency

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Views
        recyclerCart = findViewById(R.id.recyclerCart);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        txtShippingFee = findViewById(R.id.txtShippingFee);
        txtGrandTotal = findViewById(R.id.txtGrandTotal);
        txtUserName = findViewById(R.id.txtUserName);
        txtUserContact = findViewById(R.id.txtUserContact);
        txtUserAddress = findViewById(R.id.txtUserAddress);
        imgEditAddress = findViewById(R.id.imgEditAddress);
        btnProceedPayment = findViewById(R.id.btnProceedPayment);

        // Default User Info
        txtUserName.setText("Name: Eidrei Magcalas");
        txtUserContact.setText("Contact: +63 912 345 6789");
        txtUserAddress.setText("Address: 123 Main St, Manila, PH");

        // Sample Cart Items (Temporary)
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Biogesic", 100, 1, R.drawable.prod2));
        cartItems.add(new CartItem("Neozep", 140, 2, R.drawable.prod4));

        // Set up RecyclerView
        recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, cartItems);
        recyclerCart.setAdapter(cartAdapter);

        // Calculate total
        updateTotalPrice();

        // Edit Address Action
        imgEditAddress.setOnClickListener(v -> showEditAddressDialog());

        // Proceed to Payment Action
        btnProceedPayment.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
            intent.putExtra("totalPrice", calculateTotalPrice());
            intent.putExtra("shippingFee", SHIPPING_FEE);
            intent.putExtra("userName", txtUserName.getText().toString());
            intent.putExtra("userContact", txtUserContact.getText().toString());
            intent.putExtra("userAddress", txtUserAddress.getText().toString());
            startActivity(intent);
        });
    }

    private void updateTotalPrice() {
        double totalPrice = calculateTotalPrice();
        double grandTotal = totalPrice + SHIPPING_FEE;

        txtTotalPrice.setText("Total Price: ₱" + decimalFormat.format(totalPrice));
        txtShippingFee.setText("Shipping Fee: ₱" + decimalFormat.format(SHIPPING_FEE));
        txtGrandTotal.setText("Grand Total: ₱" + decimalFormat.format(grandTotal));
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private void showEditAddressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Address");

        // Create input fields
        final EditText inputName = new EditText(this);
        inputName.setHint("Enter Name");
        inputName.setText(txtUserName.getText().toString().replace("Name: ", ""));
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);

        final EditText inputContact = new EditText(this);
        inputContact.setHint("Enter Contact");
        inputContact.setText(txtUserContact.getText().toString().replace("Contact: ", ""));
        inputContact.setInputType(InputType.TYPE_CLASS_PHONE);

        final EditText inputAddress = new EditText(this);
        inputAddress.setHint("Enter Address");
        inputAddress.setText(txtUserAddress.getText().toString().replace("Address: ", ""));
        inputAddress.setInputType(InputType.TYPE_CLASS_TEXT);

        // Create Layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 20, 40, 20);
        layout.addView(inputName);
        layout.addView(inputContact);
        layout.addView(inputAddress);
        builder.setView(layout);

        // Set Buttons
        builder.setPositiveButton("Save", (dialog, which) -> {
            txtUserName.setText("Name: " + inputName.getText().toString());
            txtUserContact.setText("Contact: " + inputContact.getText().toString());
            txtUserAddress.setText("Address: " + inputAddress.getText().toString());
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
