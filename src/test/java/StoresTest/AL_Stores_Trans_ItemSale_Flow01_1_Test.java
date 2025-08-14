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

import Stores.AL_Stores_Trans_ItemSale_Flow01_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_ItemSale_Flow01_1_Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Stores_Trans_ItemSale_Flow01_1 itemSale;
    HomePageAdmin HP;
    static String itemSaleTRNo;
    @BeforeClass
    public void configuration() {
        reports = Reports.createReport();
    }

    @BeforeMethod
    public void launchBrowser(Method m) throws Exception {
        driver = Browser.openBrowser("url_RF_LoginAdmin");
        System.out.println("\n *****Starting Test***** : " + m.getName() + "******* \n");
    }

    @Test
    public void aL_Stores_Trans_ItemSale_Flow01_1_Test() throws Exception {
        itemSale = new AL_Stores_Trans_ItemSale_Flow01_1(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Stores_Trans_ItemSale_Flow01_1_Test");

        RF_AdminLoginPage.loginPage();
        System.out.println("STORES > TRANSACTION > Item Sale");

        threadWait1();
        HP.STORE();

        threadWait1();
        HP.Store_Transaction();

        threadWait1();
        itemSale.Click_ItemSale();

        threadWait1();
        itemSale.Click_AddNewButton();

        threadWait1();
        itemSale.Select_ItemType();

        threadWait1();
        itemSale.Select_SubCategory();

        threadWait1();
        itemSale.Select_Item();

        threadWait1();
        itemSale.Enter_SaleDate();

        threadWait1();
        itemSale.Select_VendorName();

        threadWait1();
        itemSale.Click_ShowButton();

        threadWait1();
        itemSale.Click_CheckBox();

        threadWait1();
        itemSale.Click_AddButton();

        threadWait1();
        itemSale.Enter_SaleValue();

        threadWait1();
        itemSale.Click_SaveButton();
        
        Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved  Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		  // Get and save the Item Sale TR NO. to Excel
        threadWait1();
        String itemSaleTRNo = itemSale.getItemSaleTRNumber();
        
        // Save the TR Number to Excel instead of TestDataUtil
        TestDataExcelUtil.writeData("ItemSaleTRNo", itemSaleTRNo);
        System.out.println("Saved Item Sale TR NO.: " + itemSaleTRNo + " to Excel");	 	
    }
}
