package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_FM_Master_RoleMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_FM_Master_RoleMasterTest  extends BaseClass {
	
	
	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_FM_Master_RoleMaster aL_Administration_FM_Master_RoleMaster;

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
	public void aL_Administration_FM_Master_RoleMasterTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_FM_Master_RoleMaster = new AL_Administration_FM_Master_RoleMaster(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_FM_Master_RoleMasterTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->File Movement->Master -> Role Master ");

		threadWait1();
		homePageAdmin.ADMINISTRATION();
		
		threadWait1();
		homePageAdmin.FileMovement();

		threadWait1();
		homePageAdmin.Admin_FM_Master();
		
		threadWait1();
		aL_Administration_FM_Master_RoleMaster.ClickOn_RoleMaster();
		
		threadWait1();
		aL_Administration_FM_Master_RoleMaster.ClickOn_Edit();
		
		threadWait1();
		aL_Administration_FM_Master_RoleMaster.Select_SubmitButton();
		
		// Alert
		threadWait3();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		threadWait1();
		alert.accept();

	}
		
		
		
	}


