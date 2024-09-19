package runner;

import tasks.StringBuilderTask;
import exception.CustomException;
import java.util.Scanner;

public class StringBuilderRunner {
  
  StringBuilderTask sbtask = new StringBuilderTask();
  boolean flag = true;
  
  public static void main(String[] args) {
    
    StringBuilderRunner sbRunner = new StringBuilderRunner();
    try(Scanner reader = new Scanner(System.in)){
      try {
        sbRunner.run(sbRunner, reader);
      } catch(CustomException exception) {
        exception.printStackTrace();
      } 
    }
    
  }
  
  public void run(StringBuilderRunner sbRunner, Scanner reader) throws CustomException {
    while(sbRunner.flag) { 
      System.out.print("Enter the question number: ");
      int questionNo = reader.nextInt();
      reader.nextLine();
      switch(questionNo) {

        case 1:
          handleInitialAppend(reader);
          break;
        
        case 2:
          handleMerge(reader);
          break;
          
        case 3:
          handleInsert(reader);
          break;
          
        case 4:
          handleDeleteString(reader);
          break;
          
        case 5:
          handleReplaceDelimiter(reader);
          break;
          
        case 6:
          handleReverse(reader);
          break;
          
        case 7:
          handleDelete(reader);
          break;
          
        case 8:
          handleReplace(reader);
          break;
          
        case 9:
          handleFirstDelimiterIndex(reader);
          break;
          
        case 10:
          handleLastDelimiterIndex(reader);
          break;
        
        case -1:
          sbRunner.flag = false;
          return;
      }
    }
  }
  
  private void handleFirstDelimiterIndex(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    handleAppend(inputStringBuilder, delimiter, reader);
    int index = sbtask.firstDelimiterIndex(inputStringBuilder, delimiter);
    System.out.println("The index of the first " + delimiter +  " is " + index);
  }
  
  private void handleLastDelimiterIndex(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    handleAppend(inputStringBuilder, delimiter, reader);
    int index = sbtask.lastDelimiterIndex(inputStringBuilder, delimiter);
    System.out.println("The last index of the " + delimiter +  " is " + index);
  }
  
  private void handleReplace(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter a of string : ");
    sbtask.append(inputStringBuilder, reader.next());
    printLengthAndString(inputStringBuilder);
    System.out.println("Enter the start and end indexes to replace");
    int startIndex = reader.nextInt(), endIndex = reader.nextInt();
    reader.nextLine();
    System.out.println("Enter the string to replace with");
    String replaceString = reader.next();
    sbtask.replace(inputStringBuilder, startIndex, endIndex, replaceString);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleReverse(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    handleAppend(inputStringBuilder, delimiter, reader);
    sbtask.reverse(inputStringBuilder);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleDelete(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter a of string : ");
    sbtask.append(inputStringBuilder, reader.next());
    printLengthAndString(inputStringBuilder);
    System.out.println("Enter the start and end indexes to delete");
    int startIndex = reader.nextInt(), endIndex = reader.nextInt();
    reader.nextLine();
    sbtask.delete(inputStringBuilder, startIndex, endIndex);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleReplaceDelimiter(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    handleAppend(inputStringBuilder, delimiter, reader);
    System.out.println("Enter a delimiter to replace the previous delimiter");
    String replaceDelimiter = reader.next(); 
    sbtask.replaceCharAt(inputStringBuilder, delimiter, replaceDelimiter);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleInitialAppend(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.print("Enter a string : ");
    String inputString = reader.next();
    printLengthAndString(inputStringBuilder);
    sbtask.append(inputStringBuilder, inputString);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleInsert(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    handleAppend(inputStringBuilder, delimiter, reader);
    System.out.println("Enter another string to insert : ");
    String inputString = reader.next();
    System.out.println("Enter the position to insert : ");
    int position = reader.nextInt();
    reader.nextLine();
    sbtask.insert(inputStringBuilder, position, inputString);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleDeleteString(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.println("Enter the delimiter");
    String delimiter = reader.nextLine();
    handleAppend(inputStringBuilder, delimiter, reader);
    System.out.println("Enter the index of the word you want to delete : ");
    int index = reader.nextInt();
    sbtask.deleteString(inputStringBuilder, index, delimiter);
    printLengthAndString(inputStringBuilder);
  }
  
  private void handleAppend(StringBuilder inputStringBuilder, String delimiter, Scanner reader) throws CustomException {
    System.out.println("Enter number of strings : ");
    int numberOfStrings = reader.nextInt();
    reader.nextLine();
    for(int i=0;i<numberOfStrings;i++) {
      if(i == numberOfStrings - 1) {
        sbtask.append(inputStringBuilder, reader.next());
      }
      else {
        sbtask.append(inputStringBuilder, reader.next(), delimiter);
      }
    }
    printLengthAndString(inputStringBuilder);
  }
  
  private void printLengthAndString(StringBuilder inputStringBuilder) throws CustomException {
    int length = sbtask.stringBuilderLength(inputStringBuilder);
    System.out.println("The length of the StringBuilder with the string " + inputStringBuilder.toString() +  " is " + length);
  }
  
  private void handleMerge(Scanner reader) throws CustomException {
    StringBuilder inputStringBuilder = sbtask.getStringBuilder();
    System.out.print("Enter a string : ");
    String inputString = reader.next();
    System.out.println("Enter the delimiter");
    String delimiter = reader.next();
    printLengthAndString(inputStringBuilder);
    System.out.println("Enter the number of strings to be added");
    int numberOfStrings = reader.nextInt();
    reader.nextLine();
    String[] stringArray = new String[numberOfStrings];
    for(int i=0;i<numberOfStrings;i++) {
      stringArray[i] = reader.next();
    }
    String resultString = sbtask.merge(delimiter, stringArray);
    sbtask.append(inputStringBuilder, inputString, delimiter, resultString);
    printLengthAndString(inputStringBuilder);
  }
  
}
