package helper.util;

import exception.CustomException;

public class Helper {
  public static void checkNullValues(Object inputObject) throws CustomException{
      if(inputObject== null) {  
          throw new CustomException("Error: Null value provided.");
      }
  }

  public static void checkIndexBounds(int index, int limit) throws CustomException{
      if (index >= limit || index < 0) {
        throw new CustomException("Error: The specified index is out of bounds.");
      }
  }
  
  public static void checkTwoIndexBounds(int startIndex, int endIndex, int limit) throws CustomException {
    checkIndexBounds(startIndex, limit);
    checkIndexBounds(endIndex, limit);
    if (startIndex > endIndex) {
        throw new CustomException("Error: The start index is greater than end index.");
    }
  }
}