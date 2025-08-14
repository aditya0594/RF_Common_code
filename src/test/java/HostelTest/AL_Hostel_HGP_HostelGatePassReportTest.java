package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_FR_CreateFeeDemand;
import Hostel.AL_Hostel_HGP_HostelGatePassReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Hostel_HGP_HostelGatePassReportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_HostelGatePassReport gatepassreport;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;
	
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
	public void al_Hostel_HGP_HostelGatePassReport() throws Exception {

		gatepassreport = new Hostel.AL_Hostel_HGP_HostelGatePassReport(driver);

		test = reports.createTest("al_Hostel_HGP_HostelGatePassReport");
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Hostel Gate Pass > Hostel Gate Pass Report");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		gatepassreport.Click_HostelGatePassReport();

		Thread.sleep(2000);
		gatepassreport.FromDate();

		Thread.sleep(2000);
		gatepassreport.ToDate();

		Thread.sleep(2000);
		gatepassreport.submitReport();

		Thread.sleep(2000);
		excelutilitytest.ReadExcel("MOHAMED","GatePassDetailsReport");

		
		
		Thread.sleep(6000);
		pdfutility.downloadPDF(driver, "Hostel - Gate Pass Report");
		pdfutility.readPDF("Hostel - Gate Pass Report", "MOHAMED");	
		Thread.sleep(5000);
	}
}
