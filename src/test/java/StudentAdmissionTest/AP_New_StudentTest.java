package StudentAdmissionTest;

import Administration.AL_Administration_FM_Rpt_MR_CompleteFilesReport;
import RFCCAcademic.AL_Academic_AP_NewStudent;
import RFCCAcademic.SL_Academic_SR_StudentInformation;
import RFCC_Extra.BulkStudentUserCreation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

import java.io.IOException;
import java.lang.reflect.Method;

public class AP_New_StudentTest extends BaseClass {

    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;
    BulkStudentUserCreation bulkStudentcreate = new BulkStudentUserCreation(driver);
    AL_Academic_AP_NewStudent newStudentPage;
    SL_Academic_SR_StudentInformation studentInfoPage;

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
        SL_NewCreated_StudentLogin studentLogin = new SL_NewCreated_StudentLogin(driver);
        System.out.println("ACADEMIC > Admission Process > New Student");

//        HP.Academic();
//        newStudentPage.admissionProcess();
//        newStudentPage.newStudent();
//        Thread.sleep(2000);
//        newStudentPage.clickNewStudentButton();
//        Thread.sleep(2000);
//        String fistname = generateLastName();
//        String lastname = generateLastName();
//        String studentName = fistname+" "+lastname;
//        String RRNOnumber = "AD"+Random4DigitString();
//
//
//        newStudentPage.enterStudentName(studentName);
//        String fatherName = generateFirstName();
//        newStudentPage.enterFatherName(fatherName);
//        String mobileNumber = generateMobileNumber();
//        newStudentPage.enterMobileNumber(mobileNumber);
//        String alternateMobileNumber = generateMobileNumber();
//        newStudentPage.enterAlternateMobileNumber(alternateMobileNumber);
//        String email =fistname+lastname+"@yopmail.com";
//        newStudentPage.enterEmailId(email);
//
//        try {
//            ExcelUtility.writeStudentDataToExcel(
//                    studentName,
//                    fatherName,
//                    mobileNumber,
//                    alternateMobileNumber,
//                    email,
//                    RRNOnumber
//            );
//            System.out.println("student data written to excel");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        newStudentPage.selectNationality();
//        newStudentPage.selectState();
//        newStudentPage.selectDistrict();
//        newStudentPage.selectCity();
//        newStudentPage.clickGender();
//        newStudentPage.SchoolInstitution();
//        newStudentPage.degreeSelect();
//        newStudentPage.branchselect();
//        newStudentPage.admissionThroughSelect();
//        newStudentPage.admissionType();
//        newStudentPage.admissionYear();
//        newStudentPage.semesterselect();
//        newStudentPage.admissionBranchSelect();
//        newStudentPage.DobSelect();
//        newStudentPage.admissionCategorySelect();
//        Thread.sleep(3000);
//        newStudentPage.DateOFEntrySelect();
//        Thread.sleep(3000);
//        newStudentPage.paymentTypeSelect();
//        //newStudentPage.receptTypeSelect();
//       newStudentPage.sessionSelection("2023-2024");
//        newStudentPage.SubmitStudent();
//        Thread.sleep(3000);
//        //==========demand=================
//
//
//
//            HP.Academic();
//            newStudentPage.preAdmission();
//            newStudentPage.demandCreationMenu();
            String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");

            System.out.println("Student name extracted from Excel: " + StudentName);
//            newStudentPage.singleStudentDemand();
//            newStudentPage.searchCreatria();
//            newStudentPage.searchStringName(StudentName);
//            newStudentPage.searchBtn();
//            newStudentPage.clickonSearchStudent();
//            newStudentPage.sessiontitle();
//            newStudentPage.sessionSelectiondemand("2023-2024 (  )");
//            newStudentPage.semesterselectDemand();
//            newStudentPage.receptTypeSelectdemand();
//            newStudentPage.verifyDemandStatus();
//            newStudentPage.CreateDemandbutton();
//
//
//        //===========================Fee Receipt==========
//        //  String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
//        // System.out.println("Student name extracted from Excel: "+ StudentName);
//
//        HP.Academic();
//        feeCollection.feeCollections();
//        feeCollection.searchCriteriaSelect();
//        feeCollection.SearchStringStudentName(StudentName);
//        feeCollection.searchBtn();
//        feeCollection.clickonSearchedStudent();
//        feeCollection.feeCollectionModeSelection();
//        feeCollection.payTypeSelection();
//        feeCollection.amountTobePaid();
//        feeCollection.submitButton();


         //pdfutility.downloadPDF(driver,"New Student Fee receipt");
         //pdfutility.readPDF("New Student Fee receipt",StudentName);

        //===========================Post Admission ==========

       // String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
         System.out.println("Student name extracted from Excel: "+ StudentName);

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
       // System.out.println("Student name extracted from Excel: "+ RRNOnumber);
        feeCollection.enterUnqiueRRNO(RRNOnumber);
        feeCollection.submitSectionEnrollmentEnroll();
          bulkStudentcreate.User_able_to_Bulk_Student_User_Creation(StudentName);

        // ========================department wise Linked assigned  ==========
        AL_Dept_wise_Link_Assigned deptWise = new AL_Dept_wise_Link_Assigned(driver);
      //  String StudentName = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/NewStudents.xlsx", "StudentName");
     //   System.out.println("Student name extracted from Excel: "+ StudentName);
        deptWise.deptWiseLinked(StudentName);


        // ========================= Student login ======================
        System.out.println("Student name extracted from Excel: "+ RRNOnumber);
        feeCollection.adminLogout();
        acceptAlert();
        studentLogin.newCreatedStudentLogin(RRNOnumber,RRNOnumber);
        studentLogin.changeStudentPassword(RRNOnumber);
        studentLogin.StudentLoginWithChangepassword(RRNOnumber);


        /// =====================information edit in student login ===================
        feeCollection.adminLogout();
        acceptAlert();
        studentLogin.newCreatedStudentLogin("AD5320", "Student@12345");
        System.out.println("ACADEMIC(SL) > Student Related > Student Information");
        studentInfoPage = new SL_Academic_SR_StudentInformation(driver);
        threadWait1();
        HP.Academic();
        threadWait1();
        studentInfoPage.clickStudentRelated();

        threadWait1();
        studentInfoPage.clickStudentInformation();

        // Personal Details

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
        studentInfoPage.Upload_AdharCard();

        threadWait1();
        studentInfoPage.Upload_Addressparticulars();

        threadWait1();
        studentInfoPage.Upload_CandidateMedicalRecord();

        threadWait1();
        studentInfoPage.Upload_CommunityCertificate();

        threadWait1();
        studentInfoPage.Upload_ConductCertificate();

        threadWait1();
        studentInfoPage.Upload_JointDeclaration();

        threadWait1();
        studentInfoPage.Upload_JointUndertakingHindi();

        threadWait1();
        studentInfoPage.Upload_JointUndertakingTamil();

        threadWait1();
        studentInfoPage.Upload_Otherdocuments();

        threadWait1();
        studentInfoPage.Upload_Photograph();

        threadWait1();
        studentInfoPage.Upload_Profileofthestudent();

        threadWait1();
        studentInfoPage.Upload_TransferCertificate();

        threadWait1();
        studentInfoPage.Click_NextContinueBtn();


    }
}
