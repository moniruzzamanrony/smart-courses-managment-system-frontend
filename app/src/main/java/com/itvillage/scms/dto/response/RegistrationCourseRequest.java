package com.itvillage.scms.dto.response;


import java.util.List;

public class RegistrationCourseRequest {

 private String id;
 private String studentId;
 private String studentName;
 private String department;
 private String mobileNo;
 private String currentSemester;
 private String password;

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getStudentId() {
  return studentId;
 }

 public void setStudentId(String studentId) {
  this.studentId = studentId;
 }

 public String getStudentName() {
  return studentName;
 }

 public void setStudentName(String studentName) {
  this.studentName = studentName;
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

 public String getCurrentSemester() {
  return currentSemester;
 }

 public void setCurrentSemester(String currentSemester) {
  this.currentSemester = currentSemester;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }
}
