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

import Payroll.AL_Payroll_Trans_IT_ITCalculation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_IT_ITCalculationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_IT_ITCalculation IT_calcul;
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
	public void aL_Payroll_Trans_IT_ITCalculationTest() throws Exception {
	
		IT_calcul = new AL_Payroll_Trans_IT_ITCalculation(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_IT_ITCalculationTest");
		System.out.println("Payroll==> Transaction==> Income Tax==> IT Calculation");
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.PAYROLL_Trans_IncomeTax();
		
		Thread.sleep(2000);
		IT_calcul.Click_ITCalculation();
		
		Thread.sleep(2000);
		IT_calcul.Select_College();
		
		
		Thread.sleep(2000);
		IT_calcul.Select_Staff();
	
		
		Thread.sleep(2000);
		IT_calcul.Click_CalculateIncomeTaxbtn();
		
		Thread.sleep(8000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "INCOME TAX CALCULATION PROCESS SUCCESSFUL!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
	}
}
