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

import Payroll.AL_Payroll_Trans_MW_UpdatePayHead;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_UpdatePayHeadTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_UpdatePayHead update_payhead;
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
	public void aL_Payroll_Trans_MW_UpdatePayHeadTest() throws Exception {
	
		update_payhead = new AL_Payroll_Trans_MW_UpdatePayHead(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_UpdatePayHeadTest");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(4000);
		HP.PAYROLL();
		Thread.sleep(4000);
		HP.PAYROLL_Transactions();
		Thread.sleep(4000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(4000);
		update_payhead.Click_UpdatePayHead();
		
		Thread.sleep(4000);
		update_payhead.Select_Staff();
		
		Thread.sleep(4000);
		update_payhead.Select_EmployeeName();
		
		Thread.sleep(4000);
		update_payhead.Enter_EarningHead_Additional();
		
		Thread.sleep(4000);
		update_payhead.Enter_EarningHead_TA();
		
		Thread.sleep(4000);
		update_payhead.Enter_DeductionHeads_Bus();
		
		Thread.sleep(4000);
		update_payhead.Enter_DeductionHeads_Rent();
		
		Thread.sleep(4000);
		update_payhead.Click_Submit_btn();
		
		Thread.sleep(3000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
	}
}
