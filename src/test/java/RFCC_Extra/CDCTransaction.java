package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import utility.Screenshot;

public class CDCTransaction extends BaseClass {

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
	public void cDCstudent_Related() throws Exception {
		test = reports.createTest("CDCstudent_Related");

		Thread.sleep(2000);
		RF_StudentLoginPage.loginPage();

		System.out.println("Student Logged in Successfully");
//		//for handling alert
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		Thread.sleep(2000);
		WebElement Cdcele = driver.findElement(By.linkText("CDC"));
		System.out.println("Student CDC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Cdcele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Student CDC Transaction submenu selected");
		action.moveToElement(subMenu);

		// build()- used to compile all the actions into a single step
		action.click().build().perform();

		Thread.sleep(2000);
		WebElement TPCategory = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		TPCategory.click();
		System.out.println("TP Catergory update button clicked");

		// Application Catergory type field
//		WebElement CategoryTypDropdwn = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlApplicationType-container"));
//		CategoryTypDropdwn.click();
		System.out.println("Application catergory dropdown field clicked");
		Thread.sleep(2000);
		WebElement Obj = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlApplicationType-container"));
		Obj.click();

		Thread.sleep(2000);
		System.out.println("Application Category Type -> Entrepreneurship");
		driver.findElement(By.className("select2-search__field")).sendKeys("Entrepreneurship", Keys.ENTER);
		System.out.println("Entrepreneurship Application category is selected");

		Thread.sleep(2000);
		System.out.println("Category Description -> Public Speaker");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtcategorydescription")).sendKeys("Public Speaker");

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnTPSubmitType")).click();
		System.out.println("Click Submit Button");


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
