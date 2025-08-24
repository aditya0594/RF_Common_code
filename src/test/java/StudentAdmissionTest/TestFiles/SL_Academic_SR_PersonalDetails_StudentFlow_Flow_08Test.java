package StudentAdmissionTest.TestFiles;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Academic_SR_SI_QualificationDetails;
import StudentAdmissionTest.SL_Login_SetLogin;
import StudentAdmissionTest.pages.SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08;
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

public class SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08Test extends BaseClass {
    ExtentReports reports;
    HomePageAdmin HP;
    SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08 studentInfoPage;
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
    public void Information_studentInfoEdit() throws Exception {
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        HP = new HomePageAdmin(driver);
        String RRNOnumberInfo = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        //String RRNOnumberInfo = "AD1697"; //ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumberInfo);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.adminLogout();
        acceptAlert();
        String RRNOnumber = getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        studentLogin.newCreatedStudentLogin(RRNOnumberInfo, "Student@12345");
        System.out.println("ACADEMIC(SL) > Student Related > Student Information");
        studentInfoPage = new SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08(driver);
        threadWait1();
        HP.Academic();
        threadWait1();
        studentInfoPage.clickStudentRelated();
        threadWait1();
        studentInfoPage.clickStudentInformation();
        //==============Personal Details================
        threadWait1();
        studentInfoPage.Enter_MobileNo();
        threadWait1();
        studentInfoPage.Enter_BirthPlace();
        threadWait1();
        studentInfoPage.Select_Nationality();
        threadWait1();
        studentInfoPage.Enter_ABC_ID();
        threadWait1();
        studentInfoPage.Enter_AdharCard();
        threadWait1();
        studentInfoPage.Select_Religion();
        threadWait1();
        studentInfoPage.Upload_Photo();
        threadWait1();
        studentInfoPage.Click_SaveContinueBtn();
    }


}
