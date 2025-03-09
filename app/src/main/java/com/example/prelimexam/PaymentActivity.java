package com.example.prelimexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {

    private TextView txtTotalAmount, txtShippingFee, txtGrandTotal, txtUserName, txtUserContact, txtUserAddress;
    private RadioGroup radioPaymentOptions;
    private Button btnConfirmPayment;

    private double totalAmount;
    private double shippingFee;
    private double grandTotal;

    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); // Format currency

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize Views
        txtTotalAmount = findViewById(R.id.txtTotalAmount);
        txtShippingFee = findViewById(R.id.txtShippingFee);
        txtGrandTotal = findViewById(R.id.txtGrandTotal);
        txtUserName = findViewById(R.id.txtUserName);
        txtUserContact = findViewById(R.id.txtUserContact);
        txtUserAddress = findViewById(R.id.txtUserAddress);
        radioPaymentOptions = findViewById(R.id.radioPaymentOptions);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        // Get Data from CartActivity
        totalAmount = getIntent().getDoubleExtra("totalPrice", 0.00);
        shippingFee = getIntent().getDoubleExtra("shippingFee", 50.00); // Default ₱50.00
        grandTotal = totalAmount + shippingFee;

        String userName = getIntent().getStringExtra("userName");
        String userContact = getIntent().getStringExtra("userContact");
        String userAddress = getIntent().getStringExtra("userAddress");

        // Set values
        txtTotalAmount.setText("Total Amount: ₱" + decimalFormat.format(totalAmount));
        txtShippingFee.setText("Shipping Fee: ₱" + decimalFormat.format(shippingFee));
        txtGrandTotal.setText("Grand Total: ₱" + decimalFormat.format(grandTotal));

        txtUserName.setText(userName);
        txtUserContact.setText(userContact);
        txtUserAddress.setText(userAddress);

        // Confirm Payment Button
        btnConfirmPayment.setOnClickListener(v -> {
            int selectedId = radioPaymentOptions.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(PaymentActivity.this, "Please select a payment method!", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedRadio = findViewById(selectedId);
                String paymentMethod = selectedRadio.getText().toString();
                Toast.makeText(PaymentActivity.this, "Payment confirmed using " + paymentMethod, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
