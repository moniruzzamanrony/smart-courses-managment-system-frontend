package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RadioGroup rg = (RadioGroup) findViewById(R.id.registration_type);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               String squadPlayerNo = ((RadioButton)findViewById(checkedId)).getText().toString();
                switch (squadPlayerNo.toLowerCase()) {
                    case "faculty":

                        break;
                    case "student":

                        break;
                }
                Toast.makeText(getBaseContext(), squadPlayerNo+" Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}