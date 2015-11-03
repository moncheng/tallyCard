package tallysystem.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class TallyCard {
	@Id
	private String id;
	private String name;
	private int count;
	private Date dateCreate;
	
	public TallyCard(String name)
	{
		this.name= name;
		this.count=1;
		this.dateCreate=new Date();
	}
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
