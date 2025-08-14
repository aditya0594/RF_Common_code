package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_SA_Room;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_SA_RoomTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_SA_Room al_Examination_SA_Room;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Examination_SA_RoomTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_SA_Room = new AL_Examination_SA_Room(driver);
		test = reports.createTest("SeatingArrangement_Room");

		Thread.sleep(3000);

		RF_AdminLoginPage.loginPage();

		Thread.sleep(3000);
		//Click main Examination menu
		homePageAdmin.EXAMINATION();

		Thread.sleep(3000);
		//Click Seating Arrangment menu
		homePageAdmin.Exam_SeatingArrangement();

		Thread.sleep(3000);
		//Click Room Page
		al_Examination_SA_Room.click_Room();

		Thread.sleep(3000);
		//Select college name
		al_Examination_SA_Room.select_College();

		Thread.sleep(3000);
		//Select on departmemt
		al_Examination_SA_Room.select_Department();

		Thread.sleep(3000);
		//Select on Floor
		al_Examination_SA_Room.select_Floor();

		Thread.sleep(3000);
		//Select on Block
		al_Examination_SA_Room.select_Block();

		Thread.sleep(3000);
		//EnterRoom Name
		al_Examination_SA_Room.enter_RoomName();

		Thread.sleep(3000);
		//Enter Room Capacity 
		al_Examination_SA_Room.enter_RoomCapacity(); 

		Thread.sleep(3000);
		//Click checkbox status
		al_Examination_SA_Room.check_Status_Checkbox();

		Thread.sleep(3000);
		//click on submit
		al_Examination_SA_Room.click_SubmitButton();

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Room Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();


	}
}
