package com.serjer.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serjer.domain.LastLetter;
import com.serjer.domain.Text;
import com.serjer.repo.LastLetterRepo;
import com.serjer.repo.TextRepo;


@Service
public class TextService {
	
	@Autowired
	private LastLetterRepo lastLetterRepo;
	
	@Autowired
	private TextRepo textRepo;
	
	
	public boolean isStringOnlyAlphabet(String word) {
		return ((word != null) && (!word.equals("")) && (word.matches("^[a-zA-Z]*$")));
	}

	public void countWordsByLastLetter(String inputText) {
		Text text = new Text(inputText);
		textRepo.save(text);
		
		Map<String, List<String>> wordsByLastLetter = new HashMap<String, List<String>>();

		wordsByLastLetter = Arrays.stream(inputText.replaceAll("^ +| +$|( )+", "$1").split(" "))
				.filter(s -> isStringOnlyAlphabet(s))
				.collect(Collectors.groupingBy(s -> String.valueOf(s.toLowerCase().charAt(s.length() - 1))));

		wordsByLastLetter.entrySet().forEach(entry -> {
			LastLetter letter = new LastLetter(entry.getKey(), text, entry.getValue());
			lastLetterRepo.save(letter);
		});
	}
}
