package com.itvillage.scms.dto.response;


import java.util.List;

public class RegistrationCourseRequest {

 private List<StudentRequestList> studentRequestLists;
 private List<CourseRequestList> courseRequestLists;

 public List<StudentRequestList> getStudentRequestLists() {
  return studentRequestLists;
 }

 public void setStudentRequestLists(List<StudentRequestList> studentRequestLists) {
  this.studentRequestLists = studentRequestLists;
 }

 public List<CourseRequestList> getCourseRequestLists() {
  return courseRequestLists;
 }

 public void setCourseRequestLists(List<CourseRequestList> courseRequestLists) {
  this.courseRequestLists = courseRequestLists;
 }
}
