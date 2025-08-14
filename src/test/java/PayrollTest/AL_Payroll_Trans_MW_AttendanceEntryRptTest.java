package PayrollTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_AttendanceEntry;
import Payroll.AL_Payroll_Trans_MW_AttendanceEntryRpt;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;


public class AL_Payroll_Trans_MW_AttendanceEntryRptTest extends BaseClass { 

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_AttendanceEntryRpt attendEntryrpt;
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
	public void aL_Payroll_Trans_MW_AttendanceEntryRptTest() throws Exception {
	
		attendEntryrpt = new AL_Payroll_Trans_MW_AttendanceEntryRpt(driver);
		excelutilitytest = new ExcelUtility(driver);

		test = reports.createTest("aL_Payroll_Trans_MW_AttendanceEntryRptTest");
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > TRANSACTION > Attendance Entry > Download Report");
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.PAYROLL();
		
		threadWait1();
		HP.PAYROLL_Transactions();
		
		threadWait1();
		attendEntryrpt.MonthlyWork();
		
		threadWait1();
		attendEntryrpt.AttendaneEntry();
		
		threadWait1();
		attendEntryrpt.SelectCollege();
		
		threadWait1();
		attendEntryrpt.SelectStaff();
		
		threadWait1();
		attendEntryrpt.Click_DownloadBtn();
		
		threadWait1();
		excelutilitytest.ReadExcel("PANNEERSELVAM","AttendanceEntry"); 
		 
	}

}
