package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_EU_BulkDuesStatusAllotment;
import Examination.AL_Examination_EU_BulkExamFormGeneration;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EU_BulkDuesStatusAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EU_BulkDuesStatusAllotment bulk_dues;
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
	
	@Test
	public void aL_Examination_EU_BulkDuesStatusAllotmentTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Exam Utility => Bulk Exam Form Generation");
		
		bulk_dues = new AL_Examination_EU_BulkDuesStatusAllotment(driver);
		test = reports.createTest("aL_Examination_EU_BulkDuesStatusAllotmentTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		threadWait1();;
		bulk_dues.Click_ExamUtility();
		
		threadWait1();;
		bulk_dues.Click_BulkDuesStatusAllotment();
		
		threadWait1();;
		bulk_dues.Select_Session();
		
		threadWait1();;
		bulk_dues.Select_SchoolInstituteName();
		
		threadWait1();;
		bulk_dues.Click_ShowStudent_btn();
		
		threadWait1();;
		bulk_dues.Click_CheckBox();
		
		threadWait1();;
		bulk_dues.Click_Submitbtn();
		
		threadWait1();; 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Student Dues Status Alloted Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();

	}
}
