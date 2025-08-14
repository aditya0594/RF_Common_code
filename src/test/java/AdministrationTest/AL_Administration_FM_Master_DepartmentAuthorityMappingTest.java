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

import Administration.AL_Administration_FM_Master_DepartmentAuthorityMapping;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_FM_Master_DepartmentAuthorityMappingTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_FM_Master_DepartmentAuthorityMapping aL_Administration_FM_Master_DepartmentAuthorityMapping;

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
	public void aL_Administration_FM_Master_DepartmentAuthorityMappingTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_FM_Master_DepartmentAuthorityMapping = new AL_Administration_FM_Master_DepartmentAuthorityMapping(
				driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_FM_Master_DepartmentAuthorityMappingTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->File Movement-> Master ->  Department Authority Mapping ");

		threadWait1();
		homePageAdmin.ADMINISTRATION();

		threadWait1();
		homePageAdmin.FileMovement();

		threadWait3();
		homePageAdmin.Admin_FM_Master();

		threadWait3();
		aL_Administration_FM_Master_DepartmentAuthorityMapping.ClickOn_DepartmentAuthorityMapping();

		threadWait3();
		aL_Administration_FM_Master_DepartmentAuthorityMapping.ClickOn_Edit();

		threadWait3();
		aL_Administration_FM_Master_DepartmentAuthorityMapping.Select_SubmitButton();

		// Alert
		threadWait3();
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully.";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		threadWait1();
		alert.accept();

		threadWait3();
		aL_Administration_FM_Master_DepartmentAuthorityMapping.ClickOn_CGRReports();

		//threadWait2();
		//new ProcessBuilder("AutoIT/PrintPDF.exe").start();
	//	Thread.sleep(15000);
		pdfutility.downloadPDF(driver, "Administration-File Movement-Master - Department Authority Mapping - Report");

		threadWait3();
		pdfutility.readPDF("Administration-File Movement-Master - Department Authority Mapping - Report", "SAIBULLA");

	} 
}
