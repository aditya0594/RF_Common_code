package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_CreateAnnouncementFlow06_1;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class FL_ELearning_Trans_CreateAnnouncementFlow06_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	FL_ELearning_Trans_CreateAnnouncementFlow06_1 CreateAnnouncement;
	HomePageAdmin HP;
	

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
	public void fL_ELearning_Trans_CreateAnnouncementFlow06_1Test() throws Throwable {
		
		test = reports.createTest("fL_ELearning_Trans_CreateAnnouncementFlow06_1Test");
		
		CreateAnnouncement = new FL_ELearning_Trans_CreateAnnouncementFlow06_1(driver); 
		HP = new HomePageAdmin(driver); 
		
		pdfutility =new PDFUtility(driver);
		Thread.sleep(1000);

		CreateAnnouncement.login();
		
		Thread.sleep(3000);
		HP.ELearning();
		Thread.sleep(3000);

		Thread.sleep(3000);
		CreateAnnouncement.ClickTrnasctionTest();
		
		Thread.sleep(3000);
		CreateAnnouncement.SelectCourseTest();
		
		Thread.sleep(3000);
		CreateAnnouncement.ClickCreateAnnouncementPageTest();
		
		Thread.sleep(3000);
		CreateAnnouncement.Enter_AnnouncementTitle();
		
		Thread.sleep(3000);
		CreateAnnouncement.Select_ExpiryDate();
			
		Thread.sleep(3000);
		CreateAnnouncement.SubmitButtonTest();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record saved successfully."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(3000);
		CreateAnnouncement.AnnouncementReportButtonTest();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "ELearning - Create Announcement");
		Thread.sleep(3000);
		pdfutility.readPDF("ELearning - Create Announcement", "Workshop");	 
		
	}
}
