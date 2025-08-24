package StudentAdmissionTest.TestFiles;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Login_SetLogin;
import StudentAdmissionTest.pages.SL_Academic_SR_CovidAndOtherInformation_StudentFlow_Flow_11;
import StudentAdmissionTest.pages.SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08;
import com.aventstack.extentreports.ExtentReports;
import com.qa.pages.HomePageAdmin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

import java.lang.reflect.Method;
import java.time.Duration;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.getLastValueFromColumn;

public class SL_Academic_SR_CovidAndOtherInformation_StudentFlow_Flow_11Test extends BaseClass {
    ExtentReports reports;
    HomePageAdmin HP;
    SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08 studentInfoPage;
    SL_Academic_SR_CovidAndOtherInformation_StudentFlow_Flow_11  covidDetails;
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
    public void Information_Covid() throws Exception {
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        HP = new HomePageAdmin(driver);
        String RRNOnumberInfo = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        // getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
        System.out.println("Student name extracted from Excel: " + RRNOnumberInfo);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.adminLogout();
        acceptAlert();
        String RRNOnumberInfoDocu = getLastValueFromColumn("Excel/NewStudents.xlsx", "RRNO");
        studentLogin.newCreatedStudentLogin(RRNOnumberInfoDocu, "Student@12345");
        System.out.println("ACADEMIC(SL) > Student Related > Student Information");
        studentInfoPage = new SL_Academic_SR_PersonalDetails_StudentFlow_Flow_08(driver);
        covidDetails = new SL_Academic_SR_CovidAndOtherInformation_StudentFlow_Flow_11(driver);
        threadWait1();
        HP.Academic();
        threadWait1();
        studentInfoPage.clickStudentRelated();
        threadWait1();
        studentInfoPage.clickStudentInformation();
        threadWait1();
        studentInfoPage.covidTab();
        threadWait1();
        covidDetails.Click_Vaccinated_No();
        threadWait1();
        covidDetails.Click_SaveContinueCovidInformation();
        // Other Information
        threadWait1();
        covidDetails.Enter_BankName();
        threadWait1();
        covidDetails.Enter_BankAccountNo();
        threadWait1();
        covidDetails.Enter_BranchName();
        threadWait1();
        covidDetails.Enter_IFSCode();
        threadWait1();
        covidDetails.Enter_BankAddress();
        threadWait1();
        covidDetails.I_AgreeCheckBox();
        threadWait1();
        covidDetails.sportName();
        threadWait1();
        covidDetails.sportLevel();
        threadWait1();
        covidDetails.sportAchivement();
        threadWait1();
        covidDetails.sportAddButton();
        threadWait1();
        covidDetails.Click_SaveBtn();
        Thread.sleep(2000);
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Other Information Saved Successfully!";
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        Thread.sleep(2000);
        alert.accept();

    }

}
