package main;

import java.io.Serializable;

/**
 */
public abstract class Employee extends User implements Salariable, Serializable{
    public Employee(String id, String firstname, String lastname, String telNumber,
			String email) {
		super(id, firstname.charAt(0)+"_"+lastname, firstname, lastname, "123", telNumber, email);
		// TODO Auto-generated constructor stub
	}



	/**
     * @param ord 
     * @param exe 
     */
    public void makeOrder(Executor exe, Order ord) {
    }
     
    

	/**
     * @return 
     */
    public int getSalary() {
        return 0;
    }
    
//    public String toString() {
//    	return super.toString();
//    }
    
}

