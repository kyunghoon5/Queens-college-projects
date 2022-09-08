

import java.util.TreeMap;

//This class prints the sorted information from the text file.

public class SortedDateMap {
   TreeMap<String, Date212> datemap = new TreeMap<String, Date212>();

   public void add(Date212 date) {

       datemap.put(date.toString(), date);

   }
  
   public String toString() {
       String s = "";
       for (Date212 value : datemap.values()) {
           s = s + value.toString() + "\n";
       }
       return s;
   }

}