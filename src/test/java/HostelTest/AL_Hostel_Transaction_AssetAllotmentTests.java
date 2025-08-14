package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_Transaction_AssetAllotmentTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	Hostel.AL_Hostel_Transaction_AssetAllotment aL_Hostel_Transaction_AssetAllotment;
	HomePageAdmin HP;
	
	
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
	public void AssetAllotment() throws Exception {

		aL_Hostel_Transaction_AssetAllotment = new Hostel.AL_Hostel_Transaction_AssetAllotment(driver);

		test = reports.createTest("AssetAllotment");
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Transaction > Asset Allotment");
        
        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);

        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Transaction();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Asset_Allotment();
        
        Thread.sleep(2000);
        aL_Hostel_Transaction_AssetAllotment.Editbutton();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Hostelddl();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Blockddl();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Floorddl();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Roomddl();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Assetddl();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.AssetQuantity();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.AssetAllotmentDate();
        
        Thread.sleep(1000);
        aL_Hostel_Transaction_AssetAllotment.Submitbutton();
        
        Thread.sleep(1000);
        
        Thread.sleep(2000);
		//Accept Alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Asset Allotment Updated Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
     
        
}
}
