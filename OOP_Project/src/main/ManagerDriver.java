package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Vector;

public class ManagerDriver implements Serializable{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String manager = "";
	static Vector<Course> courses = new Vector<Course>();
	static Vector<News> news = new Vector<News>();
	
	public static void managerMode(Manager m) throws IOException {
		
		manager = m.getFirstname();
		System.out.println("Welcome to Manager mode " + manager+"!!!");
		
		managerQue();
	}

	private static void managerQue() throws IOException {
		System.out.println("Please print the number of action");
		System.out.println();
		System.out.println("1. News");
		System.out.println("2. Courses");
		System.out.println("3. Create Report");
		System.out.println("4. Log out");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				newsPage();
				break;				
			case '2':
				coursePage();
				break;
			case '3':
				createReport();
				break;
			case '4':
				Driver.preLogin();
				break;
		}
	}

	private static void createReport() {
		// TODO Auto-generated method stub
		
	}

	private static void coursePage() throws IOException {
		
		System.out.println("Please print the number of action");
		System.out.println();
		System.out.println("1. Create course");
		System.out.println("2. Registration list");
		System.out.println("3. Course list");
		System.out.println("4. News page");
		System.out.println("5. go Back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				addCourse();
				break;				
			case '2':
				registrationList();
				break;
			case '3':
				courseList();
				break;
			case '4':
				newsPage();
				break;
			case '5':
				managerQue();
				break;
		}
	}

	private static void courseList() throws IOException {
		System.out.println("Course List:");
		for(int i=0;i<courses.size();i++) {
			System.out.println(i+1+". CourseTitle: "+courses.get(i).getName()+"; Teacher: "+courses.get(i).getTeacher().getLastname());
		}
		String txt = reader.readLine();
		if(txt.equals("q")) {
			coursePage();
		}
	}

	private static void registrationList() {
		
	}

	private static void addCourse() throws IOException {
		System.out.println("Please fill the Course fields with spaces as in Example");
		System.out.print("Course name:__");
		String name = reader.readLine();
		
		System.out.print("Choose teacher:__");
		for(int i=0; i<Driver.teachers.size();i++) {
			System.out.println(i+1+". "+Driver.teachers.get(i).getLastname()+ " " + Driver.teachers.get(i).getFirstname());
		}
		String teach = reader.readLine();
		//Driver.teachers.get(Integer.parseInt(teach)-1);
		
		System.out.print("Course credits:__");
		String credits = reader.readLine();
		
		System.out.print("Course code:__");
		String code = reader.readLine();
		
		System.out.print("Course specialization:__");
		String spec = reader.readLine();
		
		Course c = new Course(name, Driver.teachers.get(Integer.parseInt(teach)-1), Integer.parseInt(credits), code, spec);
		Driver.teachers.get(Integer.parseInt(teach)-1).setCourses(c);
		courses.addElement(c);
		
		Course.serialize();
		Storage.serialize("teacher");
		
		System.out.println("Success!");			
		coursePage();
	}

	private static void newsPage() throws IOException {
		System.out.println("Please print the number of action");
		System.out.println();
		System.out.println("1. Add News");
		System.out.println("2. Delete News");
		System.out.println("3. News List");
		System.out.println("4. go Back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				addNews();
				break;				
			case '2':
				deleteNews();
				break;
			case '3':
				newsList();
				break;
			case '4':
				managerQue();
				break;
		}
		
	}

	private static void newsList() throws IOException {
		System.out.println("News List:");
		for(int i=0;i<news.size();i++) {
			System.out.println(i+1+". NewsTitle: "+news.get(i).getTheme()+"; Author: "+news.get(i).getAuthor());
			System.out.println("Description: "+news.get(i).getDescription());
		}
		String txt = reader.readLine();
		if(txt.equals("q")){
			newsPage();
		}
	}

	private static void addNews() throws IOException {
		System.out.println("Please fill the News fields");
		System.out.print("News name:__");
		String name = reader.readLine();
		
		System.out.print("News author:__");		
		String auth = reader.readLine();
		
		
		System.out.print("News Description:__");
		String desc = reader.readLine();
		
		News c = new News(name, auth, desc);
		news.addElement(c);
		News.serialize();
		
		System.out.println("Success!");			
		newsPage();
	}

	private static void deleteNews() throws IOException {
		System.out.println("Please print the number of News you wanna delete(q to quit)");
		for(int i=0;i<news.size();i++) {
			System.out.println(i+1+". "+news.get(i).getTheme()+" "+news.get(i).getAuthor());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			newsPage();
		}
		news.remove(Integer.parseInt(ans)-1);		
		News.serialize();
		System.out.println("News deleted");
		newsPage();
	}
}
