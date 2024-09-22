package runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import car.CarModel;
import exception.CustomException;
import person.Person;
import property.PropertyTask;

public class FileRunner {
	
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
		
		fileRunner.logger.info("Enter the question number: ");
	    int questionNo = reader.nextInt();
	    reader.nextLine();
	    try {
	    	switch(questionNo) {
	    	
	        	case 1:
	        		fileRunner.createFile("sample.txt", reader);
	        		break;
	        		
	        	case 2:
	        		fileRunner.storeProperties("myprops.txt", reader);
	        		break;
	        	
	        	case 3:
	        		fileRunner.loadProperties("myprops.txt");
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
			exception.printStackTrace();
		}
	    
	}
	
	public void handleReflector() {
		try {
			Class<?> pojoClass = Class.forName("person.Person");
	
	        Constructor<?> defaultConstructor = pojoClass.getConstructor();
	        Object pojoDefault = defaultConstructor.newInstance();
	
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
		String directoryPath = "/home/guru-pt7672/Dynamic/myDir";
        String sampleFilePath = directoryPath + "/sample.txt";
        String mypropsFilePath = directoryPath + "/myprops.txt";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean isCreated = directory.mkdirs();
            System.out.print(isCreated);
            if (!isCreated) {
            	return;
            } 
        }
        createFile(sampleFilePath, reader);
        storeProperties(mypropsFilePath, reader);
        loadProperties(mypropsFilePath);
	}
	
	public void loadProperties(String filePath) throws CustomException {
		File file = new File(filePath);
        if (!file.exists()) {
        	throw new CustomException("No file exists");
        }
		Properties props = pTask.loadPropertiesFromFile(filePath);
		props.list(System.out);
	}
	
	public void storeProperties(String filePath, Scanner reader) throws CustomException {
		Properties props = pTask.getProperty();
		logger.info("Enter number of key value pairs to store");
		int length = reader.nextInt();
		reader.nextLine();
		while(length --> 0) {
	        pTask.addProperty(props, reader.next(), reader.next());
		}
        pTask.storePropertiesToFile(filePath, props);
		
	}
	
	public void createFile(String filePath, Scanner reader) {
		try (FileWriter writer = new FileWriter(filePath)){
			logger.info("Enter the number of words : ");
			int numberOfWords = reader.nextInt();
			reader.nextLine();
			logger.info("Enter the words to add in the file");
			while(numberOfWords --> 0) {
				writer.write(reader.nextLine() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}
