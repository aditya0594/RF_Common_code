package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_FinalDetentionFlow09_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_CR_FinalDetentionFlow09_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_FinalDetentionFlow09_2 finalDetain;
	HomePageAdmin HP;
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
	public void aL_Academic_CR_FinalDetentionTest() throws IOException, Throwable 
 {
		
		finalDetain = new AL_Academic_CR_FinalDetentionFlow09_2(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_FinalDetentionTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Final Detention "); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(4000);
		finalDetain.Click_FinalDetention();
		
		Thread.sleep(4000);
		finalDetain.Select_CollegeScheme();
		
		Thread.sleep(4000);
		finalDetain.Select_Session();
		
		Thread.sleep(4000);
		finalDetain.Select_Semister();
		
		Thread.sleep(4000);
		finalDetain.Click_DetentionToAllSubjectsBtn();
		
		Thread.sleep(4000);
		finalDetain.Click_ShowStudentBtn();
		
		Thread.sleep(4000);
		finalDetain.Click_CheckBox();
		
		Thread.sleep(4000);
		finalDetain.Click_SubmitBtn();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Final Detention entry done successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		Thread.sleep(4000);
		finalDetain.Click_FinalDetaintionReportBtn();
		
		Thread.sleep(4000);
		excelutilitytest.ReadExcel("Rajat ","Final Detaintion Report"); 
 	}
}
