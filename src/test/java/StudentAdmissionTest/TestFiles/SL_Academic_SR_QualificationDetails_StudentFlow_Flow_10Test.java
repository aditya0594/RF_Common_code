package StudentAdmissionTest.TestFiles;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Login_SetLogin;
import StudentAdmissionTest.pages.SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08;
import StudentAdmissionTest.pages.SL_Academic_SR_QualificationDetails_StudentFlow_Flow_10;
import com.aventstack.extentreports.ExtentReports;
import com.qa.pages.HomePageAdmin;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

import java.lang.reflect.Method;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.getLastValueFromColumn;

public class SL_Academic_SR_QualificationDetails_StudentFlow_Flow_10Test extends BaseClass {
    ExtentReports reports;
    HomePageAdmin HP;
    SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08 studentInfoPage;
    SL_Academic_SR_QualificationDetails_StudentFlow_Flow_10  qualificationdetails;
    @BeforeClass
    public void configuration() {
        reports = Reports.createReport();
    }
    @BeforeMethod
    public void launchBrowser(Method m) throws Exception {
        driver = Browser.openBrowser("url_RF_LoginAdmin");

        System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
    }
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test(priority = 1, enabled = true)
    public void Information_qualificationdetails() throws Exception {
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        HP = new HomePageAdmin(driver);
        // String RRNOnumberInfo = getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        String RRNOnumberInfo = "AD1697"; //getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumberInfo);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.adminLogout();
        acceptAlert();
        String RRNOnumberInfoDocu = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        studentLogin.newCreatedStudentLogin(RRNOnumberInfoDocu, "Student@12345");
        System.out.println("ACADEMIC(SL) > Student Related > Student Information");
        studentInfoPage = new SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08(driver);
        qualificationdetails = new SL_Academic_SR_QualificationDetails_StudentFlow_Flow_10(driver);
        threadWait1();
        HP.Academic();
        threadWait1();
        studentInfoPage.clickStudentRelated();
        threadWait1();
        studentInfoPage.clickStudentInformation();
        threadWait1();
        studentInfoPage.qualificationTab();
        threadWait1();
        qualificationdetails.Enter_Schoolname10th();
        threadWait1();
        qualificationdetails.Enter_Board10th();
        threadWait1();
        qualificationdetails.Enter_YearOfExam10th();
        threadWait1();
        qualificationdetails.OutOfMArks();
        threadWait1();
        qualificationdetails.MarksObtain();

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
        acceptAlert();

        threadWait1();
        qualificationdetails.Click_SaveContinueQualificationDetails();
    }


}
