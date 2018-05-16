package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;

public class TeacherDriver implements Serializable{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Teacher t;
	
	public static void teacherMode(Teacher teach) throws IOException {
		System.out.println("Teacher Mode");
		System.out.println("Welcome "+teach.getFirstname()+"!!!");
		t=teach;
		teacherQue();
	}

	private static void teacherQue() throws IOException {
		System.out.println("1. Information about me");
		System.out.println("2. Courses");
		System.out.println("3. Files");
		System.out.println("4. Log out");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				getInfo();
				break;				
			case '2':
				getCourses();
				break;
			case '3':
				files();
				break;
			case '4':
				logOut();
				break;
			default:
				teacherQue();
		}
	}

	private static void logOut() throws IOException {
		Driver.preLogin();
	}

	private static void files() {
		// TODO Auto-generated method stub
		
	}

	private static void getCourses() throws IOException {
		System.out.println("Courses list(Press 'q' to quit)");
		
		for(int i=0;i<t.getCourses().size();i++) {
			System.out.println((i+1)+". "+t.getCourses().get(i).getName());
		}	
		System.out.println("Plese choose the Course to make further actions!");
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			teacherQue();
		}
		
		courseAction(ans);
		
	}

	private static void courseAction(String it) throws IOException {
		System.out.println();
		System.out.println("1. List of Students");
		System.out.println("2. Put mark");
		System.out.println("3. Attendence");
		System.out.println("4. Go back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
		case '1':
			getInfoStudent(it);
			break;				
		case '2':
			putMark(it);
			break;
		case '3':
			attendence(it);
			break;
		default:
			getCourses();
	}
		
	}

	

	private static void attendence(String it) {
		
	}

	private static void putMark(String it) throws IOException {
		for(int i=0;i<t.getCourses().get(Integer.parseInt(it)-1).getStudents().size();i++) {
			System.out.println((i+1)+". "+t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getFirstname()+" "+
					t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getLastname());
		}
		System.out.println("Choose the Student you wanna put MARK(Press 'q' to quit)");
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			courseAction(it);
		}
		
		int indexOfStudent = Integer.parseInt(ans)-1;
		int indexOfSubject = Integer.parseInt(it)-1;
		
		putMarkStudent(indexOfSubject,indexOfStudent);
		
	}

	private static void putMarkStudent(int indexOfSubject, int indexOfStudent) throws IOException {
		System.out.println("Mark(0-100)");
		System.out.println("#__");
		String ans = reader.readLine();
		Mark m = new Mark(Double.parseDouble(ans));
		HashMap<Course, Mark> mark = new HashMap<Course, Mark>();
		
		System.out.println(m);
		System.out.println(t.getCourses().get(indexOfSubject));
		mark.put(t.getCourses().get(indexOfSubject), m);
		System.out.println(mark);
		
		
		t.getCourses().get(indexOfSubject).getStudents().get(indexOfStudent).setMark(mark);///ERROR
		
		Storage.serialize("student");
		Storage.serialize("teacher");
		Course.serialize();
		
		System.out.println("Success!");		
	}

	private static void getInfoStudent(String it) throws IOException {
		//System.out.println(t.getCourses().get(0).getStudents());
		//System.out.println("-----------------------");
		for(int i=0;i<t.getCourses().get(Integer.parseInt(it)-1).getStudents().size();i++) {
			System.out.println((i+1)+". "+t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getFirstname()+" "+
					t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getLastname()+" has Point out of 100 -> "+
					t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getMark().get(t.getCourses().get(Integer.parseInt(it)-1)));
		  			System.out.println("----------------------------");
		  			System.out.println(t.getCourses().get(Integer.parseInt(it)-1).getStudents().get(i).getMark());
		  			System.out.println("----------------------------");
		
		}
		System.out.println("Press 'q' to quit");///ERROR
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			courseAction(it);
		}
	}

	private static void getInfo() throws IOException {
		System.out.println("Full Information: "+t.toString());
		System.out.println("Press 'q' to quit");
		System.out.print("#__");
		String ans = reader.readLine();
		
		if(ans.equals("q")) {
			teacherQue();
		}
		
	}
}
