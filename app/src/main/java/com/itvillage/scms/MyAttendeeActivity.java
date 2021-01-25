package com.itvillage.scms;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itvillage.scms.dto.response.AttandeeResponse;
import com.itvillage.scms.services.ApiServices;
import com.itvillage.scms.util.LoggedUserInfo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyAttendeeActivity extends AppCompatActivity {

    private TableLayout detailsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attendee);

        detailsTable = (TableLayout) findViewById(R.id.myTable);
        String courseId = getIntent().getExtras().getString("courseId");
        showMyAttendee(courseId);
    }
    private void showMyAttendee(String courseId) {
        ApiServices apiServices = new ApiServices(this);
        Observable<List<AttandeeResponse>> identityResponseObservable = apiServices.getAttendeeByStudentId(courseId, LoggedUserInfo.userId);
        AttandeeResponse attandeeResponseMock = new AttandeeResponse();
        attandeeResponseMock.setClassNo("Classes");
        attandeeResponseMock.setStatus("Status");
        addOneStudentAttendeeRowInTable(attandeeResponseMock);
        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    for (AttandeeResponse attandeeResponse : res) {
                        addOneStudentAttendeeRowInTable(attandeeResponse);
                    }

                }, throwable -> {
                }, () -> {
                });
    }

    private TableRow addOneStudentAttendeeRowInTable(AttandeeResponse attandeeResponse) {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));


        TextView classNo = new TextView(this);
        classNo.setWidth(1000);
        classNo.setText(attandeeResponse.getClassNo());
        tr.addView(classNo);

        TextView status = new TextView(this);
        status.setWidth(1000);
        status.setText(attandeeResponse.getStatus());
        tr.addView(status);
        detailsTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        return tr;
    }
}