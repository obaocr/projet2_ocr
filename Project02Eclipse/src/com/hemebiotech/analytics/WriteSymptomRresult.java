package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomRresult implements ISymptomWriter {

	private String filepath;
	private Map<String, Integer> symptomMapp;


	public WriteSymptomRresult(String filepath, Map<String, Integer> resultMap) {
		this.filepath = filepath;
		this.symptomMapp = resultMap;
	}

	@Override
	public void WriteResult() {
		try {
			FileWriter writer = new FileWriter(filepath);
			if (symptomMapp.size() == 0) {
				writer.write("Input file is empty" + "\n");
			} else {
				for (Map.Entry mapentry : symptomMapp.entrySet()) {
					writer.write(mapentry.getKey() + ": " + mapentry.getValue() + "\n");
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}