package ELearningTest;

import java.lang.reflect.Method;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageStudent;

import ELearning.SL_Elearning_View_AccessELibraryFlow01_2;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class SL_Elearning_View_AccessELibraryFlow01_2Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageStudent homePageStudent;
	PDFUtility pdfutility;
	SL_Elearning_View_AccessELibraryFlow01_2 sl_Elearning_View_AccessELibrary;
	
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
	public void sL_Elearning_View_AccessELibraryFlow01_2Test() throws Throwable {
		
		homePageStudent = new HomePageStudent(driver);
		sl_Elearning_View_AccessELibrary = new SL_Elearning_View_AccessELibraryFlow01_2(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("sL_Elearning_View_AccessELibraryFlow01_2Test"); 
		
		Thread.sleep(2000);
		sl_Elearning_View_AccessELibrary.login();

		Thread.sleep(2000);
		//Click main E-Learning Menu
		homePageStudent.ELEARNING();

		Thread.sleep(3000);
		//Click Transactions submenu
		homePageStudent.Elearning_Trans();

		Thread.sleep(2000);
		sl_Elearning_View_AccessELibrary.select_Session();
		
		Thread.sleep(2000);
		sl_Elearning_View_AccessELibrary.select_Course();
		
		Thread.sleep(2000);
		sl_Elearning_View_AccessELibrary.click_OK_button();

		Thread.sleep(2000);
		//Select Elearning
		homePageStudent.ELEARNING(); 

		Thread.sleep(2000);
		//Click on View
		homePageStudent.Elearning_View();

		Thread.sleep(2000);
		//Click on Access E-Library
		sl_Elearning_View_AccessELibrary.click_accessELibrary();

		Thread.sleep(4000);
		//Click view button
		sl_Elearning_View_AccessELibrary.click_edit_btn();
		
		String Actual_Msg=sl_Elearning_View_AccessELibrary.getTextFromElement();
		
		String Expected_Msg = "Income Tax amd Law Practicee";  
		//String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg); 
		
	}
}

