package helper.util;

import exception.CustomException;

public class Helper {

    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "default");
    
    public static String get() {
    	return threadLocal.get();
    }
     
    public static void set(String newValue) {
    	threadLocal.set(newValue);
    }
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