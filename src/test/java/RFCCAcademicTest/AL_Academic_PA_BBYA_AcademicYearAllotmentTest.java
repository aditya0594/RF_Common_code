package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_BBYA_AcademicYearAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_BBYA_AcademicYearAllotmentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_PA_BBYA_AcademicYearAllotment aL_PA_BulkBatchAndYearAllotment_ABA;
	HomePageAdmin HP;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test******* : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_PA_BBYA_AcademicYearAllotmentTest() throws Exception {

		aL_PA_BulkBatchAndYearAllotment_ABA = new AL_Academic_PA_BBYA_AcademicYearAllotment(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Academic_PA_BBYA_AcademicYearAllotmentTest");
		threadWait1();
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic > Post Admission > Bulk Batch & Year Allotment > Academic Batch Allotment");

		threadWait1();
		HP.Academic();
		threadWait1();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.PostAdmission();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.BulkBatchYearAllotment();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.AdmissionBatch();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.SchoolInstitute();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.AdmissionType();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.AcademicBatch();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.ShowButton();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.CheckBox();

		threadWait1();
		aL_PA_BulkBatchAndYearAllotment_ABA.SubmitButton();

		threadWait1();
		acceptAlert();
	}
}
