package tallysystem.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TallyCard implements Serializable {
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
	private String lastUpdateString;

	public TallyCard(String name) {
		this.name = name;
		this.dateCreate = new Date();
		this.lastUpdate = this.dateCreate;
		this.count = 0;
		this.lastUpdateString = "";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return this.count;
	}

	public void addCount() {
		this.count++;
	}

	public void setCount(int newCount) {
		this.count = newCount;
	}

	public Date getDateCreated() {
		return this.dateCreate;
	}

	public Date getLastUpdated() {
		return this.lastUpdate;
	}

	public void updateLastUpdated() {
		this.lastUpdateString = getSmartUpdateString();
		this.lastUpdate = new Date();
		
	}

	public String getSmartUpdateString() {
		long secsAgo = new Date().getTime() - this.lastUpdate.getTime();
		long sec = 1000;
		long min = 60 * sec;
		long hr = 60 * min;
		long day = 24 * hr;
		long week = 7 * day;
		long month = 34 * week;
		long year = 12 * month;
		long d1;
		long d2;
		String smartString = "";
		// if less than 10 sec, 'just now'
		if (secsAgo <= 10 * sec) {
			smartString = "Just now.";
		} else if (secsAgo > 10 * sec && secsAgo <= 60 * sec) {
			smartString = Long.toString(secsAgo / sec) + " seconds ago.";
		} else if (secsAgo >= 1 * min && secsAgo < 60 * min) {
			smartString = Long.toString(d1 = secsAgo / min) + trimS(d1, " Minute ") + "and "
					+ (d2 = (secsAgo - (d1 * min)) / sec) + trimS(d2, " Second ") + "ago.";
		} else if (secsAgo >= 1 * hr && secsAgo < 23 * hr) {
			smartString = Long.toString(d1 = secsAgo / hr) + trimS(d1, " Hour ") + "and "
					+ (d2 = (secsAgo - (d1 * hr)) / min) + trimS(d2, " Minute ") + "ago.";
		} else if (secsAgo >= 1 * day && secsAgo < 6 * day) {
			smartString = Long.toString(d1 = secsAgo / day) + trimS(d1, " Day ") + "and "
					+ (d2 = (secsAgo - (d1 * day)) / hr) + trimS(d2, " Hour ") + "ago.";
		} else if (secsAgo >= 1 * week && secsAgo < 3 * week) {
			smartString = Long.toString(d1 = secsAgo / week) + trimS(d1, " Week ") + "and "
					+ (d2 = (secsAgo - (d1 * week)) / day) + trimS(d2, " Day ") + "ago.";
		} else if (secsAgo >= 1 * month && secsAgo < 11 * month) {
			smartString = Long.toString(d1 = secsAgo / month) + trimS(d1, " Month ") + "and "
					+ (d2 = (secsAgo - (d1 * month)) / week) + trimS(d2, " Week ") + "ago.";
		} else if (secsAgo >= 1 * year) {
			smartString = Long.toString(d1 = secsAgo / year) + trimS(d1, " Year ") + "and "
					+ (d2 = (secsAgo - (d1 * year)) / month) + trimS(d2, " Month ") + "ago.";
		}
		return smartString;
	}

	public String trimS(long value, String text) {
		if (value > 1) {
			text = text.substring(0, text.length() - 1) + "s ";
		}
		return text;
	}

	public String getLastUpdateString() {
		this.lastUpdateString=getSmartUpdateString();
		return this.lastUpdateString;
	}

	public String toString() {
		String text = "Name: " + this.name + "\nCount: " + this.count + "\nDate Created: " + this.dateCreate;
		return text;
	}

}
