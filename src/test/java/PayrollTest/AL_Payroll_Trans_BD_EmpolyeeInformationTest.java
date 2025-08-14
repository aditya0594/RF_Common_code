package PayrollTest;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_BD_EmpolyeeInformation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_EmpolyeeInformationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_EmpolyeeInformation emp_info;
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
	public void aL_Payroll_Trans_BD_EmpolyeeInformationTest() throws Exception {
	
		emp_info = new AL_Payroll_Trans_BD_EmpolyeeInformation(driver);
		
		
		
		test = reports.createTest("aL_Payroll_Trans_BD_EmpolyeeInformationTest");
		Thread.sleep(5000);;
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > TRANSACTION > Basic Details > Employee Information");
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(5000);;
		emp_info.Transactions();
		
		Thread.sleep(5000);;
		emp_info.BasicDetails();
		
		// Click Search Employee modification tab
		
		Thread.sleep(5000);;
		emp_info.Click_PersonalDetails();
		
		Thread.sleep(5000);;
		emp_info.Enter_StaffId_EmpCode();
		
		Thread.sleep(5000);;
		emp_info.Enter_BioId_RfID();
		
		Thread.sleep(5000);;
		emp_info.Select_Title();
		
		Thread.sleep(5000);;
		emp_info.Enter_FirstName();

		Thread.sleep(5000);;
		emp_info.Enter_LastName();
		
		Thread.sleep(6000);
		emp_info.Enter_DepatSenorityNo();
		
		Thread.sleep(5000);;
		emp_info.Enter_MobNum();
		
		// Service Type Details
		
		Thread.sleep(6000);
		emp_info.Click_ServiceTypeDetails();
		
		Thread.sleep(5000);;
		emp_info.Select_College();
		
		Thread.sleep(5000);
		emp_info.Select_SchemeStaff();
		
		Thread.sleep(5000);
		emp_info.Select_Designation();
		
		Thread.sleep(5000);;
		emp_info.Select_LeaveCategory();
		
		Thread.sleep(5000);
		emp_info.Select_Department();
		
		Thread.sleep(5000);
		emp_info.Select_Appointment();
		
		Thread.sleep(5000);
		emp_info.Select_UserType();
		
		Thread.sleep(5000);
		emp_info.Select_EmployeeType();
		

		Thread.sleep(5000);
		emp_info.Click_ServiceTypeDetails();
		// Pay-Scale Details
		
		Thread.sleep(5000);;
		emp_info.Click_PayScaleDetails();
		
		Thread.sleep(5000);;
		emp_info.Select_Rule();
		
		Thread.sleep(5000);;
		emp_info.Enter_PresentBasic();
		
		Thread.sleep(5000);;
		emp_info.Click_SubmiBtn();
		
		//Switch to Alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(5000);;
		alert.accept();

	}
}
