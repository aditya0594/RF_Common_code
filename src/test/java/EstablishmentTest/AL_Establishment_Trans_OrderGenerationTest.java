package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_OrderGeneration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_OrderGenerationTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_OrderGeneration order_generate;
	HomePageAdmin HP;

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
	public void aL_Establishment_Trans_OrderGenerationTest() throws InterruptedException, IOException {

		System.out.println("Establishment==>Transaction==> Order Generation");

		order_generate = new AL_Establishment_Trans_OrderGeneration(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_OrderGenerationTest");
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(5000);;
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);;
		HP.Estab_Transactions();

		Thread.sleep(5000);
		order_generate.Click_OrderGeneration();

		// Click for Report Generation
		Thread.sleep(5000);
		order_generate.Click_Report();

		Thread.sleep(5000);;
		order_generate.Select_College_name_for_Report();

		Thread.sleep(5000);;
		order_generate.Select_Staff_name_for_Report();

		Thread.sleep(5000);;
		order_generate.Select_Employee_name_for_Report();

		Thread.sleep(5000);
		order_generate.Select_Order_No_for_Report();

		Thread.sleep(5000);
		order_generate.Click_Report_btn_For_Report();
		
		Thread.sleep(5000);;
		switchToNextWindow();
		Thread.sleep(5000);;
		captureScreenshot(driver, "Order Generation Report");
	}
}
