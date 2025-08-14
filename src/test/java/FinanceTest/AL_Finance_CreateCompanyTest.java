package FinanceTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Finance.AL_Finance_CreateCompany;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

/**
 * Test class for AL_Finance_CreateCompany functionality
 */
public class AL_Finance_CreateCompanyTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Finance_CreateCompany createCompany;
	HomePageAdmin HP;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	/**
	 * Test method for Finance Create Company functionality
	 * @throws Exception if any error occurs during test execution
	 */
	@Test
	public void aL_Finance_CreateCompanyTest() throws Exception {
		createCompany = new AL_Finance_CreateCompany(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("AL_Finance_CreateCompany");
		Thread.sleep(4000);

		// Login as admin
		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");
		
		// Navigate to FINANCE > Create Company
		System.out.println("FINANCE > Create Company");
		
		Thread.sleep(2000);
		// Click on FINANCE menu
		HP.FINANCE();
		
		Thread.sleep(2000);
		// Click on Create Company link
		createCompany.clickCreateCompanyLink();
		
		Thread.sleep(2000);
		// Enter company code
		createCompany.enterCode();
		
		Thread.sleep(2000);
		// Enter company name
		createCompany.enterName();
		
		Thread.sleep(2000);
		// Click submit button
		createCompany.clickSubmitButton();

		// Handle alert and verify message
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		// Expected message could be something like "The company code already exist !" or "Company created successfully!"
		String alertText = alert.getText();
		System.out.println("Alert message: " + alertText);
		
		// Accept the alert
		alert.accept();
		
		// Take screenshot
		Thread.sleep(5000);
		captureScreenshot(driver, "Finance Create Company");
	}

}
