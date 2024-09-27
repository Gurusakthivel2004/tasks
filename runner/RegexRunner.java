package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import exception.CustomException;
import tasks.RegexTask;

public class RegexRunner {

    Logger logger = Logger.getLogger(FileRunner.class.getName());	
    RegexTask rTask = new RegexTask();
	public static void main(String[] args) {	
	    RegexRunner regexRunner = new RegexRunner();
		regexRunner.run(regexRunner);
	}
	
	public void run(RegexRunner regexRunner) {
		regexRunner.logger.info("Enter the question number: ");
	    try(Scanner reader = new Scanner(System.in);) {
	    	int questionNo = reader.nextInt();
		    reader.nextLine();
	    	switch(questionNo) {
		    
				case 1:
					regexRunner.handleMobileNumber(reader);
					break;
					
				case 2:
					regexRunner.handleAlphaNumeric(reader);
					break;
					
				case 3:
					regexRunner.handleEquals(reader);
					break;
					
				case 4:
					regexRunner.handleListMatch(reader);
					break;
					
				case 5:
					regexRunner.handleEmailCheck(reader);
					break;
					
				case 6:
					regexRunner.handleLength(reader);
					break;
					
				case 7:
					regexRunner.handleTwoListMatch(reader);
					break;
					
				case 8:
					regexRunner.handleHtml(reader);
					break;
					
				case -1:
					return;
	    	}	
		} catch (CustomException e) {
			regexRunner.logger.severe("Error occured");
		}
	}
	
	public void handleHtml(Scanner reader) throws CustomException {
		logger.info("Enter the input string : ");
		String inputString = reader.nextLine();
		List<String> resultList = rTask.checkHtmlTags(inputString);
		logger.info(resultList.toString());
	}
 	
	public void handleTwoListMatch(Scanner reader) throws CustomException {
		logger.info("Enter the number of strings for first list : ");
		int firstLength = reader.nextInt();
		List<String> firstList = new ArrayList<>();
		while(firstLength --> 0) {
			firstList.add(reader.next());
		}
		logger.info("Enter the number of strings for second list : ");
		int secondLength = reader.nextInt();
		List<String> secondList = new ArrayList<>();
		while(secondLength --> 0) {
			secondList.add(reader.next());
		}
		Map<String, Integer> result = rTask.checkListMatches(firstList, secondList);
        logger.info("Matching strings with indices: " + result);
	}
	
	public void handleLength(Scanner reader) throws CustomException {
		logger.info("Enter the number of strings: ");
		int number = reader.nextInt();
		List<String> list = new ArrayList<>();
		while(number --> 0) {
			list.add(reader.next());
		}
		boolean result = rTask.checkLength(list);
		logger.info("Does it match : " + result);
	}
	
	public void handleEmailCheck(Scanner reader) throws CustomException {
		logger.info("Enter the input string : ");
		String inputString = reader.next();
		boolean result = rTask.checkEmail(inputString);
		logger.info("Is it valid  : " + result);
	}
	
	public void handleListMatch(Scanner reader) throws CustomException {
		logger.info("Enter the number of strings: ");
		int number = reader.nextInt();
		List<String> list = new ArrayList<>();
		while(number --> 0) {
			list.add(reader.next());
		}
		logger.info("Enter the match string : ");
		String matchString = reader.next();
		boolean result = rTask.checkCaseInsensitiveMatch(list, matchString);
		logger.info("Does it match : " + result);
	}
	
	public void handleEquals(Scanner reader) throws CustomException {
		logger.info("Enter the input string : ");
		String inputString = reader.next();
		logger.info("Enter the match string : ");
		String matchString = reader.next();
		
		boolean startsWith = rTask.checkStartWith(inputString, matchString);
		logger.info(inputString + " starts with " + matchString + " : " + startsWith);
		

		boolean contains = rTask.checkContains(inputString, matchString);
		logger.info(inputString + " contains " + matchString + " : " + contains);
		

		boolean endsWith = rTask.checkEndsWith(inputString, matchString);
		logger.info(inputString + " ends with " + matchString + " : " + endsWith);
		

		boolean exactMatch = rTask.checkExactMatch(inputString, matchString);
		logger.info(inputString + " is exact match  with " + matchString + " : " + exactMatch);
	}
	
	public void handleMobileNumber(Scanner reader) throws CustomException{
		logger.info("Enter the mobile number to check : ");
		String inputString = reader.next();
		boolean result = rTask.checkMobileNumber(inputString);
		logger.info("Is entered mobile number valid : " + result);
	}
	
	public void handleAlphaNumeric(Scanner reader) throws CustomException{
		logger.info("Enter the alpha numeric to check : ");
		String inputString = reader.next();
		boolean result = rTask.checkAlphaNumeric(inputString);
		logger.info("Is entered alpha numeric valid : " + result);
	}
	
}