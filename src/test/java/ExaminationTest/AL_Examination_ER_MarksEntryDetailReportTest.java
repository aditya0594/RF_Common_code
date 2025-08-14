package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_MarksEntryDetailReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_MarksEntryDetailReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_MarksEntryDetailReport markentry;
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
	public void aL_Examination_ER_MarksEntryDetailReportTest () throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Marks Entry Detail Report");
		
		markentry = new AL_Examination_ER_MarksEntryDetailReport(driver);
		pdfutility =new PDFUtility(driver);	
		test = reports.createTest("aL_Examination_ER_MarksEntryDetailReportTest ");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();

		

		Thread.sleep(5000);;
		markentry.EXAMINATION_REPORT();
		
		Thread.sleep(5000);;
		markentry.MarksEntryDetailReport();
		
		Thread.sleep(5000);;
		markentry.Select_SchoolInstituteName();
		
		Thread.sleep(5000);
		markentry.Select_Session();
		
		Thread.sleep(5000);;
		markentry.Select_Semister();
		
		Thread.sleep(5000);
		markentry.Select_SubjectType();
		
		Thread.sleep(5000);
		
		markentry.Select_Course();
		
		Thread.sleep(5000);
		markentry.Click_ShowBtn();
		
		Thread.sleep(5000);
		markentry.Click_DownArrow();
		
		Thread.sleep(5000);
		markentry.Click_SubjectWiseMarkEntryReportBtn();
		
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Examination - Subject Wise Marks Entry Detail Report");
		pdfutility.readPDF("Examination - Subject Wise Marks Entry Detail Report", "ABDUL");	

//		switchToFrameOrDefault();
//		Thread.sleep(5000);;
//		
//		String parent = driver.getWindowHandle();
//	    Set<String> s =driver.getWindowHandles();
//	    Iterator<String> I1= s.iterator();
//	    while(I1.hasNext())
//	    {
//		    String child_window=I1.next();
//		    if(!parent.equals(child_window))
//		    {
//			    driver.switchTo().window(child_window);
//			    System.out.println(driver.switchTo().window(child_window).getTitle());
//			    Thread.sleep(5000);;
//				System.out.println("Inside child window");
//				Thread.sleep(5000);
//				pdfutility.downloadPDF(driver, "Examination - Marks Entry Detail Report");
//				pdfutility.readPDF("Examination - Marks Entry Detail Report", "ABDUL");	
//		    }
//		 }
//	    driver.switchTo().window(parent);
//	    System.out.println("Inside main browser");
		
//	    // 2 nd report
//		Thread.sleep(5000);
//		markentry.Click_BlankMarkReportBtn();
//		Thread.sleep(5000);
//		pdfutility.downloadPDF(driver, "Examination - Blank Mark Report");
//		pdfutility.readPDF("Examination - Blank Mark Report", "ABDUL");	
	}
}
