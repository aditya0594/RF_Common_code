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

import Examination.FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 reval_mark_entry;
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
	public void fL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1Test() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Mark Entry==> Revalution Mark Entry");
		
		reval_mark_entry = new FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1(driver);
		test = reports.createTest("fL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1Test");
		pdfutility =new PDFUtility(driver);	
	
		threadWait1();
		reval_mark_entry.Login_Faculty();
		
		threadWait1();
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		threadWait1();;
		reval_mark_entry.Click_MarkEntry();
		
		threadWait1();;
		reval_mark_entry.Click_revaluationMarkEntry();
		
		threadWait1();;
		reval_mark_entry.Select_Session();
		
		threadWait1();;
		reval_mark_entry.Click_Course();
		
		threadWait1();;
		reval_mark_entry.Enter_EndSemMarks();
		
		threadWait1();;
		reval_mark_entry.Click_Save_btn();
		
		threadWait1();;
		reval_mark_entry.Click_Lock_btn();
		
		threadWait1();;
		reval_mark_entry.Click_MarkEntryReport();
		
		threadWait1();
		pdfutility.downloadPDF(driver, "Examination - Revaluation Mark Entry");
		Thread.sleep(2000);
		pdfutility.readPDF("Examination - Revaluation Mark Entry", "AKIL");	
	}
}
