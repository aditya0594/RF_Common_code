package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.SL_ELearning_Trans_ViewLectureNotesFlow02_3;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class SL_ELearning_Trans_ViewLectureNotesFlow02_3Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	HomePageAdmin homePageAdmin;
	SL_ELearning_Trans_ViewLectureNotesFlow02_3 sl_ELearning_Trans_ViewLectureNotes;
	
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
	public void sL_ELearning_Trans_ViewLectureNotesFlow02_2Test() throws Throwable {
		test = reports.createTest("sL_ELearning_Trans_ViewLectureNotesFlow02_2Test");
		homePageAdmin = new HomePageAdmin(driver);
		pdfutility = new PDFUtility(driver);
		sl_ELearning_Trans_ViewLectureNotes = new SL_ELearning_Trans_ViewLectureNotesFlow02_3(driver);
		
		sl_ELearning_Trans_ViewLectureNotes.login();

		Thread.sleep(2000);
		homePageAdmin.ELearning();

		Thread.sleep(3000);
		homePageAdmin.ELearning_Transaction();

		Thread.sleep(2000);
		sl_ELearning_Trans_ViewLectureNotes.select_session();
		
		Thread.sleep(2000);
		sl_ELearning_Trans_ViewLectureNotes.select_course();
		
		Thread.sleep(2000);
		homePageAdmin.ELearning();

		Thread.sleep(2000);
		homePageAdmin.Elearning_View(); 

		Thread.sleep(2000);
		sl_ELearning_Trans_ViewLectureNotes.click_viewLectureNotes_link();

		Thread.sleep(2000);
		sl_ELearning_Trans_ViewLectureNotes.click_edit_button();
	
		Thread.sleep(2000);
		sl_ELearning_Trans_ViewLectureNotes.click_download_button();

		Thread.sleep(4000);
		switchToNextWindow();
		
		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "E-Learning - View Lecture Notes"); 
		Thread.sleep(3000);
		pdfutility.readPDF("E-Learning - View Lecture Notes", "B.COM (Hons.)");

	}
}

