package main;

import java.io.*;
import java.util.Vector;

public class Driver implements Serializable{
	static Vector<Admin> admins = new Vector<Admin>();
	static Vector<Manager> managers = new Vector<Manager>();
	static Vector<Executor> executors = new Vector<Executor>();
	static Vector<Teacher> teachers = new Vector<Teacher>();
	static Vector<Student> students = new Vector<Student>();
	static Vector<News> news = new Vector<News>();
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void start() throws IOException {	
		getAllData();//get all data while user is going to mail		
		System.out.println("Welcome to Intranet of Jigies");
		System.out.println("Current NEWS!!!");
		for(int i=0;i<news.size();i++) {
			System.out.println(i+1+". Theme: "+news.get(i).getTheme()+"; Author: "+news.get(i).getAuthor());
			System.out.println("Description: "+news.get(i).getDescription());
		}
		
		System.out.println();
		System.out.println("Please write your login and password to enter the Intranet");
		
		
		
		preLogin();
		
	}
	
	public static void preLogin() throws IOException {
		System.out.print("L0gin:__");
		String login = reader.readLine();
		System.out.print("Pa$$w0rd:__");
		String pass = reader.readLine();
		
		login(login, pass);
	}

	public static void getAllData() {
		Storage.deserialize("admin");
		Storage.deserialize("manager");
		Storage.deserialize("executor");
		Storage.deserialize("teacher");
		Storage.deserialize("student");
		Course.deserialize();
		News.deserializeForDriver();
		News.deserialize();
		
//		System.out.println(admins);
//		System.out.println("------------");
//		System.out.println(managers);
//		System.out.println("------------");
//		System.out.println(executors);
//		System.out.println("------------");
//		System.out.println(teachers);
//		System.out.println("------------");
//		System.out.println(students);
	}
	
	public static void saveAllData() {
		Storage.serialize("admin");
		Storage.serialize("manager");
		Storage.serialize("executor");
		Storage.serialize("teacher");
		Storage.serialize("student");
		
	}

	private static void login(String login, String pass) throws IOException {
//		Admin a = new Admin("AD17_0001", "first", "admin", "87786340203", "admin@gmail.com");
//		admins.addElement(a);
//		Storage.serialize("admin");
		
		for(int i=0; i<admins.size();i++) {
			if(admins.get(i).getUsername().equals(login) && admins.get(i).getPassword().equals(pass.hashCode()+"")) {
				AdminDriver.adminMode(admins.get(i));
				return;
			}
		}
		for(int i=0; i<managers.size();i++) {
			if(managers.get(i).getUsername().equals(login) && managers.get(i).getPassword().equals(pass.hashCode()+"")) {
				ManagerDriver.managerMode(managers.get(i));
				return;
			}
		}
		for(int i=0; i<executors.size();i++) {
			if(executors.get(i).getUsername().equals(login) && executors.get(i).getPassword().equals(pass.hashCode()+"")) {
				return;
			}
		}
		for(int i=0; i<teachers.size();i++) {
			if(teachers.get(i).getUsername().equals(login) && teachers.get(i).getPassword().equals(pass.hashCode()+"")) {
				TeacherDriver.teacherMode(teachers.get(i));
				return;
			}
		}
		for(int i=0; i<students.size();i++) {
			if(students.get(i).getUsername().equals(login) && students.get(i).getPassword().equals(pass.hashCode()+"")) {
				//System.out.println(students.get(i));
				StudentDriver.studentMode(students.get(i));
				return;
			}
		}
		System.out.println("Incorrect username or password, please try again!");
		preLogin();	
		
	}
}
