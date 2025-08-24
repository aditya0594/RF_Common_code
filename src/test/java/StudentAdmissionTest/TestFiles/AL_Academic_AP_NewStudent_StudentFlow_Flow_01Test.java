package StudentAdmissionTest.TestFiles;

import RFCCAcademic.AL_Academic_AP_NewStudent;
import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import StudentAdmissionTest.SL_Login_SetLogin;
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

import java.io.IOException;
import java.lang.reflect.Method;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.getLastValueFromColumn;
import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.writeStudentDataToExcel;

public class AL_Academic_AP_NewStudent_StudentFlow_Flow_01Test extends BaseClass {

    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_Academic_AP_NewStudent newStudentPage;

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
    public void New_Student_create() throws Exception {

        newStudentPage = new AL_Academic_AP_NewStudent(driver);
        test = reports.createTest("aL_Academic_AP_NewStudentTest_Row");
        HP = new HomePageAdmin(driver);
        // Set data row to use for this test
        //ewStudentPage.setDataRow(dataRow);
        Thread.sleep(4000);
        RF_AdminLoginPage.loginPage();
        AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
        SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
        System.out.println("ACADEMIC > Admission Process > New Student");

        HP.Academic();
        newStudentPage.admissionProcess();
        newStudentPage.newStudent();
        Thread.sleep(2000);
        newStudentPage.clickNewStudentButton();
        Thread.sleep(2000);
        String fistname = generateLastName();
        String lastname = generateLastName();
        String studentName = fistname+" "+lastname;
        String RRNOnumber = "AD"+Random4DigitString();


        newStudentPage.enterStudentName(studentName);
        String fatherName = generateFirstName();
        newStudentPage.enterFatherName(fatherName);
        String mobileNumber = generateMobileNumber();
        newStudentPage.enterMobileNumber(mobileNumber);
        String alternateMobileNumber = generateMobileNumber();
        newStudentPage.enterAlternateMobileNumber(alternateMobileNumber);
        String email =fistname+lastname+"@yopmail.com";
        newStudentPage.enterEmailId(email);

        try {
           writeStudentDataToExcel(
                    studentName,
                    fatherName,
                    mobileNumber,
                    alternateMobileNumber,
                    email,
                    RRNOnumber
            );
            System.out.println("student data written to excel");
        } catch (IOException e) {
            e.printStackTrace();
        }
        newStudentPage.selectNationality();
        newStudentPage.selectState();
        newStudentPage.selectDistrict();
        newStudentPage.selectCity();
        newStudentPage.clickGender();
        newStudentPage.SchoolInstitution();
        newStudentPage.degreeSelect();
        newStudentPage.branchselect();
        newStudentPage.admissionThroughSelect();
        newStudentPage.admissionType();
        newStudentPage.admissionYear();
        newStudentPage.semesterselect();
        newStudentPage.admissionBranchSelect();
        newStudentPage.DobSelect();
        newStudentPage.admissionCategorySelect();
        Thread.sleep(3000);
        newStudentPage.DateOFEntrySelect();
        Thread.sleep(3000);
        newStudentPage.paymentTypeSelect();
        //newStudentPage.receptTypeSelect();
        newStudentPage.sessionSelection("2023-2024");
        newStudentPage.SubmitStudent();
        Thread.sleep(3000);
    }
    String StudentName = getLastValueFromColumn("Excel/NewStudents.xlsx", "StudentName");


}
