package main;
import java.lang.*;
import java.io.*;

/**
 */
public class Admin extends Employee implements Serializable{
    /**
     */

    public Admin(String id, String firstname, String lastname, String telNumber,
			String email) {
		super(id, firstname, lastname, telNumber, email);
	}    

}

