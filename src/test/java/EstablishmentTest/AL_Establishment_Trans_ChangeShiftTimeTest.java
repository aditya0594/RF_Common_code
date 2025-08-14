package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_ChangeShiftTime;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_ChangeShiftTimeTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_ChangeShiftTime shift_time;
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
	public void aL_Establishment_Trans_ChangeShiftTimeTest() throws InterruptedException, IOException {
		
	System.out.println("Establishment==>Transaction==> Change Shift Time");
		
		shift_time = new AL_Establishment_Trans_ChangeShiftTime(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_ChangeShiftTimeTest");
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(4000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(4000);
		shift_time.Click_Transactions();
		
		Thread.sleep(4000);
		shift_time.Click_ChangeShiftTime();
		
		Thread.sleep(4000);
		shift_time.Select_College_name();
		
		Thread.sleep(4000);
		shift_time.Select_Stafff_Type();
		
		Thread.sleep(4000);
		shift_time.Select_FromDate();
		
		Thread.sleep(4000);
		shift_time.Select_ToDate();
		
		Thread.sleep(4000);
		shift_time.Set_InTime();
		
		Thread.sleep(4000);
		shift_time.Set_OutTime();
		
		Thread.sleep(3000);
		shift_time.Click_check_box();
		
		Thread.sleep(4000);
		shift_time.Click_submit_btn();    // Records Saved Successfully
		
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();

		String Act_Msg = alert.getText();
		String Exp_Msg = "Record saved successfully";

		Assert.assertEquals(Act_Msg, Exp_Msg);
		acceptAlert();
	}
}
