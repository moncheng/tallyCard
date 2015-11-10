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
	private Date lastUpdate;
	
	public TallyCard(String name)
	{
		this.name=name;
		this.dateCreate=new Date();
		this.lastUpdate=this.dateCreate;
		this.count=0;
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
	public Date getLastUpdated()
	{
		return this.lastUpdate;
	}

	public void updateLastUpdated()
	{
		this.lastUpdate=new Date();
	}


	public String toString()
	{
		String text="Name: "+this.name+"\nCount: "+this.count+"\nDate Created: "+this.dateCreate;
		return text;
	}
	
}
