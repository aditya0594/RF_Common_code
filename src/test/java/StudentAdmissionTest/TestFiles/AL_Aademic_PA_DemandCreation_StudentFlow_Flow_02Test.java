package StudentAdmissionTest.TestFiles;


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

public class AL_Aademic_PA_DemandCreation_StudentFlow_Flow_02Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 demandCreation;

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
    public void demandCreation() throws Exception {
        HP = new HomePageAdmin(driver);
        demandCreation = new AL_Academic_PA_DemandCreation_StudentFlow_Flow_02(driver);
        test = reports.createTest("aL_Academic_AP_NewStudentTest_Row");
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        demandCreation.preAdmission();
        demandCreation.demandCreationMenu();
        String StudentName = getLastValueFromColumn("Excel/NewStudents.xlsx", "StudentName");
        System.out.println("Student name extracted from Excel: " + StudentName);
        demandCreation.singleStudentDemand();
        demandCreation.searchCreatria();
        demandCreation.searchStringName(StudentName);
        demandCreation.searchBtn();
        demandCreation.clickonSearchStudent();
        demandCreation.sessiontitle();
        demandCreation.sessionSelectiondemand("2023-2024 ( 2023-2024 )");
        demandCreation.semesterselectDemand();
        demandCreation.receptTypeSelectdemand();
        demandCreation.verifyDemandStatus();
        demandCreation.CreateDemandbutton();

    }
}
