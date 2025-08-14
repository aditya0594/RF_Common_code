package CDCTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import CDC.AL_CDC_Reports_TPOStudentDetailReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_CDC_Reports_TPOStudentDetailReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;

	AL_CDC_Reports_TPOStudentDetailReport tpoStudentDetailReport;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n");
	}
	
	@Test
	public void aL_CDC_Reports_TPOStudentDetailReportTest() throws Throwable 
	{
		test = reports.createTest("aL_CDC_Reports_TPOStudentDetailReportTest");
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(1000);
		
		System.out.println("CDC -> Reports -> TPO Student Detail Report");
		
		tpoStudentDetailReport = new AL_CDC_Reports_TPOStudentDetailReport(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		Thread.sleep(2000);
		HP.CDC();
		
		Thread.sleep(2000);
		HP.CDC_Reports();
		
		Thread.sleep(2000);
		tpoStudentDetailReport.clickTPOStudentDetailReport();
		
		Thread.sleep(2000);
		tpoStudentDetailReport.selectCollege();
		
		Thread.sleep(2000);
		tpoStudentDetailReport.selectSession();
		
		Thread.sleep(2000);
		tpoStudentDetailReport.selectDegree();
		
		Thread.sleep(2000);
		tpoStudentDetailReport.clickExcelReportBtn();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("SANKET", "TP_StudentDetailedReport");
	}
}
