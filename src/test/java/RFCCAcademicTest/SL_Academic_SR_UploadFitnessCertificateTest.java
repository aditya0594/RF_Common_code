package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.SL_Academic_SR_UploadFitnessCertificate;
import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

/**
 * Test class for Upload Fitness Certificate functionality
 */
public class SL_Academic_SR_UploadFitnessCertificateTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	SL_Academic_SR_UploadFitnessCertificate uploadFitnessCertificate;
	HomePageAdmin HP;
	
	/**
	 * Configure the ExtentReports before test execution
	 */
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	/**
	 * Launch the browser before each test method
	 * @param m test method being executed
	 */
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	/**
	 * Test method for uploading fitness certificate
	 */
	@Test
	public void sL_Academic_SR_UploadFitnessCertificateTest() throws Exception {
		// Initialize page objects
		uploadFitnessCertificate = new SL_Academic_SR_UploadFitnessCertificate(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("sL_Academic_SR_UploadFitnessCertificateTest");
		
		// Login to the system
		Thread.sleep(2000);
		RF_StudentLoginPage.loginPage();

		System.out.println("Academic --> Student Related --> Upload Fitness Certificate --> Fitness Certificate Submission");
		
		// Navigate to Academic module
		Thread.sleep(2000);
		HP.Academic();
		
		// Navigate to Student Related
		Thread.sleep(2000);
		HP.Academic_StudentRelated();
		
		// Click on Upload Fitness Certificate link
		Thread.sleep(2000);
		uploadFitnessCertificate.Click_Upload_Fitness_Certificate_Link();
		
		// Upload the fitness certificate file
		Thread.sleep(2000);
		uploadFitnessCertificate.Upload_Fitness_Certificate();
		
		// Click the upload button
		Thread.sleep(2000);
		uploadFitnessCertificate.Click_Upload_Button();
		
		// Verify alert message
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "File Uploaded Successfully";
		String actualMsg = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(actualMsg, expectedMsg, "Certificate upload confirmation message verification");
		alert.accept();
		
		// Preview the uploaded certificate
		Thread.sleep(2000);
		uploadFitnessCertificate.Click_Preview_Button();
		
		// Take screenshot for reporting
		Thread.sleep(5000);
		captureScreenshot(driver, "Upload Fitness Certificate");
	}
}
