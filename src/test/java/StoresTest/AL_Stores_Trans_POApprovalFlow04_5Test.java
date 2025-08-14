package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Trans_POApprovalFlow04_5;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Stores_Trans_POApprovalFlow04_5Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Stores_Trans_POApprovalFlow04_5 poApproval;
   
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
    public void aL_Stores_Trans_POApprovalTest() throws Exception {
        poApproval = new AL_Stores_Trans_POApprovalFlow04_5(driver);
   
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Stores_Trans_POApprovalTest");

        RF_AdminLoginPage.loginPage();
        System.out.println("STORES > TRANSACTION > PO Approval");

        threadWait1();
        HP.STORE();

        threadWait1();
        HP.Store_Transaction();

        threadWait1();
        poApproval.Click_POApproval();
        
        threadWait1();
        poApproval.Click_PurchaseOrderCheckbox();
        
        threadWait1();
        poApproval.Click_SubmitBtn();
        
        System.out.println("PO Approval completed successfully");
    }
}
