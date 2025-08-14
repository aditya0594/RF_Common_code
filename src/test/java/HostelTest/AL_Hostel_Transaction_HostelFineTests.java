package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Transaction_HostelFine;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Transaction_HostelFineTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	AL_Hostel_Transaction_HostelFine aL_Hostel_Transaction_HostelFine;
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
	public void aL_Hostel_Transaction_HostelFineTests() throws Exception {

		aL_Hostel_Transaction_HostelFine = new AL_Hostel_Transaction_HostelFine(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Hostel_Transaction_HostelFineTests"); 
		
		threadWait1();
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Transaction > Hostel Fine");
        

        HP = new HomePageAdmin(driver);
    	threadWait1();
    	HP.HOSTEL();
    	threadWait1();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.Transaction();
	
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.Hostel_Fine();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.AddEditStudentFine();
	
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.HostelSessionddl();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.HostelNameddl();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.HostelBlockddl();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.HostelFloorddl();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.showbutton();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.SelectStudent();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.FineAmount();
		
		Thread.sleep(3000);	
		aL_Hostel_Transaction_HostelFine.SelectCheckbox();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.Submitbutton();
		threadWait1();	
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Student Fine Saved Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		threadWait1();	
		aL_Hostel_Transaction_HostelFine.Reportbutton(); 
		

		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Hostel - Hostel Fine Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Hostel - Hostel Fine Report", "RUKKIAH"); 
		
	}
}


