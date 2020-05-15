package com.dmitrenko.algorithms.ahocorasicktrie.engine.impl;

import com.dmitrenko.algorithms.ahocorasicktrie.dto.JobEngineParameter;
import com.dmitrenko.algorithms.ahocorasicktrie.engine.JobEngine;
import com.dmitrenko.algorithms.ahocorasicktrie.service.ChartersTrie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobEngineImpl implements JobEngine {

	private final ChartersTrie trie;

	@Override
	public List<String> findWords(JobEngineParameter parameter) {
		List<String> searchWords = parameter.getSearchWords();
		String analyzedText = parameter.getAnalyzedText();

		trie.add(searchWords);
		Set<Integer> wordsId = trie.find(analyzedText);

		return wordsId.stream()
			.map(searchWords::get)
			.collect(Collectors.toList());
	}

	@Override
	public String redactor(JobEngineParameter parameter) {
		return null;
	}
}
