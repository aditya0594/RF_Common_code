package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for sharing test data between test classes
 * This class uses a Properties file to store and retrieve shared data
 */
public class TestDataSharing {
    private static final String DATA_FILE = "target/test-data.properties";
    
    /**
     * Store data in the properties file for test data sharing
     * @param key The key to store the data under
     * @param value The value to store
     */
    public static void storeData(String key, String value) {
        Properties props = loadProperties();
        props.setProperty(key, value);
        saveProperties(props);
        System.out.println("Stored data: " + key + " = " + value);
    }

    /**
     * Retrieve data from the properties file
     * @param key The key to retrieve data for
     * @return The stored value, or null if no data exists for the key
     */
    public static String retrieveData(String key) {
        Properties props = loadProperties();
        String value = props.getProperty(key);
        System.out.println("Retrieved data: " + key + " = " + value);
        return value;
    }
    
    /**
     * Load properties from the data file
     */
    private static Properties loadProperties() {
        Properties props = new Properties();
        File file = new File(DATA_FILE);
        
        // Create parent directories if they don't exist
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        
        // Load existing properties if the file exists
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                props.load(fis);
            } catch (IOException e) {
                System.err.println("Error loading properties file: " + e.getMessage());
            }
        }
        
        return props;
    }
    
    /**
     * Save properties to the data file
     */
    private static void saveProperties(Properties props) {
        try (FileOutputStream fos = new FileOutputStream(DATA_FILE)) {
            props.store(fos, "Test data properties");
        } catch (IOException e) {
            System.err.println("Error saving properties file: " + e.getMessage());
        }
    }
}
