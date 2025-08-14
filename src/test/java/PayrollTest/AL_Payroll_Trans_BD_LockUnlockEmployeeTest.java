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

import Payroll.AL_Payroll_Trans_BD_LockUnlockEmployee;
import Payroll.AL_Payroll_Trans_MW_SupplementaryBill;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_LockUnlockEmployeeTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_LockUnlockEmployee lockUnlock_emp;
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
	public void aL_Payroll_Trans_BD_LockUnlockEmployeeTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Basic Details ==> Lock/Unlock Employee");
		
		lockUnlock_emp = new AL_Payroll_Trans_BD_LockUnlockEmployee(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_BD_LockUnlockEmployeeTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.Payroll_Trans_BasicDetails();
		
		Thread.sleep(2000);
		lockUnlock_emp.LockUnlockEmployee();
		
		Thread.sleep(2000);
		lockUnlock_emp.Select_College();
		
		Thread.sleep(2000);
		lockUnlock_emp.Select_Staff();
		
		Thread.sleep(2000);
		lockUnlock_emp.Select_Department();
		
		Thread.sleep(2000);
		lockUnlock_emp.Select_OrderBy();
		
		Thread.sleep(2000);
		lockUnlock_emp.Click_ShowBtn();
		
		Thread.sleep(2000);
		lockUnlock_emp.Click_LockUnlockCheckBox();
		
		Thread.sleep(2000);
		lockUnlock_emp.Click_Submit_btn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(2000);
		lockUnlock_emp.Click_LockUnlockCheckBox();
		
		Thread.sleep(2000);
		lockUnlock_emp.Click_Submit_btn();
		
		Thread.sleep(2000); 
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Record Updated Successfully"; 
		String Actual_Msg1 = alert.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert1.accept();
	}
}
