package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_IncidentRegister;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_VM_Trans_IncidentRegisterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_IncidentRegister incidentRegister;
	HomePageAdmin HP;
	PDFUtility pdfutility;


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
	public void aL_Administration_VM_Trans_IncidentRegisterTest() throws Exception {

		incidentRegister = new AL_Administration_VM_Trans_IncidentRegister(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_IncidentRegisterTest"); 
		pdfutility =new PDFUtility(driver);	

		
		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Incident Register");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		incidentRegister.Click_IncidentRegisterLink();
		
		threadWait1();
		incidentRegister.Enter_RouteNo();
	
		threadWait1();
		incidentRegister.Click_CurrentDate();
		
		threadWait1();
		incidentRegister.Enter_IncidentTime();
		
		threadWait1();
		incidentRegister.Enter_FollowUp();
		
		threadWait1();
		incidentRegister.Enter_NatureOfIncident();
		
		threadWait1();
		incidentRegister.Enter_IncidentPlace();
		
		threadWait1();
		incidentRegister.Click_SubmitBtn();
		
		Thread.sleep(2000);
		incidentRegister.Validate_AlertMessage();
		
		// Click on Report Button
		threadWait1();
		incidentRegister.Click_ReportBtn();
		
		// Enter report date range
		threadWait1();
		incidentRegister.Enter_FromDate();
		
		threadWait1();
		incidentRegister.Enter_ToDate();
		
		threadWait1();
		incidentRegister.Click_ShowReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Administration - Incident Register");
		Thread.sleep(2000);
		pdfutility.readPDF("Administration - Incident Register", "Tyre puncture");	
	}
}
