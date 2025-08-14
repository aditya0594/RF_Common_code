package RFCCAcademicTest;

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

import RFCCAcademic.AL_Academic_CR_CancelDetentionFlow09_3;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_CR_CancelDetentionFlow09_3Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CancelDetentionFlow09_3 canceldetain;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
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
	public void aL_Academic_CR_CancelDetentionFlow09_3Test() throws IOException, Throwable 
 {
		
		canceldetain = new AL_Academic_CR_CancelDetentionFlow09_3(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_CancelDetentionFlow09_3Test"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Cancel Detention "); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(4000);
		canceldetain.Click_CancelDetention();
		
		Thread.sleep(4000);
		canceldetain.Select_SchoolInstitute();
		
		Thread.sleep(3000);
		canceldetain.Select_Session();
		
		Thread.sleep(4000);
		canceldetain.Select_Semister();
		
		Thread.sleep(4000);
		canceldetain.Enter_RRNO();
		
		Thread.sleep(4000);
		canceldetain.Click_ShowBtn();
		
		Thread.sleep(4000);
		canceldetain.Click_SubmitBtn();
		
		acceptAlert();
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "The detention has been successfully cancelled!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
 	}
}
