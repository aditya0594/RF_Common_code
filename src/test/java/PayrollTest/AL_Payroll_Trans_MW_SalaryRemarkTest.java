package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_SalaryRemark;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

@Listeners(utility.Listeners.class)
public class AL_Payroll_Trans_MW_SalaryRemarkTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Payroll_Trans_MW_SalaryRemark al_Payroll_Trans_MW_SalaryRemark;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "********" + "\n");
	}

	@Test
	public void aL_Payroll_Trans_MW_SalaryRemarkTest() throws Exception {
		
		test = reports.createTest("salary_Remark");
		homePageAdmin = new HomePageAdmin(driver);
		al_Payroll_Trans_MW_SalaryRemark = new AL_Payroll_Trans_MW_SalaryRemark(driver);
		
		RF_AdminLoginPage.loginPage();

		//Move to Payroll 
		homePageAdmin.PAYROLL();
		Thread.sleep(2000);
		
		//Move to Transactions
		homePageAdmin.PAYROLL_Transactions(); 
		System.out.println("Hover on Transactions in drop down");
		Thread.sleep(2000);
		//Click on Monthly Work
		homePageAdmin.PAYROLL_Trans_MonthlyWork();
		Thread.sleep(2000);
		
		//Click on Salary Remark
		al_Payroll_Trans_MW_SalaryRemark.Click_SalaryRemark_Link();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Select Month and Year
		al_Payroll_Trans_MW_SalaryRemark.Select_MonthAndYear();

		Thread.sleep(2000);
		//Select College
		al_Payroll_Trans_MW_SalaryRemark.Select_College();

		Thread.sleep(2000);
		//Enter Month Remark
		al_Payroll_Trans_MW_SalaryRemark.Enter_MonthRemark();

		Thread.sleep(2000);
		//Select Scheme or Staff
		al_Payroll_Trans_MW_SalaryRemark.Select_SchemeOrStaff();

		Thread.sleep(2000);
		//Click Show Empployee For Common Remark Button
		al_Payroll_Trans_MW_SalaryRemark.Click_ShowEmpForCommonRemark_Button();

		Thread.sleep(3000);
		//Click Submit Button
		al_Payroll_Trans_MW_SalaryRemark.Click_Submit_Button();

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
