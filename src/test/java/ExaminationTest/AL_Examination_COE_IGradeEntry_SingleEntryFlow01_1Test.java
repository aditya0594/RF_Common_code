package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 al_Examination_COE_IGradeEntry_SingleEntry;
	
	@BeforeTest
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");  
	}

	@Test
	public void aL_Examination_COE_IGradeEntry_SingleEntryFlow01_1Test() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_COE_IGradeEntry_SingleEntry = new AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1(driver);
		
		test = reports.createTest("aL_Examination_COE_IGradeEntry_SingleEntryFlow01_1Test");
		RF_AdminLoginPage.loginPage();

		//Move to Examination
		homePageAdmin.EXAMINATION();

		threadWait1();
		// Locating the element from Sub Menu
		homePageAdmin.Exam_ConductionOfExamination();

		threadWait1();
		// Locating the element from Sub Menu
		al_Examination_COE_IGradeEntry_SingleEntry.click_IGradeEntry_Link();

		threadWait1();
		//click Single Individual Student Entry Radio Button
		al_Examination_COE_IGradeEntry_SingleEntry.click_SingleIndividualStudentEntry();

		threadWait1();
		//Select Session
		al_Examination_COE_IGradeEntry_SingleEntry.select_Session();

		threadWait1();
		//Select Semester
		al_Examination_COE_IGradeEntry_SingleEntry.Select_Semester();

		threadWait1();
		//Enter Registration Number
		al_Examination_COE_IGradeEntry_SingleEntry.enter_RegNo();

		threadWait1();
		//Click Show Button
		al_Examination_COE_IGradeEntry_SingleEntry.click_Show_Button();

		threadWait1();
		//Search Course 
		al_Examination_COE_IGradeEntry_SingleEntry.Search_Course();
		
		threadWait1();
		//Click Submit Button
		al_Examination_COE_IGradeEntry_SingleEntry.click_Submit_Button();

		threadWait1();
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Students Grade Are Updated Successfully";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		threadWait1();
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

	}
}