package PayrollTest;

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

import Payroll.AL_Payroll_Trans_MW_ReleaseEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_ReleaseEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_ReleaseEntry releaseEntry;
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
	public void aL_Payroll_Trans_MW_ReleaseEntryTest() throws Exception {
		
		System.out.println("Payroll==> Transaction ==> Monthly Work ==> Release Entry");
		
		releaseEntry = new AL_Payroll_Trans_MW_ReleaseEntry(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_ReleaseEntryTest");
		
		RF_AdminLoginPage.loginPage();
		
		threadWait1();
		HP.PAYROLL();
		
		threadWait1();
		HP.PAYROLL_Transactions();
		
		threadWait1();
		HP.PAYROLL_Trans_MonthlyWork();
		
		threadWait1();
		releaseEntry.Click_ReleaseEntry();
		
		threadWait1();
		releaseEntry.Select_AllColleges();
		
		threadWait1();
		releaseEntry.Select_AllStaff();
		
		threadWait1();
		releaseEntry.Click_ShowButton();
		
		threadWait1();
		releaseEntry.Enter_WithdrawRemark();
		
		threadWait1();
		releaseEntry.Click_SaveButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Record Saved Successfully"; 
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message: " + actualMsg + "\nExpected Message: " + expectedMsg);
		threadWait1();
		alert.accept();
		
		System.out.println("Release Entry process completed successfully");
	}
}
