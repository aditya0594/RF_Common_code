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

import Payroll.AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 lockUnlockSalary;
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
	public void aL_Payroll_Trans_MW_LockUnLockSalary_Flow1_03_2Test() throws Exception {
		
		System.out.println("Payroll==> Transaction ==> Monthly Work ==> Lock/UnLock Salary");
		
		lockUnlockSalary = new AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_LockUnLockSalary_Flow1_03_2Test");
		
		RF_AdminLoginPage.loginPage();
		
		threadWait1();
		HP.PAYROLL();
		
		threadWait1();
		HP.PAYROLL_Transactions();
		
		threadWait1();
		HP.PAYROLL_Trans_MonthlyWork();
		
		threadWait1();
		lockUnlockSalary.Click_LockUnlockSalary();
		
		threadWait1();
		lockUnlockSalary.Select_College();
		
		threadWait1();
		lockUnlockSalary.Enter_SearchText();
		
		threadWait1();
		lockUnlockSalary.DoubleClick_LockStatusField();
		
		threadWait1();
		lockUnlockSalary.Click_SaveButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Record Updated Successfully"; 
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message: " + actualMsg + "\nExpected Message: " + expectedMsg);
		threadWait1();
		alert.accept();
		
		System.out.println("UnLock Salary process completed successfully");
	}
}
