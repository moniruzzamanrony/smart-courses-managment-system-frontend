package com.itvillage.scms.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.itvillage.scms.AttendeesActivity;
import com.itvillage.scms.FacultyHomeActivity;
import com.itvillage.scms.R;
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


public class AvailableCourseListForStudentAdapter extends ArrayAdapter<String> {

    private Activity context;
    private ArrayList<String> facultyId;
    private ArrayList<String> courseId;
    private ArrayList<String> courseTitle;
    private ArrayList<String> courseCode;
    private ArrayList<String> assignFaculty;
    private ArrayList<String> totalClass;
    private ArrayList<String> facultyName;
    private ArrayList<String> facultyPhoneNo;
    private ArrayList<String> facultyEmail;
    private ArrayList<List<StudentDetailsResponse>> registerStudent;

    public AvailableCourseListForStudentAdapter(Activity context,ArrayList<String> facultyId, ArrayList<String> courseId, ArrayList<String> courseTitle,
                                                ArrayList<String> courseCode,
                                                ArrayList<String> assignFaculty,
                                                ArrayList<String> totalClass,
                                                ArrayList<List<StudentDetailsResponse>> registerStudent,
                                                ArrayList<String> facultyName,
                                                ArrayList<String> facultyPhoneNo,
                                                ArrayList<String> facultyEmail) {
        super(context, R.layout.custom_course_list_for_student, facultyId);

        this.context = context;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.assignFaculty = assignFaculty;
        this.totalClass = totalClass;
        this.registerStudent = registerStudent;
        this.facultyName = facultyName;
        this.facultyPhoneNo = facultyPhoneNo;
        this.facultyEmail = facultyEmail;
        this.facultyId = facultyId;
        this.courseId = courseId;

    }


    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_course_list_for_student, null, true);

        Button courseStudentsDetailsShowBut = rowView.findViewById(R.id.courseStudentsDetailsShowBut);
        TextView courseFacultyPhone = rowView.findViewById(R.id.courseFacultyPhone);
        TextView courseFacultyEmail = rowView.findViewById(R.id.courseFacultyEmail);
        TextView courseFacultyName = rowView.findViewById(R.id.courseFacultyName);
        TextView courseTotalStudents = rowView.findViewById(R.id.courseStudents);
        TextView totalClasses = rowView.findViewById(R.id.totalClasses);
        TextView courseCodeTextView = rowView.findViewById(R.id.courseCode);
        TextView courseTitleTextView = rowView.findViewById(R.id.courseTitle);

        courseTitleTextView.setText(courseTitle.get(position));
        courseCodeTextView.setText(courseCode.get(position));
        totalClasses.setText(totalClass.get(position));
        courseTotalStudents.setText("34");
        courseFacultyName.setText(facultyName.get(position));
        courseFacultyEmail.setText(facultyEmail.get(position));
        courseFacultyPhone.setText(facultyPhoneNo.get(position));

        courseStudentsDetailsShowBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = LoggedUserInfo.userId;
                setDataInListView(id,facultyId.get(position),courseId.get(position));
                Log.e("Id",registerStudent.get(position).get(position).getStudentId());
            }
        });
        return rowView;


    }
    private void setDataInListView(String studentId,
                                   String facultyId,
                                   String courseId) {
        ApiServices apiServices = new ApiServices(context);
        Observable<IdentityResponse> identityResponseObservable= apiServices.registrationInCourse(studentId,facultyId,courseId);

        identityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    context.startActivity(new Intent(context, FacultyHomeActivity.class));
                }, throwable -> {
                }, () -> {
                });


    }

//    @SuppressLint("CheckResult")
//    private void updateGameResult(String gameId, String userId, String squadPrize, String numberOfKill) {
//
//        UpdateGameResultService updateGameResultService = new UpdateGameResultService(context);
//
//        Observable<String> responseObservable = updateGameResultService.updateGameResultService(gameId, userId, squadPrize, numberOfKill);
//
//
//        responseObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(res -> {
//
//                    onLoginSuccess();
//
//                }, throwable -> {
//                    onLoginFailure(throwable);
//                }, () -> {
//
//                });
//
//    }
//
//
//    private void onLoginFailure(Throwable throwable) {
//
//        if (throwable instanceof HttpException) {
//            HttpException httpException = (HttpException) throwable;
//
//            if (httpException.code() == 500 || httpException.code() == 401) {
//                Utility.onErrorAlert("Something Wrong",context);
//
//            }
//            Log.e("Error", "" + throwable.getMessage());
//        }
//    }
//
//    private void onLoginSuccess() {
//
//        Utility.onSuccessAlert("Update Successful",context);
//
//    }
}