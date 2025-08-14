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

import Payroll.AL_Payroll_Trans_BD_EmpolyeeInformation;
import Payroll.AL_Payroll_Trans_BD_SequenceNumberAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_SequenceNumberAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Payroll_Trans_BD_SequenceNumberAllotment seq_num;

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
	public void aL_Payroll_Trans_BD_SequenceNumberAllotmentTest() throws Exception {
		
		test = reports.createTest("aL_Payroll_Trans_BD_SequenceNumberAllotmentTest");
		
		homePageAdmin = new HomePageAdmin(driver);
		seq_num = new AL_Payroll_Trans_BD_SequenceNumberAllotment(driver);
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > TRANSACTION > Basic Details > Sequence Number Allotment");
		
		Thread.sleep(2000);
		homePageAdmin.PAYROLL();
			
		Thread.sleep(2000);
		homePageAdmin.PAYROLL_Transactions();
		
		Thread.sleep(2000);
		homePageAdmin.Payroll_Trans_BasicDetails();
		//seq_num.BasicDetails();
		
		Thread.sleep(2000);
		seq_num.Click_SequenceNumberAllotment();
		
		Thread.sleep(2000);
		seq_num.Select_College();
		
		Thread.sleep(2000);
		seq_num.Select_SChemeStaff();
		
		Thread.sleep(2000);
		seq_num.Select_EmployeeType();
		
		Thread.sleep(2000);
		seq_num.Select_Department();
		
		Thread.sleep(2000);
		seq_num.Select_OrderBy();
		
		Thread.sleep(2000);
		seq_num.Edit_seq_num();
		
		Thread.sleep(4000);
		seq_num.Click_Submit_btn();
		
		Thread.sleep(4000);
		// Switch To Alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(1000);
		alert.accept();

	}
}
