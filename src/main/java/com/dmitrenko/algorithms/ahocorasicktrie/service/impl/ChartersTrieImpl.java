package com.dmitrenko.algorithms.ahocorasicktrie.service.impl;

import com.dmitrenko.algorithms.ahocorasicktrie.domain.TrieNode;
import com.dmitrenko.algorithms.ahocorasicktrie.exception.DataFlowException;
import com.dmitrenko.algorithms.ahocorasicktrie.service.ChartersTrie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import static com.dmitrenko.algorithms.ahocorasicktrie.utils.SymbolService.check;

@Component
@Scope("prototype")
public class ChartersTrieImpl implements ChartersTrie {

	private TrieNode root;

	private void init() {
		root = TrieNode.builder('$').build();
		TrieNode space = TrieNode.builder('~').parentNode(root).build();
		root.addChildren(' ', space);
	}

	@Override
	public void add(List<String> words) {
		if (root == null) init();

		AtomicInteger num = new AtomicInteger(0);
		words.forEach(word -> {
			TrieNode node = addChars(word);
			node.setTerminating(num.getAndIncrement());
		});
	}

	private TrieNode addChars(String word) {
		char space = ' ';
		TrieNode current = root.getChildren(space);
		for (char c : word.toUpperCase().toCharArray()) {
			if (check(c)) c = space;
			if (current.getChildren(c) == null) {
				TrieNode child = TrieNode.builder(c).parentNode(current).build();
				current.addChildren(c, child);
			}
			current = current.getChildren(c);
		}
		return current;
	}

	@Override
	public Set<Integer> find(String text) {
		if (root == null) throw new DataFlowException("No data in Trie");

		Set<Integer> result = new TreeSet<>();
		char space = ' ';
		TrieNode current = root.getChildren(space);
		char[] textChars = text.toUpperCase().toCharArray();
		for (int i = 0; i < textChars.length; i++) {
			char c = textChars[i];
			if (check(c)) c = space;
			if (current.getChildren(c) != null) {
				if (current.getChildren(space) != null && current.getTerminating().isPresent()) result.add(current.getTerminating().get());
				current = current.getChildren(c);
				if (i == textChars.length - 1 && current.getTerminating().isPresent()) result.add(current.getTerminating().get());
			} else {
				if (check(c) && current.getTerminating().isPresent()) result.add(current.getTerminating().get());
				current = followTheLink(current, c);
			}
		}
		return result;
	}

	private TrieNode followTheLink(TrieNode node, Character c) {
		if (node.getSuffixJump(c) == null) {
			if (node.getChildren(c) != null) {
				node.addSuffixJump(c, node.getChildren(c));
			} else if (node == root) {
				node.addSuffixJump(c, root);
			} else {
				node.addSuffixJump(c, followTheLink(buildSuffixLink(node), c));
			}
		}
		return node.getSuffixJump(c);
	}

	private TrieNode buildSuffixLink(TrieNode node) {
		if (node.getSuffixLink().isEmpty()) {
			node.setSuffixLink(
				!node.equals(root) && !node.getParentNode().equals(root) ?
					followTheLink(buildSuffixLink(node.getParentNode()), node.getParentChar())
					: root
			);
		}
		return node.getSuffixLink().get();
	}
}
