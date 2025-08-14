package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_IdentityCard;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class AL_Academic_AR_IdentityCardTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AR_IdentityCard al_Academic_AR_IdentityCard;
	PDFUtility pdfutility;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting Test : " + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Academic_AR_IdentityCardTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AR_IdentityCard = new AL_Academic_AR_IdentityCard(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Academic_AR_IdentityCardTest");
		Thread.sleep(5000);

		RF_AdminLoginPage.loginPage();

		// Hover on Academic from Navigation bar
		System.out.println("ACADEMIC->Academic Reports->Identity Card");
		homePageAdmin.Academic();
		Thread.sleep(5000);

		// Click on Academic Reports from Drop Down
		homePageAdmin.Academic_AcademicReport();
		Thread.sleep(5000);

		// Click on Identity Card from subMenu
		al_Academic_AR_IdentityCard.Click_IdCardSubMenu();

		// Check the first row in the search result
		Thread.sleep(5000);
		al_Academic_AR_IdentityCard.Select_First_Search_Result(); 

		Thread.sleep(5000);
		// Click on Front Back Identity Card Button
		al_Academic_AR_IdentityCard.Click_FrontBackIdentityCard_Button(); 

		Thread.sleep(7000);
		switchToNextWindow();

		Thread.sleep(7000);
		pdfutility.downloadPDF(driver, "Academic - Identity Card");
		Thread.sleep(5000);
		pdfutility.readPDF("Academic - Identity Card", "NAYAN");
	}
}
