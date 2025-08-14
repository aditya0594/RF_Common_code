package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.qa.pages.academic.AL_Acadm_CR_BulkCourseRegistration;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_PEA_InvigilatorEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_PEA_InvigilatorEntryTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_PEA_InvigilatorEntry Invigi_Entry;
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
	public void aL_Examination_PEA_InvigilatorEntryTest() throws InterruptedException {
		Invigi_Entry = new AL_Examination_PEA_InvigilatorEntry(driver);
		
		test = reports.createTest("InvigilatorEntryPage");
		RF_AdminLoginPage.loginPage();

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();

		Thread.sleep(5000);
		Invigi_Entry.PreExaminationActivity();
		
		Thread.sleep(5000);
		Invigi_Entry.InvigilatorEntry();
		
		Thread.sleep(5000);
		Invigi_Entry.InvigilatorMaster();
		
		Thread.sleep(5000);
		Invigi_Entry.SubmitBtn();

		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Invigilator Entry Done ...!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(5000); 
		alert.accept();
	}
			
}
