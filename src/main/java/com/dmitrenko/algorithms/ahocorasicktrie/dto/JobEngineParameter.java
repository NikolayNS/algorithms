package com.dmitrenko.algorithms.ahocorasicktrie.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class JobEngineParameter {

	private String analyzedText;
	private List<String> searchWords;
}
