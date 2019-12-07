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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Text other = (Text) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



		
}
