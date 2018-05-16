package main;

import java.io.Serializable;
import java.util.Vector;

/**
 */
public class Executor extends Employee implements Serializable{

	/**
     */
    private Vector<Order> orders = new Vector<Order>();

    public Executor(String id, String firstname, String lastname, String telNumber, String email) {
		super(id, firstname, lastname, telNumber, email);
		// TODO Auto-generated constructor stub
	}
    
    public void accept(Order ord) {
    }

    
	@Override
	public String toString() {
		return "Executor [orders=" + orders + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
		Executor other = (Executor) obj;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		return true;
	}

	public Vector<Order> getOrders() {
		return orders;
	}

	public void setOrders(Vector<Order> orders) {
		this.orders = orders;
	}

	/**
     * @param ord 
     */
    public void reject(Order ord) {
    }
}

