package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import utility.Screenshot;

public class Student_CDCTransaction extends BaseClass {
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
	public void tP_Category_Update_TandP_APPLICATION_CATEGORY() throws Exception {
		test = reports.createTest("student_CDC");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();

		System.out.println("Student Logged in Successfully");
//		//for handling alert
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		Thread.sleep(3000);
		WebElement Cdcele = driver.findElement(By.linkText("CDC"));
		System.out.println("Admin CDC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Cdcele).perform();

		// Locating the element from Sub Menu
		Thread.sleep(2000);
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Admin CDC Transaction submenu selected");
		action.moveToElement(subMenu);
		// build()- used to compile all the actions into a single step
		action.click().build().perform();

		System.out.println("Select Application Category Type : Placement");
		WebElement cate_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlApplicationType"));
		Select app_cat_typ = new Select(cate_typ);
		app_cat_typ.selectByVisibleText("Placement");
		Thread.sleep(2000);
		// Note: Take every time new student of Degree Name :Bachelor of Technology
		// Branch / Programme :Computer Science and Engineering(Cyber Security)
		// semester- III

		System.out.println("Click on Submit Button");
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnTPSubmitType"));
		btn_submit.click();
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Are you sure you want to Submit !";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(2000);
		String Expected_Msgs = "You Are Not Eligible For Application Category Registration !";
		String Actual_Msgs =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msgs, Expected_Msgs, "Actual and Expected Msg matched");
		alert.accept();

	
		
		Thread.sleep(5000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());

	}

}
