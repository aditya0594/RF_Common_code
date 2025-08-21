package StudentAdmissionTest;

import Administration.AL_Administration_FM_Rpt_MR_CompleteFilesReport;
import RFCCAcademic.AL_Academic_AP_NewStudent;
import RFCCAcademic.SL_Academic_SR_StudentInformation;
import RFCC_Extra.BulkStudentUserCreation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.*;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.*;

import java.io.IOException;
import java.lang.reflect.Method;
//@Listeners(utility.RetryAnalyzer.class)
public class AL_Academic_AP_NewStudentTest extends BaseClass {

    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_Academic_AP_NewStudent newStudentPage;
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
//        if (driver != null) {
//            driver.quit();
//        }
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
            ExcelUtility.writeStudentDataToExcel(
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
    String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");


    //==========demand=================

          @Test(priority = 2, enabled = true)
            public void demandCreation() throws Exception {
              HP = new HomePageAdmin(driver);
            newStudentPage = new AL_Academic_AP_NewStudent(driver);
            test = reports.createTest("aL_Academic_AP_NewStudentTest_Row");
            RF_AdminLoginPage.loginPage();
            HP.Academic();
            newStudentPage.preAdmission();
            newStudentPage.demandCreationMenu();
            String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
            System.out.println("Student name extracted from Excel: " + StudentName);
            newStudentPage.singleStudentDemand();
            newStudentPage.searchCreatria();
            newStudentPage.searchStringName(StudentName);
            newStudentPage.searchBtn();
            newStudentPage.clickonSearchStudent();
            newStudentPage.sessiontitle();
            newStudentPage.sessionSelectiondemand("2023-2024 (  )");
            newStudentPage.semesterselectDemand();
            newStudentPage.receptTypeSelectdemand();
            newStudentPage.verifyDemandStatus();
            newStudentPage.CreateDemandbutton();

        }

       //===========================Fee Receipt==========
        @Test(priority = 3, enabled = true)
        public void FeeReceipt() throws Exception {
        //  String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
        // System.out.println("Student name extracted from Excel: "+ StudentName);
            HP = new HomePageAdmin(driver);
            AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
            RF_AdminLoginPage.loginPage();
        HP.Academic();
        feeCollection.feeCollections();
        feeCollection.searchCriteriaSelect();
        feeCollection.SearchStringStudentName(StudentName);
        feeCollection.searchBtn();
        feeCollection.clickonSearchedStudent();
        feeCollection.feeCollectionModeSelection();
        feeCollection.payTypeSelection();
        feeCollection.amountTobePaid();
        feeCollection.submitButton();
            // FIX: Initialize pdfutility before use
        // pdfutility = new PDFUtility(driver);
         //pdfutility.downloadPDF(driver,"New Student Fee receipt");
        // pdfutility.readPDF("New Student Fee receipt",StudentName);
    }

    //===========================Post Admission =====================================
        @Test(priority = 4, enabled = true)
        public void PostAdmission() throws Exception {
            // String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
            System.out.println("Student name extracted from Excel: " + StudentName);
            AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
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
            feeCollection.filterNameForTable(StudentName);

            String RRNOnumber = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
            System.out.println("Student name extracted from Excel: " + RRNOnumber);
            feeCollection.enterUnqiueRRNO(RRNOnumber);

            feeCollection.submitSectionEnrollmentEnroll();
            BulkStudentUserCreation bulkStudentcreate = new BulkStudentUserCreation(driver);
            bulkStudentcreate.User_able_to_Bulk_Student_User_Creation(StudentName);
        }

        // ========================department wise Linked assigned  ==============
        @Test(priority = 5, enabled = true)
        public void deptWiseLinked() throws Exception {
            HP = new HomePageAdmin(driver);
            RF_AdminLoginPage.loginPage();
            HP.Academic();
            AL_Configuration_UM_DeptwiseLinkAssigned deptWise = new AL_Configuration_UM_DeptwiseLinkAssigned(driver);
            //  String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
            //   System.out.println("Student name extracted from Excel: "+ StudentName);
            deptWise.deptWiseLinked(StudentName);
        }


        // ========================= Student login ======================
        @Test(priority = 6, enabled = true)
        public void studentLogin() throws Exception {
            AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
            SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
            String RRNOnumber = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
            System.out.println("Student name extracted from Excel: " + RRNOnumber);
            HP = new HomePageAdmin(driver);
            RF_AdminLoginPage.loginPage();
            HP.Academic();
            feeCollection.adminLogout();
            acceptAlert();
            studentLogin.newCreatedStudentLogin(RRNOnumber, RRNOnumber);
            studentLogin.changeStudentPassword(RRNOnumber);
            studentLogin.StudentLoginWithChangepassword(RRNOnumber);
        }

        // =====================information edit in student login ===================
            @Test(priority = 7, enabled = true)
            public void Information_studentInfoEdit() throws Exception {
                AL_Academics_FR_FeeCollection feeCollection = new AL_Academics_FR_FeeCollection(driver);
                SL_Login_SetLogin studentLogin = new SL_Login_SetLogin(driver);
                HP = new HomePageAdmin(driver);
                RF_AdminLoginPage.loginPage();
                HP.Academic();
                feeCollection.adminLogout();
                acceptAlert();
                String RRNOnumber = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "RRNO");
                studentLogin.newCreatedStudentLogin(RRNOnumber, "Student@12345");
                System.out.println("ACADEMIC(SL) > Student Related > Student Information");
                studentInfoPage = new SL_Academic_SR_StudentInformation(driver);
                qualificationdetails = new SL_Academic_SR_SI_QualificationDetails(driver);

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
                // Address Details
                threadWait1();
                studentInfoPage.Click_AddressDetails();
                threadWait1();
                studentInfoPage.Enter_Country();
                threadWait1();
                studentInfoPage.Enter_State();
                threadWait1();
                studentInfoPage.Enter_District();
                threadWait1();
                studentInfoPage.Enter_City();
                threadWait1();
                studentInfoPage.Enter_PinCode();
                threadWait1();
                studentInfoPage.Click_SaveContinueBtn();
                // Document Upload
                threadWait1();
                studentInfoPage.Upload_10th_Marksheet();
                threadWait1();
                studentInfoPage.Upload_12th_Marksheet();
                threadWait1();
                //studentInfoPage.Upload_AdharCard();
                threadWait1();
                studentInfoPage.uploadDoucumentNext();
                threadWait1();
                qualificationdetails.Enter_Schoolname10th();
                threadWait1();
                qualificationdetails.Enter_Board10th();
                threadWait1();
                qualificationdetails.Enter_YearOfExam10th();

//		threadWait1();
//		qualificationdetails.Enter_OutOfMarks10th();
//
//		threadWait1();
//		qualificationdetails.Enter_MarkObtain10th();

                threadWait1();
                qualificationdetails.Enter_SchoolName12th();
                threadWait1();
                qualificationdetails.Enter_Board12th();
                threadWait1();
                qualificationdetails.Enter_YearOfExam12th();
                threadWait1();
                qualificationdetails.Enter_TotalMarks12th();
                threadWait1();
                qualificationdetails.Enter_MarkObtained12th();
                threadWait1();
                qualificationdetails.Enter_EntranceExamName();
                threadWait1();
                qualificationdetails.Enter_SeatNo();
                threadWait1();
                qualificationdetails.Enter_YearOfExam();
                threadWait1();
                qualificationdetails.Enter_Percentage();
                threadWait1();
                qualificationdetails.Enter_TotalMarks();
                threadWait1();
                qualificationdetails.Enter_EntranceObtainedMarks();
                threadWait1();
                qualificationdetails.Enter_Rank();
                threadWait1();
                qualificationdetails.Enter_CategoryRank();
//		threadWait1();
//		qualificationdetails.Click_EntranceAddBtn();
                threadWait1();
                qualificationdetails.Enter_SchoolCollegePG();
                threadWait1();
                qualificationdetails.Enter_BoardPG();
                threadWait1();
                qualificationdetails.Enter_QualifyingExamPG();
                threadWait1();
                qualificationdetails.Enter_SeatNoPG();
                threadWait1();
                qualificationdetails.Enter_YearofExamPG();
                threadWait1();
                qualificationdetails.Enter_StatusPG();
                threadWait1();
                qualificationdetails.Enter_OutOfMarksPG();

                threadWait1();
                qualificationdetails.Enter_MarksObtainedPG();

                threadWait1();
                qualificationdetails.Enter_GradePG();

                threadWait1();
                qualificationdetails.Enter_DGPACGPA_PG();

                threadWait1();
                qualificationdetails.Enter_SchoolCollegeAddressPG();

                threadWait1();
                qualificationdetails.Click_AddBtn_PG();

                threadWait1();
                qualificationdetails.Click_SaveContinueQualificationDetails();

                // Covid Information

                threadWait1();
                qualificationdetails.Click_Vaccinated_Yes();

                threadWait1();
                qualificationdetails.Click_SaveContinueCovidInformation();

                // Other Information

                threadWait1();
                qualificationdetails.Enter_BankName();

                threadWait1();
                qualificationdetails.Enter_BankAccountNo();

                threadWait1();
                qualificationdetails.Enter_BranchName();

                threadWait1();
                qualificationdetails.Enter_IFSCode();

                threadWait1();
                qualificationdetails.Enter_BankAddress();

                threadWait1();
                qualificationdetails.Click_SaveBtn();
                Thread.sleep(2000);
                Alert alert =  driver.switchTo().alert();
                String Expected_Msg = "Final Submit Done Successfully!!!";
                String Actual_Msg = alert.getText();
                Assert.assertEquals(Actual_Msg , Expected_Msg );
                System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
                alert.accept();

            }

    }
