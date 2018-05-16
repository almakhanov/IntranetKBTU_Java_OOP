package main;

import java.io.Serializable;

/**
 */
public class Attendence implements Serializable{
    /**
     */
    private Student student;

    /**
     */
    private Course course;

    /**
     */
    private int attend;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getAttend() {
		return attend;
	}

	public void setAttend(int attend) {
		this.attend = attend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attend;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Attendence other = (Attendence) obj;
		if (attend != other.attend)
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attendence [student=" + student + ", course=" + course + ", attend=" + attend + "]";
	}

	public Attendence(Student student, Course course, int attend) {
		super();
		this.student = student;
		this.course = course;
		this.attend = attend;
	}

}

