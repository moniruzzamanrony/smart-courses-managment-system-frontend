package com.itvillage.scms.api;

import com.itvillage.scms.dto.request.TeacherSignUpRequest;
import com.itvillage.scms.dto.response.AttandeeResponse;
import com.itvillage.scms.dto.response.IdentityResponse;
import com.itvillage.scms.dto.response.LoginResponse;
import com.itvillage.scms.dto.response.RegistrationCourseRequest;
import com.itvillage.scms.dto.response.TeacherResponse;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Apis {
    @POST("api/maintenance/create/teacher")
    Observable<IdentityResponse> signUpForFaculty(@Body RequestBody body);

    @POST("api/maintenance/create/student")
    Observable<IdentityResponse> signUpForStudent(@Body RequestBody body);

    @POST("api/maintenance/common/login")
    Observable<LoginResponse> login(@Body RequestBody body);

    @POST("api/maintenance/create/course/teacher/{facultyId}")
    Observable<IdentityResponse> createNewCourse(@Path("facultyId") String facultyId,@Body RequestBody body);

    @POST("api/maintenance/courses/{courseId}/students/{studentId}/days/{dayNo}")
    Observable<IdentityResponse> addNewAttendee(@Path("courseId") String courseId,
                                                 @Path("studentId") String studentId,
                                                 @Path("dayNo") String dayNo);

    @POST("api/maintenance/student/registration/by/{studentId}/teacher/{facultyId}/course/{courseId}")
    Observable<IdentityResponse> registrationInCourse(@Path("studentId") String studentId,
                                                      @Path("facultyId") String facultyId,
                                                      @Path("courseId") String courseId
    );
    @GET("api/maintenance/getAll/teacher/course/{facultyId}")
    Observable<List<TeacherResponse>> getCoursesByFacultyId(@Path("facultyId") String facultyId);

    @GET("api/maintenance/courses")
    Observable<List<TeacherResponse>> getCourses();



    @GET("api/maintenance/getAll/registration/course/{courseId}")
    Observable<List<RegistrationCourseRequest>> getRegisterStudents(@Path("courseId") String courseId);

    @GET("api/maintenance/getAll/registration/students/{studentId}")
    Observable<List<TeacherResponse>> getCourseByStudentId(@Path("studentId") String studentId);

    @GET("api/maintenance/courses/{courseId}/students/{studentId}/attendee")
    Observable<List<AttandeeResponse>> getAttendeeByStudentId(@Path("courseId") String courseId,
                                                              @Path("studentId") String studentId);




}
