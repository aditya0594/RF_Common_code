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

import Payroll.AL_Payroll_Trans_MW_RegularDeductions;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_RegularDeductionsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_RegularDeductions regular_deduc;
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
	public void aL_Payroll_Trans_MW_RegularDeductionsTest() throws Exception {
	
		regular_deduc = new AL_Payroll_Trans_MW_RegularDeductions(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_MW_RegularDeductionsTest");
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(3000);
		regular_deduc.Click_RegularDeductions();
		
		Thread.sleep(3000);
		regular_deduc.Select_OrderBy();
		
		Thread.sleep(3000);
		regular_deduc.Select_CollegeName();
		
		Thread.sleep(3000);
		regular_deduc.Select_EmployeeName();
		
		Thread.sleep(3000);
		regular_deduc.Click_AddNewBtn();
		
		Thread.sleep(2000);
		regular_deduc.Select_PayHead();
		
		Thread.sleep(2000);
		regular_deduc.Enter_MonthlyDeductedAmount();
		
		Thread.sleep(2000);
		regular_deduc.Select_Bank();
		
		Thread.sleep(2000);
		regular_deduc.Select_BankPlace();
		
		Thread.sleep(2000);
		regular_deduc.Enter_AccountNumber();
		
		Thread.sleep(2000);
		regular_deduc.Click_Submit_Btn();
		
		Thread.sleep(2000);
		regular_deduc.Click_Save_Btn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
		
	}
}
