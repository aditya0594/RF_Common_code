package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_EM_ExaminationRules;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EM_ExaminationRulesTest extends BaseClass
{
    ExtentReports reports;
    ExtentTest test;
    AL_Examination_EM_ExaminationRules examinationRules;
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
    public void aL_Examination_EM_ExaminationRulesTest() throws InterruptedException, IOException {
        
        System.out.println("Examination==>Examination Master => Examination Rules");
        
        examinationRules = new AL_Examination_EM_ExaminationRules(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Examination_EM_ExaminationRulesTest");
        RF_AdminLoginPage.loginPage();
        
        threadWait1();
        HP.EXAMINATION();
        
        threadWait1();
        HP.Exam_ExaminationMaster();
        
        threadWait2();
        examinationRules.Click_ExaminationRules();
        
        threadWait2();
        examinationRules.Select_College();
        
        threadWait2();
        examinationRules.Select_Session();
        
        threadWait2();
        examinationRules.Select_SubjectType();
        
        threadWait2();
        examinationRules.Select_Semester();
        
        threadWait2();
        examinationRules.Click_ShowButton();
        
        threadWait2();
        examinationRules.Click_AcceptCheckbox();
        
        threadWait2();
        examinationRules.Set_CAT1Marks();
        
        threadWait2();
        examinationRules.Click_SubmitButton();
        
    }
}
