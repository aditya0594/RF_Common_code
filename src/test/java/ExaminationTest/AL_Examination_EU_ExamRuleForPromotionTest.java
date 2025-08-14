package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_EU_ExamRuleForPromotion;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EU_ExamRuleForPromotionTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EU_ExamRuleForPromotion exam_rule;
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
	public void aL_Examination_EU_ExamRuleForPromotionTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Exam Utility => Bulk Exam Form Generation");
		
		exam_rule = new AL_Examination_EU_ExamRuleForPromotion(driver);
		test = reports.createTest("aL_Examination_EU_ExamRuleForPromotionTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		exam_rule.Click_ExamUtility();
		
		Thread.sleep(2000);
		exam_rule.Click_ExamRuleForPromotion();
		
		Thread.sleep(2000);
		exam_rule.Click_EditIcon_btn();
		
		Thread.sleep(2000);
		exam_rule.Enter_MinEarnedCredits();
		
		Thread.sleep(2000);
		exam_rule.Enter_PrevSemCourseCleared();
		
		Thread.sleep(2000);
		exam_rule.Click_Submit_btn();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actMsg=alert.getText();
		String expMsg="Exam Promotion Rules Updated Successfully !!!!";
		Assert.assertEquals(actMsg, expMsg);
		alert.accept();
		Thread.sleep(2000);
	//	captureScreenshot(driver, "Exam Rule for Promotion");
	}
}
