package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_VacationDaysAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_VacationDaysAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_VacationDaysAllotment vacation_allot;
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
	public void aL_Establishment_Trans_VacationDaysAllotmentTest() throws InterruptedException, IOException {
		
	System.out.println("Establishment==>Transaction==> Vacation Days Allotment");
		
		vacation_allot = new AL_Establishment_Trans_VacationDaysAllotment(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_VacationDaysAllotmentTest");
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		HP.ESTABLISHMENT();
		Thread.sleep(2000);
		HP.Estab_Transactions();
		
		Thread.sleep(4000);
		vacation_allot.Click_VacationDaysAllotment();
		
		Thread.sleep(2000);
		vacation_allot.Select_College_name();
		
		Thread.sleep(2000);
		vacation_allot.Select_Stafff_Type();
		
		Thread.sleep(2000);
		vacation_allot.Click_CheckBox();
		
		Thread.sleep(2000);
		vacation_allot.Set_FromDate();
		
		Thread.sleep(2000);
		vacation_allot.Set_ToDate();    
		
		Thread.sleep(2000);
		vacation_allot.Click_Submit_btn();
		
		Thread.sleep(2000);
	    Alert alert = driver.switchTo().alert();
	    String Act_Msg = alert.getText();
		String Exp_Msg = "Record saved successfully";
		Assert.assertEquals(Act_Msg, Exp_Msg);
		System.out.println("Actual Message - " + Act_Msg+ "\n"+ "Expected Message - " + Exp_Msg);
		Thread.sleep(1000);
		alert.accept();
	}
}
