package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.util.*;
/**
 */
public class Course implements Serializable{
    
    private String name;
    private Teacher teacher;
    private int credit;
    private Vector<Student> students = new Vector<Student>();
    private Date date = new Date();
    private Vector<HashMap<Days, Vector<String>>> time = new Vector<HashMap<Days, Vector<String>>>();
    private String courseCode;
    private boolean onStudying=true;
    private String spec;
    
    public Course(String name, Teacher teacher, int credit, String courseCode, String spec) {
		this.name = name;
		this.teacher = teacher;
		this.credit = credit;
		this.courseCode = courseCode;
		this.spec = spec;
	}
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Vector<Student> getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students.addElement(students);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vector<HashMap<Days, Vector<String>>> getTime() {
		return time;
	}

	public void setTime(Vector<HashMap<Days, Vector<String>>> time) {
		this.time = time;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public boolean isOnStudying() {
		return onStudying;
	}

	public void setOnStudying(boolean onStudying) {
		this.onStudying = onStudying;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + credit;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (onStudying ? 1231 : 1237);
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (credit != other.credit)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onStudying != other.onStudying)
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public static void serialize() {
		try {					
	         FileOutputStream fileOut = new FileOutputStream("Courses.out");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(ManagerDriver.courses);
	         out.flush();
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static void deserialize() {
		try {					
			if((new File("Courses.out").exists())){
				FileInputStream fileIn = new FileInputStream("Courses.out");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         ManagerDriver.courses = (Vector<Course>) in.readObject();				         
		         in.close();
		         fileIn.close();
			}
	      } catch (IOException i) {
//	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Course class not found");
	         c.printStackTrace();
	      }
	}


	@Override
	public String toString() {
		return "Course [name=" + name + 
				", credit=" + credit + 
				", date=" + date + ", time=" + time + ", courseCode=" + courseCode + ", onStudying=" + onStudying
				+ ", spec=" + spec + "]";
	}
	
	
	
    
}

