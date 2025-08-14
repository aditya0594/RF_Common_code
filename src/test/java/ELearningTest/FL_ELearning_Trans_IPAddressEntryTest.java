package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_CreateForumFlow05_1;
import ELearning.FL_ELearning_Trans_IPAddressEntry;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_IPAddressEntryTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_IPAddressEntry fL_ELearning_Trans_IPAddressEntry;
	FL_ELearning_Trans_CreateForumFlow05_1 fL_ELearning_Trans_CreateForum;
	
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
	public void fL_ELearning_Trans_IPAddressEntry() throws Exception {


		test = reports.createTest("FL_ELearning_Trans_IPAddressEntry");

		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_IPAddressEntry = new FL_ELearning_Trans_IPAddressEntry(driver);
		fL_ELearning_Trans_CreateForum = new FL_ELearning_Trans_CreateForumFlow05_1(driver);
		
		Thread.sleep(1000);
		fL_ELearning_Trans_IPAddressEntry.login();

		System.out.println("Elearning-> Transactions-> IP Address Entry ");

		homePageAdmin.ELearning();
		Thread.sleep(4000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(3000);
		fL_ELearning_Trans_CreateForum.SelectCourseTest();	
		threadWait1();
		fL_ELearning_Trans_IPAddressEntry.click_iPAddressEntry_link();
		threadWait1();
		fL_ELearning_Trans_IPAddressEntry.enter_computerName();
		threadWait1();
		fL_ELearning_Trans_IPAddressEntry.enter_ipAdress();
		threadWait1();
		fL_ELearning_Trans_IPAddressEntry.click_submit_btn();
		Thread.sleep(4000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "IP Address saved successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(5000);
		
		fL_ELearning_Trans_IPAddressEntry.searchtxt();
		Thread.sleep(3000);
		
		fL_ELearning_Trans_IPAddressEntry.edit_ipAdrress();
		Thread.sleep(4000);
		fL_ELearning_Trans_IPAddressEntry.click_submit_btn();
		threadWait1();
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "IP Address Updated successfully!"; 
		String Actual_Msg1 = alert1.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		Thread.sleep(3000);
		
		fL_ELearning_Trans_IPAddressEntry.delete_ipAddress();
		threadWait1();
		Alert alert2 =  driver.switchTo().alert();
		String Expected_Msg2 = "IP Address Deleted successfully!"; 
		String Actual_Msg2 = alert2.getText();
		Assert.assertEquals(Actual_Msg2 , Expected_Msg2 );
		System.out.println("Actual Message - " + Actual_Msg2+ "\n"+ "Expected Message - " + Expected_Msg2);
		alert2.accept();
		Thread.sleep(3000);
	}
}
