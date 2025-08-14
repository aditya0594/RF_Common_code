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

import RFCCAcademic.AL_Academic_CR_ModifyCourseRegistrationFlow02_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_CR_ModifyCourseRegistrationFlow02_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_CR_ModifyCourseRegistrationFlow02_1 modifycourse;
	
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
	public void aL_Academic_CR_ModifyCourseRegistrationFlow02_1Test() throws Exception {

		test = reports.createTest("aL_Academic_CR_ModifyCourseRegistrationFlow02_1Test");
		
		homePageAdmin = new HomePageAdmin(driver);
		modifycourse = new AL_Academic_CR_ModifyCourseRegistrationFlow02_1(driver);	
		pdfutility =new PDFUtility(driver);	

		
		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC=> Coordinator Related => Modify Course Registration");
		
		Thread.sleep(4000);		
		//Click on Academic from navigation bar
		homePageAdmin.Academic();
		
		Thread.sleep(4000);		
		//Click on Coordinator Related option
		homePageAdmin.Academic_CoordinatorRelated();
		
		Thread.sleep(4000);	
		modifycourse.Click_ModifyCourseRegistration();
		
		Thread.sleep(4000);	
		modifycourse.Select_Session();
		
		Thread.sleep(4000);	
		modifycourse.Select_SearchCriteria();
		
		Thread.sleep(4000);	
		modifycourse.Enter_SearchString();
		
		Thread.sleep(4000);	
		modifycourse.Click_SearchBtn();
		
		Thread.sleep(4000);	
		modifycourse.Click_Student();
		
		Thread.sleep(4000);	
		modifycourse.Select_CousreSegment();
		
		
		Thread.sleep(4000);	
		modifycourse.Click_CheckBox();
		
		Thread.sleep(4000);	
		modifycourse.Click_SubmitBtn();
		
		Thread.sleep(2000);	
		acceptAlert();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Subject Registration Successfully. Print the Registration Slip."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		Thread.sleep(4000);	
		modifycourse.Click_RegistrationSlipBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Modify Course Registration Slip");
		Thread.sleep(2000);
		pdfutility.readPDF("Academic - Modify Course Registration Slip", "MOHAMED");	

	}
}
