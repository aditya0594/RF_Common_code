package StoresTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Trans_IndentPreparationFlow04_3;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_IndentPreparationFlow04_3Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Stores_Trans_IndentPreparationFlow04_3 indentPreparation;
   
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
    public void aL_Stores_Trans_IndentPreparationFlow04_3Test() throws Exception {
        indentPreparation = new AL_Stores_Trans_IndentPreparationFlow04_3(driver);
   
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Stores_Trans_IndentPreparationFlow04_3Test");

        RF_AdminLoginPage.loginPage();
        System.out.println("STORES > TRANSACTION > Indent Preparation");

        threadWait1();
        HP.STORE();

        threadWait1();
        HP.Store_Transaction();

        threadWait1();
        indentPreparation.Click_IndentPrepration();

        // Read requisition slip number from Excel and use it to search
        String requisitionSlipNo = TestDataExcelUtil.readData("RequisitionSlipNumber");
        System.out.println("Using Requisition Slip No.: " + requisitionSlipNo + " from previous test");
        
        threadWait1();
        // Use the searchBySlipNo method that utilizes the requisition slip number
        indentPreparation.searchBySlipNo(requisitionSlipNo);
        
        threadWait1();
        indentPreparation.Click_ShowItems();
        
        threadWait1();
        indentPreparation.Select_Item();
        
        threadWait1();
        indentPreparation.Click_AddButton();
        
//        threadWait1();
//        indentPreparation.Enter_Quantity();
//        
        threadWait1();
        indentPreparation.Click_NextButton();
        
        threadWait1();
        indentPreparation.Select_DirectPO();
        
        threadWait1();
        indentPreparation.Click_SaveIndent();
        
        threadWait1(); 
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Record Saved Successfully"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg, Expected_Msg);
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
        
      
    }
}
