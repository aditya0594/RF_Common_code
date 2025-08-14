package ELearningTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_CreateLectureNotesFlow02_2;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateLectureNotesFlow02_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_CreateLectureNotesFlow02_2 fl_ELearning_Trans_CreateLectureNotes;
	
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
	public void fL_ELearning_Trans_CreateLectureNotesTest() throws Throwable
	{
		test = reports.createTest("ELearning_CreateLectureNotes");
		homePageAdmin = new HomePageAdmin(driver);
		fl_ELearning_Trans_CreateLectureNotes = new FL_ELearning_Trans_CreateLectureNotesFlow02_2(driver);
		
		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(2000);
		//click on E-Learning Main Menu
		homePageAdmin.ELearning();

		Thread.sleep(2000);
		//click on Transactions submenu Menu
		homePageAdmin.ELearning_Transaction();
		
		Thread.sleep(2000);
		//Select Session
		fl_ELearning_Trans_CreateLectureNotes.select_session();
		
		Thread.sleep(2000);
		//Select Course
		fl_ELearning_Trans_CreateLectureNotes.select_course();
		
		Thread.sleep(2000);
		//Select lecture Notes link
		fl_ELearning_Trans_CreateLectureNotes.click_CreateLectureNotes_link();

		Thread.sleep(3000);
		//Select Topic
		fl_ELearning_Trans_CreateLectureNotes.select_topic();
		
		Thread.sleep(2000);
		// Enter Subtopic 
		fl_ELearning_Trans_CreateLectureNotes.enter_subTopic();
	
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CreateLectureNotes.click_fileUploader();

		Thread.sleep(2000);
		Path relativePath = Paths.get("src\\test\\resources\\documentsForTesting\\bcom-syllabus.pdf");
		String absolutePath = relativePath.toAbsolutePath().toString();

		StringSelection selection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Thread.sleep(3000);
		
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
		//Click Attach Button
		fl_ELearning_Trans_CreateLectureNotes.click_attachFile_button();
	
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	    Thread.sleep(2000);
	    //click on submit
	    fl_ELearning_Trans_CreateLectureNotes.click_submit_button();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
			
		String Expected_Msg = "Record Saved Successfully!";
		String Actual_Msg = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		acceptAlert();
	}

}
