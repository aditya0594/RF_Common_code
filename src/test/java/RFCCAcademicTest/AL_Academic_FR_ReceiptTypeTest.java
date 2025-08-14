package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_ReceiptType;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

@Listeners(utility.Listeners.class)

public class AL_Academic_FR_ReceiptTypeTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_FR_ReceiptType al_Academic_FR_ReceiptType;

	@BeforeTest
	public void configureReport() { 
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Academic_FR_ReceiptTypeTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_FR_ReceiptType = new AL_Academic_FR_ReceiptType(driver);

		test = reports.createTest("aL_Academic_FR_ReceiptTypeTest");

		RF_AdminLoginPage.loginPage();

		System.out.println("ACADEMIC->Fee Related->Receipt Type");

		Thread.sleep(2000);
		homePageAdmin.Academic();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		homePageAdmin.Academic_FeesRelated();
		Thread.sleep(2000);

		//Click Receipt Type Link
		System.out.println("click Receipt Type");
		al_Academic_FR_ReceiptType.click_Receipt_Type_Link();		
		Thread.sleep(2000);

		//Click skip button if present
		al_Academic_FR_ReceiptType.click_Skip_Notice_Button();
		Thread.sleep(2000);

		//Enter Receipt Code
		System.out.println("Enter Receipt Title -> Other Fees");
		al_Academic_FR_ReceiptType.enter_Receipt_Title();
		Thread.sleep(2000);

		System.out.println("Select Receipt type -> Is Transport Fee");
		al_Academic_FR_ReceiptType.select_Receipt_Code();
		Thread.sleep(2000);

		System.out.println("Select Receipt belongs to -> Hostel");
		al_Academic_FR_ReceiptType.select_Receipt_BelongsTo();
		Thread.sleep(2000);
		
		//Enter Account Number
		al_Academic_FR_ReceiptType.enter_Account_Number();
		Thread.sleep(2000);
		
		//Select Tution/Admission/Institute Fees checkbox
		al_Academic_FR_ReceiptType.select_TutionAdmissionFees_Checkbox();
		Thread.sleep(2000);
		
		//Click Submit Button
		System.out.println("Click on submit button");
		al_Academic_FR_ReceiptType.click_Submit_Button();
		Thread.sleep(2000);
		
		Thread.sleep(2000); 
//		Alert alert =  driver.switchTo().alert();
//		String Expected_Msg = "Is Tution/Admission/Institute Fees Submit only for one Receipt Code"; 
//		String Actual_Msg = alert.getText();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
//		Thread.sleep(5000); 
//		alert.accept();		 
		acceptAlert();
	}


}
