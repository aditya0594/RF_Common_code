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
import Payroll.AL_Payroll_Trans_MW_ExcelUploadPayHeads;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_ExcelUploadPayHeadsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_ExcelUploadPayHeads excel_payHead;
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
	public void aL_Payroll_Trans_MW_ExcelUploadPayHeadsTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Basic Details ==> Excel Upload Pay Heads");
		
		excel_payHead = new AL_Payroll_Trans_MW_ExcelUploadPayHeads(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_ExcelUploadPayHeadsTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		threadWait1();;
		HP.PAYROLL_Transactions();
		threadWait1();;
		HP.PAYROLL_Trans_MonthlyWork();
		
		threadWait1();;
		excel_payHead.ExcelUploadPayHeads();
		
		threadWait1();;
		excel_payHead.Select_PayHead();
		
		threadWait1();
		excel_payHead.Click_UploadExcelSheet();
		
		threadWait1();;
		excel_payHead.Click_Upload_btn();
		
		threadWait1();
//		Alert alert =  driver.switchTo().alert();
//		String Expected_Msg = "Data Updated Successfully!!"; 
//		String Actual_Msg = alert.getText();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
//		alert.accept();  
		acceptAlert();
	}
}
