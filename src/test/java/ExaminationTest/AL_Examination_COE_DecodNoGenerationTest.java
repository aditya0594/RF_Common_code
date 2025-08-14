package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_COE_DecodNoGeneration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_COE_DecodNoGenerationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_COE_DecodNoGeneration al_Examination_COE_DecodNoGeneration;
	ExcelUtility excelutilitytest;

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
	public void aL_Examination_COE_DecodNoGenerationTest() throws InterruptedException, IOException {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_COE_DecodNoGeneration = new AL_Examination_COE_DecodNoGeneration(driver);
		excelutilitytest = new ExcelUtility(driver);


		test = reports.createTest("DecodNoGeneration");
		RF_AdminLoginPage.loginPage();

		System.out.println("Examination - Conduction of Examination -> Decode No. Generation");
		// Select Examination
		homePageAdmin.EXAMINATION();
		Thread.sleep(2000);

		// Select Conduction of Examination
		homePageAdmin.Exam_ConductionOfExamination();
		Thread.sleep(2000);

		// click Decode No. Generation
		al_Examination_COE_DecodNoGeneration.click_DecodeNoGeneration_Link();
		Thread.sleep(2000);

		// --------------To select college & Scheme
		al_Examination_COE_DecodNoGeneration.select_College();
		Thread.sleep(2000);

		// ---------To select Session
		al_Examination_COE_DecodNoGeneration.select_Session(); 
		Thread.sleep(2000);

		//select semester
		al_Examination_COE_DecodNoGeneration.select_Semester();
		Thread.sleep(2000);

		//select course
		al_Examination_COE_DecodNoGeneration.select_Course();
		Thread.sleep(2000);

		//Select Number Type
		al_Examination_COE_DecodNoGeneration.select_NumberType();
		Thread.sleep(2000);

		//Select Number Type
		al_Examination_COE_DecodNoGeneration.Select_StudentType();
		Thread.sleep(2000);

				
		//Click Show Button
		al_Examination_COE_DecodNoGeneration.click_Show_Button();
		Thread.sleep(2000);

		//Click Generate Number Button
		al_Examination_COE_DecodNoGeneration.click_GenerateNo_Button();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);


		//Click Roll List Excel Report Button
		al_Examination_COE_DecodNoGeneration.click_RolllistExcelReport_Button();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("MOHAMED","StudentRollList"); 
	}

}
