package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentDriver {
	static Student stud;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void studentMode(Student s) throws IOException {
		stud = s;
		
		
		System.out.println("Student Mode\nWelcome "+s.getFirstname()+"!!!");
		System.out.println();
		
		studentQue();
		
				
	}
	
	private static void studentQue() throws IOException {
		System.out.println("1. Information about me");
		System.out.println("2. Courses");
		System.out.println("3. Registrate to course");
		System.out.println("4. Teachers");
		System.out.println("5. Transcript");
		System.out.println("6. Marks");
		System.out.println("7. Log out");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				getInfo();
				break;				
			case '2':
				getCoursesOfStudent();
				break;
			case '3':
				registrateToCourse();
				break;
			case '4':
				getTeachers();
				break;
			case '5':
				getTranscript();
				break;
			case '6':
				getMarks();
				break;
			case '7':
				logOut();
				break;
			default: 
				studentQue();
		}
	}

	private static void getTranscript() {
		// TODO Auto-generated method stub
		
	}

	private static void getInfo() throws IOException {
		System.out.println(stud.toString());
		System.out.println("Id: "+stud.getId());
		System.out.println("Username: "+stud.getUsername());
		System.out.println("Full name: "+stud.getFirstname()+" "+stud.getLastname());
		System.out.println("Date of registration: "+stud.getDateOfRegistration());
		System.out.println("Telephone number: "+stud.getTelNumber());
		System.out.println("Email: "+stud.getEmail());
		System.out.println("Year of study: "+stud.getYearOfStudy());
		System.out.println("Faculty: "+stud.getFaculty());
		System.out.println("Specialization: "+stud.getSpecialization());
		System.out.println("Press 'q' to quit");
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			studentQue();
		}
	}

	private static void getCoursesOfStudent() throws IOException {
		System.out.println("Course List(Press 'q' to quit)");
		for(int i=0;i<stud.getCources().size();i++) {
			System.out.println(i+1+". CourseTitle: "+stud.getCources().get(i).getName()+
					"; Teacher: "+stud.getCources().get(i).getTeacher().getLastname()+" "+ stud.getCources().get(i).getTeacher().getFirstname());
		}
		
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			studentQue();
		}
	}

	private static void registrateToCourse() throws IOException {
		System.out.println("Choose the course you want to registrate(Press 'q' to quit)");
		
		for(int i=0;i<ManagerDriver.courses.size();i++) {
			System.out.println(i+1+". CourseTitle: "+ManagerDriver.courses.get(i).getName()+
					"; Teacher: "+ManagerDriver.courses.get(i).getTeacher().getLastname());
		}
		
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			studentQue();
		}
		////////////////////////////////////////////////////////////////////
		stud.setCources(ManagerDriver.courses.get(Integer.parseInt(ans)-1));
		Storage.serialize("student");
		ManagerDriver.courses.get(Integer.parseInt(ans)-1).setStudents(stud);//
		
		for(int i=0;i<Driver.teachers.size();i++) {
			
			for(int j=0;j<Driver.teachers.get(i).getCourses().size();j++) {
				if(Driver.teachers.get(i).getCourses().get(j).getName().equals(ManagerDriver.courses.get(Integer.parseInt(ans)-1).getName())) {
					System.out.println("Evrika");
					Driver.teachers.get(i).setCourses(ManagerDriver.courses.get(Integer.parseInt(ans)-1));
					break;
				}
			}
		}
		
		Storage.serialize("teacher");
		Course.serialize();	
		
		
		System.out.println("Success!");
		System.out.println("You registrated to course "+ManagerDriver.courses.get(Integer.parseInt(ans)-1).getName());
		studentQue();
	}

	

	private static void getTeachers() throws IOException {
		System.out.println("Teachers' List(Press 'q' to quit)");
		
		for(int i=0;i<stud.getCources().size();i++) {
			System.out.println(i+1+". "+stud.getCources().get(i).getTeacher().getLastname()+" "+stud.getCources().get(i).getTeacher().getFirstname());
		}
		
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			studentQue();
		}
	}

	private static void getMarks() {
		// TODO Auto-generated method stub
		
	}

	private static void logOut() throws IOException {
		Driver.preLogin();
	}
}
