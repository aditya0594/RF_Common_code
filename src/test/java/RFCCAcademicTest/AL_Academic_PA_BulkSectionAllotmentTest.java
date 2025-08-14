package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_BulkSectionAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_BulkSectionAllotmentTest extends BaseClass{

	private WebDriver driver;

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_BulkSectionAllotment al_Academic_PA_BulkSectionAllotment;

	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Academic_PA_BulkSectionAllotmentTest() throws Exception {


		test = reports.createTest("aL_Academic_PA_BulkSectionAllotmentTest");

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_PA_BulkSectionAllotment = new AL_Academic_PA_BulkSectionAllotment(driver);

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Post Admission-> Bulk Section Allotment ");

		homePageAdmin.Academic();
		Thread.sleep(2000);
		homePageAdmin.Academic_PostAdmission();
		Thread.sleep(2000);
		al_Academic_PA_BulkSectionAllotment.click_bulkSectionAllotment_link();
		Thread.sleep(5000);
		al_Academic_PA_BulkSectionAllotment.select_school();
		Thread.sleep(5000);
		al_Academic_PA_BulkSectionAllotment.select_degree();
		Thread.sleep(5000);
		al_Academic_PA_BulkSectionAllotment.select_branch();
		Thread.sleep(5000);

		al_Academic_PA_BulkSectionAllotment.click_sortByEnrollmentNo();
		threadWait1();

		al_Academic_PA_BulkSectionAllotment.click_filter_button();
		threadWait1();

		al_Academic_PA_BulkSectionAllotment.select_section();
		threadWait1();

		al_Academic_PA_BulkSectionAllotment.select_courseType();
		threadWait1();

		al_Academic_PA_BulkSectionAllotment.enter_rangeFrom();
		threadWait1();
		al_Academic_PA_BulkSectionAllotment.enter_rangeTo();
		threadWait1();

		al_Academic_PA_BulkSectionAllotment.click_confirm_button();
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("(//tr[@class='odd'])[1]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		threadWait1();
		String a=	driver.findElement(By.xpath("(//tr[@class='odd'])[1]/td[2]")).getText();
		threadWait1();
		al_Academic_PA_BulkSectionAllotment.click_submit_button();
		Thread.sleep(5000);

		threadWait1();
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Record Updated Successfully."; 
		String Actual_Msg1 = alert1.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		threadWait1();

	}
}
