package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends BaseClass {

	public static void takesScreenshot(String name) throws IOException {

//		String path = System.getProperty("user.dir") + ".\\ScreenShot\\" + File.separator + name
//				+ System.currentTimeMillis() + ".png";

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss"); // yyyyMMdd_HHmmss
		Date date = new Date();
		String timestamp = formatter.format(date);

		String path = System.getProperty("user.dir") + ".\\ScreenShot\\ScreenShotOfPages" + File.separator + timestamp + ".png";

		// Convert the WebDriver instance to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture the screenshot as a File
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE); 

		try {
			// Specify the destination path for the screenshot
			File destFile = new File(path);

			// Copy the screenshot to the destination path using FileUtils from Apache
			// Commons IO
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot captured: " + destFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}

	public static void takesScreenshotReports(String name) throws IOException {
//		// take screenshot of the entire page
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		// get current date and time
//		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss"); // yyyyMMdd_HHmmss
//		Date date = new Date();
//		String timestamp = formatter.format(date);
//
//		// save the screenshot to a file
//		FileUtils.copyFile(screenshotFile, new File(".\\ScreenShot\\screenshot" + timestamp + name + ".png"));
		SimpleDateFormat formatter = new SimpleDateFormat("_dd-MM-yyyy_HH-mm-ss"); // yyyyMMdd_HHmmss
		Date date = new Date();
		String timestamp = formatter.format(date);

		// String path = System.getProperty("user.dir") + ".\\ScreenShot\\Reports" +
		// File.separator + name + timestamp + ".png";
		String path = System.getProperty("user.dir") + ".\\ScreenShot\\Reports" + File.separator + timestamp + ".png";

		// Convert the WebDriver instance to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture the screenshot as a File
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			// Specify the destination path for the screenshot
			File destFile = new File(path);

			// Copy the screenshot to the destination path using FileUtils from Apache
			// Commons IO
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot captured: " + destFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage()); 
		}
	}

}
