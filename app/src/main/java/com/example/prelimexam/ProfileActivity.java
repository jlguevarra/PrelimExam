package com.example.prelimexam;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtUserName, txtUserEmail, txtUserContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize UI elements
        txtUserName = findViewById(R.id.txtUserName);
        txtUserEmail = findViewById(R.id.txtUserEmail);
        txtUserContact = findViewById(R.id.txtUserContact);

        // Sample user data (Replace with real data later)
        txtUserName.setText("Eidrei Magcalas");
        txtUserEmail.setText("eidreimagcalas@gmail.com");
        txtUserContact.setText("+63 912 345 6789");
    }
}
