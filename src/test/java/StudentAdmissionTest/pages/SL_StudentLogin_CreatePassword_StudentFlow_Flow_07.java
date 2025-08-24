package StudentAdmissionTest.pages;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Login_SetLogin;
import com.aventstack.extentreports.ExtentReports;
import com.qa.pages.HomePageAdmin;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

import java.lang.reflect.Method;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.getLastValueFromColumn;

public class SL_StudentLogin_CreatePassword_StudentFlow_Flow_07 extends BaseClass {
    ExtentReports reports;
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
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 6, enabled = true)
    public void studentLogin() throws Exception {
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        String RRNOnumberStudentLogin = getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumberStudentLogin);
        HP = new HomePageAdmin(driver);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.adminLogout();
        acceptAlert();
        studentLogin.newCreatedStudentLogin(RRNOnumberStudentLogin, RRNOnumberStudentLogin);
        studentLogin.changeStudentPassword(RRNOnumberStudentLogin);
        studentLogin.StudentLoginWithChangepassword(RRNOnumberStudentLogin);
    }


}
