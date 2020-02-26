package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * class that implements ISymptomWriter Interface the method
 * "WriteSymptomRresult" read the Map of symptoms and occurrence and write the
 * result file
 */
public class WriteSymptomResult implements ISymptomWriter {

	private String filepath;
	private Map<String, Integer> symptomMap;

	public WriteSymptomResult(String filepath, Map<String, Integer> resultMap) {
		this.filepath = filepath;
		this.symptomMap = resultMap;
	}

	@Override
	public void WriteResult() {
		try (FileWriter writer = new FileWriter(filepath)) {
			if (symptomMap.size() == 0) {
				writer.write("Input file is empty" + "\n");
			} else {

				for (Map.Entry mapentry : symptomMap.entrySet()) {
					writer.write(mapentry.getKey() + ": " + mapentry.getValue() + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}