package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.dto.response.RegistrationCourseRequest;
import com.itvillage.scms.services.ApiServices;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AttendeesActivity extends AppCompatActivity {
    String courseId;
    String studentId;

    private  TableLayout detailsTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees);
        detailsTable = (TableLayout) findViewById(R.id.activity_tableLayout_attandee);
        courseId = getIntent().getExtras().getString("courseId").toString();
        createTableRow(courseId);


    }

    private void createTableRow(String courseId) {
        ApiServices apiServices = new ApiServices(this);
        Observable<List<RegistrationCourseRequest>> identityResponseObservable= apiServices.getRegisterStudents(courseId);

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    for (RegistrationCourseRequest registrationCourseRequest: res) {

                        studentId = registrationCourseRequest.getId();
                        TableRow tr1 = AddOneStudentAttendeeRowInTable(registrationCourseRequest.getStudentName());
                        detailsTable.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    }
                }, throwable -> {
                }, () -> {
                });
    }

    private TableRow AddOneStudentAttendeeRowInTable(String StudentName) {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        int i;
        TextView b = new TextView(this);
        b.setText(StudentName);
        b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.addView(b);
        for( i = 0; i<=30; i++) {
            CheckBox checkBox = new CheckBox(this);
            tr.addView(checkBox);

            int finalI = i+1;
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    attendee(courseId,studentId,String.valueOf(finalI));

                }
            });

        }
        return tr;
    }

    private void attendee(String courseId,String studentId,String dayNo) {
        ApiServices apiServices = new ApiServices(this);
        Observable<IdentityResponse> identityResponseObservable= apiServices.addNewAttendee(courseId,studentId,dayNo);

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {

                }, throwable -> {
                }, () -> {
                });
    }
}