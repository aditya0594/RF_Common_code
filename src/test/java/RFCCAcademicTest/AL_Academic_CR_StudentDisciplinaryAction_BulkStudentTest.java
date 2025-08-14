package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_StudentDisciplinaryAction_BulkStudent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_StudentDisciplinaryAction_BulkStudentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_StudentDisciplinaryAction_BulkStudent singlestudent;
	HomePageAdmin HP;
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
	public void aL_Academic_CR_StudentDisciplinaryAction_BulkStudentTest() throws Exception {
		
		singlestudent = new AL_Academic_CR_StudentDisciplinaryAction_BulkStudent(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_StudentDisciplinaryAction_BulkStudentTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Student Disciplinary Action => Bulk Student Disciplinary Action"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(4000);
		singlestudent.Click_StudentDisciplinaryAction();
		
		Thread.sleep(4000);
		singlestudent.Select_BulkStudentDisciplinaryAction();
		
		Thread.sleep(4000);
		singlestudent.Select_SchoolInstitute();
		
		Thread.sleep(4000);
		singlestudent.Select_Session();
		
		Thread.sleep(4000);
		singlestudent.Select_Degree();
		
		Thread.sleep(4000);
		singlestudent.Click_ShowDetailsBtn();
		
		Thread.sleep(4000);
		singlestudent.Select_Remarks();
		
		Thread.sleep(4000);
		singlestudent.Select_FromDate();
		
		Thread.sleep(4000);
		singlestudent.Select_ToDate();
		
		Thread.sleep(4000);
		singlestudent.Click_CheckBox();
		
		Thread.sleep(4000);
		singlestudent.Click_Submitbtn();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000); 
		alert.accept();
	}
}
