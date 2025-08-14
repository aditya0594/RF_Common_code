package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_SR_OnlinePaymentFlow06_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_SR_OnlinePaymentFlow06_1Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_SR_OnlinePaymentFlow06_1 onlinepayment;
	PDFUtility pdfutility;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Academic_SR_OnlinePaymentFlow06_1Test() throws Exception {
		System.out.println("Academic->Student Related->Online Payment");
		homePageAdmin = new HomePageAdmin(driver);
		onlinepayment = new AL_Academic_SR_OnlinePaymentFlow06_1(driver);
		test = reports.createTest("aL_Academic_SR_OnlinePaymentFlow06_1Test");
		pdfutility =new PDFUtility(driver);
		Thread.sleep(4000);

		RF_AdminLoginPage.loginPage();

		System.out.println("Student Logged in Successfully");	
		
		Thread.sleep(4000);
		//Click main Academic Menu
		homePageAdmin.Academic();

		Thread.sleep(3000);
		//Click Student Related Submenu
		homePageAdmin.Academic_StudentRelated();

		Thread.sleep(4000);
		//Click Online Payment
		onlinepayment.click_onlinePaymentOption_link();
		
		Thread.sleep(4000);
		onlinepayment.enter_RRN();
		
		Thread.sleep(4000);
		onlinepayment.click_search_btn();
		
		Thread.sleep(4000);
		onlinepayment.click_name();
		

		Thread.sleep(4000);
		//Select Receipt Type
		onlinepayment.click_semester();
		
		Thread.sleep(4000);
		//Select Semester
		onlinepayment.select_semester();
		
		Thread.sleep(4000);
		
		//Click Payment Button
		onlinepayment.click_PaymentBtn();
		Thread.sleep(4000);
		
//		//Select Payment Gateway
//		onlinepayment.Select_PaymentGateway();
//		Thread.sleep(4000);
				
		//Click Pay Button
		onlinepayment.Click_Btn_Pay();
		Thread.sleep(8000);
//		
//		onlinepayment.Click_InternetBanking();
//		Thread.sleep(8000);
//		
//		onlinepayment.Click_SuccesBtn();
//		Thread.sleep(8000);
//		//Click Payment mode
		onlinepayment.Click_InternetBanking();
		threadWait2();
		
//		//Click Payment mode
		onlinepayment.Click_AvenueTestBtn();
		threadWait2();
		
//		//Click Pay Button
//		onlinepayment.Click_PayNowBtn();
//		Thread.sleep(Wait);
		
		//Click Pay Button
		switchToNextWindow();
		
		threadWait2();
		onlinepayment.click_SendResponseBtn();
		

	}

}
