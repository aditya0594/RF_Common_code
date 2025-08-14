package StoresTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Trans_GenerateItemSerialNumber;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Stores_Trans_GenerateItemSerialNumberTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Trans_GenerateItemSerialNumber generateItemSerialNumber;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
	
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
	public void aL_Stores_Trans_GenerateItemSerialNumberTest() throws Exception {

		generateItemSerialNumber = new AL_Stores_Trans_GenerateItemSerialNumber(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Trans_GenerateItemSerialNumberTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORE > Transaction > Generate Item Serial Number");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Store_Transaction();

		threadWait1();
		generateItemSerialNumber.Click_GenerateItemSerialNumber();
		
		threadWait1();
		generateItemSerialNumber.Click_ModifyButton();
		
		threadWait1();
		generateItemSerialNumber.Select_Category();
		
		threadWait1();
		generateItemSerialNumber.Select_SubCategory();
		
		threadWait1();
		generateItemSerialNumber.Select_SelectItems();
		
		threadWait1();
		generateItemSerialNumber.Enter_Specification();
		
		threadWait1();
		generateItemSerialNumber.Click_SubmitButton();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Records Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
