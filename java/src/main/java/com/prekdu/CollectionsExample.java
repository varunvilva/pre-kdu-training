package com.prekdu;

/*
 * Create a basic Java Program that takes 10 strings as input and adds them to an ArrayList and
 * HashSet. Also, create a HashMap by populating the words as key and frequency as the value in the
 * map. Iterate the list, set and map and print the content of the collection.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public final class CollectionsExample {

  public static int numInputs = 10;

  public static void main(String[] args) {
    //asking 10 strings input and adding them to ArrayList and a HashSet
    ArrayList<String> arr = new ArrayList<>();
    HashSet<String>set = new HashSet<>();
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < numInputs; i++){
      String input = sc.nextLine();
      arr.add(input);
      set.add(input);
    }

    //creating a frequency hashmap
    HashMap<String, Integer> map = new HashMap<>();
    for(String s: arr){
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    //list
    System.out.print("ArrayList: ");
    for(String s: arr){
      System.out.print(s+" ");
    }
    System.out.println();
    //set
    System.out.print("HashSet: ");
    for(String s: set){
      System.out.print(s+" ");
    }
    System.out.println();
    //map
    System.out.print("HashMap: ");
    for(Map.Entry<String, Integer> entry: map.entrySet()){
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
    System.out.println();
  }
}

// output:
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ javac com/prekdu/CollectionsExample.java
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ java com.prekdu.CollectionsExample
//        varun
//sanidhya
//        samanway
//tanish
//        takshal
//rushabh
//        varun
//aishik
//        sanidhya
//varun
//ArrayList: varun sanidhya samanway tanish takshal rushabh varun aishik sanidhya varun
//HashSet: tanish sanidhya varun takshal aishik samanway rushabh
//HashMap: tanish : 1
//sanidhya : 2
//varun : 3
//takshal : 1
//aishik : 1
//samanway : 1
//rushabh : 1

