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

import Stores.AL_Stores_Trans_RequisitionApprovalFlow04_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_RequisitionApprovalFlow04_2Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Stores_Trans_RequisitionApprovalFlow04_2 requisitionApproval;
   
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
    public void aL_Stores_Trans_RequisitionApprovalTest() throws Exception {
        requisitionApproval = new AL_Stores_Trans_RequisitionApprovalFlow04_2(driver);
   
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Stores_Trans_RequisitionApprovalTest");

        RF_AdminLoginPage.loginPage();
        System.out.println("STORES > TRANSACTION > Requisition Approval");

        threadWait1();
        HP.STORE();

        threadWait1();
        HP.Store_Transaction();

        threadWait1();
        requisitionApproval.Click_RequisitionApproval();

        threadWait1();
        // Read the requisition slip number that was generated in DepartmentUserRequisitonTest
        String requisitionSlipNo = TestDataExcelUtil.readData("RequisitionSlipNumber");
        System.out.println("Using Requisition Slip No.: " + requisitionSlipNo + " from Excel");
        requisitionApproval.Search_RequisitionSlipNo(requisitionSlipNo);
        
        threadWait1();
        requisitionApproval.Click_EditButton();

        threadWait1();
        requisitionApproval.Click_SubmitButton();
        
        Thread.sleep(4000); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Requisition Approved Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
    }
}
