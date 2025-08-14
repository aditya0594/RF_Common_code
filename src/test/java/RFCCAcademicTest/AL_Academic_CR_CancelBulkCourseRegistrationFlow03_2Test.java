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

import RFCCAcademic.AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 cancelbulkcourse;
	
	
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
	public void aL_Academic_CR_CancelBulkCourseRegistrationFlow03_2Test() throws Exception {

		cancelbulkcourse = new AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_CancelBulkCourseRegistrationFlow03_2Test");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic > Coordinator Related -> Cancel Course Registration -> Cancel Bulk Course Registration");

		threadWait1();
		HP.Academic();

		threadWait1();
		HP.Academic_CoordinatorRelated();

		threadWait1();
		cancelbulkcourse.Click_CancelCourseRegistration();

		threadWait1();
		cancelbulkcourse.Click_CancelBulkStudentCourseRegistration();
		
		threadWait1();
		cancelbulkcourse.Select_Session();
		
		threadWait1();
		cancelbulkcourse.Select_CollegeAndScheme();
		
		threadWait1();
		cancelbulkcourse.Select_Department();
		
		threadWait1();
		cancelbulkcourse.Select_Semester();
		
		threadWait1();
		cancelbulkcourse.Select_Course();
		
		threadWait1();
		cancelbulkcourse.Click_ShowBtn();
		
		threadWait1();
		cancelbulkcourse.Search_Student_Click_Chkbox();
		
		threadWait1();
		cancelbulkcourse.Click_SubmitBtn();
		acceptAlert();
		threadWait1();
		Alert alert = driver.switchTo().alert();

		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Student Course Registration Cancelled Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);
		threadWait1();
		alert.accept();
	}
}
