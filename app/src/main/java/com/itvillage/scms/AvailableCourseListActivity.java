package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.itvillage.scms.adapter.AvailableCourseListForStudentAdapter;
import com.itvillage.scms.adapter.CourseListAdapter;
import com.itvillage.scms.dto.response.StudentDetailsResponse;

import java.util.ArrayList;
import java.util.List;

public class AvailableCourseListActivity extends AppCompatActivity {

    private ListView available_courses_list;

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
        setContentView(R.layout.activity_available_course_list);

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
        setDataInAvailableCourseListView();
    }

    private void setDataInAvailableCourseListView() {

        available_courses_list  = findViewById(R.id.available_courses_list);
        AvailableCourseListForStudentAdapter adapter = new AvailableCourseListForStudentAdapter(this,courseId,courseTitle,courseCode,assignFaculty,totalClass,registerStudents,facultyName,facultyPhoneNo,facultyEmail);
        available_courses_list.setAdapter(adapter);
    }
}