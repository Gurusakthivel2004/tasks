package tasks;

import exception.CustomException;
import helper.util.Helper;
 
public class StringTask {

  public boolean checkStartsWith(String inputString, String startString) throws CustomException {
    Helper.checkNullValues(inputString);
    Helper.checkNullValues(startString);
    return inputString.startsWith(startString);
  }
  
  public boolean checkEndsWith(String inputString, String endString) throws CustomException {
    Helper.checkNullValues(inputString);
    Helper.checkNullValues(endString);
    return inputString.endsWith(endString);
  }
  
  public boolean equalCaseSensitive(String firstString, String secondString) throws CustomException {
    Helper.checkNullValues(firstString);
    Helper.checkNullValues(secondString);
    return firstString.equals(secondString);
  }
  
  public boolean equalInCaseSensitive(String firstString, String secondString) throws CustomException {
    Helper.checkNullValues(firstString);
    Helper.checkNullValues(secondString);
    return firstString.equalsIgnoreCase(secondString);
  }
  
  public String noSpaceAtEnds(String inputString) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.trim();
  }
  
  public String mergeString(String delimiter, String[] stringArray) throws CustomException {//swami
    Helper.checkNullValues(stringArray);
    Helper.checkNullValues(delimiter);
    return String.join(delimiter, stringArray);
  }
  
  public int greatPosition(String inputString, char inputCharacter) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.lastIndexOf(inputCharacter);
  }
  
  public String concatenate(String inputString, String toReplace, String replacement) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.replace(toReplace, replacement);
  }

  
  public String toEnclose(String inputString, String delimiter, String splitDelimiter) throws CustomException {
    Helper.checkNullValues(inputString);
    return mergeString(delimiter, inputString.split(splitDelimiter));
  }
  
  public String toReverse(String inputString) throws CustomException {
    int length = stringLength(inputString);
    char[] charArray = toCharArray(inputString);
    for (int i=0;i<length/2;i++) {
      char tempCharacter = charArray[i];
      charArray[i] = charArray[length-i-1];
      charArray[length-i-1] = tempCharacter;
    }
    return String.valueOf(charArray);
  }
  
  public String toUpperCase(String inputString) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.toUpperCase();
  }
  
  public String toLowerCase(String inputString) throws CustomException {
    Helper.checkNullValues(inputString); 
    return inputString.toLowerCase();
  }
  
  public String firstNCharacters(String inputString, int endIndex) throws CustomException {
    int length = stringLength(inputString);
    Helper.checkIndexBounds(endIndex, length);
    return inputString.substring(0, endIndex + 1);
  }
  
  public String lastNCharacters(String inputString, int startIndex) throws CustomException {
    int length = stringLength(inputString);
    Helper.checkIndexBounds(startIndex, length);
    return inputString.substring(length - startIndex - 1,length);
  }
  
  public int stringLength(String inputString) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.length();
  }
  
  public char characterAt(String inputString, int position) throws CustomException {//swami
    int length = stringLength(inputString);
    Helper.checkIndexBounds(position, length);
    return inputString.charAt(position);
  }
  
  public char[] toCharArray(String inputString) throws CustomException {
    Helper.checkNullValues(inputString);
    return inputString.toCharArray();
  }
  
  public int countCharacter(String inputString, char inputCharacter) throws CustomException {
    char[] charArray = toCharArray(inputString);
    int count = 0;
    for(char ch : charArray) {
      if(inputCharacter == ch) {
        count++;
      }
    }
    return count;
  }
  
  public String replaceCharacters(String inputString, String replaceString, int position) throws CustomException {
    int length = stringLength(inputString);
    Helper.checkNullValues(replaceString);
    Helper.checkIndexBounds(position, length+1);
    return inputString.replaceAll("^.{"+position+"}", replaceString);
  } 
  
}