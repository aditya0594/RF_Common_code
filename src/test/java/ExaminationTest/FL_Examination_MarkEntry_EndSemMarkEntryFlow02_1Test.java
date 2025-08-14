package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1;

import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 end_sem_mark;
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
	public void fL_Examination_MarkEntry_EndSemMarkEntryFlow02_1Test() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Mark Entry==> End Sem Mark Entry");
		
		end_sem_mark = new FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1(driver);
		test = reports.createTest("fL_Examination_MarkEntry_EndSemMarkEntryFlow02_1Test");
		
		end_sem_mark.FacultyLogin();
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(5000);;
		end_sem_mark.Click_MarkEntry();
		
		Thread.sleep(5000);;
		end_sem_mark.Click_EndSemMarkEntry();
		
		Thread.sleep(5000);;
		end_sem_mark.Select_Session();
		
		Thread.sleep(5000);;
		end_sem_mark.Click_Course();
		
		Thread.sleep(5000);;
		end_sem_mark.Enter_EndSemMarks();
		
		Thread.sleep(5000);;
		end_sem_mark.Click_Save_btn();
		
		Thread.sleep(5000);;
		end_sem_mark.Click_Lock_btn();
		
		Thread.sleep(5000);;
		end_sem_mark.Click_Format1();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		
		captureScreenshot(driver, "End Sem Mark Entry Report");
	}
	
}
