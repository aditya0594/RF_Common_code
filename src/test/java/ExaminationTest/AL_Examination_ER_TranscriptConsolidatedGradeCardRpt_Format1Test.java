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

import Examination.AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1 transcript_conso;
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
	public void aL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1Test() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Transcript/Consolidated Grade Card Report => Format 1");
		
		transcript_conso = new AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1(driver);
		test = reports.createTest("aL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format1Test");
		pdfutility =new PDFUtility(driver);	
		
		Thread.sleep(5000);
		
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.EXAMINATION();
		threadWait1();
		
		threadWait1();
		HP.Exam_ExaminationReports();
		
		threadWait1();
		transcript_conso.Click_TranscriptConsolidatedGradeCardReport();
		
		threadWait1();
		transcript_conso.Click_RRN_RegNo();
		
		threadWait1();
		transcript_conso.Click_Search_btn();
		
		threadWait1();
		transcript_conso.Select_Session();
		
		// Transcript Report Format 2
		threadWait1();
		transcript_conso.Click_TranscriptReportFormat1_btn();
		
		threadWait1();
		pdfutility.downloadPDF(driver, "Examination - Transcript Consolidated Grade Card Report Format1");
		threadWait1();
		pdfutility.readPDF("Examination - Transcript Consolidated Grade Card Report Format1", "MUHAMMAD");	
		
	}
}
