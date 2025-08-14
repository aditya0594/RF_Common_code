package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 CancelAmtSingleStudInstallment;
	HomePageAdmin HP;
	

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2Test() throws Throwable {
		
		CancelAmtSingleStudInstallment = new AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2(driver);
		
		test = reports.createTest("aL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2Test"); 
		threadWait1();
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Fee Related -> Fee Installment Allotment -> Amountwise Single Student Fee Installment"); 
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.Academic();
		threadWait1();

		Actions action = new Actions(driver);
		threadWait1();
		CancelAmtSingleStudInstallment.ClickFeeRelatedTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.ClickFeeInstallmentAllotmentTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.AmountwiseSingleStudnentFeeInstallmentTabTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.SearchRRNTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.SearchButtonTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.ClickStudentNameTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.SelectReceiptTypeTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.SelectSemesterTest();
		
		threadWait1();
		CancelAmtSingleStudInstallment.ClickShowButtonTest();
		
		Thread.sleep(1000);
		acceptAlert();
		
		threadWait1();
		CancelAmtSingleStudInstallment.ClickRemoveAllInstallmentButtonTest();
		
		threadWait1();		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Student Installment Data Remove Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
	}
}
