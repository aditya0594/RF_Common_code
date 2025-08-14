package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_FeesReceiptDetails;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_FeesReceiptDetailsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_FeesReceiptDetails feerecept;
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
	public void aL_Academic_FR_FeesReceiptDetailsTest() throws Exception {
		
		feerecept = new AL_Academic_FR_FeesReceiptDetails(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FR_FeesReceiptDetailsTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Fee Related > Fees Receipt Details"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_FeesRelated();
		
		Thread.sleep(2000);
		feerecept.Click_FeesReceiptDetails();
		
		Thread.sleep(2000);
		feerecept.Select_ReceiptType();
		
		Thread.sleep(2000); 
		WebElement first_name = driver.findElement(By.xpath("(//td[normalize-space()='AISHWARYA. A'])[1]"));
		
		String Expected_Msg = "AISHWARYA. A"; 
		String Actual_Msg = first_name.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		System.out.println("Name is present in list");

	}
}
