package tasks;

import exception.CustomException;
import helper.util.Helper;

public class StringBuilderTask {

  public StringBuilder getStringBuilder() {
    return new StringBuilder();
  }
  
  public int stringBuilderLength(StringBuilder inputStringBuilder) throws CustomException {
    Helper.checkNullValues(inputStringBuilder);
    return inputStringBuilder.length();
  }
  
  public StringBuilder reverse(StringBuilder inputStringBuilder) throws CustomException {
    return inputStringBuilder.reverse();
  }
  
  public StringBuilder insert(StringBuilder inputStringBuilder, int index, String inputString) throws CustomException {
    int length = stringBuilderLength(inputStringBuilder);
    Helper.checkNullValues(inputString);
    Helper.checkIndexBounds(index, length);
    return inputStringBuilder.insert(index, inputString);
  }
  
  public StringBuilder replace(StringBuilder inputStringBuilder, int startIndex, int endIndex, String replaceString) throws CustomException {
    int length = stringBuilderLength(inputStringBuilder);
    Helper.checkNullValues(replaceString);
    Helper.checkTwoIndexBounds(startIndex, endIndex-1, length); // -1 is for the exclusive end!!!!
    return inputStringBuilder.replace(startIndex, endIndex, replaceString);
  }
  
  public int firstDelimiterIndex(StringBuilder inputStringBuilder, String delimiter) throws CustomException {
    Helper.checkNullValues(delimiter);
    Helper.checkNullValues(inputStringBuilder);
    return inputStringBuilder.indexOf(delimiter);
  }
  
  public int lastDelimiterIndex(StringBuilder inputStringBuilder, String delimiter) throws CustomException {
    Helper.checkNullValues(delimiter);
    Helper.checkNullValues(inputStringBuilder);
    return inputStringBuilder.lastIndexOf(delimiter);
  }
  
  public StringBuilder deleteString(StringBuilder inputStringBuilder, int index, String delimiter) throws CustomException {
    Helper.checkNullValues(inputStringBuilder);
    int length = stringBuilderLength(inputStringBuilder), delimiterCount = 0;;
    Helper.checkIndexBounds(index, length);
    for(int i=0;i<length;i++) {
      if(inputStringBuilder.charAt(i) == delimiter.charAt(0)) {
        delimiterCount++;
      }
      if(delimiterCount == index) {
        int nextIndex = inputStringBuilder.indexOf(delimiter, i+1);
        return delete(inputStringBuilder, i, nextIndex == -1 ? length : nextIndex);
      }
    }
    return inputStringBuilder;
  } 
  
  public StringBuilder delete(StringBuilder inputStringBuilder, int startIndex, int endIndex) throws CustomException {
    int length = stringBuilderLength(inputStringBuilder);
    Helper.checkTwoIndexBounds(startIndex, endIndex-1, length); // -1 is for the exclusive end!!!!
    return inputStringBuilder.delete(startIndex, endIndex);
  }
  
  public StringBuilder replaceCharAt(StringBuilder inputStringBuilder, String delimiter, String replaceDelimiter) throws CustomException {
     int length = stringBuilderLength(inputStringBuilder);
     Helper.checkNullValues(delimiter);
     Helper.checkNullValues(replaceDelimiter);
     for(int i=0;i<length;i++) {
      if(inputStringBuilder.charAt(i) == delimiter.charAt(0)) {
        inputStringBuilder.setCharAt(i, replaceDelimiter.charAt(0));
      }
     }
     return inputStringBuilder;
  }
  
  public String merge(String delimiter, String[] stringArray) throws CustomException {
    Helper.checkNullValues(stringArray);
    Helper.checkNullValues(delimiter);
    return String.join(delimiter, stringArray);
  }
  
  public StringBuilder append(StringBuilder inputStringBuilder, String ... strings) throws CustomException {
    Helper.checkNullValues(inputStringBuilder);
    Helper.checkNullValues(strings);
    for(String str : strings) {
      inputStringBuilder.append(str);
    }
    return inputStringBuilder;
  }
  
}
