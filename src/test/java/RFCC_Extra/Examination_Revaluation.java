package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Examination_Revaluation extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting: " + m.getName() + "******" + "\n");
	}

	@Test
	public void StudentExamination_Revaluation() throws Exception {
		test = reports.createTest("StudentExamination_Revaluation");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();

		System.out.println("Student Logged in Successfully");
		Thread.sleep(1000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform(); 

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Revaluation"));
		System.out.println("Revaluation submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

//    	String s1 = driver.switchTo().alert().getText();
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
//		System.out.println("Alert Text is:" +s1);
	}
}
