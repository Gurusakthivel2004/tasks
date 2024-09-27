package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exception.CustomException;
import helper.util.Helper;

public class RegexTask {
	
	private boolean validate(String inputString, String pattern) throws CustomException {
		Helper.checkNullValues(inputString);
		return Pattern.matches(pattern, inputString);
	}
	
	public boolean checkMobileNumber(String inputString) throws CustomException {
		String patternString = "^[789][0-9]{9}";
		return validate(inputString, patternString);
	}
	
	public boolean checkAlphaNumeric(String inputString) throws CustomException {
		String patternString = "^[a-zA-Z0-9]+$";
		return validate(inputString, patternString);
	}
	
	public boolean checkStartWith(String inputString, String matchString) throws CustomException {
		String patternString = "^" + matchString + ".*";
		return validate(inputString, patternString);
	}
	
	public boolean checkContains(String inputString, String matchString) throws CustomException {
		String patternString = ".*" + Pattern.quote(matchString) + ".*"; 
		return validate(inputString, patternString);
	}
	
	public boolean checkEndsWith(String inputString, String matchString) throws CustomException {
		String patternString = ".*" + Pattern.quote(matchString) + "$"; 
		return validate(inputString, patternString);
	}
	
	public boolean checkExactMatch(String inputString, String matchString) throws CustomException {
		String patternString = "^" + Pattern.quote(matchString) + "$";
		return validate(inputString, patternString);
	}
	
	public boolean checkEmail(String inputString) throws CustomException {
		String patternString = ".*@.*\\..*"; 
		return validate(inputString, patternString);
	}
	
	public List<String> checkHtmlTags(String inputStrings) {
		List<String> resultList = new ArrayList<String>();
        String patternString = "<[^>]+>";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputStrings);
        while (matcher.find()) {
           resultList.add(matcher.group());
        }
        return resultList;
    }
	
	public boolean checkLength(List<String> inputList) throws CustomException {
        Helper.checkNullValues(inputList);
        String regexPattern = "^.{1,6}$";
        for (String input : inputList) {
            if(!Pattern.matches(regexPattern, input)) {
                return false;
            }	
        }
        return true;
    }
	
	public boolean checkCaseInsensitiveMatch(List<String> inputList, String matchString) throws CustomException {
        Helper.checkNullValues(inputList);
        Helper.checkNullValues(matchString);
        String regexPattern = "(?i)" + Pattern.quote(matchString);
        for (String input : inputList) {
            if (Pattern.matches(regexPattern, input)) {
                return true;
            }	
        }
        return false;
    }
	
	public Map<String, Integer> checkListMatches(List<String> firstList, List<String> secondList) throws CustomException {
		Helper.checkNullValues(firstList);
		Helper.checkNullValues(secondList);
        Map<String, Integer> resultMap = new HashMap<>();
        
        for (String matchString : secondList) {
            String patternString = "^" + matchString + "$";
            Pattern pattern = Pattern.compile(patternString);
            for (int i = 0; i < firstList.size(); i++) {
                if (pattern.matcher(firstList.get(i)).matches()) {
                    resultMap.put(matchString, i);
                }
            }
        }
        if (resultMap.size() != secondList.size()) {
            throw new CustomException("Not all values in List2 are present in List1.");
        }
        return resultMap;
    }
	
}
