package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.BaseClass;
import RFCCExtra.AL_Academic_CR_CancelElectiveCourseRegistration;

public class AL_Academic_CR_CancelElectiveCourseRegistrationTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CancelElectiveCourseRegistration CancelBulkCourseRegistration;
	
	/*
	 * public AL_Acadm_CR_CancelBulkCourseRegistrationTests(WebDriver rdriver) {
	 * driver = rdriver; PageFactory.initElements(rdriver, this); }
	 */
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void aL_Academic_CR_CancelElectiveCourseRegistrationTest() throws Exception {

		CancelBulkCourseRegistration = new AL_Academic_CR_CancelElectiveCourseRegistration(driver);

		test = reports.createTest("aL_Academic_CR_CancelElectiveCourseRegistrationTest");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic > Coordinator Related -> Cancel Course Registration");

		Thread.sleep(2000);
		CancelBulkCourseRegistration.ACADEMIC();

		Thread.sleep(5000);
		CancelBulkCourseRegistration.CoordinatorRelated();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.Cancelcourse();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.CancelStudent();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.SelectSession();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.SelectSemester();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.RRNO();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.ShowButton();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.SelectAllChechBox();

		Thread.sleep(2000);
		CancelBulkCourseRegistration.SubmitButton();
		Alert alert = driver.switchTo().alert();

		alert.accept();
		
		Thread.sleep(2000);

		//Alert alert = driver.switchTo().alert();

		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Student Course Registration Cancelled Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

		alert.accept();
	}
}

