package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import RFCCAcademic.AL_Academic_PA_BulkSectionAllotment;
import RFCCAcademic.AL_Academic_PA_ProgrammeOrBranchChange;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_ProgrammeOrBranchChangeTest extends BaseClass{

	private WebDriver driver;

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_ProgrammeOrBranchChange al_Academic_PA_ProgrammeOrBranchChange;
	
	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Academic_PA_BulkSectionAllotmentTest() throws Exception {

		
		test = reports.createTest("aL_Academic_PA_BulkSectionAllotmentTest");
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_PA_ProgrammeOrBranchChange = new AL_Academic_PA_ProgrammeOrBranchChange(driver);
		
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic-> Post Admission-> Programme/Branch Change");
		
		homePageAdmin.Academic();
		Thread.sleep(2000);
		homePageAdmin.Academic_PostAdmission();
		
		al_Academic_PA_ProgrammeOrBranchChange.click_programmeOrBranchChange_link();
		Thread.sleep(3000);
		al_Academic_PA_ProgrammeOrBranchChange.enter_searchString();
		Thread.sleep(3000);
		al_Academic_PA_ProgrammeOrBranchChange.click_show_button();
		Thread.sleep(3000);
		al_Academic_PA_ProgrammeOrBranchChange.Click_Student();
		Thread.sleep(3000);

		al_Academic_PA_ProgrammeOrBranchChange.select_college();
		Thread.sleep(3000);

		al_Academic_PA_ProgrammeOrBranchChange.select_session();
		Thread.sleep(3000);
		
		al_Academic_PA_ProgrammeOrBranchChange.select_receiptType();
		Thread.sleep(3000);
		
		al_Academic_PA_ProgrammeOrBranchChange.select_newDegree();
		Thread.sleep(3000);
	
		al_Academic_PA_ProgrammeOrBranchChange.select_newBranch();
		Thread.sleep(3000);
		
		al_Academic_PA_ProgrammeOrBranchChange.enter_remark();
		Thread.sleep(3000);
		
		al_Academic_PA_ProgrammeOrBranchChange.click_submit_button();
		
		Thread.sleep(5000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Branch changed successfully and confirmation mail has been sent to your Email ID."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
	
	}
}
