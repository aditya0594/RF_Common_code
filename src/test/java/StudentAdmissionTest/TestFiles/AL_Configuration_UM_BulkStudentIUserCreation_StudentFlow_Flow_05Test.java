package StudentAdmissionTest.TestFiles;

import RFCC_Extra.BulkStudentUserCreation;
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

public class AL_Configuration_UM_BulkStudentIUserCreation_StudentFlow_Flow_05Test extends BaseClass {

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
    @Test(priority = 1, enabled = true)
    public void BulkStudentUserCreation() throws Exception {
        HP = new HomePageAdmin(driver);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        String StudentNamePost = getLastValueFromColumn("Excel/NewStudents.xlsx", "StudentName");
        System.out.println("Student name extracted from Excel: " + StudentNamePost);
        BulkStudentUserCreation bulkStudentcreate = new BulkStudentUserCreation(driver);
        bulkStudentcreate.User_able_to_Bulk_Student_User_Creation(StudentNamePost);
    }
}
