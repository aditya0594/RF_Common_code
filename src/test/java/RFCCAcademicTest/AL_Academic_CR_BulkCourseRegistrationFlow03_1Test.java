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

import RFCCAcademic.AL_Academic_CR_BulkCourseRegistrationFlow03_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_CR_BulkCourseRegistrationFlow03_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_BulkCourseRegistrationFlow03_1 aL_Acadm_CR_BulkCourseRegistration;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	
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
	public void aL_Academic_CR_BulkCourseRegistrationFlow03_1Test() throws Exception {

		aL_Acadm_CR_BulkCourseRegistration = new AL_Academic_CR_BulkCourseRegistrationFlow03_1(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);	
		
		Actions action = new Actions(driver);
		test = reports.createTest("aL_Academic_CR_BulkCourseRegistrationFlow03_1Test");
		RF_AdminLoginPage.loginPage();
		System.out.println("Academic > Coordinator Related -> Bulk Course Registration");
		
		
		threadWait1();

		HP.Academic();
		threadWait1();


		Thread.sleep(5000);
		aL_Acadm_CR_BulkCourseRegistration.CoordinatorRelated();

		Thread.sleep(5000);
		aL_Acadm_CR_BulkCourseRegistration.BulkCourseRegistration();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.CollegeAndScheme();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Session();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Semester();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Section();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.ShowButton();
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.SearchStudent();
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.SelectCheckBoxStudent();
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Select_DeselctChkBox();
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Search_Select_Course();
		

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.SubmitButton();
		
		Thread.sleep(3000);		
		Alert alert = driver.switchTo().alert();

		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Student(s) Registered Successfully!!";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);

		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);
		
		alert.accept();
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.CollegeAndScheme();

		
		
		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Session();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Semester();

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.Section();
		

		threadWait1();
		aL_Acadm_CR_BulkCourseRegistration.RegistrationSlipReport();
		
		threadWait1();
	
		pdfutility.downloadPDF(driver, "Academic - Bulk Course Registration");
		threadWait1();
		pdfutility.readPDF("Academic - Bulk Course Registration", "ALAN ");	

	}
}
