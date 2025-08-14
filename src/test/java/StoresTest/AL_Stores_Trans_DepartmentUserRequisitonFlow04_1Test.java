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

import Stores.AL_Stores_Trans_DepartmentUserRequisitonFlow04_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_DepartmentUserRequisitonFlow04_1Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 departmentUserRequisition;
	
	@BeforeClass
	public void configureReport() {
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test : " + m.getName() + "*******" + "\n");
	}
	
	@Test(groups = "departmentUserRequisition")
	public void aL_Stores_Trans_DepartmentUserRequisitonFlow04_1Test() throws Exception {
		HP = new HomePageAdmin(driver);
		departmentUserRequisition = new AL_Stores_Trans_DepartmentUserRequisitonFlow04_1(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Stores_Trans_DepartmentUserRequisitonFlow04_1Test");
		
		// Login to admin page
		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");
		threadWait1();
		
		System.out.println("STORES > TRANSACTION > Department User Requisition");
		
		// Navigate to Stores
		HP.STORE();
		threadWait1();
		
		// Navigate to Transaction
		HP.Store_Transaction();
		threadWait1();
		
		// Click on Department User Requisition
//		departmentUserRequisition.click_DepartmentUserRequisition();
//		threadWait1();
		
		// Click on Purchase radio button
		departmentUserRequisition.click_Purchase();
		threadWait1();
		
		// Select Department
		departmentUserRequisition.select_Department();
		threadWait1();
		
		// Select Item Name
		departmentUserRequisition.select_ItemName();
		threadWait1();
		
		// Get the Requisition Slip Number and store it in Excel
		String RequisitionSlipNumber = departmentUserRequisition.getRequisitionSlipNumber();
		TestDataExcelUtil.writeData("RequisitionSlipNumber", RequisitionSlipNumber);
		System.out.println("Saved Requisition Slip Number: " + RequisitionSlipNumber + " to Excel");
		threadWait1();
		
		// Enter Required Quantity
		departmentUserRequisition.enter_RequiredQty();
		threadWait1();
		
		// Enter Rate
		departmentUserRequisition.enter_Rate();
		threadWait1();
		
		// Click on Add Item button
		departmentUserRequisition.click_AddItemBtn(); 
		threadWait1();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Item Added Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		// Click on Submit button
		departmentUserRequisition.click_SubmitBtn();
	
		Thread.sleep(5000); 
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Requisition Submitted Successfully"; 
		String Actual_Msg1 = alert.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
	}
}
