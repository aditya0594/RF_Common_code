package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
//import com.qa.pages.academic.AL_Acadm_CR_BulkCourseRegistration;

import Establishment.FL_Establishment_Trans_PermissionEntryFlow02_1;
//import AdminExamination.InvigilatorEntryPage;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_Establishment_Trans_PermissionEntryFlow02_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
//	AL_Acadm_CR_BulkCourseRegistration aL_Acadm_CR_BulkCourseRegistration;
//	InvigilatorEntryPage Invigi_Entry;
	FL_Establishment_Trans_PermissionEntryFlow02_1 PermissionEntry;
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
	public void fL_Establishment_Trans_PermissionEntryFlow02_1Test() throws InterruptedException, IOException {
		System.out.println("Login with employee credentials");
		PermissionEntry=new FL_Establishment_Trans_PermissionEntryFlow02_1(driver); 
		HP = new HomePageAdmin(driver);
		
			Thread.sleep(2000);
			System.out.println("Enter UserName -> 2021008");
			driver.findElement(By.id("txt_username")).sendKeys("2021008");

			Thread.sleep(2000);
			System.out.println("Enter Password Live -> Admin@12345 || UAT -> admin@123");
			driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

			///// captchaHandle();
			Thread.sleep(2000);
			System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
			driver.findElement(By.id("txtcaptcha")).sendKeys("4321"); 

			Thread.sleep(2000);
			System.out.println("Click on Login Button");
			driver.findElement(By.id("btnLogin")).click();
			
			System.out.println("Login with employee Creds");
			System.out.println("Establishment==> Transactions==>Permission Entry");
		
			Thread.sleep(2000);
			HP.ESTABLISHMENT();
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			PermissionEntry.click_Transaction();
			
			Thread.sleep(3000);
			PermissionEntry.click_PermissionEntry();
			
			Thread.sleep(3000);
			PermissionEntry.click_NewApplication();
			
			Thread.sleep(3000);
			PermissionEntry.Set_Date();
			
			
			Thread.sleep(5000);
			PermissionEntry.Select_Reason();
			
			Thread.sleep(5000);
			PermissionEntry.Click_SubmitBtn();
			
			Thread.sleep(2000);
			Alert alert =  driver.switchTo().alert();
			String Expected_Msg = "Record Saved Successfully"; 
			String Actual_Msg = alert.getText();
			System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
			Thread.sleep(2000);
			alert.accept();		
	}	
			
}
