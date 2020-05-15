package com.dmitrenko.algorithms.ahocorasicktrie.service;

import java.util.List;
import java.util.Set;

public interface ChartersTrie {

	void add(List<String> words);

	Set<Integer> find(String text);
}
