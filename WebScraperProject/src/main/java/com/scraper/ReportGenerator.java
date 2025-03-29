package com.scraper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

	public static void generateReport(List<Map<String, String>> articles, List<String> translatedTitles, Map<String, Integer> wordFrequency) {
	    try (FileWriter writer = new FileWriter("Report.txt")) {
	        writer.write("Article Report\n\n");

	        for (int i = 0; i < articles.size(); i++) {
	            Map<String, String> article = articles.get(i);  // <-- Ensure this is used
	            writer.write("Title: " + article.get("title") + "\n");
	            writer.write("Translated Title: " + (i < translatedTitles.size() ? translatedTitles.get(i) : "N/A") + "\n");
	            writer.write("Content: " + article.get("content") + "\n\n");
	        }

	        writer.write("Most Repeated Words:\n");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	        }

	        System.out.println("✅ Report successfully generated!");
	    } catch (IOException e) {
	        System.out.println("❌ Error writing report: " + e.getMessage());
	    }
	}

}

