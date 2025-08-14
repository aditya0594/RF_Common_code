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

//import RFCCExtra.A_CR_OC_ElectiveCoursesIntake;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import RFCCAcademic.AL_Academic_CR_OC_ElectiveCoursesIntake;

public class AL_Academic_CR_OC_ElectiveCoursesIntakeTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_OC_ElectiveCoursesIntake a_CR_OC_ElectiveCoursesIntake;
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
	public void aL_Academic_CR_OC_ElectiveCoursesIntakeTest() throws Exception {

		RF_AdminLoginPage.loginPage();
		
		a_CR_OC_ElectiveCoursesIntake = new AL_Academic_CR_OC_ElectiveCoursesIntake(driver);
		
		System.out.println("Academic -> Coordinator Related -> Offered Courses-> Elective Courses Intake");
		

		test = reports.createTest("aL_Academic_CR_OC_ElectiveCoursesIntakeTest");
		
		Thread.sleep(5000);

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
	
		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.click_offeredCourse();

		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.click_electiveCoursesIntake();

		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.Session();

		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.ShowCourse();

		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.ElectiveIntakeCourseList();

		Thread.sleep(5000);
		a_CR_OC_ElectiveCoursesIntake.SubmitCapacity();

		Thread.sleep(5000);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String popUp = driver.switchTo().alert().getText();
		System.out.println("Alert text is : " + popUp);
		Thread.sleep(2000);
		alert.accept();
		assertEquals(popUp, "Course Capacity Saved Successfully");
	}
}
