package RFCCAcademicTest;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_StudentDisciplinaryAction_SingleStudent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_CR_StudentDisciplinaryAction_SingleStudentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_StudentDisciplinaryAction_SingleStudent singlestudent;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_CR_StudentDisciplinaryAction_SingleStudentTest() throws Exception {
		
		singlestudent = new AL_Academic_CR_StudentDisciplinaryAction_SingleStudent(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_StudentDisciplinaryAction_SingleStudentTest"); 
		threadWait1();
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Student Disciplinary Action => Single Student Disciplinary Action"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_CoordinatorRelated();
		
		threadWait1();
		singlestudent.Click_StudentDisciplinaryAction();
		
		threadWait1();
		singlestudent.Select_SchoolInstitute();
		
		threadWait1();
		singlestudent.Select_Session();
		
		threadWait1();
		singlestudent.Select_SearchCriteria();
		
		threadWait1();
		singlestudent.Select_Branch();
		
		threadWait1();
		singlestudent.Click_ShowDetailsBtn();
		
		threadWait1();
		singlestudent.Click_StudentName();
		
		
		threadWait1();
		singlestudent.Set_FromDate();
		
		threadWait1();
		singlestudent.To_Date();
		
		threadWait1();
		singlestudent.Select_Remark();
		
		threadWait1();
		singlestudent.Click_SubmitBtn();
		
		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(3000);
		alert.accept();
		
		threadWait1();
		singlestudent.Click_DownloadExcelbtn();          
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("Misconduct","STUDENT_DISCIPLINARY_ACTION_REPORT"); 

		
		threadWait1();
		singlestudent.Click_DownloadPDFbtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Student Disciplinary Action Single");
		Thread.sleep(2000);
		pdfutility.readPDF("Academic - Student Disciplinary Action Single", "Misconduct");
	}
}
