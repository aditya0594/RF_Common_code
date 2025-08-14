package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_DemandCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_PA_DemandCreationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_PA_DemandCreation demandcreation;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;        
	

	@BeforeTest
	public void configureReport() { 
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*********Starting Test : " + m.getName() + "******" + "\n");
	}
 
	@Test
	public void demandcreationTest() throws Exception {
		test = reports.createTest("demandcreationTest");
		Thread.sleep(3000);
		demandcreation = new AL_Academic_PA_DemandCreation(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		

		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Pre Admission->Demand Creation ");
		
		Thread.sleep(4000);
		
		HP.Academic();
		Thread.sleep(4000);
		
		HP.Academic_PreAdmission();
		Thread.sleep(4000);
	
		Thread.sleep(2000);
		//click on Demand Creation
		demandcreation.click_Demand_Creation();
		System.out.println("click Demand Creation");

		Thread.sleep(2000);
		//Select Session
		demandcreation.select_Session();
		System.out.println("Session -> May 2022");	
		Thread.sleep(2000);

		//Select College
		demandcreation.select_School();	
		Thread.sleep(2000); 

		//Select Receipt Type		
		demandcreation.select_Receipt_Type();
		System.out.println("Select -> Admission Fee");		
		Thread.sleep(2000);

		//Select Degree
		demandcreation.select_Degree();	
		Thread.sleep(2000);

		//Select Program Branch
		demandcreation.select_Branch();
		Thread.sleep(2000);

		//Select Semester
		demandcreation.select_Semester();	
		Thread.sleep(2000);

		//Select Demand Semester
		demandcreation.select_Demand_Semester();
		Thread.sleep(2000);

		//Select Payment Type
		demandcreation.select_Payment_Type();	
		Thread.sleep(2000);

		//Click show student
		demandcreation.click_Show_Button();
		System.out.println("Click on Show Students Under Selected Criteria");	
		Thread.sleep(2000);

		//Click checkbox
		demandcreation.click_Student_Checkbox();
		System.out.println("Click on List of Students -> CheckBox 1st");
		Thread.sleep(2000);

		//Demand Creation for Selected Student
		demandcreation.click_Demand_For_Selected_Students();
		System.out.println("Click on Create Demand for Selected Students"); 

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Demand successfully created for selected students.";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

		Thread.sleep(2000);
		//click on show reports
		demandcreation.click_show_Report_Button();
		System.out.println("Click show report button");

		Thread.sleep(5000);
		excelutilitytest.ReadExcel("ABIRAMI","FeeDemandReport"); 
		
		
	}

}
