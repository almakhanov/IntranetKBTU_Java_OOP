package main;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;

/**
 */
public class News implements Serializable{
    /**
     */
    private final Date date = new Date();
    

    private String theme;
    private String author;    
    private String description;

	public News(String theme, String author, String description) {
		super();
		this.theme = theme;
		this.author = author;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
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
		News other = (News) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [date=" + date + ", theme=" + theme + ", author=" + author + ", description=" + description + "]";
	}

	public News(String theme, String author) {
		super();
		this.theme = theme;
		this.author = author;
	}
	
	
	public static void serialize() {
		try {					
	         FileOutputStream fileOut = new FileOutputStream("News.out");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(ManagerDriver.news);
	         out.flush();
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static void deserialize() {
		try {					
			if((new File("News.out").exists())){
				FileInputStream fileIn = new FileInputStream("News.out");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         ManagerDriver.news = (Vector<News>) in.readObject();				         
		         in.close();
		         fileIn.close();
			}
	      } catch (IOException i) {
//	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("News class not found");
	         c.printStackTrace();
	      }
	}
	
	
	public static void serializeForDriver() {
		try {					
	         FileOutputStream fileOut = new FileOutputStream("News.out");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(Driver.news);
	         out.flush();
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static void deserializeForDriver() {
		try {					
			if((new File("News.out").exists())){
				FileInputStream fileIn = new FileInputStream("News.out");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         Driver.news = (Vector<News>) in.readObject();				         
		         in.close();
		         fileIn.close();
			}
	      } catch (IOException i) {
//	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("News class not found");
	         c.printStackTrace();
	      }
	}

}

