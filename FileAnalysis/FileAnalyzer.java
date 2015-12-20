package com.company;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Main {
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
    //public static int[] getMostFrequentValues

    public static MyHashMap getWordFrequency (ArrayList<String> words){
        MyHashMap map = new MyHashMap();
        words.add("~~~~~~~~~"); //this is a filler to get the last value.
        map.put("",0); //this is just a filler for the second if statement.
        long startTime = System.nanoTime();
        for (int index=0; index<words.size(); index++) { //checks
            String word = words.get(index);
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            }
            else {
                map.put(word,1);
            }
        }
        return map;
    }
    /*public static void printHashMap(ArrayList<String> words) {
        //HashMap<String, Integer> rohan = new HashMap<>(getWordFrequency(words));
        MyHashMap rohan = new MyHashMap();
        System.out.print(rohan.toString());
        Set<Map.Entry<String, Integer>> entries = rohan.entrySet();

    }*/
    //public toString()
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Hamlet.txt";
        System.out.println("This file is: " + fileName);
        ArrayList<String> words = getFileAsArrayList(fileName);
        /*
        ArrayList<String> rohan = new ArrayList<String>();
        rohan.add("arohan"); rohan.add("crohan"); rohan.add("lrohan"); rohan.add("frohan"); rohan.add("arohan");
        rohan.add("lrohan");
        rohan.add("zrohan"); rohan.add("frohan"); rohan.add("rohan"); rohan.add("crohan"); rohan.add("arohan");
        rohan.add("crohan"); rohan.add("arohan"); rohan.add("zrohan"); rohan.add("zrohan"); rohan.add("rohan");
        */
        long startTime = System.nanoTime();
        MyHashMap ghjk = getWordFrequency(words);
        System.out.print(ghjk);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        System.out.println("It took around " + totalTime + "nanoseconds to get the Hash Map of values and to print the hash map.");
        /*HashMap<String, Integer> thing = new HashMap<>();
        thing.put("Rohan",4); thing.put("Rahul",6);
        System.out.println(thing);*/

    }
}
class MyHashMap extends HashMap<String, Integer> {
    @Override
    public String toString() {
        String tobePrinted = "";
        Set<Map.Entry<String, Integer>> entries = this.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            tobePrinted += entry.getKey() + ": " + entry.getValue() + "\n"; //print then out one line by line
            //System.out.print(entry.getKey() + ": " + entry.getValue() + "  ");//print them out really weirdly with multiple per line.
        }
        return tobePrinted;
    }
}
