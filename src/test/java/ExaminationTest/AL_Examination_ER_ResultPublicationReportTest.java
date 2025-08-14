package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ResultPublicationReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_ResultPublicationReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ResultPublicationReport publish_result;
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
	public void aL_Examination_ER_ResultPublicationReportTest () throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Result Publication Report");
		
		publish_result = new AL_Examination_ER_ResultPublicationReport(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Examination_ER_ResultPublicationReportTest ");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();


		Thread.sleep(5000);;
		publish_result.EXAMINATION_REPORT();
		
		Thread.sleep(5000);;
		publish_result.Click_ResultPublicationReport();
		
		Thread.sleep(5000);
		publish_result.Select_Session();
		
		Thread.sleep(10000);
		publish_result.Select_CollegeScheme();
		
		Thread.sleep(5000);
		publish_result.Select_Semister();
		
		Thread.sleep(5000);;
		publish_result.Click_Report_btn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Examination - Result Publication Report");
		pdfutility.readPDF("Examination - Result Publication Report", "AHAMED");	

	}
}
