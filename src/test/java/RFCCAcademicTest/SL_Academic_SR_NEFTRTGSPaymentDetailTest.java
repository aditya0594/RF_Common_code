package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.SL_Academic_SR_NEFTRTGSPaymentDetail;
import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

/**
 * Test class for SL_Academic_SR_NEFTRTGSPaymentDetail functionality
 */
public class SL_Academic_SR_NEFTRTGSPaymentDetailTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	SL_Academic_SR_NEFTRTGSPaymentDetail neftRtgsPayment;
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
	 * Test method for NEFT/RTGS payment details
	 * @throws Exception if any error occurs during test execution
	 */
	@Test
	public void sL_Academic_SR_NEFTRTGSPaymentDetailTest() throws Exception {
		neftRtgsPayment = new SL_Academic_SR_NEFTRTGSPaymentDetail(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("SL_Academic_SR_NEFTRTGSPaymentDetailTest");
		Thread.sleep(4000);

		// Login as student
		RF_StudentLoginPage.loginPage();
		System.out.println("Student Logged in Successfully");
		
		// Navigate to Academic -> Student Related
		System.out.println("ACADEMIC > Student Related > NEFT/RTGS Payment Detail");
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		// Click on Student Related submenu
		
		HP.Academic_StudentRelated();
		Thread.sleep(2000);
		// Click on NEFT/RTGS Payment Details link
		neftRtgsPayment.Click_NEFTRTGSDetails_Link();
		
		Thread.sleep(2000);
		// Select Receipt Type
		neftRtgsPayment.Select_ReceiptType();
		
		Thread.sleep(2000);
		// Select Semester
		neftRtgsPayment.Select_Semester();
		
		Thread.sleep(2000);
		// Enter Transaction ID
		neftRtgsPayment.Enter_Transaction_ID();
		
		Thread.sleep(2000);
		// Select Date
		neftRtgsPayment.Select_Date();
		
		Thread.sleep(2000);
		// Enter Bank Name
		neftRtgsPayment.Enter_Bank_Name();
		
		Thread.sleep(2000);
		// Enter Amount
		neftRtgsPayment.Enter_Amount();
		
		Thread.sleep(2000);
		// Upload File
		neftRtgsPayment.Upload_File();
		
		Thread.sleep(2000);
		// Scroll to Submit Button
		neftRtgsPayment.Scroll_To_Submit_Button();
		
		Thread.sleep(2000);
		// Click Submit Button
		neftRtgsPayment.Click_Submit_Button();

		// Handle alert and verify message
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Payment Details Is Already Exists.";  
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg, "Alert message validation failed");
		 
		// Accept the alert
		alert.accept();
		
		// Take screenshot
		Thread.sleep(5000);
		captureScreenshot(driver, "NEFT RTGS Payment");
	}
}
