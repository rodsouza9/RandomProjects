import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class FileAnalyzer
{
   public static void print (String var)
   {
       System.out.print(var);
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
   
   public static char getFrequentChar (ArrayList<String> words)
   {
       for(int indexA = 0; indexA<words.size(); indexA++)
       {
           for(int indexS = 0; indexS<(words.get(indexA)).length();)
           {
               
           }
       }
       return 'c';
   }
   public static String getMostFrequentWords (ArrayList<String> words)
   {  
      ArrayList<String> twentyTopWords = new ArrayList<String>();
      ArrayList<Integer> frequency = new ArrayList<Integer>();
      frequency.add(0);    
      twentyTopWords.add("This is just for buffer *Ignore* This IS NOT in the text!!!!");
      Collections.sort(words);
      words.add("~~~~~~~~~");
      int minus = -1;
      long startTime = System.nanoTime();
      for (int index = 0; index<words.size(); index++) {
          if (index != words.size()-1  && !words.get(index).equals(words.get(index+1))) {
              twentyTopWords.add(words.get(index));
              frequency.add(index-minus);
              minus = index;
          }
      }
      String rohan= "";
      for (int i=0; i < frequency.size(); i++) {
          rohan = rohan + "\n" + twentyTopWords.get(i) + " : " + frequency.get(i);
      }
      long endTime   = System.nanoTime();
      long totalTime = (endTime - startTime);
      return rohan + "\nIt took: " + totalTime + " in nanosecond to get this ouput this.";
   }
   public static void getFrequencyWords (ArrayList<String> words) {
       HashMap<String, Integer> map = new HashMap<String, Integer>();
       map.put("~~~~~~~~~",0);
       System.out.println(map);
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
