package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_TestCreation_DeleteFlow07_2;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_TestCreation_DeleteFlow07_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_ELearning_Trans_TestCreation_DeleteFlow07_2 delete;
	HomePageAdmin HP;
	

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void fL_ELearning_Trans_TestCreation_DeleteFlow07_2Test() throws Throwable {
		test = reports.createTest("fL_ELearning_Trans_TestCreation_DeleteFlow07_2Test");
		delete = new FL_ELearning_Trans_TestCreation_DeleteFlow07_2(driver);

		System.out.println("E- LEARNING -> Transactions -> Test Creation => Delete");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		HP = new HomePageAdmin(driver);
		HP.ELearning();
		Thread.sleep(2000);

		Thread.sleep(2000);
		delete.ClickTrnasctionTest();

		Thread.sleep(2000);
		delete.SelectCourseTest();

		Thread.sleep(2000);
		delete.TestCreation();

		Thread.sleep(2000);
		delete.Click_Delete_icon();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Test Delete Succusessfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
	}
}
