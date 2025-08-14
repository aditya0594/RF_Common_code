package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import Administration.AL_Administration_GR_Master_GrievanceType;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_GR_Master_GrievanceTypeTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_GR_Master_GrievanceType aL_Administration_GR_M_GrievanceType;

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
	public void aL_Administration_GR_M_GrievanceTypeTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_GR_M_GrievanceType = new AL_Administration_GR_Master_GrievanceType(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_GR_M_GrievanceTypeTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->GrievanceRedressal->Master -> GrievanceType");

		threadWait1();
		homePageAdmin.ADMINISTRATION();

		threadWait1();
		homePageAdmin.GrievanceRedressal();

		threadWait1();
		homePageAdmin.Admin_GR_Master();

		threadWait1();
		aL_Administration_GR_M_GrievanceType.ClickOn_GrievanceType();

		threadWait1();
		aL_Administration_GR_M_GrievanceType.ClickOn_Edit();
		
		threadWait1();
		aL_Administration_GR_M_GrievanceType.Select_SubmitButton();

		
		// Alert
		threadWait1();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		threadWait1();
		alert.accept();

	}

}
