package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.util.Date;
import java.util.Vector;

/**
 */
public class Mark implements Serializable{
    /**
     */
    private double points=0;
    private Date date = new Date();
    /**
     * @param p 
     * @return 
     */
    public static String generateMark(double p) {
        return null;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		if(this.points + points<100) {
			this.points += points;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(points);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Mark other = (Mark) obj;
		if (Double.doubleToLongBits(points) != Double.doubleToLongBits(other.points))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [points=" + points + "]";
	}

	public Mark(double points) {
		if(this.points + points<100) {
			this.points += points;
		}	
	}
	
	
}

