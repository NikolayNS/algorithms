package com.dmitrenko.algorithms.ahocorasicktrie.engine;

import com.dmitrenko.algorithms.ahocorasicktrie.dto.JobEngineParameter;

import java.util.List;

public interface JobEngine {

	List<String> findWords(JobEngineParameter parameter);

	String redactor(JobEngineParameter parameter);
}
