package runner;

import tasks.ArrayListTask;
import exception.CustomException;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListRunner {
  
	ArrayListTask altask = new ArrayListTask();
	boolean flag = true;
  
	public static void main(String[] args) {
    
	    ArrayListRunner alRunner = new ArrayListRunner();
	    try(Scanner reader = new Scanner(System.in)){
	      try {
	    	alRunner.run(alRunner, reader);
	      } catch(CustomException exception) {
	        exception.printStackTrace();
	      } 
	    }
    
	}
  
  public void run(ArrayListRunner alRunner, Scanner reader) throws CustomException {
    while(alRunner.flag) { 
      System.out.println("Enter the question number: ");
      int questionNo = reader.nextInt();
      reader.nextLine();
      switch(questionNo) {

        case 1:
        	handleCreate(reader);
			break;
        
        case 2:
        	handleAddStrings(reader);
        	break;
        	
        case 3:
        	handleAddInteger(reader);
        	break;

        case 4:
        	handleCustom(reader);
        	break;
        
        case 5:
        	handleAddMultiType(reader);
        	break;
        	
        case 6:
        	handleFindIndex(reader);
        	break;
        	
        case 7:
        	handleIterator(reader);
        	break;
        	
        case 8:
        	handleFindString(reader);
        	break;
        	
        case 9:
        	handleDuplicateIndex(reader);
        	break;
        	
        case 10:
        	handleInsert(reader);
        	break;
        	
        case 11:
        	handleSublist(reader);
        	break;
        	
        case 12:
        	handleAddFirstList(reader);
        	break;
        	
        case 13:
        	handleAddSecondList(reader);
        	break;
        	
        case 14:
        	handleDelete(reader);
        	break;
        	
        case 15:
        	handleListDelete(reader);
        	
        case 16:
        	handlePredicate(reader);
        	break;
        	
        case 17:
        	handleAddRemove(reader);
        	break;
        
        case 18:
        	handleContains(reader);
        	break;
        	
        case -1:
        	alRunner.flag = false;
        	return;
      }
    }
  }
  
  public void handleContains(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.print("Enter the string to check : ");
	  String inputString = reader.next();
	  altask.contains(list, inputString);
	  printList(list);
  }
  
  public void handleAddRemove(Scanner reader) throws CustomException {
	  List<Long> list = handleAddLong(reader);
	  altask.deleteAll(list);
	  printList(list);
  }
  
  public void handlePredicate(Scanner reader) throws CustomException {
	  List<String> firstlist = handleAddStrings(reader);
	  List<String> secondlist = handleAddStrings(reader);
	  printList(altask.deleteIf(firstlist, secondlist));
  }
  
  public void handleListDelete(Scanner reader) throws CustomException {
	  List<String> firstlist = handleAddStrings(reader);
	  List<String> secondlist = handleAddStrings(reader);
	  printList(altask.deleteAll(firstlist, secondlist));
  }
  
  public void handleDelete(Scanner reader) throws CustomException {
	  List<Float> list = handleAddFloat(reader);
	  System.out.print("Enter the index to delete from : ");
	  int inputIndex= reader.nextInt();
	  altask.remove(list, inputIndex);
	  printList(list);
  }
  
  public void handleAddFirstList(Scanner reader) throws CustomException {
	  List<String> firstlist = handleAddStrings(reader);
	  List<String> secondlist = handleAddStrings(reader);
	  printList(handleMultiList(firstlist, secondlist));
  }
  
  public void handleAddSecondList(Scanner reader) throws CustomException {
	  List<String> firstlist = handleAddStrings(reader);
	  List<String> secondlist = handleAddStrings(reader);
	  printList(handleMultiList(secondlist, firstlist));
  }
  
  public <T> List<T> handleMultiList(List<T> firstlist, List<T> secondlist) throws CustomException {
	  return altask.addAll(firstlist, secondlist);
  }
  
  public void handleSublist(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.print("Enter the start and end index to trim ");
	  int startIndex = reader.nextInt(), endIndex = reader.nextInt();
	  List<String> subList = altask.sublist(list, startIndex, endIndex);
	  printList(subList);
  }
  
  public void handleInsert(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.println("Enter the string to insert");
	  String inputString = reader.next();
	  System.out.println("Enter the index");
	  int index = reader.nextInt();
	  altask.insert(list, inputString, index);
	  printList(list);
  }
  
  public void handleDuplicateIndex(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.println("Enter the duplicate string to find it's index");
	  String inputString = reader.next();
	  int firstIndex = altask.findFirstIndex(list, inputString);
	  int lastIndex = altask.findLastIndex(list, inputString);
	  System.out.println("The first index is " + firstIndex + " and last index is " + lastIndex);
  }
  
  public void handleFindString(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.print("Enter the index to find the string : ");
	  int inputIndex = reader.nextInt();
	  String resultString = altask.find(list, inputIndex);
	  System.out.println("The String is " + resultString);
	  printList(list);
  }
  
  public void handleIterator(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  Iterator<String> iterator = list.iterator();
	  while(iterator.hasNext()) {
		  System.out.print(iterator.next() + " ");
	  }
  }
  
  public void handleFindIndex(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.print("Enter the string to find it's index : ");
	  String inputString = reader.next();
	  int index = altask.findFirstIndex(list, inputString);
	  System.out.println("The index is " + index);
	  printList(list);
  }
  
  public void handleAddMultiType(Scanner reader) throws CustomException {
	  List<Object> list =  altask.getArrayList();
	  System.out.println("Enter number of strings to add");
	  int number= reader.nextInt();
	  while(number --> 0) {
		  altask.add(list, reader.next());
	  }
	  System.out.println("Enter number of Integer to add");
	  number = reader.nextInt();
	  while(number--> 0) {
		  altask.add(list, reader.nextInt());
	  }
	  altask.add(list, altask);
	  printList(list);
  }
  
  public void handleCustom(Scanner reader) throws CustomException {
	  List<ArrayListTask> list =  altask.getArrayList();
	  altask.add(list, altask);
	  printList(list);
  }
  
  
  public List<Integer> handleAddInteger(Scanner reader) throws CustomException {
	  System.out.println("Enter number of strings to add");
	  int numberOfStrings = reader.nextInt();
	  List<Integer> list =  altask.getArrayList();
	  while(numberOfStrings --> 0) {
		  altask.add(list, reader.nextInt());
	  }
	  printList(list);
	  return list;
  }
  
  public List<Float> handleAddFloat(Scanner reader) throws CustomException {
	  System.out.println("Enter number of decimals to add");
	  int numberOfDecimals = reader.nextInt();
	  List<Float> list =  altask.getArrayList();
	  while(numberOfDecimals--> 0) {
		  altask.add(list, reader.nextFloat());
	  }
	  printList(list);
	  return list;
  }
  
  public List<String> handleAddStrings(Scanner reader) throws CustomException {
	  System.out.println("Enter number of strings to add");
	  int numberOfStrings = reader.nextInt();
	  List<String> list =  altask.getArrayList();
	  while(numberOfStrings --> 0) {
		  altask.add(list, reader.next());
	  }
	  printList(list);
	  return list;
  }
  
  public List<Long> handleAddLong(Scanner reader) throws CustomException {
	  System.out.println("Enter number of long values to add");
	  int numberOfStrings = reader.nextInt();
	  List<Long> list =  altask.getArrayList();
	  while(numberOfStrings --> 0) {
		  altask.add(list, reader.nextLong());
	  }
	  printList(list);
	  return list;
  }
  
  
  public void handleCreate(Scanner reader) throws CustomException {
	  List<Integer> list =  altask.getArrayList();
	  printList(list);
  }
  
  public <T> void printList(List<T> list) throws CustomException {
	  System.out.println(list + " and the length is " + altask.getLength(list));
  }
  
}
