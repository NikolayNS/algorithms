package com.dmitrenko.algorithms.ahocorasicktrie.utils;

public interface SymbolService {
	static boolean check(char symbol) {
		return symbol == ' '
			|| symbol == ','
			|| symbol == '.'
			|| symbol == '_'
			|| symbol == ':'
			|| symbol == ';'
			|| symbol == '\''
			|| symbol == '\"'
			|| symbol == '('
			|| symbol == ')'
			|| symbol == '['
			|| symbol == ']'
			|| symbol == '{'
			|| symbol == '}'
			|| symbol == '/'
			|| symbol == '\\'
			|| symbol == '?'
			|| symbol == '!'
			|| symbol == '^'
			|| symbol == '$'
			|| symbol == '#'
			|| symbol == '*'
			|| symbol == '+'
			|| symbol == '-'
			|| symbol == '~'
			|| symbol == '<'
			|| symbol == '='
			|| symbol == '>';
	}
}
