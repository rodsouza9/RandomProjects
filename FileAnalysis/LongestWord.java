import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class LongestWord
{
   public static String longestWord(ArrayList<String> words)
   {
      String longest = "";
      for (String word: words)
      {
         if (word.length() > longest.length())
            longest = word;
      }
      return longest;
   }
   public static ArrayList<String> getFileAsArrayList(String inputFileName)
      throws FileNotFoundException 
   {
      ArrayList<String> words = new ArrayList<String>();
      FileReader reader = new FileReader(inputFileName);
      Scanner in = new Scanner(reader);
      while ( in.hasNext() )
      {
         words.add( in.next() );
      }
      return words;
   }
   public static void main(String[] args)
      throws FileNotFoundException 
   {
     //String fileName = "InSearchOfLostTime.txt";
     String fileName = "Hamlet.txt";
     System.out.println("This file is: " + fileName);
     ArrayList<String> words = getFileAsArrayList(fileName);
     System.out.print("The longest word in " + fileName + " is ");
     System.out.println( longestWord(words) );
     ArrayList<String> test = new ArrayList<String>();
     System.out.println(words.size());
     //getFrequencyWords(words);
     //test.add("the"); test.add("the"); test.add("the"); test.add("~~"); test.add("the"); test.add("and"); test.add("and"); test.add("and"); test.add("and");
     //test.add("Rohan"); test.add("Rohan"); test.add("Rohan"); test.add("Rohan"); test.add("Rohan");
     //Collections.sort(test);
     System.out.println(getMostFrequentWords(words));
   }
}
