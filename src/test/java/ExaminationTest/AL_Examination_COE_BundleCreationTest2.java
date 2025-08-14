package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_COE_BundleCreation2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_COE_BundleCreationTest2 extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_COE_BundleCreation2 al_Examination_COE_BundleCreation;
	PDFUtility pdfutility;

	@BeforeTest
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n"); 
	}

	@Test
	public void aL_Examination_COE_BundleCreationTest2() throws InterruptedException, IOException, AWTException {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_COE_BundleCreation = new AL_Examination_COE_BundleCreation2(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("Bundle_Creation");
		RF_AdminLoginPage.loginPage();

		// Move to Examination
		homePageAdmin.EXAMINATION();
		Thread.sleep(3000);

		// Move to Conduction Of Examination
		homePageAdmin.Exam_ConductionOfExamination();
		Thread.sleep(3000);

		// Click Bundle Creation Link
		al_Examination_COE_BundleCreation.click_BundleCreation_Link();
		Thread.sleep(3000);

		System.out.println("Examination -> Conduction of Examination -> Bundle Creation");

		// --------------To select college & Scheme
		al_Examination_COE_BundleCreation.select_College();
		Thread.sleep(3000);

		// ---------To select Session
		al_Examination_COE_BundleCreation.select_Session();
		Thread.sleep(3000);

		// Select Date
		al_Examination_COE_BundleCreation.select_Date();
		Thread.sleep(3000);

		// Select Exam Slot
		al_Examination_COE_BundleCreation.select_Slot();
		Thread.sleep(3000);

		// enter No. of Answer Books Per Bundle
		al_Examination_COE_BundleCreation.enter_NoOfAnsBookPerBundle();
		Thread.sleep(3000);

		// Select Course
		al_Examination_COE_BundleCreation.select_Course();
		Thread.sleep(4000);

		// Click Submit Button
		al_Examination_COE_BundleCreation.click_Submit_Button();

		Thread.sleep(4000);
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(4000);
		// Click Report Button
		al_Examination_COE_BundleCreation.click_Report_Button();
		Thread.sleep(4000);
		switchToNextWindow();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Exam - Bundle Creation - Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Exam - Bundle Creation - Report", "Theory");	

	}

}
