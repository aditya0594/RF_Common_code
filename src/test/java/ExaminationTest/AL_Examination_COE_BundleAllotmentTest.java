package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_COE_BundleAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_COE_BundleAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_COE_BundleAllotment bundle_allotm;
	HomePageAdmin HP;
	Actions action;
	PDFUtility pdfutility;
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
	public void aL_Examination_COE_BundleAllotmentTest () throws InterruptedException, IOException, AWTException, Exception {
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		
		Thread.sleep(2000);

		action = new Actions(driver);
		
		bundle_allotm = new AL_Examination_COE_BundleAllotment(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Examination_COE_BundleAllotmentTest ");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		
		HP.EXAMINATION();

		System.out.println("Examination==>Conduction of Examination=> Bundle Allotment");

		Thread.sleep(4000);
		
		Thread.sleep(2000);
		bundle_allotm.CONDUCTION_OF_EXAMINATION();
		
		Thread.sleep(2000);
		bundle_allotm.Click_BundleAllotment();
		
		Thread.sleep(2000);
		bundle_allotm.Select_Session();
		
		Thread.sleep(2000);
		bundle_allotm.Select_CourseCode();
		
		Thread.sleep(2000);
		bundle_allotm.Select_Unknown();
		
		Thread.sleep(3000);
		bundle_allotm.Select_FacultyName();
		
		Thread.sleep(2000);
		bundle_allotm.Click_submitBtn();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = " Assigned to Valuer Successfully..!!";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(2000);
		bundle_allotm.Select_DateOfExam();
		
		Thread.sleep(3000);
		bundle_allotm.Click_ReportBtn();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Examination - Bundle Allotment");
		pdfutility.readPDF("Examination - Bundle Allotment", "MADHUMATHI");	
	}
}
