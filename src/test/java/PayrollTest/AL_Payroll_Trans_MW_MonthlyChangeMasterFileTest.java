package PayrollTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_MonthlyChangeMasterFile;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Trans_MW_MonthlyChangeMasterFileTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_MonthlyChangeMasterFile Trans_MonthlyChangeMasterFile;
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
	public void aL_Payroll_Trans_MW_MonthlyChangeMasterFileTest() throws Exception {

		Trans_MonthlyChangeMasterFile = new AL_Payroll_Trans_MW_MonthlyChangeMasterFile(driver);

		test = reports.createTest("Trans_MonthlyChangeMasterFile");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > TRANSACTION > Monthly Change Master File  > Show");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(4000);
		Trans_MonthlyChangeMasterFile.Transactions();

		Thread.sleep(2000);
		Trans_MonthlyChangeMasterFile.MonthlyWork();

		Thread.sleep(2000);
		Trans_MonthlyChangeMasterFile.MonthlyChangesInMasterFile();

		Thread.sleep(2000);
		Trans_MonthlyChangeMasterFile.payhead();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.College();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.Staff();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.OrderBy();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.ShowButton();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.editamount();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.SubmitButton();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Record Updated Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"
				+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);
		alert.accept();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.reeditamount();

		Thread.sleep(3000);
		Trans_MonthlyChangeMasterFile.SubmitButton();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}
}
