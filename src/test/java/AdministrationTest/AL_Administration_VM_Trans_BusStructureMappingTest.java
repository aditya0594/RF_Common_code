package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_BusStructureMapping;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Administration_VM_Trans_BusStructureMappingTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_BusStructureMapping busStructureMapping;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
	
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
	public void aL_Administration_VM_Trans_BusStructureMappingTest() throws Exception {

		busStructureMapping = new AL_Administration_VM_Trans_BusStructureMapping(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_BusStructureMappingTest"); 
		excelutilitytest = new ExcelUtility(driver);

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Bus Structure Mapping");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		busStructureMapping.Click_BusStructureMappingLink();
		
		threadWait1();
		busStructureMapping.Select_Route();
		
		threadWait1();
		busStructureMapping.Select_BusStructure();
		
		threadWait1();
		busStructureMapping.Select_Session();
		
		threadWait1();
		busStructureMapping.Click_ShowBusBookingBtn();
		
		threadWait1();
		busStructureMapping.Click_CheckBox();
		
		threadWait1();
		busStructureMapping.Select_Status();
		
		threadWait1();
		busStructureMapping.Click_SubmitBtn();
		
		Thread.sleep(2000); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Update Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
		
		threadWait1();
		busStructureMapping.Click_PaymentReportBtn();
		

		Thread.sleep(2000);
		excelutilitytest.ReadExcel("ADNAN","PaymentReport"); 

	}
}
