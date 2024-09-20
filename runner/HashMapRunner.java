package runner;

import tasks.HashMapTask;
import exception.CustomException;

import java.util.Iterator;
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
        	handleContainsKey(reader);
        	break;
        	
        case 9:
        	handleContainsValue(reader);
        	break;
        	
        case 10:
        	handleReplaceValues(reader);
        	break;
        	
        case 11:
        	handleExistingKey(reader);
        	break;
        	
        case 12:
        	handleNonExistingKey(reader);
        	break;
        	
        case 13:
        	handleDefaultValue(reader);
        	break;
        	
        case 14:
        	handleRemoveKey(reader);
        	break;
        	
        case 15:
        	handleRemoveKeyValue(reader);
        	break;
        
        case 16:
        	handleReplaceValue(reader);
        	break;
        	
        case 17:
        	handleReplaceValueIfMatches(reader);
        	break;
        	
        case 18:
        	handleTransfer(reader);
        	break;
        	
        case 19:
        	handleIterator(reader);
        	break;
        	
        case 20:
        	handleClear(reader);
        	break;
        		
        case -1:
        	hmRunner.flag = false;
        	return;
      }
    }
  }
  
  public void handleClear(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  hmtask.clear(map);
	  printMap(map);
  }
  
  public void handleTransfer(Scanner reader) throws CustomException {
	  Map<String, String> firstMap = handleGetStrings(reader);
	  Map<String, String> secondMap = handleGetStrings(reader);
	  hmtask.putAll(firstMap, secondMap);
	  printMap(firstMap);
	  printMap(secondMap);
  }
  
  public void handleReplaceValueIfMatches(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter the key : ");
	  String key = reader.next();
	  System.out.println("Enter the old value for that key : ");
	  String oldValue = reader.next();
	  System.out.println("Enter the new value that you want to replace : ");
	  String newValue = reader.next();
	  hmtask.replace(map, key, oldValue, newValue);
	  printMap(map);
  }
  
  public void handleReplaceValue(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter the key : ");
	  String key = reader.next();
	  System.out.println("Enter the new value that you want to replace : ");
	  String newValue = reader.next();
	  hmtask.replace(map, key, newValue);
	  printMap(map);
  }
  
  public void handleRemoveKeyValue(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter a existing key : ");
	  String key = reader.next();
	  System.out.print("Enter it's value : ");
	  String value = reader.next();
	  hmtask.remove(map, key, value);
	  printMap(map);
  }
  
  public void handleRemoveKey(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter a existing key : ");
	  String key = reader.next();
	  hmtask.remove(map, key);
	  printMap(map);
  }
  
  
  public void handleDefaultValue(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter a non existing key : ");
	  String key = reader.next();
	  String value = hmtask.getOrDefault(map, key, "zoho");
	  System.out.println("The value is " + value);
  }
  
  public void handleNonExistingKey(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter a non existing key : ");
	  String key = reader.next();
	  String value = hmtask.get(map, key);
	  System.out.println("The value is " + value);
  }
  
  public void handleExistingKey(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter the key that you want to get the value from : ");
	  String key = reader.next();
	  String value = hmtask.get(map, key);
	  System.out.println("The value is " + value);
  }
  
  public void handleReplaceValues(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  int mapSize = hmtask.getMapLength(map);
	  while(mapSize --> 0) {
		  System.out.print("Enter the key : ");
		  String key = reader.next();
		  System.out.println("Enter the new value that you want to replace : ");
		  String newValue = reader.next();
		  hmtask.replace(map, key, newValue);
	  }
	  printMap(map);
  }
  
  public void handleContainsValue(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter the value that you want to check : ");
	  String value = reader.next();
	  System.out.println("Does map contains the key leo ? " + hmtask.containsValue(map, value));
  }
  
  public void handleContainsKey(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  System.out.print("Enter the key that you want to check : ");
	  String key = reader.next();
	  System.out.println("Does map contains the key leo ? " + hmtask.containsKey(map, key));
  }
  
  public void handleIterator(Scanner reader) throws CustomException {
	  Map<String, String> map = handleGetStrings(reader);
	  Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); 
      while(itr.hasNext()) { 
    	System.out.println("key : " + itr.next().getKey() + ", value : " + itr.next().getValue()); 
      } 
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
  
