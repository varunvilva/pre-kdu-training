package com.prekdu;

/*
 * Create a basic Java Program that takes two strings as input and produces the following output.
 * Print the length of the first string
 * Print the length of the second string
 * Print if the length matches or not
 * Print if the two strings are the same
 */
import java.util.Scanner;
public class StringComparison {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String s1 = sc.nextLine();
    System.out.print("Enter the second string: ");
    String s2 = sc.nextLine();
    //checking the length of the two strings
    int n1 = s1.length();
    int n2 = s2.length();
    System.out.println("Length of the first string: " + n1);
    System.out.println("Length of the second string: " + n2);
    if(n1 == n2){
      System.out.println("Length of first string and second string matches!");
      if(s1.equals(s2)){
        System.out.println("First and the second string are the same!");
      }else {
        System.out.println("First and the second are not the same.");
      }
    }else{
      System.out.println("Length of first string and second string does not match.");
      System.out.println("First and the second are not the same.");
    }
  }
}

//output:
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ javac com/prekdu/StringComparison.java
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ java com.prekdu.StringComparison
//Enter the first string: varun
//Enter the second string: varun
//Length of the first string: 5
//Length of the second string: 5
//Length of first string and second string matches!
//First and the second string are the same!
//varunvilva@rog-g513:~/Workspace/Kickdrum/pre-kdu-training/java/src/main/java$ java com.prekdu.StringComparison
//Enter the first string: varun
//Enter the second string: notvarun
//Length of the first string: 5
//Length of the second string: 8
//Length of first string and second string does not match.
//First and the second are not the same.

