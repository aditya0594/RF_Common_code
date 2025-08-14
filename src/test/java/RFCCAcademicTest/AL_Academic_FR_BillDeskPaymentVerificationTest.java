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

import RFCCAcademic.AL_Academic_FR_BillDeskPaymentVerification;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_BillDeskPaymentVerificationTest extends BaseClass
{
	ExtentReports reports;
    ExtentTest test;
    AL_Academic_FR_BillDeskPaymentVerification billdeskpayment;
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
    public void aL_Academic_FR_BillDeskPaymentVerificationTest() throws InterruptedException, IOException {
        
        System.out.println("Academic ==>Fee Related => BillDesk Payment Verification");
        
        billdeskpayment = new AL_Academic_FR_BillDeskPaymentVerification(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Academic_FR_BillDeskPaymentVerificationTest");
        RF_AdminLoginPage.loginPage();
        
        threadWait1();
        HP.Academic();
        
        threadWait1();
        HP.Academic_FeesRelated();
        
        threadWait1();
        billdeskpayment.Click_BillDeskPaymentVerification();
        
        threadWait1();
        billdeskpayment.Select_ActivityName();
        
        threadWait1();
        billdeskpayment.Select_ReceiptCode();
        
        threadWait1();
        billdeskpayment.Enter_RRNNo();
        
        threadWait1();
        billdeskpayment.Click_ShowBtn();
        
        Thread.sleep(3000);
		
		String Expected_Msg = "Success"; 
 		String Actual_Msg = "Success";
 		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
 		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		
    }
}
