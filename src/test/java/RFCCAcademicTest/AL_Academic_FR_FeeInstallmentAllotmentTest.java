package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_FeeInstallmentAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_FeeInstallmentAllotmentTest extends BaseClass
{	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_FR_FeeInstallmentAllotment al_Academic_FR_FeeInstallmentAllotment;

	@BeforeClass
	public void configuration() 
	{
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception 
	{
		//Open browser with given link
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Academic_FR_FeeInstallmentAllotmentTest() throws InterruptedException
	{
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_FR_FeeInstallmentAllotment = new AL_Academic_FR_FeeInstallmentAllotment(driver);

		test = reports.createTest("aL_Academic_FR_FeeInstallmentAllotmentTest");
		//Open Login page having login details 
		RF_AdminLoginPage.loginPage(); 

		System.out.println(" ACADEMIC -> Fee Related-> fee Installment Allotment-> Bulk Student Fees Discount");

		Thread.sleep(2000);
		// Click Main Academic menu
		homePageAdmin.Academic();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		homePageAdmin.Academic_FeesRelated();

		Thread.sleep(2000);		
		// Click on fee Installment Allotment
		al_Academic_FR_FeeInstallmentAllotment.click_feeInstallemntAllotment_Link();

		Thread.sleep(2000);
		// Click on Bulk Student Fees Discount
		al_Academic_FR_FeeInstallmentAllotment.click_bulkStudFeesDiscount();

		Thread.sleep(2000);
		// Select School/Institute
		al_Academic_FR_FeeInstallmentAllotment.select_School();

		Thread.sleep(2000);
		// Select Degree
		al_Academic_FR_FeeInstallmentAllotment.select_Degree();

		Thread.sleep(2000);
		// Select Branch
		al_Academic_FR_FeeInstallmentAllotment.select_branch();

		Thread.sleep(2000);
		// Select Semester
		al_Academic_FR_FeeInstallmentAllotment.select_Semester();

		Thread.sleep(2000);
		// Select Receipt Type
		al_Academic_FR_FeeInstallmentAllotment.select_receiptType();

		Thread.sleep(2000);
		// Select Payment Type
		al_Academic_FR_FeeInstallmentAllotment.select_paymentType();

		Thread.sleep(2000);
		// Click on show button
		al_Academic_FR_FeeInstallmentAllotment.click_show_btn();

		Thread.sleep(2000);
		// Click on AmountWise button
		al_Academic_FR_FeeInstallmentAllotment.click_amountwise_btn();
		Thread.sleep(2000);
		
		al_Academic_FR_FeeInstallmentAllotment.SearchBar();
		Thread.sleep(2000);
		
		al_Academic_FR_FeeInstallmentAllotment.click_checkbox();
		Thread.sleep(2000);

		al_Academic_FR_FeeInstallmentAllotment.select_discountType();
		Thread.sleep(2000);
		// Enter Discount Amount
		al_Academic_FR_FeeInstallmentAllotment.enter_discountAmount();

		Thread.sleep(2000);
		// Click on submit button
		al_Academic_FR_FeeInstallmentAllotment.click_Submit_Btn();

		Thread.sleep(2000);
		// Accept the alert
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();

		String Expected_Msg = "Record Saved Successfully.";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
	}



}
