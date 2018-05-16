package main;

import java.io.Serializable;

public class Manager extends Employee implements Serializable{

private Position position;

public Manager(String id, String firstname, String lastname, String telNumber, String email, Position pos) {
	super(id, firstname, lastname, telNumber, email);
	this.position=pos;
}


public boolean postNews(News n) {
    return false;
}

public boolean deleteNews(News n) {
    return false;
}

public boolean editNews(News n) {
    return false;
}

public boolean assignCourse(Course course) {
    return false;
}

public boolean approveRegistration(Course c, Student s) {
    return false;
}

public boolean createReport(User u) {
    return false;
}
public Position getPosition() {
	return position;
}
public void setPosition(Position position) {
	this.position = position;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((position == null) ? 0 : position.hashCode());
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
	Manager other = (Manager) obj;
	if (position == null) {
		if (other.position != null)
			return false;
	} else if (!position.equals(other.position))
		return false;
	return true;
}
@Override
public String toString() {
	return "Manager [position=" + position + super.toString() +"]";
}

}

