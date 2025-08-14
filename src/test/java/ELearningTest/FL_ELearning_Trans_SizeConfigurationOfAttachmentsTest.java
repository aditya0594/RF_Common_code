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

import ELearning.FL_ELearning_Trans_SizeConfigurationOfAttachments;
import RFCCAcademic.AL_Academic_AM_AttendanceEmailTrigger;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class FL_ELearning_Trans_SizeConfigurationOfAttachmentsTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_SizeConfigurationOfAttachments fL_ELearning_Trans_SizeConfigurationOfAttachments;
	
	
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
	public void fL_ELearning_Trans_SizeConfigurationOfAttachments() throws Exception {


		test = reports.createTest("FL_ELearning_Trans_SizeConfigurationOfAttachments");

		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_SizeConfigurationOfAttachments = new FL_ELearning_Trans_SizeConfigurationOfAttachments(driver);
		
		
		Thread.sleep(1000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.login();

		System.out.println("Elearning-> Transactions-> Size Configuration Of Attachments ");

		homePageAdmin.ELearning();
		Thread.sleep(2000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(3000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.click_sizeConfigOfAttachments_link();
		Thread.sleep(3000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.select_userType();
		Thread.sleep(3000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.click_edit_btn();
		Thread.sleep(3000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.enter_fileSize();
		Thread.sleep(3000);
		fL_ELearning_Trans_SizeConfigurationOfAttachments.click_submit_btn();
		Thread.sleep(3000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Modified Sucessfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(3000);
	}
}
