package property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import exception.CustomException;
import helper.util.Helper;

public class PropertyTask {
    
	public Map<?, ?> getProperty() {
    	return new Properties();
    }

    public Map<?, ?> addProperty(Properties props, String key, String value) {
    	props.setProperty(key, value);
        return props;
    }
    
    public Map<?, ?> loadPropertiesFromFile(String filePath) throws CustomException {
    	Helper.checkNullValues(filePath);
    	try (FileInputStream inputStream = new FileInputStream(filePath)) {
			Properties props = (Properties) getProperty();
			props.load(inputStream);
			return props;
		} catch (IOException e) {
			throw new CustomException("Error occured during loading properties.");
		}
    }

    public Map<?, ?> storePropertiesToFile(String directoryPath, String fileName, Properties props) throws CustomException {
    	Helper.checkNullValues(fileName);
    	createDirectory(directoryPath);
    	try (FileOutputStream outputStream = new FileOutputStream(directoryPath + File.separator  +  fileName)) {
			props.store(outputStream, "Stored Properties");
			return props;
		} catch (IOException e) {
			throw new CustomException("Error occured during storing properties.");
		}
    }
    
    public void createDirectory(String directoryPath) throws CustomException {
    	if(!checkDirectoryExists(directoryPath)) {
    		File directory = new File(directoryPath);
    		directory.mkdirs();
    	}
    }
    
    public boolean checkDirectoryExists(String directoryPath) throws CustomException {
    	Helper.checkNullValues(directoryPath);
        return new File(directoryPath).exists();
    }
    
    public FileWriter createFile(String directoryPath, String fileName) throws CustomException {
    	Helper.checkNullValues(fileName);
    	createDirectory(directoryPath);
		try(FileWriter writer = new FileWriter(directoryPath + File.separator +  fileName)) {
			return writer;
		} catch (IOException exception) {
			throw new CustomException("Error occured during creating file.");
		}
	}
    
    public void writeFile(String inputString, FileWriter writer) throws CustomException {
    	Helper.checkNullValues(writer);
    	try {
			writer.write(inputString);
		} catch (IOException exception) {
			throw new CustomException("Error occured during creating file.");
		}
    }
}