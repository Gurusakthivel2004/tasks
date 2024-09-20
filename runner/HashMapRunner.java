package runner;

import tasks.HashMapTask;
import exception.CustomException;

import java.util.Map;
import java.util.Scanner;

public class HashMapRunner {
  
	HashMapTask hmtask = new HashMapTask();
	boolean flag = true;
  
	public static void main(String[] args) {
    
		HashMapRunner hmRunner = new HashMapRunner();
	    try(Scanner reader = new Scanner(System.in)){
	      try {
	    	  hmRunner.run(hmRunner, reader);
	      } catch(CustomException exception) {
	        exception.printStackTrace();
	      } 
	    }
    
	}
  
  public void run(HashMapRunner hmRunner, Scanner reader) throws CustomException {
    while(hmRunner.flag) { 
      System.out.println("Enter the question number: ");
      int questionNo = reader.nextInt();
      reader.nextLine();
      switch(questionNo) {

        case 1:
        	handleCreate(reader);
			break;
			
        case 2:
        	handleGetStrings(reader);
        	break;
        	
        case 3:
        	handleGetInteger(reader);
        	break;
        	
        case 4:
        	handleGetBoth(reader);
        	break;
        
        case 5:
        	handleGetCustom(reader);
        	break;
        	
        case 6:
        	handleNullValue();
        	break;
        	
        case 7:
        	handleNullKey();
        	break;
        	
        case 8:
        	handleContainsKey();
        	break;
        	
        case -1:
        	hmRunner.flag = false;
        	return;
      }
    }
  }
  
  public void handleContainsKey() throws CustomException {
	  Map<String, String> map = hmtask.getHashMap();
	  hmtask.add(map, "leo", "goat");
	  System.out.println("Does map contains the key leo ? " + hmtask.containsKey(map, "leo"));
  }
  
  public Map<String, String> handleNullKey() throws CustomException {
	  Map<String, String> map = hmtask.getHashMap();
	  hmtask.add(map, null, "zoho");
	  printMap(map);
	  return map;
  }
  
  public Map<String, String> handleNullValue() throws CustomException {
	  Map<String, String> map = hmtask.getHashMap();
	  hmtask.add(map, "zoho", null);
	  printMap(map);
	  return map;
  }
  
  public Map<String, HashMapTask> handleGetCustom(Scanner reader) throws CustomException {
	  System.out.print("Enter number of key of strings to be added : ");
	  Map<String, HashMapTask> map = hmtask.getHashMap();
	  int numberOfPairs = reader.nextInt();
	  reader.nextLine();
	  while(numberOfPairs --> 0) {
		  System.out.print("Enter the key (String) : ");
		  String key = reader.next();
		  hmtask.add(map, key, hmtask);
	  }
	  printMap(map);
	  return map;
  }
  
  public Map<String, Integer> handleGetBoth(Scanner reader) throws CustomException {
	  System.out.print("Enter number of pairs of strings and integer to be added : ");
	  Map<String, Integer> map = hmtask.getHashMap();
	  int numberOfPairs = reader.nextInt();
	  reader.nextLine();
	  while(numberOfPairs --> 0) {
		  System.out.print("Enter the key (String) : ");
		  String key = reader.next();
		  System.out.print("Enter the value (Integer) : ");
		  int value = reader.nextInt();
		  hmtask.add(map, key, value);
	  }
	  printMap(map);
	  return map;
  }
  
  public Map<String, String> handleGetStrings(Scanner reader) throws CustomException {
	  System.out.print("Enter number of pairs of strings to be added : ");
	  Map<String, String> map = hmtask.getHashMap();
	  int numberOfPairs = reader.nextInt();
	  reader.nextLine();
	  while(numberOfPairs --> 0) {
		  System.out.print("Enter the key : ");
		  String key = reader.next();
		  System.out.print("Enter the value : ");
		  String value = reader.next();
		  hmtask.add(map, key, value);
	  }
	  printMap(map);
	  return map;
  }
  
  public Map<Integer, Integer> handleGetInteger(Scanner reader) throws CustomException {
	  System.out.print("Enter number of pairs of integers to be added : ");
	  Map<Integer, Integer> map = hmtask.getHashMap();
	  int numberOfPairs = reader.nextInt();
	  reader.nextLine();
	  while(numberOfPairs --> 0) {
		  System.out.print("Enter the key : ");
		  int key = reader.nextInt();
		  System.out.print("Enter the value : ");
		  int value = reader.nextInt();
		  hmtask.add(map, key, value);
	  }
	  printMap(map);
	  return map;
  }
  
  public void handleCreate(Scanner reader) throws CustomException {
	  Map<Integer, Integer> map = hmtask.getHashMap();
	  printMap(map);
  }
  
  public <K, V> void printMap(Map<K, V> map) throws CustomException {
	  for(K key : map.keySet()) {
		  System.out.println("key : "+ key + " value : " + hmtask.get(map, key));  
	  }
	  System.out.println("The length is " + hmtask.getMapLength(map));
  }
  
}
  
