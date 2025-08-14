package ELearningTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageFaculty;

import ELearning.FL_ELearning_Trans_CreateElibraryFlow01_1;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateElibraryFlow01_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageFaculty homePageFaculty;
	FL_ELearning_Trans_CreateElibraryFlow01_1 fl_ELearning_Trans_CreateElibrary;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}
	
	@Test
	public void fL_ELearning_Trans_CreateElibraryFlow01_1Test() throws Throwable
	{
		homePageFaculty = new HomePageFaculty(driver);
		fl_ELearning_Trans_CreateElibrary = new FL_ELearning_Trans_CreateElibraryFlow01_1(driver);
		test = reports.createTest("fL_ELearning_Trans_CreateElibraryFlow01_1Test"); 

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(2000);
		//Click main E-Learning Menu
		homePageFaculty.ELEARNING(); 
		
		Thread.sleep(2000);
		//Click Transactions submenu
		homePageFaculty.Elearning_Trans();
		
		Thread.sleep(2000);
		//Select Session
		fl_ELearning_Trans_CreateElibrary.select_Session();
		
		Thread.sleep(2000);
		//Select Course
		fl_ELearning_Trans_CreateElibrary.select_Course();
		
		Thread.sleep(2000);
		//click ok button
		fl_ELearning_Trans_CreateElibrary.Click_OkButton();
		
		Thread.sleep(2000);
		//Click E-Library Submenu
		fl_ELearning_Trans_CreateElibrary.click_CreateELibrary();
		
		Thread.sleep(2000);
		//Enter Title
		fl_ELearning_Trans_CreateElibrary.enter_BookTitle();
		
		Thread.sleep(2000);
		//Enter Author
		fl_ELearning_Trans_CreateElibrary.enter_BookAuthor();
		
		Thread.sleep(2000);
		//Enter Publisher
		fl_ELearning_Trans_CreateElibrary.enter_PublisherName();
		
		//upload file
		fl_ELearning_Trans_CreateElibrary.upload_File();

		Thread.sleep(2000);
		Path relativePath = Paths.get("src\\test\\resources\\documentsForTesting\\bcom-syllabus.pdf");
		String absolutePath = relativePath.toAbsolutePath().toString();
		StringSelection selection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.delay(300);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(200);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File Added added Successfully");
		
		Thread.sleep(2000);
		//Click Attach		
		fl_ELearning_Trans_CreateElibrary.click_Attach_Button();
		
		Thread.sleep(2000);
		//Click Submit
		fl_ELearning_Trans_CreateElibrary.click_Submit_Button();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "E-Book added successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}

}
