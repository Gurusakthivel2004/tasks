package runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.logging.Logger;

import car.CarModel;
import exception.CustomException;
import person.Person;
import property.PropertyTask;
import singleton.EagerSingleton;
import tasks.TimeTask;
import property.PropertyTask;

public class FileRunner {
	
	TimeTask tTask = new TimeTask();
	PropertyTask pTask = new PropertyTask();
    Logger logger = Logger.getLogger(FileRunner.class.getName());
    
    public enum RainbowColor {
    	
        VIOLET(1),
        INDIGO(2),
        BLUE(3),
        GREEN(4),
        YELLOW(5),
        ORANGE(6),
        RED(7);

        private int colorCode;

        RainbowColor(int colorCode) {
            this.colorCode = colorCode;
        }

        public int getColorCode() {
            return colorCode;
        }
    }

	public static void main(String[] args) {
		FileRunner fileRunner = new FileRunner();
		Scanner reader = new Scanner(System.in);
		
//		EagerSingleton.abc();
		fileRunner.handleTimeOperations();
		fileRunner.logger.info("Enter the question number: ");
	    int questionNo = reader.nextInt();
	    reader.nextLine();
	    try {
	    	switch(questionNo) {
	    	
	        	case 1:
	        		fileRunner.createFile(reader);
	        		break;
	        		
	        	case 2:
	        		fileRunner.storeProperties(reader);
	        		break;
	        	
	        	case 3:
	        		fileRunner.loadProperties(reader);
	        		break;
	        		
	        	case 4:
	        		fileRunner.customDirectory(reader);
	        		break;
	        		
	        	case 5:
	        		fileRunner.callConstructor();
	        		break;
	        	
	        	case 6:
	        		fileRunner.callPojo();
	        		break;
	        		
	        	case 7:
	        		fileRunner.callPojoGetSet();
	        		break;
	        		
	        	case 8:
	        		fileRunner.handleReflector();
	        		break;
	        		
	        	case 9:
	        		fileRunner.handleEnum();
	        		break;
	        		
	        		
	    	}
				
	    } catch (CustomException exception) {
	    	fileRunner.logger.warning(exception.getMessage());
		}
	    
	}
	
	public void handleTimeOperations() {
		logger.info("The current time is " + tTask.getCurrentTime() + "\n");
		logger.info("The current milliseconds is " + tTask.getCurrentTimeInMillis());
		logger.info("The current time in cities is " + tTask.getCurrentTimeInCities("Asia/Kolkata"));
	}
	
	public void callPojoGetSet() {
		Person person = new Person();
		person.setName("Alice");
        person.setAge(30);
        logger.info("Name: " + person.getName());
        logger.info("Age: " + person.getAge());
	}
	
	public void callPojo() {
		Person person = new Person("guru", 20);
		logger.info(person.toString());
	}
	
	public void callConstructor() {
		CarModel carModel = new CarModel("sedan");
		logger.info(carModel.toString());
	}
	
	public void customDirectory(Scanner reader) throws CustomException {
        createFile(reader);
        storeProperties(reader);
        loadProperties(reader);
	}
	
	
	public void handleReflector() {
		try {
			Class<?> pojoClass = Class.forName("person.Person");
			
	        Constructor<?> overloadedConstructor = pojoClass.getConstructor(String.class, Integer.class);
	        Object pojoOverloaded = overloadedConstructor.newInstance("guru", 20);
	        Method getNameMethod = pojoClass.getMethod("getName");
	        Method setNameMethod = pojoClass.getMethod("setName", String.class);
	        setNameMethod.invoke(pojoOverloaded, "messi");
	
	        String updatedName = (String) getNameMethod.invoke(pojoOverloaded);
	        logger.info("Updated name is : " + updatedName);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void handleEnum() {
		for (RainbowColor color : RainbowColor.values()) {
            logger.info("Color: " + color + ", Color Code: " + color.getColorCode() + "Ordinal of " + color + " is: " + color.ordinal());
        }
	}
	
	public void loadProperties(Scanner reader) throws CustomException {
		logger.info("Enter the file path : ");
		String filePath = reader.nextLine();
		File file = new File(filePath);
        if (!file.exists()) {
        	throw new CustomException("No file exists");
        }
		Properties props = (Properties) pTask.loadPropertiesFromFile(filePath);
		props.list(System.out);
	}
	
	public void storeProperties(Scanner reader) throws CustomException {
		logger.info("Enter the directory path: ");
		String directoryPath = reader.nextLine();
		logger.info("Enter the file name: ");
		String fileName = reader.nextLine();
		Properties props = (Properties) pTask.getProperty();
		logger.info("Enter number of key value pairs to store");
		int length = reader.nextInt();
		reader.nextLine();
		while(length --> 0) {
	        pTask.addProperty(props, reader.next(), reader.next());
		}
		reader.nextLine();
        pTask.storePropertiesToFile(directoryPath, fileName, props);
		
	}
	
	public void createFile(Scanner reader) throws CustomException {
		
		logger.info("Enter the file name: ");
		String fileName = reader.nextLine();
		String directoryPath = System.getProperty("user.dir");
		try (FileWriter writer = pTask.createFile(directoryPath, fileName)){
			logger.info("Enter the number of words : ");
			int numberOfWords = reader.nextInt();
			reader.nextLine();
			logger.info("Enter the words to add in the file");
			while(numberOfWords --> 0) {
				pTask.writeFile(reader.nextLine() + "\n", writer);
			}
		} catch (IOException exception) {
	    	logger.warning(exception.getMessage());
		}
	}
 
}