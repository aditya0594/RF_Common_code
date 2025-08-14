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

import RFCCAcademic.AL_Academic_CR_BatchAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_BatchAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_BatchAllotment batchallot;
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
	public void aL_Academic_CR_BatchAllotmentTest() throws Exception {
		
		batchallot = new AL_Academic_CR_BatchAllotment(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_BatchAllotmentTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Batch Allotment"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(2000);
		batchallot.Click_BatchAllotment();
		
		Thread.sleep(2000);
		batchallot.Select_CollegeScheme();
		
		Thread.sleep(2000);
		batchallot.Select_Session();
		
		Thread.sleep(2000);
		batchallot.Select_Semister();
		
		Thread.sleep(2000);
		batchallot.Select_CourseType();
		
		Thread.sleep(2000);
		batchallot.Select_Course();
		
		Thread.sleep(2000);
		batchallot.Select_Section();
		
		Thread.sleep(2000);
		batchallot.Click_FilterBtn();
		
		Thread.sleep(2000);
		batchallot.Enter_SerialNo();
		
		Thread.sleep(2000);
		batchallot.Select_Batch();
		
		Thread.sleep(2000);
		batchallot.Click_SaveBtn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Batch Allotted Successfully.";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
