package com.dmitrenko.algorithms.ahocorasicktrie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class JobEngineParameter {

	private String analyzedText;
	private List<String> searchWords;
}
