package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_ProspectusEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

@Listeners(utility.Listeners.class)

public class AL_Academic_AP_ProspectusEntryTest extends BaseClass { 

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AP_ProspectusEntry al_Academic_AP_ProspectusEntry;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "******" + "\n");
	}

	public int getTimestampAsInt() {
		return (int) (System.currentTimeMillis() / 1000); 
	}

	@Test
	public void aL_Academic_AP_ProspectusEntryTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AP_ProspectusEntry = new AL_Academic_AP_ProspectusEntry(driver);

		int pros_no;

		pros_no =getTimestampAsInt();
		test = reports.createTest("AL_Academic_AP_ProspectusEntryTest");

		Thread.sleep(3000);
		RF_AdminLoginPage.loginPage();

		System.out.println("ACADEMIC->Admission Process->Prospectus entry");

		Thread.sleep(3000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(3000);

		//Click on Admission Process
		homePageAdmin.Academic_AdmissionProcess(); 
		Thread.sleep(3000);

		//Click on Prospectus entry
		al_Academic_AP_ProspectusEntry.click_ProcpectusEntry_Link();
		Thread.sleep(3000);

		//Enter Student Name
		al_Academic_AP_ProspectusEntry.enter_Student_Name();
		Thread.sleep(3000);

		//Select School Name
		al_Academic_AP_ProspectusEntry.select_School();
		Thread.sleep(3000); 

		//Select Degree
		al_Academic_AP_ProspectusEntry.select_Degree();
		Thread.sleep(3000);

		//Select Branch
		al_Academic_AP_ProspectusEntry.select_Branch();
		Thread.sleep(5000);

		//Enter Mobile Number
		al_Academic_AP_ProspectusEntry.enter_Mobile_Number();
		Thread.sleep(3000);

		//Enter Prospectus Number
		al_Academic_AP_ProspectusEntry.enter_ProspectusNumber(pros_no);
		Thread.sleep(3000);

		//Enter Total Number
		al_Academic_AP_ProspectusEntry.enter_TotalAmount();
		Thread.sleep(3000);

		//Select Remark
		al_Academic_AP_ProspectusEntry.select_Remark();
		Thread.sleep(3000);

		//Click Submit Button
		al_Academic_AP_ProspectusEntry.click_Submit_Button();
		Thread.sleep(3000);

		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Prospectus Entry Done Successfully!. Now you can print receipt to click on Prospectus Receipt button.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
	}
}
