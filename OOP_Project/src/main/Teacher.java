package main;
import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;
import java.util.TreeSet;
/**
*/
import java.util.Vector;
public class Teacher extends Employee implements Serializable{

private String degree;
/**
*/
private Vector<Course> courses = new Vector<Course>();
/**
*/
private HashMap<Course, Integer> salaryPerCourse = new HashMap<Course, Integer>();
/**
*/
private HashMap<Course, Vector<File>> files = new HashMap<Course, Vector<File>>();
/**
*/
private HashMap<Course, TreeSet<Student>> students = new HashMap<Course, TreeSet<Student>>();

public Teacher(String id, String firstname, String lastname, String telNumber, String email, String deg) {
	super(id, firstname, lastname, telNumber, email);
	this.degree=deg;
}


public void viewCourse() {
}

public void addFile(File file) {
}
/**
 * @param s 
 * @param point 
 * @return 
*/
public boolean putPoint(double point, Student s) {
    return false;
}
/**
 * @param studentList 
*/
public void putAttendence(HashMap<Course, TreeSet<Student>> studentList) {
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public Vector<Course> getCourses() {
	return courses;
}
public void setCourses(Course courses) {
	this.courses.addElement(courses);
}
public HashMap<Course, Integer> getSalaryPerCourse() {
	return salaryPerCourse;
}
public void setSalaryPerCourse(HashMap<Course, Integer> salaryPerCourse) {
	this.salaryPerCourse = salaryPerCourse;
}
public HashMap<Course, Vector<File>> getFiles() {
	return files;
}
public void setFiles(HashMap<Course, Vector<File>> files) {
	this.files = files;
}
public HashMap<Course, TreeSet<Student>> getStudents() {
	return students;
}
public void setStudents(HashMap<Course, TreeSet<Student>> students) {
	this.students = students;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((courses == null) ? 0 : courses.hashCode());
	result = prime * result + ((degree == null) ? 0 : degree.hashCode());
	result = prime * result + ((files == null) ? 0 : files.hashCode());
	result = prime * result + ((salaryPerCourse == null) ? 0 : salaryPerCourse.hashCode());
	result = prime * result + ((students == null) ? 0 : students.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Teacher other = (Teacher) obj;
	if (courses == null) {
		if (other.courses != null)
			return false;
	} else if (!courses.equals(other.courses))
		return false;
	if (degree == null) {
		if (other.degree != null)
			return false;
	} else if (!degree.equals(other.degree))
		return false;
	if (files == null) {
		if (other.files != null)
			return false;
	} else if (!files.equals(other.files))
		return false;
	if (salaryPerCourse == null) {
		if (other.salaryPerCourse != null)
			return false;
	} else if (!salaryPerCourse.equals(other.salaryPerCourse))
		return false;
	if (students == null) {
		if (other.students != null)
			return false;
	} else if (!students.equals(other.students))
		return false;
	return true;
}
@Override
public String toString() {
	return "Teacher [ "+super.toString()+
			" degree=" + degree + 
			", courses=" + courses + 
			", salaryPerCourse=" + salaryPerCourse + 
			", files="+ files + 
			", students=" + students + "]";
}


}

