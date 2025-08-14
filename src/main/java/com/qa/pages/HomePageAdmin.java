package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class HomePageAdmin extends BaseClass {
	
	public HomePageAdmin(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//****************************** PAYROLL**************************************************
	
	@FindBy(linkText = "Payroll") private WebElement PAYROLL;
	@FindBy(linkText = "Transactions") private WebElement Payroll_Transactions;
	@FindBy(linkText = "Basic Details") private  WebElement Payroll_Trans_BasicDetails;
	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]") private WebElement Payroll_Report;
	@FindBy(linkText = "Monthly Work") private WebElement Payroll_Trans_MonthlyWork;
	@FindBy(linkText = "Income Tax") private WebElement Payroll_Trans_IncomeTax;
	@FindBy(linkText = "Tally Transfer") private WebElement Payroll_TallyTransfer;

	public HomePageAdmin PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public HomePageAdmin PAYROLL_Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Payroll_Transactions).build().perform();
		return this;
	}
	
	public HomePageAdmin Payroll_Trans_BasicDetails() {
		System.out.println(" Transactions > Basic Details");
		Actions action = new Actions(driver);
		action.moveToElement(Payroll_Trans_BasicDetails).click().build().perform();
		return this;
	}
	
	public HomePageAdmin PAYROLL_Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Payroll_Report);
		return this;
	}
	
	public HomePageAdmin PAYROLL_TallyTransfer() {
		System.out.println("Admin PAYROLL > Click on Tally Transfer");
		click(Payroll_TallyTransfer);
		return this;
	}
	
	public HomePageAdmin PAYROLL_Trans_MonthlyWork() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(Payroll_Trans_MonthlyWork).click().build().perform();
		return this;
	}
	
	public HomePageAdmin PAYROLL_Trans_IncomeTax() {
		System.out.println(" Transactions >  IncomeTax");
		Actions action = new Actions(driver);
		action.moveToElement(Payroll_Trans_IncomeTax).click().build().perform();
		return this;
	}
	
//***************************** ESTABLISHMENT********************************************
	
	@FindBy(linkText = "Establishment") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Estb_Transaction;
	@FindBy(linkText = "Reports") private WebElement Estab_Reports;
	
	public HomePageAdmin ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public HomePageAdmin Estab_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Estb_Transaction).click().build().perform();
		return this;
	}
	
	public HomePageAdmin Estab_Reports() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Estab_Reports).click().build().perform();
		return this;
	}
	
//*********************************ACADEMIC**************************************************
	
	@FindBy(linkText = "Academic") private WebElement academic;
	@FindBy(linkText = "Fees Related Reports") private WebElement Acad_Fees_Related_Reports;
	@FindBy(linkText = "Fee Related") private WebElement Acad_Fee_Related;
	@FindBy(linkText = "Pre Admission") private WebElement Acad_Pre_Admission;
	@FindBy(linkText = "Post Admission") private WebElement Acad_Post_Admission;
	@FindBy(partialLinkText = "FeedBack") private WebElement Acad_FeedBack;
	@FindBy(partialLinkText = "Admission Process") private WebElement Academic_AdmissionProcess;
	@FindBy(xpath = "(//a[contains(text(),'Student Related')])[1]") private WebElement Academic_StudentRelated;
	@FindBy(partialLinkText = "Academic Reports") private WebElement Academic_AcademicReports;
	@FindBy(xpath = "(//a[contains(text(),'Faculty Related')])[1]") private WebElement Academic_FacultyRelated;
	@FindBy(linkText = "Coordinator Related") private WebElement Academic_CoordinatorRelated;
	@FindBy(linkText = "Attendance Management") private WebElement Academic_AttendanceManagemenr;
	@FindBy(linkText = "Admission Process") private WebElement Admission_process;
	
	Actions action;
	public HomePageAdmin Academic() {
		System.out.println("Main academic menu selected");
		action = new Actions(driver);
		action.moveToElement(academic).perform();
		return this;
	}

	public HomePageAdmin Academic_FeesRelated_Reports() {
		System.out.println("Fees Related Reports submenu selected");
		action.moveToElement(Acad_Fees_Related_Reports);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Academic_FeesRelated() {
		System.out.println("Fee Related submenu selected");
		action.moveToElement(Acad_Fee_Related);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Academic_PreAdmission() {
		System.out.println("Pre Admission submenu selected");
		action.moveToElement(Acad_Pre_Admission);
		action.click().build().perform();
		return this;
	}

        public HomePageAdmin Academic_PostAdmission() {
		System.out.println("Click on Post Admission option");
		action.moveToElement(Acad_Post_Admission);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Academic_Feedback() {
		//System.out.println("Pre Admission submenu selected");
		action.moveToElement(Acad_FeedBack);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Academic_AdmissionProcess() {
		action.moveToElement(Academic_AdmissionProcess);
		action.click().build().perform();
		System.out.println("Click on Admission Process");
		return this;
	}

	public HomePageAdmin Academic_StudentRelated() {
		action.moveToElement(Academic_StudentRelated);
		action.click().build().perform();
		System.out.println("Student Related submenu selected");
		return this;
	}

	public HomePageAdmin Academic_AcademicReport() {
		Academic_AcademicReports.click();
		System.out.println("Click on Academic Reports from Drop Down");
		return this;
	}

	public HomePageAdmin Academic_FacultyRelated() {
		action.moveToElement(Academic_FacultyRelated);
		action.click().build().perform();
		System.out.println("Academic Faculty Related submenu selected");
		return this;
	}
	
	public HomePageAdmin Academic_CoordinatorRelated() {
		Academic_CoordinatorRelated.click();
		System.out.println("Click on Coordinator related option");
		return this;
	}

	public HomePageAdmin Academic_MiscellaneousFee() {
		WebElement subMenu = driver.findElement(By.linkText("Miscellaneous Fee"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",subMenu);
		System.out.println("Click on Miscellaneous Fee option");
		return this;
	}

        public HomePageAdmin Academic_AttendanceManagement() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Academic_AttendanceManagemenr);
		Thread.sleep(2000);	
		js.executeScript("arguments[0].click();",Academic_AttendanceManagemenr );
		System.out.println("Attendance Management submenu selected");
		return this;
	}
	public HomePageAdmin Academic_admissionProcess() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Admission_process);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",Admission_process );
		System.out.println("Attendance Management submenu selected");
		return this;
	}
	
//****************************** Administration **************************************************

	@FindBy(linkText = "Administration") private WebElement Administration;
	@FindBy(xpath = "(//a[contains(text(),'Service Request Management')])[1]") private WebElement Admin_ServiceRequestMang;
	@FindBy(linkText = "Transaction") private WebElement Admin_SRM_Transaction;
	@FindBy(linkText = "Transactions") private WebElement Admin_VM_Transaction;
	@FindBy(linkText = "Reports") private WebElement Admin_SRM_Reports;
	@FindBy(xpath = "(//a[contains(text(),'Grievance Redressal')])[1]") private WebElement GrievanceRedressal; 
	@FindBy(xpath = "(//a[contains(text(),'Reports')])[15]") private WebElement Admin_GR_Reports;
	@FindBy(xpath = "(//a[@class='level3 dynamic'][normalize-space()='Master'])[9]") private WebElement Admin_GR_Master;
	@FindBy(xpath = "(//a[contains(text(),'Transaction')])[16]") private WebElement Admin_GR_Transaction;
	@FindBy(xpath = "(//a[contains(text(),'File Movement')])[1]")
	private WebElement FileMovement;
	@FindBy(xpath = "//a[contains(@href,'/Links.aspx?PgNo=1710&UaNo=1&MastNo=1709')]")
	private WebElement Admin_FM_Master;
	@FindBy(xpath = "(//a[contains(text(),'Report')])[13]")
	private WebElement Admin_FM_Reports;

	public HomePageAdmin FileMovement() {
		Actions action = new Actions(driver);
		action.moveToElement(FileMovement).perform();
		System.out.println("Adminministration> File Movement ");
		return this;
	}

	public HomePageAdmin Admin_FM_Master() {
		Actions action = new Actions(driver);
		action.moveToElement(Admin_FM_Master);
		action.click().build().perform();
		System.out.println("Adminministration> File Movement > Master ");
		return this;
	}

	public HomePageAdmin Admin_FM_Reports() {
		Actions action = new Actions(driver);
		action.moveToElement(Admin_FM_Reports);
		action.click().build().perform();
		System.out.println("Adminministration> File Movement > Reports ");
		return this;
	}

        public HomePageAdmin ADMINISTRATION() {
		System.out.println("Admin ADMINISTRATIONL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Administration).build().perform();
		return this;
	}

	public HomePageAdmin Admin_ServiceRequestManagement() {
		System.out.println("Admin Administration menu selected > Service Request Management");
		Actions action = new Actions(driver);
		action.moveToElement(Admin_ServiceRequestMang).build().perform();
		return this;
	}

	public HomePageAdmin Admin_VehicleManagement() {
		WebElement Link_V_Managnement = driver.findElement(By.linkText("Vehicle Management"));
		System.out.println("Vehicle Management submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Link_V_Managnement);
		action.build().perform();
		return this;
	}

	public HomePageAdmin Admin_VM_Transaction() {
		System.out.println("click on Transactions  Menu");
		Actions action = new Actions(driver);
		action.moveToElement(Admin_VM_Transaction);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Admin_SRM_Transaction() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Admin_SRM_Transaction).click().build().perform();
		return this;
	}
	
	public HomePageAdmin Admin_SRM_Reports() {
		System.out.println("Adminministration> Service Request Management > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Admin_SRM_Reports).click().build().perform();
		return this;
	}

	public HomePageAdmin GrievanceRedressal() {
		Actions action = new Actions(driver);
		action.moveToElement(GrievanceRedressal).perform();
		System.out.println("Adminministration> Grievance Redressal ");
		return this;
	}

		public HomePageAdmin Admin_GR_Reports() {
		Actions action = new Actions(driver);
		action.moveToElement(Admin_GR_Reports);
		action.click().build().perform();
		System.out.println("Adminministration> Grievance Redressal > Reports Selected ");
		return this;
	}


		public HomePageAdmin Admin_GR_Master() {
		Actions action = new Actions(driver);
		action.moveToElement(Admin_GR_Master);
		action.click().build().perform();
		System.out.println("Adminministration> Grievance Redressal > Grievance Summery ");
		return this;
	}

		public HomePageAdmin Admin_GR_Transaction() {
		Actions action = new Actions(driver);
		action.moveToElement(Admin_GR_Transaction);
		action.click().build().perform();
		System.out.println("Adminministration> Grievance Redressal > Transaction ");
		return this;
	}
//****************************** Dashboard **************************************************
	@FindBy(linkText = "Dashboard") private WebElement Dashboard;
	@FindBy(linkText = "Analytics and Dashboards") private WebElement Dashboard_AnalyticsAndDashBoard;

        public HomePageAdmin DASHBOARD() {
		System.out.println("Dashboard menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Dashboard).perform();
		return this;
	}

	public HomePageAdmin Dashboard_AnalyticsAndDashBoard() {
		Dashboard_AnalyticsAndDashBoard.click();
		System.out.println("Analyatic and Dashboard submenu selected");
		return this;
	}

//****************************** Examination**************************************************
@FindBy(partialLinkText = "Examination") private WebElement EXAMINATION;
	@FindBy(partialLinkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(partialLinkText = "Pre Examination Activities") private WebElement Examination_Pre_Exam_Activities;
	@FindBy(linkText = "Answer Sheet") private WebElement Examination_AnswerSheet;
	@FindBy(linkText = "Results") private WebElement Examination_Results;
	@FindBy(linkText = "Seating Arrangement") private WebElement Examination_SeatingArrangement;
	@FindBy(linkText = "Conduction of Examination") private WebElement Examination_ConductionofExam;
	@FindBy(linkText = "Paper Set") private WebElement Examination_PaperSet;
	@FindBy(linkText = "Exam Utility") private WebElement exam_utility;
	@FindBy(linkText = "Convocation") private WebElement convocation;
	@FindBy(linkText = "Examination Masters") private WebElement examMaster;
	@FindBy(linkText = "Mark Entry") private WebElement exammarkentry;
	@FindBy(linkText = "Student Related") private WebElement examstudentrelated;
	@FindBy(linkText = "Revaluation") private WebElement examrevaluation;


        public HomePageAdmin EXAMINATION() {
		System.out.println("Dashboard menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(EXAMINATION).perform();
		return this;
	}

	public HomePageAdmin Exam_ExaminationReports() {
		Examination_Reports.click();
		System.out.println("Click on Examination Reports option");
		return this;
	}

	public HomePageAdmin Exam_PreExamActivities() {
		Examination_Pre_Exam_Activities.click();
		System.out.println("Click on Pre Examination Activities option");
		return this;
	}

	public HomePageAdmin Exam_AnswerSheet() {
		System.out.println("Examination Answer Sheet submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_AnswerSheet);
		action.click().build().perform(); 
		return this;
	}

	public HomePageAdmin Exam_Results() {
		System.out.println("Results submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Results);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Exam_SeatingArrangement() {
		System.out.println("Examination Seating Arrangement submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_SeatingArrangement);
		action.click().build().perform();
		return this;
	}

	public HomePageAdmin Exam_ConductionOfExamination() {
		System.out.println("Conduction of Examination submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_ConductionofExam);
		action.click().build().perform();
		return this;
	}
	
	public HomePageAdmin Exam_PaperSet() {
		System.out.println("Examination Paper Set submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_PaperSet);
		action.click().build().perform();
		return this;
	}
	
	public HomePageAdmin Exam_ExamUtility() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(exam_utility).click().build().perform();
		return this;
	}
	
	public HomePageAdmin Exam_Convocation() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(convocation).click().build().perform();
		return this;
	}

	public HomePageAdmin Exam_ExaminationMaster() {
		System.out.println("Click on Examination Master ");
		Actions action = new Actions(driver);
		action.moveToElement(examMaster).click().build().perform();
		return this;
	}

	public HomePageAdmin Exam_MarkEntry() {
		System.out.println("Click on Mark Entry ");
		Actions action = new Actions(driver);
		action.moveToElement(exammarkentry).click().build().perform();
		return this;
	}
	
	public HomePageAdmin Exam_StudentRelated() {
		System.out.println("Click on Exam Student Related ");
		Actions action = new Actions(driver);
		action.moveToElement(examstudentrelated).click().build().perform();
		return this;	
	}

	public HomePageAdmin Exam_Revaluation() {
		System.out.println("Revaluation submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(examrevaluation);
		action.click().build().perform(); 
		return this;
	}

//****************************** CDC **************************************************
	@FindBy(linkText = "Cdc") private WebElement CDC;
	@FindBy(linkText = "Reports") private WebElement cdcReports;

        public HomePageAdmin CDC() {
		System.out.println("Main CDC menu selected");
		action = new Actions(driver);
		action.moveToElement(CDC).perform();
		return this;
	}

	public HomePageAdmin CDC_Reports() {
		System.out.println("Report submenu selected");
		action.moveToElement(cdcReports);
		action.click().build().perform();
		return this;
	}

//****************************** Store **************************************************
	@FindBy(linkText = "Stores") private WebElement stores;
	@FindBy(linkText = "Transaction") private WebElement store_Transaction;
	@FindBy(linkText = "Reports") private WebElement reports;


        public HomePageAdmin STORE() {
		Actions action = new Actions(driver); 
		action.moveToElement(stores).perform();
		System.out.println("Click on Stores from Navigation Bar");
		return this;
	}

	public HomePageAdmin Store_Transaction() {
		Actions action = new Actions(driver); 
		action.moveToElement(store_Transaction);
		action.click().build().perform();
		System.out.println("Click on Transaction option"); 
		return this;
	}
	public HomePageAdmin Select_StoreReports() {
		System.out.println("Reports submenu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(reports);
		action.click().build().perform();
		return this;
	}
//****************************** Finance **************************************************
	@FindBy(linkText = "Finance") private WebElement FINANCE;
	@FindBy(linkText = "Create Company") private WebElement createCompany;

        public HomePageAdmin FINANCE() {
		System.out.println("Finance menu selected"); 
		Actions action = new Actions(driver);
		action.moveToElement(FINANCE).perform();
		return this;
	}
	public HomePageAdmin Finance_CreateCompany() {
		Actions action = new Actions(driver);
		System.out.println("Create Company submenu selected");
		action.moveToElement(createCompany);
		action.click().build().perform();
		return this;
	}

//****************************** Configuration **************************************************
	@FindBy(linkText = "Configuration") private WebElement CONFIGURATION;
	@FindBy(linkText = "Create Notice/News") private WebElement config_CreateNoticeOrNews;
@FindBy(linkText = " User Management") private WebElement config_UserManagements;

        public HomePageAdmin CONFIGURATION() {    // configuration
		  System.out.println("Configuration menu selected"); 
		  Actions action = new Actions(driver);
		  action.moveToElement(CONFIGURATION).perform();
		return this;
	}
	public HomePageAdmin Config_CreateNoticeOrNews() {
		  System.out.println("Configuration-create notice/news submenu selected");
		  Actions action = new Actions(driver);
		  action.moveToElement(config_CreateNoticeOrNews);
		  action.click().build().perform();
		return this;
	}
	public HomePageAdmin UserManagements() {
		  System.out.println("User Management menu selected");
		  Actions action = new Actions(driver);
		  action.moveToElement(config_UserManagements); 
		  action.click().build().perform();
		return this;
	}

//****************************** Hostel **************************************************
		@FindBy(linkText = "Hostel") private WebElement Hostel;
		@FindBy(linkText = "Transaction") private WebElement Hostel_Transaction;
		@FindBy(linkText = "Hostel Gate Pass") private WebElement Hostel_HostelGatePass;

		public HomePageAdmin HOSTEL() {
			System.out.println("Hostel menu selected");
			Actions action = new Actions(driver); 
			action.moveToElement(Hostel).build().perform();
			return this;
		}
		
		public HomePageAdmin Hostel_Transaction() {
			System.out.println("Move to Transaction");
			Actions action = new Actions(driver); 
			action.moveToElement(Hostel_Transaction).click().build().perform();
			return this;
		}
		
		public HomePageAdmin Hostel_HostelGatePass() {
			System.out.println("Click on Hostel Gate Pass");
			Actions action = new Actions(driver); 
			action.moveToElement(Hostel_HostelGatePass).click().build().perform();
			return this;
		}
		
//*********************************ELearning******************************************************
		@FindBy(linkText = "E- Learning") private WebElement elearning;
		@FindBy(linkText = "Transactions") private WebElement elearningtransaction;
@FindBy(linkText = "View") private WebElement Elearn_view;

		public HomePageAdmin ELearning() {
			System.out.println("E-Learning menu selected");
			Actions action = new Actions(driver); 
			action.moveToElement(elearning).build().perform();
			return this;
		}
		
		public HomePageAdmin ELearning_Transaction() {
			System.out.println("Click on Transaction");
			Actions action = new Actions(driver); 
			action.moveToElement(elearningtransaction).click().build().perform();
			return this;
		}
	public HomePageAdmin Elearning_View() {
			action = new Actions(driver);
			System.out.println("Click on View"); 
			action.moveToElement(Elearn_view);
			action.click().build().perform();
			return this;
		}
}