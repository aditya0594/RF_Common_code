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

import RFCCAcademic.AL_Academic_FR_BulkTransportHSU_SingleStudent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_BulkTransportHSU_SingleStudentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_BulkTransportHSU_SingleStudent singlestudent;
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
	public void aL_Academic_FR_BulkTransportHSU_SingleStudentTest() throws Exception {
		
		singlestudent = new AL_Academic_FR_BulkTransportHSU_SingleStudent(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_BulkTransportHSU_SingleStudentTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Bulk Transport/Hosteler Status Updation > Transport/Hosteler Status Update Single Student"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_FeesRelated();
		
		Thread.sleep(4000);
		singlestudent.Click_BulkTransportHostelerStatusUpdation();
		
		Thread.sleep(4000);
		singlestudent.Click_BulkTransportHostelerStatusUpdateSingle();
		
		Thread.sleep(4000);
		singlestudent.Select_SearchCriteria();
		
		Thread.sleep(4000);
		singlestudent.Select_Branch();
		
		Thread.sleep(4000);
		singlestudent.Click_Searchbtn();
		
		Thread.sleep(4000);
		singlestudent.Click_Student();
		
		Thread.sleep(4000);
		singlestudent.Select_TransportationStatus();
		
		Thread.sleep(4000);
		singlestudent.Click_SubmitBtn();         
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Student Status Allotted Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(4000);
		alert.accept();
	}
}
