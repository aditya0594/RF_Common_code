package EstablishmentTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_TransferAttendanceRecordFlow05_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_TransferAttendanceRecordFlow05_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 transferrecord;
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
	public void aL_Establishment_Trans_TransferAttendanceRecordFlow05_1Test() throws Exception {

		transferrecord = new AL_Establishment_Trans_TransferAttendanceRecordFlow05_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_TransferAttendanceRecordFlow05_1Test"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Transactions  > Transfer Attendance Record ");

		threadWait1();;
		HP.ESTABLISHMENT();
		
		threadWait1();;
		HP.Estab_Transactions();

		threadWait1();;
		transferrecord.Click_TransferAttendanceRecord();
		
		threadWait1();;
		transferrecord.Select_College();
		
		threadWait1();;
		transferrecord.Select_StaffType();
		
		threadWait1();;
		transferrecord.Select_FromDate();
		
		threadWait1();;
		transferrecord.Select_ToDate();
		
		threadWait1();;
		transferrecord.Click_ShowBtn();
		
		threadWait1();;
		transferrecord.Click_EditBtn();
		
		threadWait1();;
		transferrecord.Search_Name_EnterLWP();
		
		threadWait1();
		transferrecord.Click_Transferbtn();
		
		threadWait1();; 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Attendance Record Transfer Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
