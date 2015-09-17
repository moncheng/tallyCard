package tallysystem.models;

import java.util.Date;

public class TallyCard {
	
	private String name;
	private int count;
	private Date dateCreate;
	public TallyCard(String name)
	{
		this.name= name;
		this.count=0;
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
	
}
