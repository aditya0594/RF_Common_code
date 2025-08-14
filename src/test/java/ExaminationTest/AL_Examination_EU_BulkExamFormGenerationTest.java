package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_EU_BulkExamFormGeneration;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EU_BulkExamFormGenerationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EU_BulkExamFormGeneration exam_uti;
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
	public void aL_Examination_EU_BulkExamFormGenerationTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Exam Utility => Bulk Exam Form Generation");
		
		exam_uti = new AL_Examination_EU_BulkExamFormGeneration(driver);
		test = reports.createTest("aL_Examination_EU_BulkExamFormGenerationTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(5000);;
		exam_uti.Click_ExamUtility();
		
		Thread.sleep(5000);;
		exam_uti.Click_BulkExamFormGeneration();
		
		Thread.sleep(5000);;
		exam_uti.Select_College_Scheme();
		
		Thread.sleep(5000);;
		exam_uti.Select_Session();
		
		Thread.sleep(5000);;
		exam_uti.Select_Semister();
		
		Thread.sleep(5000);;
		exam_uti.Click_TypeAll_radio_btn();
		
		Thread.sleep(5000);;
		exam_uti.Click_ShowStudent_btn();
		
		Thread.sleep(5000);;
		exam_uti.Click_ChkBox();
		
		Thread.sleep(5000);;
		exam_uti.Click_GenerateExamForm();
		
		Thread.sleep(5000);; 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Are You Sure To Generate Exam Form.?"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}
}
