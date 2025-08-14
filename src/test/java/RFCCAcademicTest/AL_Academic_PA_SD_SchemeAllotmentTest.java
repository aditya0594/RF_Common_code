package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_SD_SchemeAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_PA_SD_SchemeAllotmentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_PA_SD_SchemeAllotment schemeallotment;
	ExcelUtility excelutilitytest;
	
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_PA_SD_SchemeAllotmentTest() throws Exception {
		
		test = reports.createTest("aL_Academics_PA_SchemeDataTest");
		HP = new HomePageAdmin(driver);
		schemeallotment = new AL_Academic_PA_SD_SchemeAllotment(driver);
		excelutilitytest = new ExcelUtility(driver);


		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academics ->Post Admission -> Scheme Data ->Scheme Allotment ");
		
		Thread.sleep(5000);
		HP.Academic();
		Thread.sleep(2000);
		HP.Academic_PostAdmission();
		Thread.sleep(2000);
		schemeallotment.click_SchemeData();

		Thread.sleep(2000);
		schemeallotment.click_SchemeAllotment_Tab();

		schemeallotment.select_school();
		Thread.sleep(2000);

		schemeallotment.select_degree();
		Thread.sleep(2000);

		schemeallotment.select_branch();
		Thread.sleep(2000);

		schemeallotment.select_admissionBatch();
		Thread.sleep(2000);

		schemeallotment.select_semester();
		Thread.sleep(2000);

		schemeallotment.click_show_button();
		Thread.sleep(2000);

		schemeallotment.scrollToView();

		Thread.sleep(2000);
		schemeallotment.click_checkbox();

		Thread.sleep(2000);
		schemeallotment.click_schemeAllotment_btn();

		Thread.sleep(4000);
		excelutilitytest.ReadExcel("ANJALI","SchemeAllotmentPendingStudent"); 


	}

}