package RFCCAcademicTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_OfferedCourses;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_OfferedCoursesTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_OfferedCourses a_CR_OC_OfferedCourses;
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
	public void a_CR_OC_OfferedCoursesTest() throws Exception {

		a_CR_OC_OfferedCourses = new AL_Academic_CR_OfferedCourses(driver);
		test = reports.createTest("a_CR_OC_OfferedCoursesTest");
		HP = new HomePageAdmin(driver);
	
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

	
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		
		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.ClickCordinatorRelatedTest();

		Thread.sleep(Wait);
		System.out.println("Offered Courses");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click(); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");

		Thread.sleep(Wait);
		System.out.println("Offered Courses");
		driver.findElement(By.linkText("Offered Courses")).click(); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");

		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.CollegeAndScheme();

		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.Session();

		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.Semester();

		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.ShowButton();

		Thread.sleep(2000);
		a_CR_OC_OfferedCourses.SubmitForOfferedCourse();

		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String popUp = driver.switchTo().alert().getText();
		System.out.println("Alert text is : " + popUp);
		Thread.sleep(1000);
		alert.accept();
		assertEquals(popUp, "Offered Courses saved Successfully.");
	}
}
