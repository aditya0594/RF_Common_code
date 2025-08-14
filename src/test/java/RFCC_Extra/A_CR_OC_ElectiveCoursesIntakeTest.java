package RFCC_Extra;

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

import RFCCExtra.A_CR_OC_ElectiveCoursesIntake;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class A_CR_OC_ElectiveCoursesIntakeTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	A_CR_OC_ElectiveCoursesIntake a_CR_OC_ElectiveCoursesIntake;

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
	public void a_CR_OC_ElectiveCoursesIntakeTest() throws Exception {

		a_CR_OC_ElectiveCoursesIntake = new A_CR_OC_ElectiveCoursesIntake(driver);

		test = reports.createTest("Course_Reg_Report");
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Admin Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		Thread.sleep(3000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Coordinator Related"));
		System.out.println("Admin Academic Reports submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(Wait);
		System.out.println("Offered Courses");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click(); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");

		Thread.sleep(Wait);
		System.out.println("Elective Courses Intake");
		driver.findElement(By.linkText("Elective Courses Intake")).click(); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");

		Thread.sleep(2000);
		a_CR_OC_ElectiveCoursesIntake.Session();

//		Thread.sleep(2000);
//		a_CR_OC_ElectiveCoursesIntake.Semester();

		Thread.sleep(2000);
		a_CR_OC_ElectiveCoursesIntake.ShowCourse();

		Thread.sleep(2000);
		a_CR_OC_ElectiveCoursesIntake.ElectiveIntakeCourseList();

		Thread.sleep(2000);
		a_CR_OC_ElectiveCoursesIntake.SubmitCapacity();

		Thread.sleep(2000);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String popUp = driver.switchTo().alert().getText();
		System.out.println("Alert text is : " + popUp);
		Thread.sleep(1000);
		alert.accept();
		assertEquals(popUp, "Course Capacity Saved Successfully");
	}
}
