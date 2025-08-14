package HostelTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_HGP_PurposeMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_HGP_PurposeMasterTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_PurposeMaster al_Hostel_HGP_PurposeMaster;
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
	public void al_Hostel_HGP_PurposeMaster() throws Exception {

		al_Hostel_HGP_PurposeMaster = new AL_Hostel_HGP_PurposeMaster(driver);

		test = reports.createTest("PurposeMaster");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > HostelGatePass > Purpose Master");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.HostelGatePass();

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.PurposeMaster();
		
		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.Search();
		
		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.Edit();

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.EnterPurposeName();

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.submit();
		
		Thread.sleep(1000);
		acceptAlert();
		
		Thread.sleep(3000);
		al_Hostel_HGP_PurposeMaster.Search();
		
		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.Edit();

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.ReEnterPurposeName();

		Thread.sleep(2000);
		al_Hostel_HGP_PurposeMaster.submit();

		Thread.sleep(2000);
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		

	}
}
