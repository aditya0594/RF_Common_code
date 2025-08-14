package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_CourseLockUnlock;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_CourseLockUnlockTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CourseLockUnlock lockUnlock;
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
	public void aL_Academic_CR_CourseLockUnlockTest() throws Exception {
		
		lockUnlock = new AL_Academic_CR_CourseLockUnlock(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_CourseLockUnlockTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Course Lock Unlock"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(2000);
		lockUnlock.Click_CourseLockUnlock();
		
		Thread.sleep(2000);
		lockUnlock.Select_Degree();
		
		Thread.sleep(2000);
		lockUnlock.Select_SchemePath();
		
		Thread.sleep(2000);
		lockUnlock.Select_Semister();
		
		Thread.sleep(2000);
		lockUnlock.Click_ShowDataBtn();
		
		Thread.sleep(2000);
		lockUnlock.Click_CheckBox();
		
		Thread.sleep(2000);
		lockUnlock.Click_UnlockBtn();
		
		
	}
}
