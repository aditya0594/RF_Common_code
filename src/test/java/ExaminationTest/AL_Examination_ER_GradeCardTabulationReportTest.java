package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_GradeCardTabulationReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_ER_GradeCardTabulationReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_ER_GradeCardTabulationReport al_Examination_ER_GradeCardTabulationReport;
	PDFUtility pdfutility;
	
	@BeforeMethod
	  public void launchBrowser(Method m) throws Exception 
	  {
			driver = Browser.openBrowser("url_RF_LoginAdmin");
			System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n"); 
	  }
	  

	  @BeforeTest
	  public void configureReport() 
	  {
			reports = Reports.createReport(); 
	  }
	
  @Test
  public void aL_Examination_ER_GradeCardTabulationReportTest() throws InterruptedException, IOException, AWTException
  {
	  System.out.println("Examination->Examination Reports->Grade Card /Tabulation Reports");
	  
	    test = reports.createTest("AdminExamination_MarkEntry");
	    homePageAdmin = new HomePageAdmin(driver);
	    al_Examination_ER_GradeCardTabulationReport = new AL_Examination_ER_GradeCardTabulationReport(driver);
		pdfutility = new PDFUtility(driver);
		Thread.sleep(3000);

		//Login to website
		RF_AdminLoginPage.loginPage();
		Thread.sleep(3000);
		
		//Move to Examination 
		homePageAdmin.EXAMINATION();
		Thread.sleep(3000);
		 
		//Click on Examination Reports Option
		homePageAdmin.Exam_ExaminationReports();
		Thread.sleep(3000);
		
		//Click on Grade Card/Tabulation Reports in sub Menu
		al_Examination_ER_GradeCardTabulationReport.Click_GradeCardReport_Link();
		Thread.sleep(3000);
		
		//Select College & Scheme 
		al_Examination_ER_GradeCardTabulationReport.Select_College();
		Thread.sleep(3000);
		
		//Select Session 
		al_Examination_ER_GradeCardTabulationReport.Select_Session();
		Thread.sleep(3000);
		
		//Select Semester 
		al_Examination_ER_GradeCardTabulationReport.Select_Semester();
		Thread.sleep(3000);
		
 		//Select Student Type
		al_Examination_ER_GradeCardTabulationReport.Select_StudentType();
		Thread.sleep(3000);
		
		//Enter Date of Publish
		al_Examination_ER_GradeCardTabulationReport.Enter_DateOfPublish();
		Thread.sleep(3000);
	
		//Enter Date of issue
		al_Examination_ER_GradeCardTabulationReport.Enter_DateOfIssue();
		Thread.sleep(3000);
		
		//Click on Show Students Button
		al_Examination_ER_GradeCardTabulationReport.Click_ShowStudent_Button();
		Thread.sleep(3000);
		
		//Select Student
		al_Examination_ER_GradeCardTabulationReport.Select_Student();
		Thread.sleep(3000); 
		
		//Click on Grade Card Button
		al_Examination_ER_GradeCardTabulationReport.Click_GradeCard_Button();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		switchToNextWindow();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Exam - Grade Card Tabulation Report");
		Thread.sleep(5000); 
		pdfutility.readPDF("Exam - Grade Card Tabulation Report", "ABDUL");
		
	
  }
}
