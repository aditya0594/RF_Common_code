package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_BulkUpdateOfPhoto;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_AR_BulkUpdateOfPhotoTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AR_BulkUpdateOfPhoto aL_ACD_ADMR_BulkUpdateOfPhoto; 
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
	public void aL_Academic_AR_BulkUpdateOfPhotoTest() throws Exception {

		aL_ACD_ADMR_BulkUpdateOfPhoto = new AL_Academic_AR_BulkUpdateOfPhoto(driver);
		HP = new HomePageAdmin(driver);
		

		test = reports.createTest("aL_Academic_AR_BulkUpdateOfPhotoTest");
		
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
	System.out.println("Academic > Administrative Related > Bulk Update Of Photo");
		
		

	Thread.sleep(2000);
	HP.Academic();
	Thread.sleep(2000);

		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.AdministrativeRelated();

		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.BulkUpdateOfPhoto();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.School_Instituteddl();

		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.Degreeddl();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.Programme_Branchddl();

		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.AdmissionBatch();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.FormatPhoto();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.ShowButton();
		
		//Thread.sleep(5000);
		//aL_ACD_ADMR_BulkUpdateOfPhoto.ChoosePhoto();
		
		//Thread.sleep(5000);
		//aL_ACD_ADMR_BulkUpdateOfPhoto.submitbutton();
		
		//Thread.sleep(5000);
	//	acceptAlert();
		
		Thread.sleep(4000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.Showphotoreport();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime()); 
		captureScreenshot(driver, "Bulk Update Of Photo");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.Formatsignature();
		
		Thread.sleep(5000);
		aL_ACD_ADMR_BulkUpdateOfPhoto.ShowButton();
		
		//Thread.sleep(5000);
		//aL_ACD_ADMR_BulkUpdateOfPhoto.Choosesignature();
		
		//Thread.sleep(5000);
		//aL_ACD_ADMR_BulkUpdateOfPhoto.submitbutton();
		
		//Thread.sleep(5000);
		//acceptAlert();
		
		Thread.sleep(3000);
		//aL_ACD_ADMR_BulkUpdateOfPhoto.Showphotoreport(); 
		aL_ACD_ADMR_BulkUpdateOfPhoto.Showsignreport();

		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());	
		captureScreenshot(driver, "Bulk Update Of Photo");
	}
}