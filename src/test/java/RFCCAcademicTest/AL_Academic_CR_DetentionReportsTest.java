package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_DetentionReports;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_CR_DetentionReportsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_DetentionReports detainreport;
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
	public void aL_Academic_CR_DetentionReportsTest() throws IOException, Throwable 
 {
		
		detainreport = new AL_Academic_CR_DetentionReports(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_DetentionReportsTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Detention Reports "); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(2000);
		detainreport.Click_DetentionReports();
		
		Thread.sleep(2000);
		detainreport.Select_Session();
		
		Thread.sleep(4000);
		detainreport.Click_CancelDetentionReportBtn();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("Rajat","Cancel_Detention"); 
 	}
}
