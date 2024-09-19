package runner;

import tasks.StringTask;
import exception.CustomException;
import java.util.Scanner;
import java.io.Console;

public class StringRunner {

  public static void main(String[] args) {
    StringRunner stringRunner = new StringRunner();
    try {
      int length = args.length;
      if(length > 0) {
        stringRunner.run(args[0]);
      } else {
        System.out.println("Pass an argument.");
      }
    } catch (CustomException exception) {
      exception.printStackTrace();
    }
  }

  private void run(String argsString) throws CustomException {
    StringTask task = new StringTask();
    Scanner reader = new Scanner(System.in);
    printQuestions();
    while (true) {
      System.out.print("Enter the question number: ");
      int questionNo = reader.nextInt();
      reader.nextLine(); 
      String inputString = "";
      if (questionNo != 17 && questionNo > 1) {
        System.out.print("Enter a string: ");
        inputString = reader.nextLine();
      }
      try {
        switch (questionNo) {
          case 1:
            handleStringLength(argsString, task);
            break;
          case 2:
            handleToCharArray(inputString, task);
            break;
          case 3:
            handleCharacterAt(inputString, reader, task);
            break;
          case 4:
            handleCountCharacter(inputString, reader, task);
            break;
          case 5:
            handleGreatPosition(inputString, reader, task);
            break;
          case 6:
            handleLastNCharacters(inputString, reader, task);
            break;
          case 7:
            handleFirstNCharacters(inputString, reader, task);
            break;
          case 8:
            handleReplaceCharacters(inputString, reader, task);
            break;
          case 9:
            handleCheckStartsWith(inputString, reader, task);
            break;
          case 10:
            handleCheckEndsWith(inputString, reader, task);
            break;
          case 11:
            handleToLowerCase(inputString, task);
            break;
          case 12:
            handleToUpperCase(inputString, task);
            break;
          case 13:
            handleToReverse(inputString, task);
            break;
          case 14:
            handlePrintInputString(inputString);
            break;
          case 15:
            handleConcatenate(inputString, reader, task);
            break;
          case 16:
            handleToEnclose(inputString, reader, task);
            break;
          case 17:
            handleMergeString(reader, task);
            break;
          case 18:
            handleEqualCaseSensitive(inputString, reader, task);
            break;
          case 19:
            handleEqualInCaseSensitive(inputString, reader, task);
            break;
          case 20:
            handleNoSpaceAtEnds(inputString, task);
            break;
          case -1:
            return; 
        }
      } catch (CustomException exception) {
        throw new CustomException("Exception occurred in case number " + questionNo, exception);
      } finally {
        reader.close();
      }
    }
  }

  private void handleStringLength(String inputString, StringTask task) throws CustomException {
    System.out.println("The length of the string is " + task.stringLength(inputString));
  }

  private void handleToCharArray(String inputString, StringTask task) throws CustomException {
    char[] characterArray = task.toCharArray(inputString);
    for (char character : characterArray) {
      System.out.print(character + " ");
    }
    System.out.println();
  }

  private void handleCharacterAt(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter an index to find the character: ");
    int position = reader.nextInt();
    char resultCharacter = task.characterAt(inputString, position);
    System.out.println("Character at index " + position + " is " + resultCharacter);
  }

  private void handleCountCharacter(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter a character to count its occurrences: ");
    char inputCharacter = reader.nextLine().charAt(0);
    int result = task.countCharacter(inputString, inputCharacter);
    System.out.println("The character " + inputCharacter + " occurs " + result + " times.");
  }

  private void handleGreatPosition(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter a character to find its greatest position: ");
    char inputCharacter = reader.nextLine().charAt(0);
    int result = task.greatPosition(inputString, inputCharacter);
    System.out.println("The greatest position of the character " + inputCharacter + " is " + result);
  }

  private void handleLastNCharacters(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the number of characters to print from the end: ");
    int startIndex = reader.nextInt();
    String resultString = task.lastNCharacters(inputString, startIndex);
    System.out.println("The last " + startIndex + " characters are: " + resultString);
  }

  private void handleFirstNCharacters(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the number of characters to print from the start: ");
    int endIndex = reader.nextInt();
    String resultString = task.firstNCharacters(inputString, endIndex);
    System.out.println("The first " + endIndex + " characters are: " + resultString);
  }

  private void handleReplaceCharacters(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter a string to replace with: ");
    String replaceString = reader.next();
    System.out.print("Enter the number of characters to replace: ");
    int position = reader.nextInt();
    String resultString = task.replaceCharacters(inputString, replaceString, position);
    System.out.println("The modified string is: " + resultString);
  }

  private void handleCheckStartsWith(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the prefix to check: ");
    String startString = reader.nextLine();
    boolean booleanResult = task.checkStartsWith(inputString, startString);
    if (booleanResult) {
      System.out.println(inputString + " starts with " + startString);
    } else {
      System.out.println(inputString + " doesn't start with " + startString);
    }
  }

  private void handleCheckEndsWith(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the suffix to check: ");
    String endString = reader.nextLine();
    boolean booleanResult = task.checkEndsWith(inputString, endString);
    if (booleanResult) {
      System.out.println(inputString + " ends with " + endString);
    } else {
      System.out.println(inputString + " doesn't end with " + endString);
    }
  }

  private void handleToLowerCase(String inputString, StringTask task) throws CustomException {
    String resultString = task.toLowerCase(inputString);
    System.out.println("The lowercase version of " + inputString + " is " + resultString);
  }

  private void handleToUpperCase(String inputString, StringTask task) throws CustomException {
    String resultString = task.toUpperCase(inputString);
    System.out.println("The uppercase version of " + inputString + " is " + resultString);
  }

  private void handleToReverse(String inputString, StringTask task) throws CustomException {
    String resultString = task.toReverse(inputString);
    System.out.println("The reverse of " + inputString + " is " + resultString);
  }

  private void handlePrintInputString(String inputString) {
    System.out.println(inputString);
  }

  private void handleConcatenate(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.println("Enter the expression to replace: ");
    String toReplace = reader.nextLine();
    System.out.println("Enter the replacement: ");
    String replacement = reader.nextLine();
    String resultString = task.concatenate(inputString, toReplace, replacement);
    System.out.println("Concatenated string: " + resultString);
  }

  private void handleToEnclose(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.println("Enter the delimiter: ");
    String delimiter = reader.nextLine();
    System.out.println("Enter the string to split: ");
    String splitDelimiter = reader.nextLine();
    String resultString = task.toEnclose(inputString, delimiter, splitDelimiter);
    System.out.println("Result: " + resultString);
  }

  private void handleMergeString(Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the number of strings: ");
    int numberOfStrings = reader.nextInt();
    reader.nextLine(); 
    String[] stringArray = new String[numberOfStrings];
    for (int i = 0; i < numberOfStrings; i++) {
      System.out.print("Enter string " + (i + 1) + ": ");
      stringArray[i] = reader.nextLine();
    }
    System.out.println("Enter a delimiter: ");
    String delimiter = reader.nextLine();
    String resultString = task.mergeString(delimiter, stringArray);
    System.out.println("Merged string: " + resultString);
  }

  private void handleEqualCaseSensitive(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the second string to compare: ");
    String secondString = reader.nextLine();
    boolean result = task.equalCaseSensitive(inputString, secondString);
    System.out.println("Are they equal (case sensitive)? " + result);
  }

  private void handleEqualInCaseSensitive(String inputString, Scanner reader, StringTask task) throws CustomException {
    System.out.print("Enter the second string to compare: ");
    String secondString = reader.nextLine();
    boolean result = task.equalInCaseSensitive(inputString, secondString);
    System.out.println("Are they equal (case insensitive)? " + result);
  }

  private void handleNoSpaceAtEnds(String inputString, StringTask task) throws CustomException {
    String resultString = task.noSpaceAtEnds(inputString);
    System.out.println("The string without leading and trailing spaces is: " + resultString);
  }

  private void printQuestions() {
    System.out.println("1: String length without spaces.");
    System.out.println("2: Print character array.");
    System.out.println("3: Find character at a position.");
    System.out.println("4: Count occurrences of a character.");
    System.out.println("5: Find greatest position of a character.");
    System.out.println("6: Print last n characters.");
    System.out.println("7: Print first n characters.");
    System.out.println("8: Replace n characters with another string.");
    System.out.println("9: Check if string starts with another string.");
    System.out.println("10: Check if string ends with another string.");
    System.out.println("11: Convert string to lowercase.");
    System.out.println("12: Convert string to uppercase.");
    System.out.println("13: Reverse a string.");
    System.out.println("14: Print input string.");
    System.out.println("15: Concatenate a string.");
    System.out.println("16: Enclose string.");
    System.out.println("17: Merge strings with delimiter.");
    System.out.println("18: Check if two strings are equal (case sensitive).");
    System.out.println("19: Check if two strings are equal (case insensitive).");
    System.out.println("20: Remove leading and trailing spaces.");
  }
}
