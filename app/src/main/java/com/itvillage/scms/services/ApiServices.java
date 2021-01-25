package com.itvillage.scms.services;

import android.content.Context;

import com.itvillage.scms.api.Apis;
import com.itvillage.scms.config.ApiClient;
import com.itvillage.scms.dto.response.AttandeeResponse;
import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.dto.response.LoginResponse;
import com.itvillage.scms.dto.response.RegistrationCourseRequest;
import com.itvillage.scms.dto.response.TeacherResponse;
import com.itvillage.scms.util.LoggedUserInfo;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApiServices {

    private final Context context;
    private final String LOGIN_REQUEST_BODY_FORMAT = "{ \"gameNumber\": \"%s\" , \"gameType\": \"%s\" }";

    public ApiServices(Context context) {
        this.context = context;
    }

    public Observable<IdentityResponse> signUpForFaculty(String password,
                                                         String faculty_id,
                                                         String address,
                                                         String phn_number,
                                                         String full_name) {

        String body = "{\"id\":\"123\",\"teacherId\":\""+faculty_id+"\",\"firstName\":\""+full_name+"\",\"department\":\""+address+"\",\"mobileNo\":\""+phn_number+"\",\"teacherDesignation\":\""+faculty_id+"\",\"teacherExpertise\":\"teacherExpertise\",\"password\":\""+password+"\"}";

        return ApiClient.getClient(context)
                .create(Apis.class)
                .signUpForFaculty(RequestBody.create(MediaType.parse("application/json"),body));
    }

    public Observable<IdentityResponse> signUpForStudent(String password,
                                                         String student_id,
                                                         String address,
                                                         String phn_number,
                                                         String full_name) {

        String body = "{\"studentId\":\""+student_id+"\",\"studentName\":\""+full_name+"\",\"department\":\""+address+"\",\"mobileNo\":\""+phn_number+"\",\"currentSemester\":\"currentSemester\",\"password\":\""+password+"\"}";

        return ApiClient.getClient(context)
                .create(Apis.class)
                .signUpForStudent(RequestBody.create(MediaType.parse("application/json"),body));
    }

    public Observable<LoginResponse> login(String userNameEditText, String passwordEditText) {

        String body = "{\"id\":\""+userNameEditText+"\",\"password\":\""+passwordEditText+"\"}";

        return ApiClient.getClient(context)
                .create(Apis.class)
                .login(RequestBody.create(MediaType.parse("application/json"),body));
    }

    public Observable<IdentityResponse> registrationInCourse(String studentId,
                                                             String facultyId,
                                                             String courseId) {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .registrationInCourse(studentId,facultyId,courseId);
    }

    public Observable<IdentityResponse> createNewCourse(String courseCredit,
                                                        String courseCode,
                                                        String courseTitle) {

        String body = "{\"id\":\"erwff\",\"courseCode\":\""+courseCode+"\",\"courseName\":\""+courseTitle+"\",\"courseDescription\":\"sdvdvd\",\"courseCredit\":\""+courseCredit+"\"}";

        return ApiClient.getClient(context)
                .create(Apis.class)
                .createNewCourse(LoggedUserInfo.userId,RequestBody.create(MediaType.parse("application/json"),body));
    }

    public Observable<IdentityResponse> addNewAttendee(String courseId,String studentId,String dayNo) {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .addNewAttendee(courseId,studentId,dayNo);
    }

    public Observable<List<TeacherResponse>> getCoursesByFacultyId(String facultyId) {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .getCoursesByFacultyId(facultyId);
    }

    public Observable<List<TeacherResponse>> getCourses() {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .getCourses();
    }



    public Observable<List<RegistrationCourseRequest>> getRegisterStudents(String courseId) {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .getRegisterStudents(courseId);
    }

    public Observable<List<TeacherResponse>> getCourseByStudentId(String studentId) {


        return ApiClient.getClient(context)
                .create(Apis.class)
                .getCourseByStudentId(studentId);
    }
    public Observable<List<AttandeeResponse>> getAttendeeByStudentId(String courseId,
                                                                     String studentId) {

        return ApiClient.getClient(context)
                .create(Apis.class)
                .getAttendeeByStudentId(courseId, studentId);
    }
}
