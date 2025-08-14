package ExaminationTest;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_Convocation_ConvocationPassoutStudentList;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.ExcelUtility;

public class AL_Examination_Convocation_ConvocationPassoutStudentListTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	ExcelUtility excelutilitytest;
	AL_Examination_Convocation_ConvocationPassoutStudentList passoutlist;
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
	public void aL_Examination_Convocation_ConvocationPassoutStudentListTest() throws InterruptedException, IOException, HeadlessException, AWTException {
		
	System.out.println("Examination==> CONVOCATION => Passout Student List");
		
		passoutlist = new AL_Examination_Convocation_ConvocationPassoutStudentList(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Examination_Convocation_ConvocationPassoutStudentListTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		HP.Exam_Convocation();
		
		Thread.sleep(2000);
		passoutlist.Click_ConvocationPassoutStudentList();
		
		Thread.sleep(2000);
		passoutlist.Select_CollegeSession();
		
		Thread.sleep(2000);
		passoutlist.Select_ConvocationType();
		
		Thread.sleep(3000);
		passoutlist.Click_PassoutStudentExcelReportbtn();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("BALAJI","PassoutStudentListReport"); 
	}
}
