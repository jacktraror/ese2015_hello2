package org.sample.controller.pojos;

import java.sql.Timestamp;

public class TeamSignupForm {
	private Long id;
    private String teamName;
    private Timestamp date;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
    
    
}
