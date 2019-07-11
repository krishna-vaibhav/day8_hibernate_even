package dao;

import pojos.Address;
import pojos.Course;
import pojos.Student;

public interface CourseManagementDao {
	public String launchCourse(Course c);
	public Course getCourseDetails(String courseName);
	public Course getCourseDetailsViaJoin(String courseName);
	public String assignStudentAddress(int id,Address a);
	public Student getStudentDetails(int studentId);
	public String assignStudentDetails(Student s);
}
