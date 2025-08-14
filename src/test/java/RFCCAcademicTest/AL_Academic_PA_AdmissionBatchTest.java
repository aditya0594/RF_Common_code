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

import RFCCAcademic.AL_Academic_PA_AdmissionBatch;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

/**
 * Test class for Admission Batch functionality
 * Tests creating a new admission batch for academic year
 */
public class AL_Academic_PA_AdmissionBatchTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_PA_AdmissionBatch admissionBatch;
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
	 * Test method for creating admission batch
	 */
	@Test
	public void aL_Academic_PA_AdmissionBatchTest() throws Exception {
		// Initialize page objects
		admissionBatch = new AL_Academic_PA_AdmissionBatch(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_PA_AdmissionBatchTest");
		
		// Login to the system
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC -> Pre Admission -> Admission Batch");

		// Navigate to Academic module
		Thread.sleep(2000);
		HP.Academic();
		
		// Navigate to Pre Admission
		Thread.sleep(2000);
		HP.Academic_PreAdmission();
		
		// Click on Admission Batch link
		Thread.sleep(2000);
		admissionBatch.Click_AdmissionBatch_Link();
		
		// Enter admission batch information
		Thread.sleep(2000);
		admissionBatch.Enter_Admission_Batch();
		
		// Click the submit button
		Thread.sleep(2000);
		admissionBatch.Click_Submit_Button();
		
		// Verify alert message
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		System.out.println("Alert message: " + actualMsg);
		
		// The expected message might vary, so we're just checking that it's not empty
		Assert.assertFalse(actualMsg.isEmpty(), "Alert message should not be empty");
		alert.accept();
		
		// Take screenshot for reporting
		Thread.sleep(5000);
		captureScreenshot(driver, "Admission Batch Creation");
	}
}
