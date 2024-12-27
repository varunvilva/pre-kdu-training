package com.prekdu;

/*
 * Create a basic Java Program that reads a CSV file and prints the top 3 repeated words in the file.
 * The CSV file is in the reosurces folder and the file name is input.csv.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class CSVWordFrequency {
  public static void main(String[] args) {
    String filePath = "../resources/input.csv"; // Path to the CSV file
    HashMap<String, Integer> wordFrequency = new HashMap<>();
    // Read the CSV file and calculate word frequencies
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] words = line.split("[,\\s]+"); // Split by commas and whitespace
        for (String word : words) {
          word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Normalize word
          if (!word.isEmpty()) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
          }
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
      return;
    }

    // Find the top 3 repeated words using a priority queue
    PriorityQueue<Map.Entry<String, Integer>> topWords = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
    );

    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
      topWords.offer(entry);
      if (topWords.size() > 3) {
        topWords.poll(); // Remove the least frequent word if size exceeds 3
      }
    }

    // Print the top 3 repeated words
    System.out.println("Top 3 repeated words:");
    while (!topWords.isEmpty()) {
      Map.Entry<String, Integer> entry = topWords.poll();
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}

//output:
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ javac com/prekdu/CSVWordFrequency.java
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ java com.prekdu.CSVWordFrequency
//Top 3 repeated words:
//world: 6
//kickdrum: 6
//hello: 6

