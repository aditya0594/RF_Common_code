package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_MarkEntryLockEntryNotDoneReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_MarkEntryLockEntryNotDoneReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_MarkEntryLockEntryNotDoneReport mark_lock_not;
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
	public void aL_Examination_ER_MarkEntryLockEntryNotDoneReportTest () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Mark_Entry_Lock_Entry_Not_Done_Report");
		
		mark_lock_not = new AL_Examination_ER_MarkEntryLockEntryNotDoneReport(driver);
		test = reports.createTest("aL_Examination_ER_MarkEntryLockEntryNotDoneReportTest ");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();

		

		Thread.sleep(5000);
		mark_lock_not.EXAMINATION_REPORT();
		
		Thread.sleep(5000);
		mark_lock_not.Mark_Entry_Lock_Entry();
		
		Thread.sleep(5000);
		mark_lock_not.Session();
		
		Thread.sleep(5000);
		mark_lock_not.College();
		
		Thread.sleep(5000);
		mark_lock_not.Semister();
		
		Thread.sleep(8000);
		mark_lock_not.Course_type();
		
		Thread.sleep(5000);
		mark_lock_not.Exam_pattern();
		
		Thread.sleep(5000);
		mark_lock_not.Exam_name();
		
		Thread.sleep(5000);
		mark_lock_not.Sub_Exam();
		
		Thread.sleep(5000);
		mark_lock_not.Mark_entry_not_don_repo_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "Mark Entry Lock Entry Not Done Report");
	}


}
