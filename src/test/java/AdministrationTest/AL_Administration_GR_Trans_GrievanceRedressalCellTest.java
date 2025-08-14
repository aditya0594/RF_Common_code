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

import Administration.AL_Administration_GR_Trans_GrievanceRedressalCell;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_GR_Trans_GrievanceRedressalCellTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_GR_Trans_GrievanceRedressalCell aL_Administration_GR_Trans_GrievanceRedressalCell;

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
	public void aL_Administration_GR_Trans_GrievanceRedressalCellTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_GR_Trans_GrievanceRedressalCell = new AL_Administration_GR_Trans_GrievanceRedressalCell(
				driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_GR_Trans_GrievanceRedressalCellTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->GrievanceRedressal->Transaction -> Grievance Redressal Cell");

		threadWait1();
		homePageAdmin.ADMINISTRATION();

		threadWait1();
		homePageAdmin.GrievanceRedressal();

		threadWait1();
		homePageAdmin.Admin_GR_Transaction();

		threadWait1();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_GrievanceRedressalCell();

		threadWait1();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_CommitteeTypeMember();

		threadWait3();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_Edit();

		threadWait3();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_Edit2();

		threadWait3();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_AddBtn();

		// Alert
		threadWait3();
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Already Exist.";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		threadWait1();
		alert.accept();

		threadWait1();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_SubmitBtn();

		// Alert
		threadWait1();
		Alert alert2 = driver.switchTo().alert();
		String Expected_Msg2 = "Record Update Successfully";
		String Actual_Msg2 = alert2.getText();
		Assert.assertEquals(Actual_Msg2, Expected_Msg2);
		System.out.println("Actual Message - " + Actual_Msg2 + "\n" + "Expected Message - " + Expected_Msg2);
		threadWait1();
		alert2.accept();

		threadWait1();
		aL_Administration_GR_Trans_GrievanceRedressalCell.ClickOn_ReportBtn();

		threadWait2();
		pdfutility.downloadPDF(driver,
				"Administration-GrievanceRedressal-Transaction - Grievanc Redressal Cell - Committee Type Member");

		threadWait2();
		pdfutility.readPDF(
				"Administration-GrievanceRedressal-Transaction - Grievance Redressal Cell- Committee Type Member",
				"RAVIKUMAR");

	}

}
