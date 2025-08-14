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

import RFCCAcademic.AL_Academic_CR_ElectiveCourseRegistrationFlow07_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_CR_ElectiveCourseRegistrationFlow07_1Test extends BaseClass {
	// private WebDriver driver;
	// private String baseUrl;

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 al_Academic_CR_ElectiveCourseRegistration;
	PDFUtility pdfutility;

//	AL_Establishment_Trans_DirectLeaveApprovalReject ApproveLeaveReject;

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
	public void aL_Academic_CR_ElectiveCourseRegistrationFlow07_1Test() throws Exception {

		test = reports.createTest("aL_Academic_CR_ElectiveCourseRegistrationFlow07_1Test");
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_CR_ElectiveCourseRegistration = new AL_Academic_CR_ElectiveCourseRegistrationFlow07_1(driver);
		pdfutility =new PDFUtility(driver);	

		
		threadWait1();
		RF_AdminLoginPage.loginPage();

		// System.out.println("ESTBALISHMENT > Transactions > Leave Approwal > Select >
		// RejectLeave > Submit ");

		System.out.println("ACADEMIC->Coordinator related->Elective Course Registration");

		// Click on Academic from navigation bar
		homePageAdmin.Academic();
		Thread.sleep(3000);

		// Click on Coordinator related option
		homePageAdmin.Academic_CoordinatorRelated();
		Thread.sleep(3000);

		// Click on Elective Course Registration from sub menu
		al_Academic_CR_ElectiveCourseRegistration.click_electiveCourseReg_link();

		Thread.sleep(3000);
		al_Academic_CR_ElectiveCourseRegistration.select_college();
		
		Thread.sleep(3000);
		al_Academic_CR_ElectiveCourseRegistration.select_session();
		
		Thread.sleep(3000);
		al_Academic_CR_ElectiveCourseRegistration.select_semester();
		
		threadWait1();			
		al_Academic_CR_ElectiveCourseRegistration.select_section();
		
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.click_show_button();
		
		threadWait1(); 
		al_Academic_CR_ElectiveCourseRegistration.Select_CourseSegment();
		
		threadWait1(); 
		al_Academic_CR_ElectiveCourseRegistration.select_OfferedCourse();
		
		
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.search_student();
		
		
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.click_searchIcon();
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.select_checkbox();
		
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.click_submit_button();
		
		threadWait1();
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Student(s) Registered Successfully!!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
			
		threadWait1();
		al_Academic_CR_ElectiveCourseRegistration.click_report_button();
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Elective Course Registration");
		Thread.sleep(2000);
		pdfutility.readPDF("Academic - Elective Course Registration", "MOHAMED");	

	}
}
