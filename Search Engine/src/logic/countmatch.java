package logic;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class countmatch {
	
	public void countsearch(String cname) throws IOException{
		HashMap<String,Integer> hashMap= new HashMap<String,Integer>();
		int counter = 0;
		ArrayList<String> arrayList = new ArrayList<String>();
		File folder = new File("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\");
		File[] listOfFiles = folder.listFiles();
		
		 for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  arrayList.add("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\"+listOfFiles[i].getName());
		       // System.out.println( listOfFiles[i].getName());
		      } 
		      }
		 for(int i=0;i<arrayList.size();i++){
			 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
			 String text = doc1.text();
			 String[] matchingword=text.split(" ");
			 Arrays.sort(matchingword);
			 for(int j=0;j<matchingword.length;j++){
				 if(matchingword[j].equals(cname)){
					 counter++;
				 }
			 }
			 //System.out.println(listOfFiles[i].getName()+"file contain**********"+counter+"**********words");
			 hashMap.put(listOfFiles[i].getName(),counter);
			 
			 matchingword=null;
			 counter=0;
		 }

		 /*System.out.println("size"+hashMap.size());
		 System.out.println("Before Sorting:");
         Set set = hashMap.entrySet();
         Iterator iterator = set.iterator();
         while(iterator.hasNext()) {
               Map.Entry me = (Map.Entry)iterator.next();
               System.out.print(me.getKey() + ": ");
               System.out.println(me.getValue());
         }*/
         
		 System.out.println("Searched results:");
         Map<Integer, String> map = sortByValues(hashMap); 
         Set set2 = map.entrySet();
         Iterator iterator2 = set2.iterator();
         while(iterator2.hasNext()) {
              Map.Entry me2 = (Map.Entry)iterator2.next();
              if(!me2.getValue().equals(0)){
            	  System.out.print(me2.getKey() + ": ");
            	  System.out.println(me2.getValue()+"  times occured");
            
              }
         }
	}
	public void puralsearch(String cname) throws IOException{
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		
		int counter =0;
		ArrayList<String> arrayList = new ArrayList<String>();
		File folder = new File("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\");
		File[] listOfFiles = folder.listFiles();
		
		 for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  arrayList.add("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\"+listOfFiles[i].getName());
		       // System.out.println( listOfFiles[i].getName());
		      } 
		      }
		 for(int i=0;i<arrayList.size();i++){
			 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
			 String text = doc1.text();
			 String pattern=cname+"(ing|ed|er|s)";
			 Pattern r = Pattern.compile(pattern);

		      // Now create matcher object.
		      Matcher m = r.matcher(text);
		      //System.out.println("***********************");
		      while (m.find( )) {
		    	  counter++;
		    	  System.out.println(m.group());
		      }
		      System.out.println("====================================================================");
			     
		      System.out.println(listOfFiles[i].getName()+":-"+counter+"---words");
		      hmap.put(listOfFiles[i].getName(),counter);
		      
		      System.out.println("====================================================================");
		      counter=0;
		      
			/* String[] matchingword=text.split(" ");*/
			 /*for(int j=0;j<matchingword.length;j++){
				 if(matchingword[j].equals(cname)){
					 counter++;
				 }
			 }*/
			 /*System.out.println(listOfFiles[i].getName()+"file contain**********"+counter+"**********words");
			 matchingword=null;*/
		 }
		 System.out.println("Before Sorting:");
         Set set = hmap.entrySet();
         Iterator iterator = set.iterator();
         while(iterator.hasNext()) {
               Map.Entry me = (Map.Entry)iterator.next();
               System.out.print(me.getKey() + ": ");
               System.out.println(me.getValue());
         }
         
         Map<Integer, String> map = sortByValues(hmap); 
         System.out.println("After Sorting:------------------------------------------------------------------------");
         Set set2 = map.entrySet();
         Iterator iterator2 = set2.iterator();
         while(iterator2.hasNext()) {
              Map.Entry me2 = (Map.Entry)iterator2.next();
              System.out.print(me2.getKey() + ": ");
              System.out.println(me2.getValue());
         }
         
         
         
         
	}
	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });
	       
	       Collections.reverse(list);
	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       System.out.println();
	       return sortedHashMap;	}
	/*public void editdistance(String name) throws IOException {
		int counter = 0;
		ArrayList<String> arrayList = new ArrayList<String>();
		File folder = new File("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\");
		File[] listOfFiles = folder.listFiles();
		
		 for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  arrayList.add("C:\\Users\\ankit\\Ankit\\computing\\src\\textfile\\"+listOfFiles[i].getName());
		       // System.out.println( listOfFiles[i].getName());
		      } 
		      }
		 for(int i=0;i<arrayList.size();i++){
			 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
			 String text = doc1.text();
			 String[] matchingword=text.split(" ");
			 
		 }
		
	}*/
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
	}

}
