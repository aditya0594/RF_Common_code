package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_Certificate;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AR_CertificateTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AR_Certificate certificate;
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
	public void aL_Academic_AR_CertificateTest() throws IOException, Throwable 
	{
		certificate = new AL_Academic_AR_Certificate(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AR_CertificateTest"); 
		threadWait1();
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Academic Reports > Certificate"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_AcademicReport();
		
		threadWait1();
		certificate.Click_Certificate();
		
		threadWait1();
		certificate.Select_AdmissionBatch();
		
		threadWait1();
		certificate.Select_Degree();
		
		threadWait1();
		certificate.Select_Program();
		
		threadWait1();
		certificate.Select_CertificateName();
		
		threadWait1();
		certificate.Select_Semister();
		
		threadWait1();
		certificate.Click_ShowButton();
		
		threadWait1();
		certificate.Click_CheckBox();
		
		threadWait1();
		certificate.Click_ConfirmButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Process Done Successfully !!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
