package property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import exception.CustomException;

public class PropertyTask {
    
    public Properties getProperty() {
    	return new Properties();
    }

    public Properties addProperty(Properties props, String key, String value) {
    	props.setProperty(key, value);
        return props;
        
    }
    
    public Properties loadPropertiesFromFile(String fileName) throws CustomException {
    	try (FileInputStream inputStream = new FileInputStream(fileName)) {
			Properties props = getProperty();
			props.load(inputStream);
			return props;
		} catch (IOException e) {
			throw new CustomException("Error occured during loading properties.");
		}
    }

    public Properties storePropertiesToFile(String fileName, Properties props) throws CustomException {
    	try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
			props.store(outputStream, "Stored Properties");
			return props;
		} catch (IOException e) {
			throw new CustomException("Error occured during storing properties.");
		}
    }
}
