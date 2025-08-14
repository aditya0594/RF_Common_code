package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_PEA_ExamAdmitCardGeneration extends BaseClass{

	public AL_Examination_PEA_ExamAdmitCardGeneration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Exam Admit Card Generation") private WebElement ExamAdmitCardGen_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlColg") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement Semester_Dropdown;
	@FindBy(xpath = "//i[@class='fa fa-calendar']") private WebElement calender;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ceExamDate_today") private WebElement ConvocationDate_Selector;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamname") private WebElement ExamName_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement ShowStudent_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport") private WebElement Select_Student;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPrintReport") private WebElement PrintReport_Button;
	
	
	public AL_Examination_PEA_ExamAdmitCardGeneration Click_ExamAdmitCardGen_Link() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ExamAdmitCardGen_Link);
		System.out.println("Click on Exam Admit Card Generation from sub menu");
		return this;
	}
	
	public AL_Examination_PEA_ExamAdmitCardGeneration Select_College() {
		Select clg = new Select(College_Dropdown);
		clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("Select College => SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Select_Session() {
		Select sesn = new Select(Session_Dropdown);
		sesn.selectByVisibleText("May 2022");
		System.out.println("Select Session => May 2022"); 
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Select_Semester() {
		Select sem = new Select(Semester_Dropdown);
		sem.selectByVisibleText("VIII");
		System.out.println("Select Semester => VIII"); 
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Enter_ConvocationDate() throws InterruptedException {
		calender.click();
		Thread.sleep(1000);
		ConvocationDate_Selector.click(); 
		System.out.println("Enter Convocation date => Today Date");
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Select_ExamName() {
		Select exmname = new Select(ExamName_Dropdown);
		exmname.selectByVisibleText("CAT-1");
		System.out.println("Select Exam name => CAT-1"); 
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Click_ShowStudent_Button() {
		ShowStudent_Button.click();
		System.out.println("Click on Show Students Button");
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Select_StudentFromList() {
		System.out.println("Select Student => ABDUL KALAM");
		WebElement searchbar = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		searchbar.sendKeys("ABDUL KALAM. ");
		js.executeScript("arguments[0].click();", Select_Student);
		
		return this;
	}
	

	public AL_Examination_PEA_ExamAdmitCardGeneration Click_AdmitCard_Button() {
		PrintReport_Button.click();
		System.out.println("Click on Admit Card Button");
		return this;
	}
	
}
