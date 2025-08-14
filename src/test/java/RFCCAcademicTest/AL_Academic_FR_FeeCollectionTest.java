package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_FeeCollection;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

@Listeners(utility.Listeners.class)

public class AL_Academic_FR_FeeCollectionTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_FeeCollection al_Academic_FR_FeeCollection;
	HomePageAdmin homePageAdmin ;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_FR_FeeCollectionTest() throws Exception {

		al_Academic_FR_FeeCollection = new AL_Academic_FR_FeeCollection(driver);
		homePageAdmin = new HomePageAdmin(driver);
		test = reports.createTest("feesRelatedTest");
		
		System.out.println("ACADEMIC->Fee Related->Fee Collection");

		RF_AdminLoginPage.loginPage();
 
		Thread.sleep(5000);		
		//Select Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		homePageAdmin.Academic_FeesRelated();
		
		Thread.sleep(2000);
		//Click Fees Collection
		al_Academic_FR_FeeCollection.Click_Fee_Collection_Link();
		System.out.println("click Fee Collection");
		
		Thread.sleep(2000);
		
		//Select Search Criteria 
		al_Academic_FR_FeeCollection.Select_Search_Criteria();
		
		//enter search string
		al_Academic_FR_FeeCollection.Enter_Search_String();
		Thread.sleep(5000); 

		//click on search button
		al_Academic_FR_FeeCollection.Click_Search_Button();
		Thread.sleep(2000);
		
		//Click on 1st Name
		System.out.println("Click on 1st Name");
		al_Academic_FR_FeeCollection.Click_First_Name();
		Thread.sleep(2000);
		
		//Select fee collection mode
		System.out.println("Mode -> Counter Collection");
		al_Academic_FR_FeeCollection.Select_Fee_Collection_Mode();
		Thread.sleep(2000);
		
		//Enter Amount
		al_Academic_FR_FeeCollection.Enter_Total_Amount();
		Thread.sleep(2000);
		
		//click submit button
		al_Academic_FR_FeeCollection.Click_Submit_Button();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Transaction Saved Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		alert.accept(); 
		
		Alert alert1 = driver.switchTo().alert();
		String Expected_Msg1 = "Fee collection done successfully, Do want to generate receipt ?";
		String Actual_Msg1 = alert1.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg1+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg1);
		Assert.assertEquals(Actual_Msg1, Expected_Msg1,"Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		alert1.accept();

		Thread.sleep(2000);
		switchToNextWindow();
		System.out.println("Inside New Window");
		
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
	}

}
