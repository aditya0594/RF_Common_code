package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_MonthlyInstallmentEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_MonthlyInstallmentEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_MonthlyInstallmentEntry monthly_installment;
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
	public void aL_Payroll_Trans_MW_MonthlyInstallmentEntryTest() throws Exception {
	
		monthly_installment = new AL_Payroll_Trans_MW_MonthlyInstallmentEntry(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_MW_MonthlyInstallmentEntryTest");
		System.out.println("Payroll==> Transaction ==> Monthly Work ==> Monthly Installment Entry");

		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(2000);
		monthly_installment.Select_OrderBy();
		
		Thread.sleep(2000);
		monthly_installment.Select_CollegeName();
		
		Thread.sleep(2000);
		monthly_installment.Select_EmployeeName();
		
		Thread.sleep(2000);
		monthly_installment.Click_AddNewBtn();
		
		Thread.sleep(2000);
		monthly_installment.Select_PayHead();
		
		Thread.sleep(2000);
		monthly_installment.Enter_MonthlyDeductedAmount();
		
		Thread.sleep(2000);
		monthly_installment.Enter_TotalNoOfInstallments();
		
		Thread.sleep(2000);
		monthly_installment.Select_Bank();
		
		Thread.sleep(2000);
		monthly_installment.Select_BankPlace();
		
		Thread.sleep(2000);
		monthly_installment.Enter_AccountNumber();
		
		Thread.sleep(2000);
		monthly_installment.Set_InstallmentDrawnDate();
		
		Thread.sleep(2000);
		monthly_installment.Set_StartDate();
		
		Thread.sleep(2000);
		monthly_installment.Click_Submit_Btn();
		
		Thread.sleep(2000);
		captureScreenshot(driver, "Monthly Installment Entry");
		
		Thread.sleep(2000);
		monthly_installment.Click_DeleteRecord();
	}
}
