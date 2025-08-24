package StudentAdmissionTest.TestFiles;

import Administration.AL_Administration_FM_Rpt_MR_CompleteFilesReport;
import RFCCAcademic.AL_Academic_AP_NewStudent;
import RFCCAcademic.SL_Academic_SR_StudentInformation;
import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Academic_SR_SI_QualificationDetails;
import StudentAdmissionTest.pages.AL_Academic_PA_DemandCreation_StudentFlow_Flow_02;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

import java.lang.reflect.Method;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.getLastValueFromColumn;

public class AL_Academic_FR_FeeCollection_StudentFlow_Flow_03Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_Academic_AP_NewStudent newStudentPage;
    AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 demandCreation;
    SL_Academic_SR_StudentInformation studentInfoPage;
    SL_Academic_SR_SI_QualificationDetails qualificationdetails;
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
    public void FeeReceipt() throws Exception {
        String StudentNamefees = getLastValueFromColumn("Excel/NewStudents.xlsx", "StudentName");
        System.out.println("Student name extracted from Excel: "+ StudentNamefees);
        HP = new HomePageAdmin(driver);
        pdfutility = new PDFUtility(driver);
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.feeCollections();
        feeCollection.searchCriteriaSelect();
        feeCollection.SearchStringStudentName(StudentNamefees);
        feeCollection.searchBtn();
        feeCollection.clickonSearchedStudent();
        feeCollection.feeCollectionModeSelection();
        feeCollection.payTypeSelection();
        feeCollection.amountTobePaid();
        feeCollection.submitButton();

        Thread.sleep(1000);
        switchToNextWindow();
        Thread.sleep(1000);
        pdfutility.downloadPDF(driver, "Student Fee receipt");
        Thread.sleep(5000);
        pdfutility.readPDF("Student Fee receipt", StudentNamefees);

    }



}
