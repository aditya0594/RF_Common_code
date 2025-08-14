package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import Examination.AL_Examination_Convocation_ConvocationPassoutStudentList;

public class SearchExcelFile {


    // Method to search for a file by partial filename in the specified directory and its subdirectories
    public static String searchFile(File directory, String partialFileName) {
    	String str = null;
        // Get all the files and directories inside the current directory
        File[] files = directory.listFiles();

        // If the directory is empty or doesn't exist, exit
        if (files == null) {
            System.out.println("The directory does not exist or is empty."); 
            return null;
        }

        // Loop through all the files and directories
        for (File file : files) {
            // If the current item is a directory, call the method recursively to search within it
            if (file.isDirectory()) {
                searchFile(file, partialFileName);  // Recursively search in subdirectories
            } else {
                // If the current item is a file, check if its name contains the search string
                if (file.getName().contains(partialFileName)) {
                    // Print the file path if a match is found
                    System.out.println("File found: " + file.getAbsolutePath());
                    str = file.getAbsolutePath();
                    break;
                }
            }
        }
        return str;
    }
    
	
}
