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

import Payroll.AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 arr_cal;
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
	public void aL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1Test() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Monthly Work ==> Increment Arrears Calculation");
		
		arr_cal = new AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1Test");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(2000);
		arr_cal.IncrementArrearsCalculation();
		
		Thread.sleep(2000);
		arr_cal.Select_College();
		
		Thread.sleep(2000);
		arr_cal.Select_Staff();
		
		Thread.sleep(2000);
		arr_cal.Set_ArrearsFromDate();
		
		Thread.sleep(2000);
		arr_cal.Enter_GovOrderNum();
		
		Thread.sleep(2000);
		arr_cal.Enter_OfficeOrderNum();
		
		Thread.sleep(2000);
		arr_cal.Set_ToDate();
		
		Thread.sleep(2000);
		arr_cal.Click_ShowEmployeeBtn();
		
		Thread.sleep(2000);
		arr_cal.Click_CheckBox();
		
		Thread.sleep(3000);
		arr_cal.Click_CalculateBtn();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Arrears Calculated Sucessfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
	}
}
