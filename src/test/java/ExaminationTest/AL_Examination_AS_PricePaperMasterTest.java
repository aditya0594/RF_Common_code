package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_AS_PricePaperMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_AS_PricePaperMasterTest extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_AS_PricePaperMaster al_Examination_AS_PricePaperMaster;
	
	@BeforeTest
	public void configureReport() { 
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception { 
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}
	
	@Test
	public void aL_Examination_AS_PricePaperMasterTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_AS_PricePaperMaster = new AL_Examination_AS_PricePaperMaster(driver);
		
		test=reports.createTest("aL_Examination_AS_PricePaperMasterTest");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		//Click on Examination
		homePageAdmin.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//click on answer sheet submenu
		homePageAdmin.Exam_AnswerSheet();
		
		Thread.sleep(2000);
		//Select Degree
		al_Examination_AS_PricePaperMaster.select_Degree();
		
		Thread.sleep(2000);
		//Enter unit
		al_Examination_AS_PricePaperMaster.enter_Unit();
		
		Thread.sleep(2000);
		//click on submit;
		al_Examination_AS_PricePaperMaster.click_SubmitButton();
		
		Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
			
		String Expected_Msg = "Degree name already exist"; 
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(1000);
		alert.accept();
	}
}
