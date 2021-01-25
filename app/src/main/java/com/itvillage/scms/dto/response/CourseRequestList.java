package com.itvillage.scms.dto.response;


import java.util.ArrayList;
import java.util.List;

public class CourseRequestList {

    private String courseCode;
    private String courseName;
    private String courseCredit;
   private List<TeacherRequestList> teacherList = new ArrayList<>();

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public List<TeacherRequestList> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherRequestList> teacherList) {
        this.teacherList = teacherList;
    }
}
