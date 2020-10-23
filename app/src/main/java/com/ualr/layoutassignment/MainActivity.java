package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcTotal = findViewById(R.id.calc_total);
        calcTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });

    }

    public void calculateTotal()
    {
        double total = 0.0;

        //ToggleGroup
        MaterialButtonToggleGroup discountToggle = findViewById(R.id.discount_toggle);
        MaterialCheckBox product01 = findViewById(R.id.product_01_check);
        MaterialTextView price01 = findViewById(R.id.product_01_price_text);
        MaterialCheckBox product02 = findViewById(R.id.product_02_check);
        MaterialTextView price02 = findViewById(R.id.product_02_price_text);
        MaterialCheckBox product03 = findViewById(R.id.product_03_check);
        MaterialTextView price03 = findViewById(R.id.product_03_price_text);
        MaterialCheckBox product04 = findViewById(R.id.product_04_check);
        MaterialTextView price04 = findViewById(R.id.product_04_price_text);
        int checkedId = discountToggle.getCheckedButtonId();
        MaterialTextView totalPrice = findViewById(R.id.total_price);

        if(product01.isChecked())
        {
            String price = price01.getText().toString();
            total += Double.parseDouble(price);
        }
        if(product02.isChecked())
        {
            String price = price02.getText().toString();
            total += Double.parseDouble(price);
        }
        if(product03.isChecked())
        {
            String price = price03.getText().toString();
            total += Double.parseDouble(price);
        }
        if(product04.isChecked())
        {
            String price = price04.getText().toString();
            total += Double.parseDouble(price);
        }

        if(checkedId == R.id.discount)
        {
            double discount = total * .15;
            total -= discount;
        }

        totalPrice.setText(String.valueOf(total));
    }
}