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
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_EM_ExamConfiguration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EM_ExamConfigurationTest extends BaseClass
{
	ExtentReports reports;
    ExtentTest test;
    AL_Examination_EM_ExamConfiguration examconfig;
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
    public void aL_Examination_EM_ExamConfigurationTest() throws InterruptedException, IOException {
        
        System.out.println("Examination==>Examination Master => Exam Configuration");
        
        examconfig = new AL_Examination_EM_ExamConfiguration(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Examination_EM_ExamConfigurationTest");
        RF_AdminLoginPage.loginPage();
        
        threadWait1();
        HP.EXAMINATION();
        
        threadWait1();
        HP.Exam_ExaminationMaster();
        
        threadWait1();
        examconfig.Click_ExamConfiguration();
        
        threadWait1();
        examconfig.Click_SaveBtn();
        
        threadWait1();
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Record Save Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
    }
}
