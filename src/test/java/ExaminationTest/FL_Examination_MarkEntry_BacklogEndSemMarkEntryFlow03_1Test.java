package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 backlog_end_sem_mark;
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
	public void fL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1Test() throws InterruptedException, IOException, AWTException {
		
		System.out.println("Examination==>Mark Entry==> BackLog End Sem Mark Entry");
		
		backlog_end_sem_mark = new FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1(driver);
		pdfutility =new PDFUtility(driver);	
		test = reports.createTest("fL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1Test");
		
		backlog_end_sem_mark.Enter_FacultyLoginCreds();
		
		threadWait2();
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		threadWait2();
		backlog_end_sem_mark.Click_MarkEntry();
		
		threadWait2();
		backlog_end_sem_mark.Click_BacklogEndSemMarkEntry();
		
		threadWait2();
		backlog_end_sem_mark.Select_Session();
		
		threadWait2();
		backlog_end_sem_mark.Click_Course();
		
		threadWait2();
		backlog_end_sem_mark.Enter_BacklogEndSemMarks();
		
		threadWait2();
		backlog_end_sem_mark.Click_Lock_btn();
		
		threadWait2();
		backlog_end_sem_mark.Click_Reportbtn();
		
		threadWait2();
		pdfutility.downloadPDF(driver, "Examination - Backlog End Sem Mark Entry");
		threadWait1();
		pdfutility.readPDF("Examination - Backlog End Sem Mark Entry", "SHAHID");	

	}
}
