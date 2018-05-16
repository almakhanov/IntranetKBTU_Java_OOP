package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;
import java.util.Vector;

/**
 */
public class Student extends User implements Serializable{
   
    private static int yearOfStudy=1;
    private String faculty;
    private String specialization;
    private Vector<Course> cources = new Vector<Course>();
    private HashMap<Course, Mark> mark = new HashMap<Course, Mark>();
    private HashMap<Course, Vector<Attendence>> attendence = new HashMap<Course, Vector<Attendence>>();
    
    public Student(String id, String firstname, String lastname, String telNumber,
			String email, String fac, String spec) {
		super(id, firstname.charAt(0)+"_"+lastname, firstname, lastname, "123", telNumber, email);
		this.faculty=fac;
		this.specialization=spec;
	}   
    
	public static int getYearOfStudy() {
		return yearOfStudy;
	}

	public static void setYearOfStudy(int yearOfStudy) {
		Student.yearOfStudy = yearOfStudy;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Vector<Course> getCources() {
		return cources;
	}

	public void setCources(Course cources) {
		this.cources.addElement(cources); 
	}

	public HashMap<Course, Mark> getMark() {
		return mark;
	}

	public void setMark(HashMap<Course, Mark> mark) {
		this.mark = mark;
	}

	public HashMap<Course, Vector<Attendence>> getAttendence() {
		return attendence;
	}

	public void setAttendence(HashMap<Course, Vector<Attendence>> attendence) {
		this.attendence = attendence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendence == null) ? 0 : attendence.hashCode());
		result = prime * result + ((cources == null) ? 0 : cources.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
		Student other = (Student) obj;
		if (attendence == null) {
			if (other.attendence != null)
				return false;
		} else if (!attendence.equals(other.attendence))
			return false;
		if (cources == null) {
			if (other.cources != null)
				return false;
		} 
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		return true;
	}

	
	
	
	@Override
	public String toString() {
		return "Student [ "+super.toString()+" faculty=" + faculty + ", specialization=" + specialization + ", cources=" + cources + ", mark="
				+ mark + ", attendence=" + attendence + "]";
	}

	public void serialize(Vector<Student> ss) {
		try {					
	         FileOutputStream fileOut = new FileOutputStream("Students.out");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(ss);
	         out.flush();
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public Vector<Student> deserialize() {
		Vector<Student> ss = new Vector<Student>();
		try {					
			if((new File("Students.out").exists())){
				FileInputStream fileIn = new FileInputStream("Students.out");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         ss = (Vector<Student>) in.readObject();				         
		         in.close();
		         fileIn.close();
			}
	      } catch (IOException i) {
//	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Course class not found");
	         c.printStackTrace();
	      }
		return ss;
	}

    
	
}

