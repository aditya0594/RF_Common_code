package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.FL_Establishment_Trans_ODApplicationFlow04_1;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_Establishment_Trans_ODApplicationFlow04_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_Establishment_Trans_ODApplicationFlow04_1 od_application;
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
	public void fL_Establishment_Trans_ODApplicationFlow04_1Test() throws InterruptedException, IOException {
		System.out.println("Login with employee credentials");
			od_application=new FL_Establishment_Trans_ODApplicationFlow04_1(driver); 
			HP = new HomePageAdmin(driver);
		
			System.out.println("Login with employee Creds");
			System.out.println("Establishment==> Transactions==> OD Application");
		
			Thread.sleep(2000);
			od_application.Enter_LoginDetails();
			
			Thread.sleep(2000);
			HP.ESTABLISHMENT();
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			od_application.click_Transaction();
			
			Thread.sleep(3000);
			od_application.click_ODApplication();
			
			Thread.sleep(3000);
			od_application.click_New_OD_Application();
			
			Thread.sleep(3000);
			od_application.click_ODApplication_FullDay();
			
			Thread.sleep(3000);
			od_application.Set_From_Date();
			
			Thread.sleep(3000);
			od_application.Set_To_Date();
			
			Thread.sleep(3000);
			od_application.Select_Purpose();
			
			Thread.sleep(3000);
			od_application.Select_EventType();
			
			Thread.sleep(3000);
			od_application.Enter_PlaceToVisit();
			
			Thread.sleep(3000);
			od_application.Click_Submit_btn();
			
			Thread.sleep(2000);
			Alert alert =  driver.switchTo().alert();
			String Expected_Msg = "Record Saved Successfully"; 
			String Actual_Msg = alert.getText();
			System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
			alert.accept();		
	}
}
