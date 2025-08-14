package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class StudentRelated_RedoCourseCertification extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "\n");
	}
	
	@Test
	public void redo_Course_Registration() throws Exception
	{
		test=reports.createTest("Student_RedoCourse_Registration");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		
		System.out.println("Student Logged in Successfully");
		 Thread.sleep(1000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);
	    
	    Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Student Related"));
		System.out.println("Student Related submenu selected");
		action.moveToElement(subMenu);
		//build()- used to compile all the actions into a single step 
		action.click().build().perform();
		
		WebElement opt = driver.findElement(By.id("ctl00_repLinks_ctl07_lbLink"));
		opt.click();
		System.out.println("Click Redo Course Registration");
		Thread.sleep(2000);
		
		//This Activity has been Stopped. Contact Admin.!!
//		
//		String s1 = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" +s1);
		
		//Note: Unable to proceed further due to error from Admin side
	}

}
