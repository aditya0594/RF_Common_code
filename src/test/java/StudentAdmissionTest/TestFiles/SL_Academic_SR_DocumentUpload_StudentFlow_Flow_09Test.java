package StudentAdmissionTest.TestFiles;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Academic_SR_SI_QualificationDetails;
import StudentAdmissionTest.SL_Login_SetLogin;
import StudentAdmissionTest.pages.SL_Academic_SR_DocumentUpload_StudentFlow_Flow_09;
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

public class SL_Academic_SR_DocumentUpload_StudentFlow_Flow_09Test extends BaseClass {
    ExtentReports reports;
    HomePageAdmin HP;
    SL_Academic_SR_DocumentUpload_StudentFlow_Flow_09 studentInfoPage;
    SL_Academic_SR_SI_QualificationDetails  qualificationdetails;
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
    public void Information_studentDocument() throws Exception {
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        HP = new HomePageAdmin(driver);
        // String RRNOnumberInfo = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        String RRNOnumberInfo = "AD1697"; //ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumberInfo);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.adminLogout();
        acceptAlert();
        String RRNOnumberInfoDocu = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        studentLogin.newCreatedStudentLogin(RRNOnumberInfoDocu, "Student@12345");
        System.out.println("ACADEMIC(SL) > Student Related > Student Information");
        studentInfoPage = new SL_Academic_SR_DocumentUpload_StudentFlow_Flow_09(driver);
        qualificationdetails = new SL_Academic_SR_SI_QualificationDetails(driver);
        threadWait1();
        HP.Academic();
        threadWait1();
        studentInfoPage.clickStudentRelated();
        threadWait1();
        studentInfoPage.clickStudentInformation();
        threadWait1();
        studentInfoPage.documentUploadTab();

        // Document Upload
        threadWait1();
        studentInfoPage.Upload_10th_Marksheet();
        threadWait1();
        studentInfoPage.Upload_12th_Marksheet();
        threadWait1();
        //studentInfoPage.Upload_AdharCard();
        threadWait1();
        studentInfoPage.uploadDoucumentNext();
    }


}
