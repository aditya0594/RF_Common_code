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

import Payroll.AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile;
import Payroll.AL_Payroll_Trans_MW_SupplementaryBill;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_ChangesInMonthlySalaryFileTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile change_salary;
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
	public void aL_Payroll_Trans_MW_ChangesInMonthlySalaryFileTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Transaction ==> Monthly Work ==> Changes In Monthly Salary File");
		
		change_salary = new AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_ChangesInMonthlySalaryFileTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_MonthlyWork();
		
		Thread.sleep(2000);
		change_salary.ChangesInMonthlySalaryFile();
		
		Thread.sleep(2000);
		change_salary.Select_MonthYear();
		
		Thread.sleep(2000);
		change_salary.Select_PayHead();
		
		Thread.sleep(2000);
		change_salary.Select_College();
		
		Thread.sleep(2000);
		change_salary.Select_StaffScheme();
		
		Thread.sleep(2000);
		change_salary.Select_OrderBy();
		
		Thread.sleep(2000);
		change_salary.Click_Show_btn();
		
		Thread.sleep(2000);
		change_salary.Click_Submit_btn();
		
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
