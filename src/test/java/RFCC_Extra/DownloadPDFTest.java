package RFCC_Extra;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BasePDF;
import utility.DonwloadPDF;

public class DownloadPDFTest extends BasePDF{
	  private static ExtentReports reports;
	  
	@BeforeTest
	public void intialize() throws Exception{
		driver = initializeDriver();
		driver.get(prop.getProperty("url_RF_LoginAdmin"));;
		// reports = Reports.createReport();
	}

	@BeforeClass
	public void startup() {
		
		 reports = new ExtentReports();
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
	        reports.attachReporter(sparkReporter);
	}
	
	@Test
	public void downloadPDFTest() throws InterruptedException {
		
		reports.createTest("TestName").log(Status.INFO, "Test started");
		DonwloadPDF downloadpdf =new DonwloadPDF(driver);
		BasePDF basepdf = new BasePDF();
		downloadpdf.ExamAdmitCardGeneration();
		basepdf.clickBeforePDF();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
