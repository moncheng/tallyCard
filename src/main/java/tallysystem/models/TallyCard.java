package tallysystem.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TallyCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3605640855256691387L;
	@Id
	private String id;
	private String name;
	private int count;
	private Date dateCreate;
	

	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCount()
	{
		return this.count;
	}
	public void addCount()
	{
		this.count++;
	}
	public void setCount(int newCount)
	{
		this.count = newCount;
	}
	public Date getDateCreated()
	{
		return this.dateCreate;
	}
	public String toString()
	{
		String text="Name: "+this.name+"\nCount: "+this.count+"\nDate Created: "+this.dateCreate;
		return text;
	}
	
}
