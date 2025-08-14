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

import Payroll.AL_Payroll_Trans_MW_DonationEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_DonationEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_DonationEntry donation_entry;
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
	public void aL_Payroll_Trans_MW_DonationEntryTest() throws Exception {
	
		donation_entry = new AL_Payroll_Trans_MW_DonationEntry(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_MW_DonationEntryTest");
		System.out.println("Payroll==> Transaction ==> Monthly Work ==> Donation Entry");
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		threadWait1();
		HP.PAYROLL();
		threadWait1();
		HP.PAYROLL_Transactions();
		threadWait1();
		HP.PAYROLL_Trans_MonthlyWork();
		
		threadWait1();
		donation_entry.Click_DonationEntry();
		
		threadWait1();
		donation_entry.Click_AddNewBtn();
		
		threadWait1();
		donation_entry.Set_MonthForSalaryDonation();
		
		threadWait1();
		donation_entry.Select_CollegeName();
		
		threadWait1();
		donation_entry.Select_StaffScheme();
		
		threadWait1();
		donation_entry.Enter_GiveDaysOfSalaryDeduct();
		
		threadWait1();
		donation_entry.Select_PayheadForTransferSalary();
		
		threadWait1();
		donation_entry.Click_Submit_Btn();
		
		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		
		// Delete record from grid
		threadWait2();
		donation_entry.Click_DeleteRecord();
	}
}
