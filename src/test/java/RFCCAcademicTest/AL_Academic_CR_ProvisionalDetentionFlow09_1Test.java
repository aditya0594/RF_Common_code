package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_ProvisionalDetentionFlow09_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_CR_ProvisionalDetentionFlow09_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_ProvisionalDetentionFlow09_1 provisionalDetain;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_CR_ProvisionalDetentionFlow09_1Test() throws IOException, Throwable 
 {
		
		provisionalDetain = new AL_Academic_CR_ProvisionalDetentionFlow09_1(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_ProvisionalDetentionFlow09_1Test"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Provisional Detention"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(4000);
		provisionalDetain.Click_ProvisionalDetention();
		
		Thread.sleep(4000);
		provisionalDetain.Select_CollegeScheme();
		
		Thread.sleep(4000);
		provisionalDetain.Select_Session();
		
		Thread.sleep(4000);
		provisionalDetain.Select_Semister();
		
		Thread.sleep(6000);
		provisionalDetain.Click_AllSubjectDetentionBtn();
		
		Thread.sleep(4000);
		provisionalDetain.Click_ShowStudentBtn();
		
		Thread.sleep(4000);
		provisionalDetain.SearchAnd_ClickChkBox();
		
		Thread.sleep(4000);
		provisionalDetain.Click_SubmitBtn();
		
		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Provisional Detention Entry Done Successfully ..."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
 	}
}
