package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_ARM_RoomMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_ARM_RoomMasterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_ARM_RoomMaster roommaster;
	HomePageAdmin HP;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_CR_ARM_RoomMasterTest() throws Exception {
		
		roommaster = new AL_Academic_CR_ARM_RoomMaster(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_CR_ARM_RoomMasterTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Academic Room Master > Room Master"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
		
		Thread.sleep(2000);
		roommaster.Click_AcademicRoomMaster();
		
		Thread.sleep(2000);
		roommaster.Click_RoomMaster();
		
		Thread.sleep(2000);
		roommaster.Enter_EditRoomName();
		
		Thread.sleep(2000);
		roommaster.Select_FloorName();
		
		Thread.sleep(2000);
		roommaster.Enter_RoomIntake();
		
		Thread.sleep(2000);
		roommaster.Click_UpdateBtn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
