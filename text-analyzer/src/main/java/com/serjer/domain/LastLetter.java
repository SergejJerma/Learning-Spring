package com.serjer.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class LastLetter {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
		
	private String lastLetter;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "text_id")
	private Text text;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "words", joinColumns = @JoinColumn(name = "last_letter_id"))
	private List<String> words;

	public LastLetter() {
		super();
	}

	public LastLetter(String lastLetter, Text text, List<String> words) {
		super();
		this.lastLetter = lastLetter;
		this.text = text;
		this.words = words;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastLetter() {
		return lastLetter;
	}

	public void setLastLetter(String lastLetter) {
		this.lastLetter = lastLetter;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
	
	
	
}
