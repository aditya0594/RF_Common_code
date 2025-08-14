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

import Payroll.AL_Payroll_Trans_BD_OverRule;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_OverRuleTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_OverRule overRule;
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
	public void aL_Payroll_Trans_BD_OverRuleTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Basic Details ==> Over Rule");
		
		overRule = new AL_Payroll_Trans_BD_OverRule(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_BD_OverRuleTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.Payroll_Trans_BasicDetails();
		
		Thread.sleep(2000);
		overRule.OverRule();
		
		Thread.sleep(2000);
		overRule.Select_EmpName();
		
		Thread.sleep(2000);
		overRule.Select_FromDate();
		
		Thread.sleep(2000);
		overRule.Select_ToDate();
		
		Thread.sleep(2000);
		overRule.Enter_Amount();
		
		Thread.sleep(2000);
		overRule.Enter_BLoanAmount();
		
		Thread.sleep(2000);
		overRule.Remark();
		
		Thread.sleep(2000);
		overRule.Click_Submit_btn();
		
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
