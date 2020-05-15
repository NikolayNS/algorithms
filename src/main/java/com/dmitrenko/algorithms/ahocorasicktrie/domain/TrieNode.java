package com.dmitrenko.algorithms.ahocorasicktrie.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class TrieNode {

	private char parentChar;
	private TrieNode parentNode;

	private TrieNode suffixLink;
	private Integer terminating;

	private final Map<Character, TrieNode> childes = new HashMap<>();
	private final Map<Character, TrieNode> suffixJump = new HashMap<>();

	private TrieNode() {
	}

	public char getParentChar() {
		return parentChar;
	}

	public TrieNode getParentNode() {
		return parentNode;
	}

	public void setSuffixLink(TrieNode suffixLink) {
		this.suffixLink = suffixLink;
	}

	public Optional<TrieNode> getSuffixLink() {
		return Optional.ofNullable(suffixLink);
	}

	public void setTerminating(Integer terminating) {
		this.terminating = terminating;
	}

	public Optional<Integer> getTerminating() {
		return Optional.ofNullable(terminating);
	}

	public void addChildren(char value, TrieNode node) {
		childes.put(value, node);
	}

	public TrieNode getChildren(char value) {
		return childes.get(value);
	}

	public void addSuffixJump(char value, TrieNode node) {
		suffixJump.put(value, node);
	}

	public TrieNode getSuffixJump(char value) {
		return suffixJump.get(value);
	}

	public static Builder builder(char parent) {
		return new TrieNode().new Builder(parent);
	}

	public class Builder {
		private Builder(char parent) {
			TrieNode.this.parentChar = parent;
		}

		public Builder parentNode(TrieNode parentNode) {
			TrieNode.this.parentNode = parentNode;
			return this;
		}

		public TrieNode build() {
			return TrieNode.this;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TrieNode node = (TrieNode) o;
		return parentChar == node.parentChar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parentChar);
	}
}
