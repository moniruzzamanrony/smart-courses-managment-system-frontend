package com.itvillage.scms.dto.response;


import com.itvillage.scms.dto.request.CourseRequest;

import java.util.List;

public class TeacherResponse {

    private String teacherId;
    private String firstName;
    private String department;
    private String mobileNo;
    private String teacherDesignation;
    private String teacherExpertise;
    private List<CourseRequest> courseAvailable;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTeacherDesignation() {
        return teacherDesignation;
    }

    public void setTeacherDesignation(String teacherDesignation) {
        this.teacherDesignation = teacherDesignation;
    }

    public String getTeacherExpertise() {
        return teacherExpertise;
    }

    public void setTeacherExpertise(String teacherExpertise) {
        this.teacherExpertise = teacherExpertise;
    }

    public List<CourseRequest> getCourseAvailable() {
        return courseAvailable;
    }

    public void setCourseAvailable(List<CourseRequest> courseAvailable) {
        this.courseAvailable = courseAvailable;
    }
}
