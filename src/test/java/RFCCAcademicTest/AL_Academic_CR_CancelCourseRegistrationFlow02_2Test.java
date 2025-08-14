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

import RFCCAcademic.AL_Academic_CR_CancelCourseRegistrationFlow02_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_CancelCourseRegistrationFlow02_2Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_CR_CancelCourseRegistrationFlow02_2 cancelcourse;
	
	
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
	public void aL_Academic_CR_CancelCourseRegistrationFlow02_2Test() throws Exception {

		cancelcourse = new AL_Academic_CR_CancelCourseRegistrationFlow02_2(driver);
		homePageAdmin = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_CancelCourseRegistrationFlow02_2Test");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic > Coordinator Related -> Cancel Course Registration");

		Thread.sleep(3000);
		homePageAdmin.Academic();

		Thread.sleep(5000);
		homePageAdmin.Academic_CoordinatorRelated();

		Thread.sleep(3000);
		cancelcourse.Click_CancelCourseRegistration();

		Thread.sleep(3000);
		cancelcourse.Click_CancelSingleStudentCourseRegistration();

		Thread.sleep(3000);
		cancelcourse.Select_Session();

		Thread.sleep(3000);
		cancelcourse.Select_Semester();

		Thread.sleep(3000);
		cancelcourse.Enter_RRNO();

		Thread.sleep(3000);
		cancelcourse.ShowButton();
		
		Thread.sleep(3000);
		cancelcourse.Search_Subject();

		Thread.sleep(3000);
		cancelcourse.Click_ChechBox();

		Thread.sleep(4000);
		cancelcourse.Click_SubmitButton();

		acceptAlert();
		
		Thread.sleep(4000);

		Alert alert = driver.switchTo().alert();

		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Student Course Registration Cancelled Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);

		alert.accept();
	}
}
