package HostelTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_HGP_GenerateHostelGatePassFlow02_5;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Hostel_HGP_GenerateHostelGatePassFlow02_5Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 generategatepass;
	HomePageAdmin HP;
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
	public void al_Hostel_HGP_GenerateHostelGatePass() throws Exception {

		generategatepass = new AL_Hostel_HGP_GenerateHostelGatePassFlow02_5(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("al_Hostel_HGP_GenerateHostelGatePass");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Hostel Gate Pass => Generate Hostel Gate Pass");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		generategatepass.clickGenerateHostelGatePass();
		
		Thread.sleep(2000);
		generategatepass.enterCurrentDateInSearch();
		
		Thread.sleep(2000);
		generategatepass.storeGatePassNumber();
		
		Thread.sleep(2000);
		generategatepass.enterStoredGatePassNumber();
		
		Thread.sleep(2000);
		generategatepass.clickSearchBtn();
		
		Thread.sleep(2000);
		generategatepass.clickGatePassReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Hostel - Gate Hstel Gate Pass");
		pdfutility.readPDF("Hostel - Gate Hstel Gate Pass","MOHAMED");	
	}
}
