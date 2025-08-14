package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_FeesRefund;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_FR_FeesRefundTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	
	HomePageAdmin homePageAdmin;
	AL_Academic_FR_FeesRefund al_Academic_FR_FeesRefund;
	PDFUtility pdfutility;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_FR_FeesRefundTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_FR_FeesRefund = new AL_Academic_FR_FeesRefund(driver);
		pdfutility =new PDFUtility(driver);	


		test = reports.createTest("aL_Academic_FR_FeesRefundTest");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Fee Related-> Fees Refund");
		
		Thread.sleep(2000);
		//Click on Academic Menu
		homePageAdmin.Academic();
		
		Thread.sleep(2000);
		//Click on Fees Related submenu
		homePageAdmin.Academic_FeesRelated();
		
		
		Thread.sleep(2000);
		//Click on Fees Refund from Sub menu
		al_Academic_FR_FeesRefund.click_feesRefund_link();
		
		Thread.sleep(2000);
		//Enter RRN no.
		al_Academic_FR_FeesRefund.enter_RRNNo();
		
		Thread.sleep(2000);
		//Click on search button
		al_Academic_FR_FeesRefund.click_search_button();
		
		Thread.sleep(2000);		
		//Click on student name
		al_Academic_FR_FeesRefund.click_studentName();
		
		Thread.sleep(2000);
		//Click on refund button
		al_Academic_FR_FeesRefund.click_refund_button();
		
		Thread.sleep(2000);
		//Enter Tution Fee
		al_Academic_FR_FeesRefund.Enter_TutionFee();
		
		Thread.sleep(2000);

		//Enter Remark
		al_Academic_FR_FeesRefund.enter_remark();
		Thread.sleep(2000);

		//Click on Submit button
		al_Academic_FR_FeesRefund.click_submit_button();
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Fees Refund Voucher");
		Thread.sleep(3000);
		pdfutility.readPDF("Academic - Fees Refund Voucher", "AADIL");	

	}

}
