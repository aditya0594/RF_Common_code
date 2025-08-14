package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_COE_IGradeEntry_BulkIGradeEntry;
import Examination.AL_Examination_ER_MarkEntryLockEntryNotDoneReport;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_COE_IGradeEntry_BulkIGradeEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Examination_COE_IGradeEntry_BulkIGradeEntryTest () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Conduction of Examination==>I Grade Mark Entry =>Bulk I Grade Entry");
		
		bulk_i_grade = new AL_Examination_COE_IGradeEntry_BulkIGradeEntry(driver);
		test = reports.createTest("aL_Examination_COE_IGradeEntry_BulkIGradeEntryTest ");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		

		Thread.sleep(5000);;
		HP.Exam_ConductionOfExamination();
		
		Thread.sleep(5000);;
		bulk_i_grade.Click_I_Grade_Entry();
		
		Thread.sleep(5000);;
		bulk_i_grade.Click_Bulk_I_Grade_Entry();
		
		Thread.sleep(5000);
		bulk_i_grade.Select_College_scheme();
		
		Thread.sleep(5000);;
		bulk_i_grade.Select_Session();
		
		Thread.sleep(5000);;
		bulk_i_grade.Select_Semister();
		
		Thread.sleep(5000);;
		bulk_i_grade.Select_Subject();
		
		Thread.sleep(5000);
		bulk_i_grade.Click_showBtn();
		
		Thread.sleep(5000);
		bulk_i_grade.Click_checkBox();
		
		Thread.sleep(5000);;
		bulk_i_grade.Click_submitBtn();
		
		Thread.sleep(5000);;
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Students Grade Are Updated Successfully";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(5000);;
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept(); 
	}
}
