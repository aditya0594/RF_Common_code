package ExaminationTest;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_EU_ConvocationMaster;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EU_ConvocationMasterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EU_ConvocationMaster convo_master;
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
	public void aL_Examination_EU_ConvocationMasterTest() throws InterruptedException, IOException, HeadlessException, AWTException {
		
	System.out.println("Examination==> CONVOCATION => CONVOCATION MANAGEMENT");
		
		convo_master = new AL_Examination_EU_ConvocationMaster(driver);
		test = reports.createTest("aL_Examination_EU_ConvocationMasterTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		
		HP.EXAMINATION();
		threadWait1();
		
		Thread.sleep(5000);
		convo_master.Click_Convocation();
		
		threadWait1();
		convo_master.Click_Edit_btn();
		
		/*
		 * Thread.sleep(5000); convo_master.Click_ActiveSatatus_chkBox();
		 */
		
		threadWait1();
		convo_master.Click_Submit_btn();
		
		threadWait1();
		Alert Al = driver.switchTo().alert();
		String actMsg=Al.getText();
		String expMsg="Record Updated Successfully";
		Assert.assertEquals(actMsg, expMsg);
		System.out.println(actMsg);
		threadWait1();
		
		Al.accept();
	//captureScreenshot(driver, "Convocation Master");
	}
}
