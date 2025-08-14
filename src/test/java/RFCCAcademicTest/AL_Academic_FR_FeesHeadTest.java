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

import RFCCAcademic.AL_Academic_FR_FeesHead;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_FeesHeadTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_FeesHead feeshead;
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
	public void aL_Academic_FR_FeesHeadTest() throws Exception {
		
		feeshead = new AL_Academic_FR_FeesHead(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_FeesHeadTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Fees Head"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated();
		
		threadWait1();
		feeshead.Click_FeesHead();
		
		threadWait1();
		feeshead.Select_SelectReceiptType();
		
//		threadWait1();
//		feeshead.Click_CheckBox();
		
		threadWait1();
		feeshead.Click_Submitbtn();
		
		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Fee Heads Defined Successfully...!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
