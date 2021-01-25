package com.itvillage.scms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.services.ApiServices;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddNewCourseActivity extends AppCompatActivity {

    private TextInputEditText
            courseCredit,
            courseCode,
            courseTitle;
    private Button addNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_course);

        courseCredit = findViewById(R.id.courseCredit);
        courseCode = findViewById(R.id.courseCode);
        courseTitle = findViewById(R.id.courseTitle);

        addNewGame = findViewById(R.id.addNewGame);
        addNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

    }

    private void callApi() {
        ApiServices apiServices = new ApiServices(this);
        Observable<IdentityResponse> identityResponseObservable = apiServices.createNewCourse(courseCredit.getText().toString(),
                courseCode.getText().toString(),
                courseTitle.getText().toString());

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    startActivity(new Intent(this, FacultyHomeActivity.class));

                }, throwable -> {
                }, () -> {
                });

    }
}