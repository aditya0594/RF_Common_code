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

import Payroll.AL_Payroll_Trans_BD_EmployeeBulkUpdate;
import Payroll.AL_Payroll_Trans_BD_SequenceNumberAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_EmployeeBulkUpdateTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_EmployeeBulkUpdate emp_bulk_update;
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
	public void aL_Payroll_Trans_BD_EmployeeBulkUpdateTest() throws Exception {
	
		emp_bulk_update = new AL_Payroll_Trans_BD_EmployeeBulkUpdate(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_BD_EmployeeBulkUpdateTest");
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > TRANSACTION > Basic Details > Employee Bulk Update");
		Thread.sleep(2000);
		
		HP.PAYROLL();
		HP.PAYROLL_Transactions();
		HP.Payroll_Trans_BasicDetails();

		Thread.sleep(2000);
		emp_bulk_update.Click_EmployeeBulkUpdate();
	
		Thread.sleep(2000);
		emp_bulk_update.Select_FieldStaff();
		
		Thread.sleep(2000);
		emp_bulk_update.Select_College();
		
		Thread.sleep(2000);
		emp_bulk_update.Select_SChemeStaff();
		
		Thread.sleep(2000);
		emp_bulk_update.Click_CheckBox();
		
		Thread.sleep(2000);
		emp_bulk_update.Enter_AdharCardNumber();
		
		Thread.sleep(2000);
		emp_bulk_update.Click_Submit_btn();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(1000);
		alert.accept();
	}
}
