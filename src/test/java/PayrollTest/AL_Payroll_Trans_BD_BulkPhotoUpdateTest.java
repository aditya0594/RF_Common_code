package PayrollTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_BD_BulkPhotoUpdate;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_BulkPhotoUpdateTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_BulkPhotoUpdate bulk_photo;
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
	public void aL_Payroll_Trans_BD_BulkPhotoUpdateTest() throws Exception {
	
		bulk_photo = new AL_Payroll_Trans_BD_BulkPhotoUpdate(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Payroll_Trans_BD_BulkPhotoUpdateTest"); 
		System.out.println("Payroll==> Transaction ==> Basic Details ==> Bulk Photo Update");

		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.Payroll_Trans_BasicDetails();
		
		Thread.sleep(2000);
		bulk_photo.Click_BulkPhotoUpdate();
		
		Thread.sleep(2000);
		bulk_photo.Select_CollegeName();
		
		Thread.sleep(2000);
		bulk_photo.Select_StaffScheme();
		
		Thread.sleep(2000);
		bulk_photo.Click_Show_Btn();
		
		Thread.sleep(2000);
		bulk_photo.Click_ChooseFile1();
		
		Thread.sleep(2000);
		bulk_photo.Click_Submit_Btn();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record Updated Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		acceptAlert();
		
	}
}
