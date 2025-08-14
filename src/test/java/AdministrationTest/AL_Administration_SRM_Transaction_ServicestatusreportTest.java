package AdministrationTest;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_SRM_Transaction_Servicstatusreport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Administration_SRM_Transaction_ServicestatusreportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Administration_SRM_Transaction_Servicstatusreport al_Administration_SRM_Transaction_Servicstatusreport;
	PDFUtility pdfutility;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n"); 
	}

	@Test
	public void aL_Administration_SRM_Transaction_Servicstatusreport() throws Exception {
		test = reports.createTest("Administration_ServiceManagement");

		homePageAdmin = new HomePageAdmin(driver);	
		al_Administration_SRM_Transaction_Servicstatusreport = new AL_Administration_SRM_Transaction_Servicstatusreport(driver);
		pdfutility = new PDFUtility(driver);

		Thread.sleep(4000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");
		Thread.sleep(4000);

		homePageAdmin.ADMINISTRATION();
		Thread.sleep(4000);
		
		// Locating the element from Sub Menu
		homePageAdmin.Admin_ServiceRequestManagement();
		Thread.sleep(4000);
		
		homePageAdmin.Admin_SRM_Reports();
		Thread.sleep(4000);

		al_Administration_SRM_Transaction_Servicstatusreport.click_serviceStatusReport();
		Thread.sleep(4000);

		//start date  
		al_Administration_SRM_Transaction_Servicstatusreport.enter_startDate(); 

		Thread.sleep(4000); 
		al_Administration_SRM_Transaction_Servicstatusreport.click_submit_button();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Administration - SRM - Service status report");
		Thread.sleep(5000);;	
		pdfutility.readPDF("Administration - SRM - Service status report", "Mastersoft");	

	}

}
