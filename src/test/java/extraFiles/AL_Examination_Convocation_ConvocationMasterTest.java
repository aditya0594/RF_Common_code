package extraFiles;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.lang.reflect.Method;

import RFCCExtra.AL_Examination_Convocation_ConvocationMaster;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_Convocation_ConvocationMasterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_Convocation_ConvocationMaster convo_master;
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
	public void aL_Examination_Convocation_ConvocationMasterTest() throws InterruptedException, IOException, HeadlessException, AWTException {
		
	System.out.println("Examination==> CONVOCATION => CONVOCATION MANAGEMENT");
		
		convo_master = new AL_Examination_Convocation_ConvocationMaster(driver);
		test = reports.createTest("aL_Examination_Convocation_ConvocationMasterTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		HP.Exam_Convocation();
		
		Thread.sleep(2000);
		convo_master.Click_Edit_btn();
		
		Thread.sleep(2000);
		convo_master.Click_ActiveSatatus_chkBox();
		
		Thread.sleep(2000);
		convo_master.Click_Submit_btn();
		
		Thread.sleep(2000);
		Alert Al = driver.switchTo().alert();
		String actMsg=Al.getText();
		String expMsg="Record Updated Successfully";
		Assert.assertEquals(actMsg, expMsg);
		System.out.println(actMsg);
		Thread.sleep(2000);
		
		Al.accept();
		captureScreenshot(driver, "Convocation Master");
	}
}
