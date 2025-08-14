package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolderTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder bulk_photo_folder;
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
	public void aL_Payroll_Trans_BD_BulkPhotoUpdateFromFolderTest() throws Exception {
	
		bulk_photo_folder = new AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder(driver);
		HP = new HomePageAdmin(driver);
		System.out.println("Payroll ==> Transaction ==> Basic Details ==> Bulk Photo Update from folder");
		test = reports.createTest("aL_Payroll_Trans_BD_BulkPhotoUpdateFromFolderTest");
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.PAYROLL();
		Thread.sleep(2000);
		HP.PAYROLL_Transactions();
		Thread.sleep(2000);
		HP.Payroll_Trans_BasicDetails();
		
		Thread.sleep(2000);
		bulk_photo_folder.Click_BulkPhotoUpdate();
		
		Thread.sleep(2000);
		bulk_photo_folder.Select_PhotoCategory();
		
		Thread.sleep(2000);
		bulk_photo_folder.Click_UploadBulkPhoto();
		
		Thread.sleep(3000);
		bulk_photo_folder.Click_SelectImage();
		
		Thread.sleep(2000);
		bulk_photo_folder.Click_Showbtn();
		
		Thread.sleep(2000);
		bulk_photo_folder.Click_UploadBtn();
		
		Thread.sleep(2000);
		bulk_photo_folder.Click_CloseBtn(); 
		
	}
}
