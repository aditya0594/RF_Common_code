package ELearningTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.SL_ELearning_View_ViewStudentTestFlow08_1;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class SL_ELearning_View_ViewStudentTestFlow08_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	SL_ELearning_View_ViewStudentTestFlow08_1 studenttest;

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
	public void sL_ELearning_View_ViewStudentTestFlow08_1Test() throws Throwable
	{
		test = reports.createTest("sL_ELearning_View_ViewStudentTestFlow08_1Test");
		HP = new HomePageAdmin(driver);
		studenttest = new SL_ELearning_View_ViewStudentTestFlow08_1(driver);
		
		
		System.out.println("ELearning >> View >> View Student Test");
		
		threadWait1();
		studenttest.Login_Student();
		
		threadWait1();
		HP.ELearning();
		threadWait1();
		HP.ELearning_Transaction();
		
		threadWait1();
		studenttest.SelectCourseTest();
		
		threadWait1();
		HP.ELearning();
		
		threadWait1();
		HP.Elearning_View();

		threadWait1();
		studenttest.Click_ViewStudentTest();

		threadWait1();
		studenttest.select_TestType();
		
		threadWait1();
		studenttest.Click_AutomationSeleniumTest();
		
		acceptAlert();
		
//		Thread.sleep(3000);
//		studenttest.Click_CloseBtn();
	}
}
