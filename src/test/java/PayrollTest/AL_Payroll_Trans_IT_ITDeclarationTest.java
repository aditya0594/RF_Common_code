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

import Payroll.AL_Payroll_Trans_IT_ITDeclaration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_IT_ITDeclarationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_IT_ITDeclaration it_declaration;
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
	public void aL_Payroll_Trans_IT_ITDeclarationTest() throws Exception {
	
		it_declaration = new AL_Payroll_Trans_IT_ITDeclaration(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_IT_ITDeclarationTest");
		System.out.println("Payroll==> Transaction==> Income Tax==> IT Declaration");
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_IncomeTax();
		
		Thread.sleep(2000);
		it_declaration.Click_ITDeclaration();
		
		Thread.sleep(2000);
		it_declaration.Select_College();
		
		Thread.sleep(3000);
		it_declaration.Select_Employee();
		
		Thread.sleep(3000);
		it_declaration.Select_ITRuleName();
		
		Thread.sleep(3000);
		it_declaration.Select_ReportedAsOnDate();
		
		
		Thread.sleep(3000);
		it_declaration.Click_Savebtn();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
	}
}
