package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_DocumentListMaster;
import RFCCAcademic.AL_Academic_CR_ARM_RoomMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AP_DocumentListMasterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_DocumentListMaster docslist;
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
	public void aL_Academic_AP_DocumentListMasterTest() throws Exception {
		
		docslist = new AL_Academic_AP_DocumentListMaster(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_AP_DocumentListMasterTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Document List Master"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(2000);
		docslist.Click_DocumentListMaster();
		
		Thread.sleep(2000);
		docslist.Click_EditBtn();
		
		Thread.sleep(2000);
		docslist.Click_SubmitBtn();
		
		Thread.sleep(2000);
		docslist.Click_DocumentMapping();
		
		Thread.sleep(2000);
		docslist.Click_Edit10Btn();
		
		Thread.sleep(2000);
		docslist.Click_MandatoryStausBtn();
		
		Thread.sleep(2000);
		docslist.Click_Submit2btn();
	}
}
