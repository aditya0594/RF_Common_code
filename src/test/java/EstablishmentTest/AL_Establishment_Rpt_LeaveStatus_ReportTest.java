package EstablishmentTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_LeaveStatus_Report;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Establishment_Rpt_LeaveStatus_ReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_LeaveStatus_Report leave_status;
	PDFUtility pdfutility;
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
	public void aL_Establishment_Rpt_LeaveStatus_ReportTest() throws InterruptedException, IOException, AWTException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Leave Status => Report");
		
		leave_status = new AL_Establishment_Rpt_LeaveStatus_Report(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Establishment_Rpt_LeaveStatus_ReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		leave_status.Click_REPORTS();
		
		Thread.sleep(8000);
		leave_status.Click_Leave_status();
		
		Thread.sleep(8000);
		leave_status.Select_College();
		
		Thread.sleep(8000);
		leave_status.Select_Stafff_Type();
		
		Thread.sleep(5000);
		leave_status.Set_from_date();
		
		Thread.sleep(5000);
		leave_status.Set_to_date();
		
//		Report for All Employee
		
		Thread.sleep(5000);
		leave_status.Click_report_btn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Establishment - Leave Status Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Establishment - Leave Status Report", "CL");	

		
			
	}

}
