package StoresTest;

import java.lang.reflect.Method;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Trans_PurchaseOrderPreperationFlow04_4;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_PurchaseOrderPreperationFlow04_4Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 purchaseOrderPreperation;
   
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
    public void aL_Stores_Trans_PurchaseOrderPreperationTest() throws Exception {
        purchaseOrderPreperation = new AL_Stores_Trans_PurchaseOrderPreperationFlow04_4(driver);
   
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Stores_Trans_PurchaseOrderPreperationTest");

        RF_AdminLoginPage.loginPage();
        System.out.println("STORES > TRANSACTION > Purchase Order Prepration");

        threadWait1();
        HP.STORE();

        threadWait1();
        HP.Store_Transaction();

        threadWait1();
        purchaseOrderPreperation.Click_PurchaseOrderPrepration();

        threadWait1();
        purchaseOrderPreperation.Click_DirectPurchaseOrderBtn();
        
        threadWait1();
        purchaseOrderPreperation.Click_ShowDetailsBtn();
        
        threadWait1();
        purchaseOrderPreperation.Click_OrderForDPRCPO();
        
        threadWait1();
        purchaseOrderPreperation.Select_IndentNumber();
        
        threadWait1();
        purchaseOrderPreperation.Select_VenderName();
        
        threadWait1();
        purchaseOrderPreperation.Enter_DateOfSending();
        
        threadWait1();
        purchaseOrderPreperation.Enter_SupplyBeforeDate();
        
        threadWait1();
        purchaseOrderPreperation.Click_TermCondition();
        
        threadWait1();
        purchaseOrderPreperation.Click_SignatureAuth();
        
        threadWait1();
        purchaseOrderPreperation.Click_SavePO();
        
        threadWait1();
        purchaseOrderPreperation.Click_POOrderLock();
        
        threadWait1();
        purchaseOrderPreperation.Select_PurchaseServiceOrder();
        
        threadWait1();
        purchaseOrderPreperation.Click_POServiceOrderBtn();
        // Alert handled in the main class method
        
        threadWait1();
        purchaseOrderPreperation.Select_Authority();
        
        threadWait1();
        purchaseOrderPreperation.Click_AddAuthorityBtn();
        // Alert handled in the main class method
        
        threadWait1();
        purchaseOrderPreperation.Click_SubmitBtn();
        // Alert handled in the main class method
        
        System.out.println("Purchase Order preparation completed successfully");
        
        // Additional validation if needed can be added here
    }
}
