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

import Payroll.AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 diff_arr;
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
	public void aL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2Test() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Monthly Work ==> Increment Arrears Diff Report");
		
		diff_arr = new AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2Test");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(2000);
		diff_arr.IncrementArrearsDiffReport();
		
		Thread.sleep(2000);
		diff_arr.Select_College();
		
		Thread.sleep(2000);
		diff_arr.Select_Arreas();
		
		Thread.sleep(2000);
		diff_arr.Click_TransferBtn();
		
		Thread.sleep(4000);
		diff_arr.Select_Arreas_supply();
		
		Thread.sleep(2000);
		diff_arr.Enter_OrderNum();
		
		Thread.sleep(2000);
		diff_arr.Set_SuplDate();
		
		Thread.sleep(2000);
		diff_arr.Select_SuplBillHead();
		
		Thread.sleep(2000);
		diff_arr.Click_SaveBtn();
		
		Thread.sleep(2000);
		diff_arr.Click_Back_Btn();
		
		Thread.sleep(2000);
		diff_arr.Click_Report_Btn();
		
		Thread.sleep(3000);
		switchToNextWindow();
		
		Thread.sleep(2000);
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Increment Arrears Diff Report");
		
		Thread.sleep(1000);
		switchToFrameOrDefault();
		
		Thread.sleep(2000);
		diff_arr.Click_Delete_Btn();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Arrears Record Deleted Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		
	}
}
