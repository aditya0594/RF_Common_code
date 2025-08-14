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

import RFCCAcademic.AL_Academic_AP_ImportStudentData;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_ImportStudentDataTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_ImportStudentData importstudent;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
	
	
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_AP_ImportStudentDataTest() throws Throwable {
		
		importstudent = new AL_Academic_AP_ImportStudentData(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_ImportStudentDataTest"); 
		threadWait1();
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Import Student Data"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_AdmissionProcess();
		
		threadWait1();
		importstudent.Click_ImportStudentData();
		
		threadWait1();
		importstudent.Select_AdmissionBatch();
		
		threadWait1();
		importstudent.Select_Degree();
		
		threadWait1();
		importstudent.Select_ChooseFile();
		
		acceptAlert();
	}
}
