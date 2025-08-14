package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_BulkUpdatePaymentType;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_BulkUpdatePaymentTypeTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_BulkUpdatePaymentType bulkupdate;
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
	public void aL_Academic_FR_BulkUpdatePaymentTypeTest() throws Exception {
		
		bulkupdate = new AL_Academic_FR_BulkUpdatePaymentType(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_BulkUpdatePaymentTypeTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Bulk update payment type"); 
		
		Thread.sleep(3000);
		HP.Academic();
		
		Thread.sleep(3000);
		HP.Academic_FeesRelated();
		
		Thread.sleep(3000);
		bulkupdate.Click_BulkUpdatePaymentType();
		
		Thread.sleep(3000);
		bulkupdate.Select_AdmissionBatch();
		
		Thread.sleep(3000);
		bulkupdate.Select_Degree();
		
		Thread.sleep(3000);
		bulkupdate.Select_ProgramBranch();
		
		Thread.sleep(3000);
		bulkupdate.Click_ShowBtn();
		
		Thread.sleep(3000);
		bulkupdate.Select_PaymentType();
		
		Thread.sleep(3000);
		bulkupdate.Click_Updatebtn();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Payment Updated Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
