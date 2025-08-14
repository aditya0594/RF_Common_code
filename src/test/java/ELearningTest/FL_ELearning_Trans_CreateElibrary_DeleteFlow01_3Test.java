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
import com.qa.pages.HomePageFaculty;

import ELearning.FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	HomePageFaculty homePageFaculty;
	FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 fL_ELearning_Trans_CreateElibrary_Delete;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}
	
	@Test
	public void fL_ELearning_Trans_CreateElibrary_DeleteFlow01_3Test() throws Throwable
	{
		homePageFaculty = new HomePageFaculty(driver);
		fL_ELearning_Trans_CreateElibrary_Delete = new FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3(driver);
		
		test = reports.createTest("fL_ELearning_Trans_CreateElibrary_DeleteFlow01_3Test"); 

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(3000);
		//Click main E-Learning Menu
		homePageFaculty.ELEARNING(); 
		
		Thread.sleep(2000);
		//Click Transactions submenu
		homePageFaculty.Elearning_Trans();
		
		Thread.sleep(2000);
		//Select Session
		fL_ELearning_Trans_CreateElibrary_Delete.select_Session();
		
		Thread.sleep(2000);
		//Select Course
		fL_ELearning_Trans_CreateElibrary_Delete.select_Course();
		
		Thread.sleep(2000);
		//click ok button
		fL_ELearning_Trans_CreateElibrary_Delete.Click_OkButton();
		
		Thread.sleep(2000);
		//Click E-Library Submenu
		fL_ELearning_Trans_CreateElibrary_Delete.click_CreateELibrary();
		
		Thread.sleep(2000);
		//Click search box and enter text => Selenium Library
		fL_ELearning_Trans_CreateElibrary_Delete.search_Txt();

			
		// Click on delete btn
		fL_ELearning_Trans_CreateElibrary_Delete.click_Delete();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "E-Book deleted successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
