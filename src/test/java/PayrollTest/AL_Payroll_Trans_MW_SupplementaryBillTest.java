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

import Payroll.AL_Payroll_Trans_MW_SupplementaryBill;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_SupplementaryBillTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_SupplementaryBill supplementry_bill;
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
	public void aL_Payroll_Trans_MW_SupplementaryBillTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Monthly Work ==> Supplementary Bill");
		
	supplementry_bill = new AL_Payroll_Trans_MW_SupplementaryBill(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_SupplementaryBillTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(2000);
		supplementry_bill.SupplementaryBill();
		
		Thread.sleep(2000);
		supplementry_bill.Click_AddNew_btn();
		
		Thread.sleep(2000);
		supplementry_bill.Select_SupliBillDate();
		
		Thread.sleep(2000);
		supplementry_bill.Select_PayHead();
		
		Thread.sleep(2000);
		supplementry_bill.Enter_OrderNo();
		
		Thread.sleep(2000);
		supplementry_bill.Select_EmpName();
		
		Thread.sleep(2000);
		supplementry_bill.Enter_BasicPay();
		
		Thread.sleep(2000);
		supplementry_bill.Enter_GradePay();
		
		Thread.sleep(2000);
		supplementry_bill.Enter_Remark();
		
		Thread.sleep(2000);
		supplementry_bill.Enter_Percentage();
		
		Thread.sleep(2000);
		supplementry_bill.Click_Calculate_btn();
		
		Thread.sleep(2000);
		supplementry_bill.Click_Submit_btn();
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
	}
}
