package fileReader.src.java;
import java.util.*;

public class basicStatistics {
    ArrayList<String> withStopWords;
    ArrayList<String> withoutStopWords;
    int uniquewords;
    Map<String, Integer> stringCountMap = new HashMap<>();
    ArrayList<String> words = new ArrayList<>();
    ArrayList<Integer> ranking = new ArrayList<>();

    //Constructor for statistics reader

    public basicStatistics(ArrayList<String> withStopWords, ArrayList<String> withoutStopWords) {

        this.withStopWords = withStopWords;
        this.withoutStopWords = withoutStopWords;
        countStringOccurrences(listToArray(withoutStopWords));
        /*for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
    }

    //Print out the basicStatistics of the file

    public void readStatistics() {
        System.out.println("The number of words in the article before removing stopwords is " + withStopWords.size());
        System.out.println("The number of words in the article after removing stopwords is " + withoutStopWords.size());
        uniqueWords(withoutStopWords);
        System.out.println("The number of unique words in the article is " + uniquewords);
        System.out.println("Word Ranking by Frequency:");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": " + ranking.get(i));
        }
    }

    //Count the unique words of file

    public void uniqueWords(ArrayList<String> words){
        Object[] object = words.toArray();
        for (int i = 0; i < object.length; i++) {
            object[i] = object[i].toString().toLowerCase();
        }
        Set result = new HashSet(Arrays.asList(object));
        uniquewords = result.size();
    }

    //Count how many words repeat.
    //Takes in array of words and length of array
    //need to debug countFreq

    //Convert the arrayList to a string array for the frequency counter

    public String[] listToArray(ArrayList<String> words){
        String[] str = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            str[i] = words.get(i);
        }
        return(str);

    }

    //bubble sort the arrays in countFreq



   public void  countStringOccurrences(String[] arr) {
       // HashMap to store the string as key and its occurrence count as value
       //Map<String, Integer> stringCountMap = new HashMap<>();

       // Loop through the array
       for (String str : arr) {
           // If the string is already in the map, increment its count
           if (stringCountMap.containsKey(str)) {
               stringCountMap.put(str, stringCountMap.get(str) + 1);
           } else {
               // Otherwise, add it to the map with an initial count of 1
               stringCountMap.put(str, 1);
           }
       }
       // Store words and counts in respective ArrayLists
       for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
           words.add(entry.getKey());
           ranking.add(entry.getValue());
       }
       for (int i = 0; i < ranking.size() - 1; i++) {
           for (int j = 0; j < ranking.size() - i - 1; j++) {
               if (ranking.get(j) < ranking.get(j + 1)) {
                   // Swap counts
                   int tempCount = ranking.get(j);
                   ranking.set(j, ranking.get(j + 1));
                   ranking.set(j + 1, tempCount);

                   // Swap corresponding words
                   String tempWord = words.get(j);
                   words.set(j, words.get(j + 1));
                   words.set(j + 1, tempWord);
               }
           }
       }
   }
   public void topWords(int x){
        int z=1;
        System.out.println("Top " + x + " words: ");
        for(int i = 0; i < x; i++){
            System.out.println(z + ". " + words.get(i) + " occurs " + ranking.get(i) + " times");
            z++;
        }
   }
   //gives back number of words in each article
    public void richestvocabulary() {
        System.out.println("The number of words in the article is: " + words.size());
    }

}
