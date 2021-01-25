package com.itvillage.scms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.services.ApiServices;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText
            password,
            faculty_id,
            address,
            phn_number,
            full_name;
    private String role;
    private Button addNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RadioGroup rg = (RadioGroup) findViewById(R.id.registration_type);

        password = findViewById(R.id.password);
        faculty_id = findViewById(R.id.faculty_id);
        address = findViewById(R.id.address);
        phn_number = findViewById(R.id.phn_number);
        full_name = findViewById(R.id.full_name);

        addNewGame = findViewById(R.id.addNewGame);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String squadPlayerNo = ((RadioButton) findViewById(checkedId)).getText().toString();
                switch (squadPlayerNo.toLowerCase()) {
                    case "faculty":
                        role = "faculty";

                        break;
                    case "student":
                        role = "student";
                        break;
                }
                Toast.makeText(getBaseContext(), squadPlayerNo + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        addNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(role.equals("faculty")) {
                    callApiForFaculty();
                }else if(role.equals("student"))
                {
                    callApiForStudent();
                }
            }
        });
    }

    private void callApiForFaculty() {
        ApiServices apiServices = new ApiServices(this);
       Observable<IdentityResponse> identityResponseObservable= apiServices.signUpForFaculty(password.getText().toString(),
               faculty_id.getText().toString(),
               address.getText().toString(),
               phn_number.getText().toString(),
               full_name.getText().toString());

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    startActivity(new Intent(this,MainActivity.class));
                }, throwable -> {
                }, () -> {
                });

    }

    private void callApiForStudent() {
        ApiServices apiServices = new ApiServices(this);
        Observable<IdentityResponse> identityResponseObservable= apiServices.signUpForStudent(password.getText().toString(),
                faculty_id.getText().toString(),
                address.getText().toString(),
                phn_number.getText().toString(),
                full_name.getText().toString());

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                   startActivity(new Intent(this,MainActivity.class));
                }, throwable -> {
                }, () -> {
                });

    }
}