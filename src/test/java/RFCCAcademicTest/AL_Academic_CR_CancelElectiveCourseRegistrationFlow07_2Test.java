package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.BaseClass;
import RFCCAcademic.AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2;

public class AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 CancelBulkCourseRegistration;
	HomePageAdmin HP;
	
	
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
	public void aL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2Test() throws Exception {

		CancelBulkCourseRegistration = new AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2(driver);

		test = reports.createTest("aL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2Test");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic > Coordinator Related -> Cancel Course Registration");

		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.Academic();
		threadWait1();

		Thread.sleep(5000);
		CancelBulkCourseRegistration.CoordinatorRelated();

		threadWait1();
		CancelBulkCourseRegistration.Cancelcourse();

		threadWait1();
		CancelBulkCourseRegistration.CancelStudent();

		threadWait1();
		CancelBulkCourseRegistration.SelectSession();

		threadWait1();
		CancelBulkCourseRegistration.SelectSemester();

		threadWait1();
		CancelBulkCourseRegistration.RRNO();

		threadWait1();
		CancelBulkCourseRegistration.ShowButton();

		threadWait1();
		CancelBulkCourseRegistration.SelectAllChechBox();

		threadWait1();
		CancelBulkCourseRegistration.SubmitButton();
		Alert alert = driver.switchTo().alert();

		alert.accept();
		
		threadWait1();

		//Alert alert = driver.switchTo().alert();

		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Student Course Registration Cancelled Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

		alert.accept();
	}
}

