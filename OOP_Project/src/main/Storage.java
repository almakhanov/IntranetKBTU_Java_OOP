package main;

import java.io.*;
import java.io.File;
import java.util.Vector;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Storage implements Serializable{
	

	public static void serialize(String user){
		 switch(user) {
		 case "admin":
			 try {					
		         FileOutputStream fileOut = new FileOutputStream("Admins.out");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(Driver.admins);
		         out.flush();
		         out.close();
		         fileOut.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
			 break;
		 case "manager":
			 try {
		         FileOutputStream fileOut = new FileOutputStream("Managers.out");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(Driver.managers);
		         out.flush();
		         out.close();
		         fileOut.close();
		      } catch (IOException i) {
		         //i.printStackTrace();
		      }
			 break;
		 case "executor":
			 try {
		         FileOutputStream fileOut =
		         new FileOutputStream("Executors.out");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(Driver.executors);
		         out.flush();
		         out.close();
		         fileOut.close();
		      } catch (IOException i) {
		         //i.printStackTrace();
		      }
			 break;
		 case "teacher":
			 try {
		         FileOutputStream fileOut =
		         new FileOutputStream("Teachers.out");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(Driver.teachers);
		         out.flush();
		         out.close();
		         fileOut.close();
		      } catch (IOException i) {
//		         i.printStackTrace();
		      }
			 break;
		 case "student":
			 try {
		         FileOutputStream fileOut =
		         new FileOutputStream("Students.out");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(Driver.students);
		         out.flush();
		         out.close();
		         fileOut.close();
		      } catch (IOException i) {
//		         i.printStackTrace();
		      }
			 break;
			 
		 }
	}
	
	@SuppressWarnings("unchecked")
	public static void deserialize(String user){
		switch(user) {
			case "admin":
				try {					
					if((new File("Admins.out").exists())){
						FileInputStream fileIn = new FileInputStream("Admins.out");
				         ObjectInputStream in = new ObjectInputStream(fileIn);
				         Driver.admins = (Vector<Admin>) in.readObject();				         
				         in.close();
				         fileIn.close();
					}
			      } catch (IOException i) {
//			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			         System.out.println("Admin class not found");
			         c.printStackTrace();
			      }
				break;
			case "manager":
				try {
					Vector<Manager> t = new Vector<Manager>();
					if((new File("Managers.out").exists())){
						FileInputStream fileIn = new FileInputStream("Managers.out");
				         ObjectInputStream in = new ObjectInputStream(fileIn);
				         Driver.managers = (Vector<Manager>)in.readObject();
				         in.close();
				         fileIn.close();
					}
			      } catch (IOException i) {
//			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			         System.out.println("Manager class not found");
			         c.printStackTrace();
			      }
				break;
			case "executor":
				try {
					Vector<Executor> t = new Vector<Executor>();
					if((new File("Executors.out").exists())){
						FileInputStream fileIn = new FileInputStream("Executors.out");
				         ObjectInputStream in = new ObjectInputStream(fileIn);
				         Driver.executors = (Vector<Executor>)in.readObject();
				         in.close();
				         fileIn.close();
					}
			      } catch (IOException i) {
//			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			         System.out.println("Executor class not found");
			         c.printStackTrace();
			      }
				break;
			case "teacher":
				try {
					Vector<Teacher> t = new Vector<Teacher>();
					if((new File("Teachers.out").exists())){
						FileInputStream fileIn = new FileInputStream("Teachers.out");
				         ObjectInputStream in = new ObjectInputStream(fileIn);
				         Driver.teachers = (Vector<Teacher>)in.readObject();
				         in.close();
				         fileIn.close();
					}
			      } catch (IOException i) {
//			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			         System.out.println("Teacher class not found");
			         c.printStackTrace();
			      }
				break;
			case "student":
				try {
					Vector<Student> t = new Vector<Student>();
					if((new File("Students.out").exists())){
						FileInputStream fileIn = new FileInputStream("Students.out");
				         ObjectInputStream in = new ObjectInputStream(fileIn);
				         Driver.students = (Vector<Student>)in.readObject();
				         in.close();
				         fileIn.close();
					}
			      } catch (IOException i) {
//			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			         System.out.println("Student class not found");
			         c.printStackTrace();
			      }
				break;
		
		}
	}
}	
