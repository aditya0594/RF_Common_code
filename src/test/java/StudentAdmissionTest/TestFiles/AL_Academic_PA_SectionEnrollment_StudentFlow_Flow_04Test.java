package StudentAdmissionTest.TestFiles;

import Administration.AL_Administration_FM_Rpt_MR_CompleteFilesReport;
import RFCC_Extra.BulkStudentUserCreation;
import StudentAdmissionTest.pages.AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04;
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

public class AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04Test extends BaseClass {
    ExtentReports reports;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;


    AL_Administration_FM_Rpt_MR_CompleteFilesReport aL_Administration_FM_Rpt_MR_CompleteFilesReport;

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
    public void SectionEnrollment() throws Exception {
        String StudentNamePost = getLastValueFromColumn("Excel/NewStudents.xlsx", "StudentName");
        System.out.println("Student name extracted from Excel: " + StudentNamePost);
        AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04 feeCollection = new AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04(driver);
        HP = new HomePageAdmin(driver);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.postAdmission();
        feeCollection.sectionEnrollmentSelect();
        feeCollection.schoolInstituteSelect();
        feeCollection.admissionBatchSelect();
        feeCollection.academicYear();
        feeCollection.degreedrop();
        feeCollection.programBranch();
        feeCollection.filterButton();
        feeCollection.filterNameForTable(StudentNamePost);

        String RRNOnumber = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumber);
        feeCollection.enterUnqiueRRNO(RRNOnumber);

        feeCollection.submitSectionEnrollmentEnroll();
        BulkStudentUserCreation bulkStudentcreate = new BulkStudentUserCreation(driver);
        bulkStudentcreate.User_able_to_Bulk_Student_User_Creation(StudentNamePost);
    }


}
