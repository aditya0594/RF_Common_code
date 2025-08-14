package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_CancelReceiptFlow06_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_CancelReceiptFlow06_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_FR_CancelReceiptFlow06_2 cancelreceipt;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting Test : " + m.getName() + "******" + "\n");
	}
	
	@Test
	
	public void aL_Academic_FR_CancelReceiptFlow06_2Test() throws Exception {
		test=reports.createTest("aL_Academic_FR_CancelReceiptFlow06_2Test");
		
		homePageAdmin = new HomePageAdmin(driver);
		cancelreceipt = new AL_Academic_FR_CancelReceiptFlow06_2(driver);
		
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic -> Fee Related -> Reprint or Cancel receipt");
		
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(4000);
		
		//Click on Fee Related
		homePageAdmin.Academic_FeesRelated();
		Thread.sleep(4000);
		
	    //Click on Reprint or Cancel receipt
		cancelreceipt.click_reprintOrCancelReceipt_link();
	    
	    Thread.sleep(4000);
	    cancelreceipt.select_searchString();
	    
	    Thread.sleep(4000);
	    cancelreceipt.click_search_button();
	    
	    Thread.sleep(4000);
	    cancelreceipt.click_studentName_link();
	    
	    Thread.sleep(4000);
	    cancelreceipt.click_reprint_button();
	    
	    cancelreceipt.click_record_radioButton();
	    
	    Thread.sleep(4000);
	    cancelreceipt.click_cancel_button();
	    
	    Thread.sleep(1000);
	    acceptAlert();
	    Thread.sleep(1000);
	    acceptAlert();
	    
		Thread.sleep(4000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Receipt has been cancelled successfully.";
		String Actual_Msg =alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);

		Thread.sleep(2000);
		alert.accept();
	    
	}
}
