package ManualIssue;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.AL_Hostel_Report_HostelVacantRooms;
import RFCCExtra.SL_CDC_Trans_TPCategoryUpdate_CareerProfile;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class SL_CDC_Trans_TPCategoryUpdate_CareerProfileTest extends BaseClass {
	
	SL_CDC_Trans_TPCategoryUpdate_CareerProfile sstudent_Cdc_Trance_Placement; 
	ExtentReports reports;
	ExtentTest test;
//	AL_Hostel_Report_HostelVacantRooms aL_Hostel_Report_HostelVacantRooms;
	
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
	public void student_Cdc_Trance_PlacementTest() throws Exception {

		

		
		test = reports.createTest("student_Cdc_Trance_PlacementTest");   
		
		
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 200101601015");
		driver.findElement(By.id("txt_username")).sendKeys("200101601015");

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");
		
		///// captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(1000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

	    sstudent_Cdc_Trance_Placement = new SL_CDC_Trans_TPCategoryUpdate_CareerProfile(driver); 

		
		System.out.println("CDC > Transactions  > TP Category Update");
		
		Thread.sleep(3000);
		sstudent_Cdc_Trance_Placement.CDCclick(); 

		Thread.sleep(4000);
		sstudent_Cdc_Trance_Placement.Transaction();
		
		Thread.sleep(4000);
		sstudent_Cdc_Trance_Placement.StuPlacement();
		
		Thread.sleep(2000);
		sstudent_Cdc_Trance_Placement.SubmitButton();
		
		Thread.sleep(2000);
		sstudent_Cdc_Trance_Placement.CareerProfile();
		
		Thread.sleep(2000);
		sstudent_Cdc_Trance_Placement.confirmation();
		
		Thread.sleep(2000);
		sstudent_Cdc_Trance_Placement.ConfirmCheckBox();
		
		Thread.sleep(2000);
		sstudent_Cdc_Trance_Placement.ProceedButton(); 
		
		
		
		}	
}	
		

