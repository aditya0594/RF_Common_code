package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_EM_ExamCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EM_ExamCreationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EM_ExamCreation examcreation;
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
	public void aL_Examination_EM_ExamCreationTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Master => Exam Creation");
		
		examcreation = new AL_Examination_EM_ExamCreation(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Examination_EM_ExamCreationTest");
		RF_AdminLoginPage.loginPage();
		
		
		threadWait1();
		HP.EXAMINATION();
		
		threadWait1();
		HP.Exam_ExaminationMaster();
		
		threadWait1();
		examcreation.Click_ExamCreation();
		
		threadWait1();
		examcreation.Select_ExamPattern();
		
		threadWait1();
		examcreation.Set_ExamName();
		
		threadWait1();
		examcreation.Select_ExamType();
		
		threadWait1();
		examcreation.Click_SubmitBtn();
		
		threadWait2();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Pattern Updated Successfully."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
