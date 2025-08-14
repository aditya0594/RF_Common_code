package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_FeeHeadCurrencyMapping;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_FeeHeadCurrencyMappingTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_FeeHeadCurrencyMapping currencymapping;
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
	public void aL_Academic_FR_FeeHeadCurrencyMappingTest() throws Exception {
		
		currencymapping = new AL_Academic_FR_FeeHeadCurrencyMapping(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_FeeHeadCurrencyMappingTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Fee Head Currency Mapping"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_FeesRelated();;
		
		Thread.sleep(2000);
		currencymapping.Click_FeeHeadCurrencyMapping();
		
		Thread.sleep(2000);
		currencymapping.Select_SelectReceiptType();
		
		Thread.sleep(2000);
		currencymapping.Select_PaymentType();
		
		Thread.sleep(2000);
		currencymapping.Select_CurrencyType();
		
		Thread.sleep(2000);
		currencymapping.Enter_LongName();
		
		Thread.sleep(2000);
		currencymapping.Enter_ShortName();
		
		Thread.sleep(2000);
		currencymapping.Click_Submitbtn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
