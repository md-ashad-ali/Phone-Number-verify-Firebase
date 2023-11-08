package com.example.phoneauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class PhoneAuth extends AppCompatActivity {

    EditText editText;
    Button button;
    public  static String PHONE ="phone number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

          editText = findViewById(R.id.phoneET);
          button = findViewById(R.id.phoneBT);

          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  String Phone = editText.getText().toString().trim();
                  if(Phone.isEmpty())
                  {
                      Toast.makeText(PhoneAuth.this, "Enter Phone number Here", Toast.LENGTH_SHORT).show();
                  }else {

                      Intent intent = new Intent(PhoneAuth.this,VerifyActivty.class);
                      intent.putExtra(PHONE,Phone);
                      startActivity(intent);
                  }


              }
          });

        AutoLogin();


    }
    private void AutoLogin() {

        FirebaseAuth auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null)
        {
            Intent intent = new Intent(PhoneAuth.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}