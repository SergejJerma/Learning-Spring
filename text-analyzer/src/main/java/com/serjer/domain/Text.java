package com.serjer.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Text {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
		
	private String textBody;
	
	@OneToMany(mappedBy = "text", cascade = CascadeType.ALL)
	private Set<LastLetter> lastLetters;

	public Text() {
		super();
	}

	public Text(String textBody) {
		super();
		this.textBody = textBody;
	}

	public Text(String textBody, Set<LastLetter> lastLetters) {
		super();
		this.textBody = textBody;
		this.lastLetters = lastLetters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	public Set<LastLetter> getLastLetters() {
		return lastLetters;
	}

	public void setLastLetters(Set<LastLetter> lastLetters) {
		this.lastLetters = lastLetters;
	}
	
	
}
