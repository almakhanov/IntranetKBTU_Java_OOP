package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminDriver implements Serializable{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String admin = "";
	
	public static void adminMode(Admin a) throws IOException {
		System.out.println("Welcome "+a.getFirstname()+ " to Admin mode!");
		admin=a.getUsername();
		addHistory("'"+admin + "'"+" logged in to a system\n");
		
		adminQue();
	}


	private static void adminQue() throws IOException {
		Driver.saveAllData();
		
		System.out.println("Please print the number of action");
		System.out.println();
		System.out.println("1. Add User");
		System.out.println("2. Update User");
		System.out.println("3. Remove User");
		System.out.println("4. List");
		System.out.println("5. Log out");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				addUser();
				break;				
			case '2':
				updateUser();
				break;
			case '3':
				removeUser();
				break;
			case '4':
				userList();
				break;
			case '5':
				Driver.preLogin();
				break;
		}
	}


	private static void userList() throws IOException {
		System.out.println("User LIST:");
		System.out.println("1. Student");
		System.out.println("2. Teacher");
		System.out.println("3. Manager");
		System.out.println("4. Executor");
		System.out.println("5. Admin");
		System.out.println("6. go Back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				for(int i=0;i<Driver.students.size();i++) {
					System.out.println(i+1+". "+Driver.students.get(i).getLastname()+" "+Driver.students.get(i).getFirstname());
				}
				String txt = reader.readLine();
				if(txt.equals("q")) {
					userList();
				}
				break;				
			case '2':
				for(int i=0;i<Driver.teachers.size();i++) {
					System.out.println(i+1+". "+Driver.teachers.get(i).getLastname()+" "+Driver.teachers.get(i).getFirstname());
				}
				String txt1 = reader.readLine();
				if(txt1.equals("q")) {
					userList();
				}
				break;
			case '3':
				for(int i=0;i<Driver.managers.size();i++) {
					System.out.println(i+1+". "+Driver.managers.get(i).getLastname()+" "+Driver.managers.get(i).getFirstname());
				}
				String txt2 = reader.readLine();
				if(txt2.equals("q")) {
					userList();
				}
				break;
			case '4':
				for(int i=0;i<Driver.executors.size();i++) {
					System.out.println(i+1+". "+Driver.executors.get(i).getLastname()+" "+Driver.executors.get(i).getFirstname());
				}
				String txt3 = reader.readLine();
				if(txt3.equals("q")) {
					userList();
				}
				break;
			case '5':
				for(int i=0;i<Driver.admins.size();i++) {
					System.out.println(i+1+". "+Driver.admins.get(i).getLastname()+" "+Driver.admins.get(i).getFirstname());
				}
				String txt4 = reader.readLine();
				if(txt4.equals("q")) {
					userList();
				}
				break;
			case '6':
				adminQue();
				break;
		}
	}


	private static void addUser() throws IOException {
		System.out.println("Please print the number of user type");
		System.out.println();
		System.out.println("1. Student");
		System.out.println("2. Teacher");
		System.out.println("3. Manager");
		System.out.println("4. Executor");
		System.out.println("5. Admin");
		System.out.println("6. go Back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				addStudent();
				break;				
			case '2':
				addTeacher();
				break;
			case '3':
				addManager();
				break;
			case '4':
				addExecutor();
				break;
			case '5':
				addAdmin();
				break;
			case '6':
				adminQue();
				break;
		}
	}

	private static void addAdmin() throws IOException {
		System.out.println("Please fill the Admin fields with spaces as in Example(q to quit)");
		System.out.println("Example(id,name,surname,teNumber,email):\n"
				+ "AD17_0002 firstName lastName 87786340203 qwe@gmail.com");
		String txt = reader.readLine();
		if(txt.equals("q")) {
			addUser();
		}
		Admin a = new Admin(txt.split(" ")[0], txt.split(" ")[1], txt.split(" ")[2], txt.split(" ")[3], txt.split(" ")[4]);
		Driver.admins.addElement(a);
		addHistory("'"+admin + "'"+" added a new Admin " + a.getId()+"\n");
		adminQue();
	}


	private static void addExecutor() throws IOException {
		System.out.println("Please fill the Executor fields with spaces as in Example(q to quit)");
		System.out.println("Example(id,name,surname,teNumber,email):\n"
				+ "EX17_0001 firstName lastName 87786340203 qwe@gmail.com");
		String txt = reader.readLine();
		if(txt.equals("q")) {
			addUser();
		}
		Executor e = new Executor(txt.split(" ")[0], txt.split(" ")[1], txt.split(" ")[2], txt.split(" ")[3], txt.split(" ")[4]);
		Driver.executors.addElement(e);
		addHistory("'"+admin + "'"+" added a new Executor " + e.getId()+"\n");
		adminQue();
	}


	private static void addManager() throws IOException {
		System.out.println("Please fill the Manager fields with spaces as in Example(q to quit)");
		System.out.println("Example(id,name,surname,teNumber,email,position):\n"
				+ "MA17_0001 firstName lastName 87786340203 qwe@gmail.com OR/Depart");
		String txt = reader.readLine();
		if(txt.equals("q")) {
			addUser();
		}
		
		Position pos = null;
		if(txt.split(" ")[5].equals("OR")) {
			pos = Position.OR;
		}else if(txt.split(" ")[5].equals("Depart")) {
			pos = Position.Department;
		}
		Manager m = new Manager(txt.split(" ")[0], txt.split(" ")[1], txt.split(" ")[2], txt.split(" ")[3], txt.split(" ")[4], pos);
		Driver.managers.addElement(m);
		addHistory("'"+admin + "'"+" added a new Manager " + m.getId()+"\n");
		adminQue();
	}


	private static void addTeacher() throws IOException {
		System.out.println("Please fill the Teacher fields with spaces as in Example(q to quit)");
		System.out.println("Example(id,name,surname,teNumber,email,degree):\n"
				+ "TE17_0001 firstName lastName 87786340203 qwe@gmail.com master");
		String txt = reader.readLine();
		if(txt.equals("q")) {
			addUser();
		}
		Teacher t = new Teacher(txt.split(" ")[0], txt.split(" ")[1], txt.split(" ")[2], txt.split(" ")[3], txt.split(" ")[4], txt.split(" ")[5]);
		Driver.teachers.addElement(t);
		addHistory("'"+admin + "'"+" added a new Teacher " + t.getId()+"\n");
		adminQue();
	}


	private static void addStudent() throws IOException {
		System.out.println("Please fill the Student fields with spaces as in Example(q to quit)");
		System.out.println("Example(id,name,surname,teNumber,email,faculty,specialization):\n"
				+ "TE17_0001 firstName lastName 87786340203 qwe@gmail.com FIT IS");
		String txt = reader.readLine();
		if(txt.equals("q")) {
			addUser();
		}
		Student s = new Student(txt.split(" ")[0], txt.split(" ")[1], txt.split(" ")[2], txt.split(" ")[3], txt.split(" ")[4], txt.split(" ")[5],  txt.split(" ")[6]);
		Driver.students.addElement(s);
		addHistory("'"+admin + "'"+" added a new Student " + s.getId()+"\n");
		adminQue();
	}


	private static void updateUser() {
		
	}
	
	private static void removeUser() throws IOException {
		System.out.println("Please print the number of user type");
		System.out.println();
		System.out.println("1. Student");
		System.out.println("2. Teacher");
		System.out.println("3. Manager");
		System.out.println("4. Executor");
		System.out.println("5. Admin");
		System.out.println("6. go Back");
		System.out.print("#__");
		String ans = reader.readLine();
		
		switch(ans.charAt(0)) {
			case '1':
				remStudent();
				break;				
			case '2':
				remTeacher();
				break;
			case '3':
				remManager();
				break;
			case '4':
				remExecutor();
				break;
			case '5':
				remAdmin();
				break;
			case '6':
				adminQue();
				break;
		}
	}
	
	
	private static void remStudent() throws IOException {
		System.out.println("Please print the number of Student you wanna delete(q to quit)");
		for(int i=0;i<Driver.students.size();i++) {
			System.out.println(i+1+". "+Driver.students.get(i).getLastname()+" "+Driver.students.get(i).getFirstname());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			removeUser();
		}
		
		Driver.students.remove(Integer.parseInt(ans)-1);
		
		addHistory("'"+admin + "'"+" deleted a Student " + Driver.students.get(Integer.parseInt(ans)-1)+"\n");

		System.out.println("Student deleted");
		adminQue();
	}


	private static void remTeacher() throws IOException {
		System.out.println("Please print the number of Teacher you wanna delete(q to quit)");
		for(int i=0;i<Driver.teachers.size();i++) {
			System.out.println(i+1+". "+Driver.teachers.get(i).getLastname()+" "+Driver.teachers.get(i).getFirstname());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			removeUser();
		}
		Driver.teachers.remove(Integer.parseInt(ans)-1);
		
		addHistory("'"+admin + "'"+" deleted a Teacher " + Driver.teachers.get(Integer.parseInt(ans)-1)+"\n");
		
		System.out.println("Teacher deleted");
		adminQue();
	}


	private static void remManager() throws IOException {
		System.out.println("Please print the number of Manager you wanna delete(q to quit)");
		for(int i=0;i<Driver.managers.size();i++) {
			System.out.println(i+1+". "+Driver.managers.get(i).getLastname()+" "+Driver.managers.get(i).getFirstname());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			removeUser();
		}
		Driver.managers.remove(Integer.parseInt(ans)-1);
		
		addHistory("'"+admin + "'"+" deleted a Manager " + Driver.managers.get(Integer.parseInt(ans)-1)+"\n");
		
		System.out.println("Manager deleted");
		adminQue();
	}


	private static void remExecutor() throws IOException {
		System.out.println("Please print the number of Executor you wanna delete(q to quit)");
		for(int i=0;i<Driver.executors.size();i++) {
			System.out.println(i+1+". "+Driver.executors.get(i).getLastname()+" "+Driver.executors.get(i).getFirstname());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			removeUser();
		}
		Driver.executors.remove(Integer.parseInt(ans)-1);
		
		addHistory("'"+admin + "'"+" deleted an Executor " + Driver.executors.get(Integer.parseInt(ans)-1)+"\n");
		
		System.out.println("Executor deleted");
		adminQue();
	}


	private static void remAdmin() throws IOException {
		System.out.println("Please print the number of Admin you wanna delete(q to quit)");
		for(int i=0;i<Driver.admins.size();i++) {
			System.out.println(i+1+". "+Driver.admins.get(i).getLastname()+" "+Driver.admins.get(i).getFirstname());
		}
		System.out.print("#__");
		String ans = reader.readLine();
		if(ans.equals("q")) {
			removeUser();
		}
		Driver.admins.remove(Integer.parseInt(ans)-1);
		
		addHistory("'"+admin + "'"+" deleted an Admin " + Driver.admins.get(Integer.parseInt(ans)-1)+"\n");
		
		System.out.println("Admin deleted");
		adminQue();
	}


	private static void addHistory(String h) throws IOException{
		BufferedWriter out = new BufferedWriter(new FileWriter("adminHistory.txt", true));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String history = "";
		
		history=dateFormat.format(date).toString()+" "+ h;
		
		out.write(history);
		
		out.flush();
		out.close();
	}
}
