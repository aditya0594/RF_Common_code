package StoresTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_SER_SecurityPassReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Stores_Rpt_SER_SecurityPassReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_SER_SecurityPassReport aL_Stores_Rpt_SER_SecurityPassReport;
	HomePageAdmin homePageAdmin;
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

	@Test(invocationCount = 1)
	public void aL_Stores_Rpt_SER_SecurityPassReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_SER_SecurityPassReport = new AL_Stores_Rpt_SER_SecurityPassReport(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Stores_Rpt_SER_SecurityPassReportTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Stock Entry Report->Security Pass Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Rpt_SER_SecurityPassReport.Select_ReportType();



		Thread.sleep(4000);
		aL_Stores_Rpt_SER_SecurityPassReport.Select_StoreName();

		Thread.sleep(4000);
		aL_Stores_Rpt_SER_SecurityPassReport.Click_ShowBtn();

		pdfutility.downloadPDF(driver,"Store - Stock Entry Report - Security Pass Report");
		//pdfutility.downloadPDF();
		//pdfutility.readPDF("Store - Stock Entry Report - Security Pass Report", "SPI2023100226");
		pdfutility.readPDF("Store - Stock Entry Report - Security Pass Report","SPI2023100226");



		//pdfutility.downloadAndVerifyPDF(newWindowUrl,"D:\\RF_Common_Code_LIVE\\DownloadPDFs", "SPI2023100226_filedownload","SPI2023100226");
		Thread.sleep(5000);



	}
	@AfterTest
	public void tear(){
		driver.quit();
	}

}
