package com.dmitrenko.algorithms.ahocorasicktrie.service.impl;

import com.dmitrenko.algorithms.ahocorasicktrie.dto.JobEngineParameter;
import com.dmitrenko.algorithms.ahocorasicktrie.service.ChartersTrie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChartersTrieImplTest {

	private final String WORD_1 = "algorithm";
	private final String WORD_2 = "Aho";
	private final String WORD_3 = "Corasick";
	private final String WORD_4 = "Bertrand";
	private final String WORD_5 = "computer science";
	private final String WORD_6 = "finite-state";
	private final String WORD_7 = "Knuth";
	private final String WORD_8 = "Morris";
	private final String WORD_9 = "Pratt";
	private final String WORD_10 = "million";
	private final String TEXT_PATH = "/test/achocorasicktrie/Aho_Corasick_Text_1.txt";

	private String text;
	private List<String> words = new ArrayList<>();

	@InjectMocks
	private ChartersTrieImpl trie;

	@BeforeEach
	public void init() {
		words.add(WORD_1);
		words.add(WORD_2);
		words.add(WORD_3);
		words.add(WORD_4);
		words.add(WORD_5);
		words.add(WORD_6);
		words.add(WORD_7);
		words.add(WORD_8);
		words.add(WORD_9);
		words.add(WORD_10);

		StringBuilder builder = new StringBuilder();
		try (Scanner scanner = new Scanner(this.getClass().getResourceAsStream(TEXT_PATH))) {
			while (scanner.hasNext()) {
				builder.append(scanner.nextLine());
			}
		}
		text = builder.toString();
	}

	@Test
	public void testFind() {
		trie.add(words);
		Set<Integer> wordsId = trie.find(text);
		List<String> finding = wordsId.stream()
			.map(words::get)
			.collect(Collectors.toList());

		assertEquals(finding.get(0), WORD_1);
		assertEquals(finding.get(1), WORD_2);
		assertEquals(finding.get(2), WORD_3);
		assertEquals(finding.get(3), WORD_4);
		assertEquals(finding.get(4), WORD_5);
		assertEquals(finding.get(5), WORD_6);

	}
}