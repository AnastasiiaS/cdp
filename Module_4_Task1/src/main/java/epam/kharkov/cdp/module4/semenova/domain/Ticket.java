package epam.kharkov.cdp.module4.semenova.domain;

import java.util.Date;

public class Ticket {
	
	private String id;
	private  String title; //Name of the film
	private Date date;    // Date when this film is demonstrated
	private TicketCategory category; //Ticket category enum - STANDARD, PREMIUM, BAR
	private Integer place; // Place number
	private TicketStatus status;
	
	public Ticket() {
		super();
		 this.status = TicketStatus.AVAILABLE;
		 this.id = String.valueOf(System.currentTimeMillis());
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TicketCategory getCategory() {
		return category;
	}

	public void setCategory(TicketCategory category) {
		this.category = category;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	

	
	
	
}
