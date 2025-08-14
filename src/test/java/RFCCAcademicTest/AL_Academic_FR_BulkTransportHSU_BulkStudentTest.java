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

import RFCCAcademic.AL_Academic_FR_BulkTransportHSU_BulkStudent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_BulkTransportHSU_BulkStudentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_BulkTransportHSU_BulkStudent blockmaster;
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
	public void aL_Academic_FR_BulkTransportHSU_BulkStudentTest() throws Exception {
		
		blockmaster = new AL_Academic_FR_BulkTransportHSU_BulkStudent(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_BulkTransportHSU_BulkStudentTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Bulk Transport/Hosteler Status Updation > Transport/Hosteler Status Updation Bulk"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_FeesRelated();
		
		Thread.sleep(2000);
		blockmaster.Click_BulkTransportHostelerStatusUpdation();
		
		Thread.sleep(2000);
		blockmaster.Select_SchoolInstitute();
		
		Thread.sleep(2000);
		blockmaster.Select_AdmissionBatch();
		
		Thread.sleep(2000);
		blockmaster.Select_Degree();
		
		Thread.sleep(2000);
		blockmaster.Select_ProgramBatch();
		
		Thread.sleep(2000);
		blockmaster.Select_AdmissionYear();
		
		Thread.sleep(2000);
		blockmaster.Select_Semister();
		
		Thread.sleep(2000);
		blockmaster.Select_Gender();
		
		Thread.sleep(2000);
		blockmaster.Click_Showbtn();
		
		Thread.sleep(2000);
		blockmaster.Select_TransportationStatus();
		
		Thread.sleep(2000);
		blockmaster.Select_HostellerStatus();
		
		Thread.sleep(2000);
		blockmaster.Select_HostellerType();
		
		Thread.sleep(2000);
		blockmaster.Click_CheckBoxbtn();
		
		Thread.sleep(2000);
		blockmaster.Click_Submitbtn();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Student Status Allotted Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
