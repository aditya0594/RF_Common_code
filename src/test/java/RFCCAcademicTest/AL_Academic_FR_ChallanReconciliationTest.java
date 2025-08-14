package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academics_FR_ChallanReconciliation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FR_ChallanReconciliationTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Academics_FR_ChallanReconciliation PendingChalanreconSave;
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
	public void aL_Academic_FR_ChallanReconciliationTest() throws Exception {
		

		PendingChalanreconSave = new AL_Academics_FR_ChallanReconciliation(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academics_FR_ChallanReconciliationTest");
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fees Related  > Challan Reconcilistion > Challan Status   ");
		
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		PendingChalanreconSave.FeesRelated();
		
		Thread.sleep(2000);
		PendingChalanreconSave.ChalanRecon();
	
		Thread.sleep(2000);
		PendingChalanreconSave.PendingChalan();
		
		Thread.sleep(2000);
		PendingChalanreconSave.ViewChallan();
	
		Thread.sleep(2000);
		PendingChalanreconSave.PenChallanExcel(); 
		Thread.sleep(5000);
        excelutilitytest.ReadExcel("Admission Fee","PendingChallanReport"); 
		
}
}

