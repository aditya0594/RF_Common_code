package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_SectionEnrollmentNoAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

/**
 * Test class for Academic Post Admission Section/Enrollment No. Allotment functionality
 * Uses page object model pattern for improved maintainability
 */
public class AL_Academic_PA_SectionEnrollmentNoAllotmentTest extends BaseClass {

    ExtentReports reports;
    ExtentTest test;
    AL_Academic_PA_SectionEnrollmentNoAllotment alAcademicPASectionEnrollmentNoAllotment;
    HomePageAdmin HP;
    
    @BeforeClass
    public void configuration() {
        reports = Reports.createReport();
    }

    @BeforeMethod
    public void launchBrowser(Method m) throws Exception {
        driver = Browser.openBrowser("url_RF_LoginAdmin");
        System.out.println("\n" + "******Starting Test*****: " + m.getName() + "*******" + "\n");
    }

    @Test
    public void aL_Academic_PA_SectionEnrollmentNoAllotmentTest() throws Exception {
        // Initialize page objects
        alAcademicPASectionEnrollmentNoAllotment = new AL_Academic_PA_SectionEnrollmentNoAllotment(driver);
        HP = new HomePageAdmin(driver);
        
        // Create test in extent reports
        test = reports.createTest("aL_Academic_PA_SectionEnrollmentNoAllotmentTest");
        
        // Login to the application
        RF_AdminLoginPage.loginPage();
        System.out.println("ACADEMIC->Post Admission->Section/Enrollment No. Allotment");
        
        threadWait1();
        
        // Navigate to Academic menu
        HP.Academic();
        threadWait1();
        
        // Use page object methods to perform actions
        alAcademicPASectionEnrollmentNoAllotment.clickPostAdmissionMenu();
        threadWait1();
        
        alAcademicPASectionEnrollmentNoAllotment.clickSectionEnrollmentNoAllotment();
        threadWait1();
        
        alAcademicPASectionEnrollmentNoAllotment.selectSchoolInstitute();
        
        alAcademicPASectionEnrollmentNoAllotment.selectDegree();
        
        alAcademicPASectionEnrollmentNoAllotment.selectBranch();
        
        alAcademicPASectionEnrollmentNoAllotment.clickFilterButton();
        
        // Commented section for class selection is handled in the page object if needed
        /* 
        alAcademicPASectionEnrollmentNoAllotment.selectClassSection();
        */
        
        alAcademicPASectionEnrollmentNoAllotment.enterRollNumber();
        threadWait1();
        
        alAcademicPASectionEnrollmentNoAllotment.clickSubmitButton();
        
        // Handle the alert and verify the message
        Alert alert = driver.switchTo().alert();
        String expectedMsg = alAcademicPASectionEnrollmentNoAllotment.getExpectedAlertMessage();
        String actualMsg = alert.getText();
        
        System.out.println("Actual Message - " + actualMsg + "\n" + "Expected Message - " + expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Alert message verification");
        System.out.println("Actual and Expected Msg matched");
        
        threadWait1();
        alert.accept();
        
        System.out.println("Section/Enrollment No. Allotment test completed successfully");
    }
}

