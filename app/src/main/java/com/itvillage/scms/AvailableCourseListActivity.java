package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.itvillage.scms.adapter.AvailableCourseListForStudentAdapter;
import com.itvillage.scms.adapter.CourseListAdapter;
import com.itvillage.scms.dto.response.StudentDetailsResponse;
import com.itvillage.scms.dto.response.TeacherResponse;
import com.itvillage.scms.services.ApiServices;
import com.itvillage.scms.util.LoggedUserInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
    private ArrayList<String> facultyId= new ArrayList<>();
    private ArrayList<List<StudentDetailsResponse>> registerStudents=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_course_list);


        List<StudentDetailsResponse> studentDetailsResponses= new ArrayList<>();
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        studentDetailsResponse.setStudentId("1234");
        studentDetailsResponses.add(studentDetailsResponse);
        registerStudents.add(studentDetailsResponses);
        setDataInAvailableCourseListView();
    }

    private void setDataInAvailableCourseListView() {
        ApiServices apiServices = new ApiServices(this);
        Observable<List<TeacherResponse>> identityResponseObservable= apiServices.getCourses();

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    for(TeacherResponse courseRequest: res) {
                        facultyId.add(courseRequest.getTeacherId());
                        facultyEmail.add("");
                        facultyPhoneNo.add("Faculty Phone: " + courseRequest.getMobileNo());
                        facultyName.add("Faculty Name: "+courseRequest.getFirstName());
                        totalClass.add(courseRequest.getCourseCredit());
                        assignFaculty.add(courseRequest.getFirstName());
                        courseCode.add(courseRequest.getCourseCode());
                        courseId.add(courseRequest.getId());
                        courseTitle.add("Software Engineering");
                    }
                    available_courses_list  = findViewById(R.id.available_courses_list);
                    AvailableCourseListForStudentAdapter adapter = new AvailableCourseListForStudentAdapter(this,facultyId,courseId,courseTitle,courseCode,assignFaculty,totalClass,registerStudents,facultyName,facultyPhoneNo,facultyEmail);
                    available_courses_list.setAdapter(adapter);
                }, throwable -> {
                }, () -> {
                });

    }
}