package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_PEA_ExamAdmitCardGeneration;
import net.sourceforge.tess4j.TesseractException;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_PEA_ExamAdmitCardGenerationTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_PEA_ExamAdmitCardGeneration al_Examination_PEA_ExamAdmitCardGeneration;
	PDFUtility pdfutility;

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
	public void aL_Examination_PEA_ExamAdmitCardGenerationTest()
			throws InterruptedException, IOException, TesseractException, AWTException {
		pdfutility = new PDFUtility(driver);

		System.out.println("Exam Admit Card Generation");
		test = reports.createTest("aL_Examination_PEA_ExamAdmitCardGenerationTest");

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_PEA_ExamAdmitCardGeneration = new AL_Examination_PEA_ExamAdmitCardGeneration(driver);

		threadWait1();

		// Login to website
		RF_AdminLoginPage.loginPage();
		threadWait1();

		// Move to Examination
		homePageAdmin.EXAMINATION();
		threadWait1();

		// Click on Examination Reports Option
		homePageAdmin.Exam_PreExamActivities();
		threadWait1();

		// Click on Exam Admit Card Generation in sub Menu
		al_Examination_PEA_ExamAdmitCardGeneration.Click_ExamAdmitCardGen_Link();
		threadWait1();

		// Select College & Institute
		al_Examination_PEA_ExamAdmitCardGeneration.Select_College();
		threadWait1();

		// Select Session
		al_Examination_PEA_ExamAdmitCardGeneration.Select_Session();
		threadWait1();

		// Select Semester
		al_Examination_PEA_ExamAdmitCardGeneration.Select_Semester();
		threadWait1();

	
		// Select Exam Name
		al_Examination_PEA_ExamAdmitCardGeneration.Select_ExamName();
		threadWait1();

		// Enter Convocation Date
		al_Examination_PEA_ExamAdmitCardGeneration.Enter_ConvocationDate();
		threadWait1();

		// Click on Show Students Button
		al_Examination_PEA_ExamAdmitCardGeneration.Click_ShowStudent_Button();
		threadWait1();

		// Select Student
		al_Examination_PEA_ExamAdmitCardGeneration.Select_StudentFromList();
		threadWait1();

		// Click on Admit Card Button
		threadWait1();
		al_Examination_PEA_ExamAdmitCardGeneration.Click_AdmitCard_Button();
		threadWait1();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Exam - Admit Card");
		threadWait1();
		pdfutility.readPDF("Exam - Admit Card", "ABDUL");

	}

}
