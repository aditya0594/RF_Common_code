package ExaminationTest;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_PEA_ExamTimeTable;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;



public class AL_Examination_PEA_ExamTimeTableTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_PEA_ExamTimeTable examtimetable;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}
	
	@Test
	public void aL_Examination_PEA_ExamTimeTableTest() throws Exception {
		

		homePageAdmin = new HomePageAdmin(driver);
		examtimetable = new AL_Examination_PEA_ExamTimeTable(driver);
		
		RF_AdminLoginPage.loginPage();
		
 		Thread.sleep(2000);
 		//Click Examination Main Menu
 		homePageAdmin.EXAMINATION();
		
		Thread.sleep(2000);
		//Click pre Examination Activities
		homePageAdmin.Exam_PreExamActivities();
		
		Thread.sleep(3000);
		examtimetable.Select_CollegeName();
		
		Thread.sleep(3000);
		examtimetable.select_session();
		
		Thread.sleep(3000);
		examtimetable.select_SchemePath();
		
		Thread.sleep(3000);
		examtimetable.select_semester();
		
		Thread.sleep(3000);
		examtimetable.select_subjectType();
		
		Thread.sleep(3000);
		examtimetable.select_examName();
		
		Thread.sleep(3000);
		examtimetable.click_showCourse_button();
		
		Thread.sleep(3000);
		examtimetable.check_checkbox();
		
		Thread.sleep(3000);
		examtimetable.enter_examDate();
		
		Thread.sleep(3000);
		examtimetable.select_slot();
		
		Thread.sleep(3000);
		examtimetable.click_submit_button();
		
		Thread.sleep(3000);
		examtimetable.Click_ExamTimeTableReportBtn();
		
//		Thread.sleep(6000);
//		examtimetable.Click_BranchWiseTimeTableReportBtn();
	    
	}
}