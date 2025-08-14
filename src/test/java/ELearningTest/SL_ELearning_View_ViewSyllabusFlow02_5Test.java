package ELearningTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageStudent;

import ELearning.SL_ELearning_View_ViewSyllabusFlow02_5;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class SL_ELearning_View_ViewSyllabusFlow02_5Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageStudent homePageStudent;
	PDFUtility pdfutility;
	SL_ELearning_View_ViewSyllabusFlow02_5 sl_ELearning_View_ViewSyllabus;

	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n"); 
	}

	@Test
	public void sL_ELearning_View_ViewSyllabusFlow02_5Test() throws Throwable {
		
		homePageStudent = new HomePageStudent(driver);
		sl_ELearning_View_ViewSyllabus = new SL_ELearning_View_ViewSyllabusFlow02_5(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("sL_ELearning_View_ViewSyllabusFlow02_5Test");
		
		sl_ELearning_View_ViewSyllabus.login();
	
		Thread.sleep(2000);
		homePageStudent.ELEARNING();

		Thread.sleep(3000);
		homePageStudent.Elearning_Trans();

		Thread.sleep(2000);
		sl_ELearning_View_ViewSyllabus.select_Session();

		Thread.sleep(2000);
		sl_ELearning_View_ViewSyllabus.select_Course();
		
		Thread.sleep(2000);
		sl_ELearning_View_ViewSyllabus.clicl_ok_button();
		
		Thread.sleep(2000);
		homePageStudent.ELEARNING();

		Thread.sleep(2000);
		homePageStudent.Elearning_View();

		Thread.sleep(2000);
		sl_ELearning_View_ViewSyllabus.click_viewSyllabus_Link();
				
		Thread.sleep(2000);
		sl_ELearning_View_ViewSyllabus.click_download_button();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Elearning - View Syllabus");
		Thread.sleep(5000);
		pdfutility.readPDF("Elearning - View Syllabus", "Income");
	}
}

