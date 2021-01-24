package com.itvillage.scms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itvillage.scms.adapter.CourseListAdapter;
import com.itvillage.scms.dto.response.StudentDetailsResponse;

import java.util.ArrayList;
import java.util.List;

public class FacultyHomeActivity extends AppCompatActivity {

    private ListView courseListView;
    private FloatingActionButton addNewCourseBut;

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
        setContentView(R.layout.activity_faculty_home);
        facultyEmail.add("Faculty Email: faculty@gmail.com");
        facultyPhoneNo.add("Faculty Phone: 01988841890");
        facultyName.add("Faculty Name: Abdul Goni");
        totalClass.add("30");
        assignFaculty.add("Abdul Goni");
        courseCode.add("SWE-122");
        courseId.add("122");
        courseTitle.add("Software Engineering");
        List<StudentDetailsResponse> studentDetailsResponses= new ArrayList<>();
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        studentDetailsResponse.setStudentId("1234");
        studentDetailsResponses.add(studentDetailsResponse);
        registerStudents.add(studentDetailsResponses);
        setDataInListView();

        addNewCourseBut = (FloatingActionButton)findViewById(R.id.addNewCourseBut);
        addNewCourseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),AddNewCourseActivity.class));
            }
        });
    }

    private void setDataInListView() {

        courseListView = findViewById(R.id.courseListView);
        CourseListAdapter adapter = new CourseListAdapter(this,courseId,courseTitle,courseCode,assignFaculty,totalClass,registerStudents,facultyName,facultyPhoneNo,facultyEmail);
        courseListView.setAdapter(adapter);
    }
}