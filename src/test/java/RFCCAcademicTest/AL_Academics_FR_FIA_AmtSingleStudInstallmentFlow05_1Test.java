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

import RFCCAcademic.AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 AmtSingleStudInstallment;
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
	public void aL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1Test() throws Throwable {
		
		AmtSingleStudInstallment = new AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1(driver);
		
		test = reports.createTest("aL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1Test"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Fee Related -> Fee Installment Allotment -> Amountwise Single Student Fee Installment"); 
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(4000);
		HP.Academic();
		Thread.sleep(4000);

		Actions action = new Actions(driver);

		
		Thread.sleep(4000);
		AmtSingleStudInstallment.ClickFeeRelatedTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.ClickFeeInstallmentAllotmentTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.AmountwiseSingleStudnentFeeInstallmentTabTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.SearchRRNTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.SearchButtonTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.ClickStudentNameTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.SelectReceiptTypeTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.SelectSemesterTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.ClickShowButtonTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.Installment1DueDateTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.Installment1AmountTest();
		
//		Thread.sleep(4000);
//		AmtSingleStudInstallment.ClickAddNewInstallmentButtonTest();
//		
//		Thread.sleep(4000);
//		AmtSingleStudInstallment.Installment2DueDateTest();
//		
//		Thread.sleep(4000);
//		AmtSingleStudInstallment.Installment2AmountTest();
		
		Thread.sleep(4000);
		AmtSingleStudInstallment.ClickSubmitButtonTest();
		
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Student Installment Data Saved Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
}
}
