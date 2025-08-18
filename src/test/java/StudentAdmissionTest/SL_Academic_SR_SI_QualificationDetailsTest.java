package StudentAdmissionTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;


import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class SL_Academic_SR_SI_QualificationDetailsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	SL_Academic_SR_SI_QualificationDetails qualificationdetails;
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
	public void sL_Academic_SR_SI_QualificationDetailsTest() throws Exception {
		test = reports.createTest("sL_Academic_SR_SI_QualificationDetailsTest");
		HP = new HomePageAdmin(driver);
		qualificationdetails = new SL_Academic_SR_SI_QualificationDetails(driver);
		Thread.sleep(2000);
		qualificationdetails.loginPage(); 
		
		System.out.println("ACADEMIC(SL) > Student Related > Student Information > Qualification Details");

		threadWait1();
		HP.Academic();
		threadWait1();
		
		threadWait1();
		qualificationdetails.clickStudentRelated();
		
		threadWait1();
		qualificationdetails.clickStudentInformation();
		
		threadWait1();
		qualificationdetails.Click_QualificationDetailsTab();
		
		threadWait1();
		qualificationdetails.Enter_Schoolname10th();
		
		threadWait1();
		qualificationdetails.Enter_Board10th();
		
		threadWait1();
		qualificationdetails.Enter_YearOfExam10th();
		
//		threadWait1();
//		qualificationdetails.Enter_OutOfMarks10th();
//		
//		threadWait1();
//		qualificationdetails.Enter_MarkObtain10th();
		
		threadWait1();
		qualificationdetails.Enter_SchoolName12th();
		
		threadWait1();
		qualificationdetails.Enter_Board12th();
		
		threadWait1();
		qualificationdetails.Enter_YearOfExam12th();
		
		threadWait1();
		qualificationdetails.Enter_TotalMarks12th();
		
		threadWait1();
		qualificationdetails.Enter_MarkObtained12th();
		
		threadWait1();
		qualificationdetails.Enter_EntranceExamName();
		
		threadWait1();
		qualificationdetails.Enter_SeatNo();
		
		threadWait1();
		qualificationdetails.Enter_YearOfExam();
		
		threadWait1();
		qualificationdetails.Enter_Percentage();
		
		threadWait1();
		qualificationdetails.Enter_TotalMarks();
		
		threadWait1();
		qualificationdetails.Enter_EntranceObtainedMarks();
		
		threadWait1();
		qualificationdetails.Enter_Rank();
		
		threadWait1();
		qualificationdetails.Enter_CategoryRank();
		
//		threadWait1();
//		qualificationdetails.Click_EntranceAddBtn();
		
		threadWait1();
		qualificationdetails.Enter_SchoolCollegePG();
		
		threadWait1();
		qualificationdetails.Enter_BoardPG();
		
		threadWait1();
		qualificationdetails.Enter_QualifyingExamPG();
		
		threadWait1();
		qualificationdetails.Enter_SeatNoPG();
		
		threadWait1();
		qualificationdetails.Enter_YearofExamPG();
		
		threadWait1();
		qualificationdetails.Enter_StatusPG();
		
		threadWait1();
		qualificationdetails.Enter_OutOfMarksPG();
		
		threadWait1();
		qualificationdetails.Enter_MarksObtainedPG();
		
		threadWait1();
		qualificationdetails.Enter_GradePG();
		
		threadWait1();
		qualificationdetails.Enter_DGPACGPA_PG();
		
		threadWait1();
		qualificationdetails.Enter_SchoolCollegeAddressPG();
		
		threadWait1();
		qualificationdetails.Click_AddBtn_PG();
		
		threadWait1();
		qualificationdetails.Click_SaveContinueQualificationDetails();
		
		// Covid Information
		
		threadWait1();
		qualificationdetails.Click_Vaccinated_Yes();
		
		threadWait1();
		qualificationdetails.Click_SaveContinueCovidInformation();
		
		// Other Information
		
		threadWait1();
		qualificationdetails.Enter_BankName();
		
		threadWait1();
		qualificationdetails.Enter_BankAccountNo();
		
		threadWait1();
		qualificationdetails.Enter_BranchName();
		
		threadWait1();
		qualificationdetails.Enter_IFSCode();
		
		threadWait1();
		qualificationdetails.Enter_BankAddress();
		
		threadWait1();
		qualificationdetails.Click_SaveBtn();
		
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Final Submit Done Successfully!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}
}
