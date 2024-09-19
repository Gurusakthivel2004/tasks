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
        	
        case -1:
        	alRunner.flag = false;
        	return;
      }
    }
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
	  // for loop
//	  for(String string : list) { 
//		  System.out.print(string + " ");
//	  }

  }
  
  public void handleFindIndex(Scanner reader) throws CustomException {
	  List<String> list = handleAddStrings(reader);
	  System.out.print("Enter the string to find it's index : ");
	  String inputString = reader.next();
	  int index = altask.findIndex(list, inputString);
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
  
  
  public void handleCreate(Scanner reader) throws CustomException {
	  List<Integer> list =  altask.getArrayList();
	  printList(list);
  }
  
  public <T> void printList(List<T> list) throws CustomException {
	  System.out.println(list + " and the length is " + altask.getLength(list));
  }
  
}
