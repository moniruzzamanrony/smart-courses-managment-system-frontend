package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itvillage.scms.adapter.CourseListAdapter;
import com.itvillage.scms.adapter.MyCourseListAdapter;
import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.dto.response.StudentDetailsResponse;
import com.itvillage.scms.dto.response.TeacherResponse;
import com.itvillage.scms.services.ApiServices;
import com.itvillage.scms.util.LoggedUserInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class StudentHomeActivity extends AppCompatActivity {

    private FloatingActionButton addNewCourseBut;
    private ListView myCourseListView;

    private ArrayList<String> courseTitle=new ArrayList<>();
    private ArrayList<String> courseId=new ArrayList<>();
    private ArrayList<String> courseCode=new ArrayList<>();
    private ArrayList<String> assignFaculty=new ArrayList<>();
    private ArrayList<String> totalClass=new ArrayList<>();
    private ArrayList<String> facultyName= new ArrayList<>();
    private ArrayList<String> facultyPhoneNo= new ArrayList<>();
    private ArrayList<String> facultyEmail= new ArrayList<>();
    private ArrayList<List<StudentDetailsResponse>> registerStudents=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        addNewCourseBut = findViewById(R.id.addNewCourseBut);

        List<StudentDetailsResponse> studentDetailsResponses= new ArrayList<>();
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        studentDetailsResponse.setStudentId("1234");
        studentDetailsResponses.add(studentDetailsResponse);
        registerStudents.add(studentDetailsResponses);
        setDataInMyCourseListView();

        addNewCourseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AvailableCourseListActivity.class));
            }
        });
    }

    private void setDataInMyCourseListView() {
        ApiServices apiServices = new ApiServices(this);
        Observable<List<TeacherResponse>> identityResponseObservable= apiServices.getCourseByStudentId(LoggedUserInfo.userId);

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    for(TeacherResponse courseRequest: res) {
                        facultyEmail.add("");
                        facultyPhoneNo.add("Faculty Phone: " + courseRequest.getMobileNo());
                        facultyName.add("Faculty Name: "+courseRequest.getFirstName());
                        totalClass.add(courseRequest.getCourseCredit());
                        assignFaculty.add(courseRequest.getFirstName());
                        courseCode.add(courseRequest.getCourseCode());
                        courseId.add(courseRequest.getId());
                        courseTitle.add("Software Engineering");
                    }
                    myCourseListView = findViewById(R.id.courseListView);
                    MyCourseListAdapter adapter = new MyCourseListAdapter(this,courseId,courseTitle,courseCode,assignFaculty,totalClass,registerStudents,facultyName,facultyPhoneNo,facultyEmail);
                    myCourseListView.setAdapter(adapter);

                }, throwable -> {
                }, () -> {
                });

    }
}