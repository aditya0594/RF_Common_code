package PayrollTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_AttendanceEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Trans_MW_AttendanceEntryTest extends BaseClass{

	
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_AttendanceEntry Trans_MonthlyWork_AttendanceEntry;
	HomePageAdmin HP;
	
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
	public void aL_Payroll_Trans_MW_AttendanceEntryTest() throws Exception {
	
		Trans_MonthlyWork_AttendanceEntry = new AL_Payroll_Trans_MW_AttendanceEntry(driver);
		
		test = reports.createTest("Trans_MonthlyWork_AttendanceEntry");
		threadWait1();
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > TRANSACTION > Monthly Work > Attendance Entry ");
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		threadWait1();
		Trans_MonthlyWork_AttendanceEntry.Transactions(); 
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.MonthlyWork();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.AttendaneEntry();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.SelectCollege();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.SelectStaff();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Click_ShowBtn();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Attendance1();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Attendance2();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Attendance3();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Attendance4();
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.Attendance5();
		
		
		threadWait1();;
		Trans_MonthlyWork_AttendanceEntry.SubmitButton();	
		
		threadWait1();;
		Alert alert = driver.switchTo().alert();

		threadWait1();;
		String alertText = alert.getText();

		threadWait1();; // expected alert text
		String expected = "Record Updated Successfully";
		String actual = alertText;
		Assert.assertEquals(actual, expected);
		System.out.println("Actual alert -> " + actual + "\n" + "Expected alert -> "+ expected);

		acceptAlert();
		
		threadWait1();;
		Screenshot.takesScreenshot(getCurrentDate());
		
	}
}
