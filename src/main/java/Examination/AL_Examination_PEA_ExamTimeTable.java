package Examination;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;
import utility.PDFUtility;
import utility.Screenshot;

public class AL_Examination_PEA_ExamTimeTable  extends BaseClass
{
	
	PDFUtility pdfutility;
	
	public AL_Examination_PEA_ExamTimeTable(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme") private WebElement schemepath;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubjecttype") private WebElement subjectType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamName") private WebElement examName_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showCourse_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_chkAccept") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_txtExamDate") private WebElement examDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_ddlSlot") private WebElement slot_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement sbmit_btn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement examtimetablerptbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnBranchWiserpt") private WebElement branchwisebtn;

	public AL_Examination_PEA_ExamTimeTable Select_CollegeName() {
		Select sel = new Select(college);
		sel.selectByVisibleText("Crescent School of Architecture");
		System.out.println("Select College => Crescent School of Architecture");
		return this;
	}
	
	public AL_Examination_PEA_ExamTimeTable select_SchemePath() {
		Select sel = new Select(schemepath);
		sel.selectByVisibleText("B. Arch-Architecture-2021-22-Crescent School of Architecture (New Scheme)");
		System.out.println("Select Scheme/Path : B. Arch-Architecture-2021-22-Crescent School of Architecture (New Scheme)");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_session() {
		Select sessn = new Select(session_dropdown);
		sessn.selectByVisibleText("May 2022");
		System.out.println("Select Session: May 2022");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_semester() {
		Select sem = new Select(semester_dropdown);
		sem.selectByVisibleText("I");
		System.out.println("Select Semester: I");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_subjectType() {
		Select sub_typ = new Select(subjectType_dropdown);
		sub_typ.selectByVisibleText("Theory with Tutorial");
		System.out.println("Select Subject Type: Theory with Tutorial");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_section() {
		Select sectn = new Select(section_dropdown);
		sectn.selectByVisibleText("A");
		System.out.println("Select Section: A");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_examName() {
		Select exm_typ = new Select(examName_dropdown);
		exm_typ.selectByVisibleText("END SEM");
		System.out.println("Select Exam Name: END SEM");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable click_showCourse_button() {
		click(showCourse_button);
		System.out.println("Click on Show Courses Button");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable check_checkbox() throws InterruptedException {
		System.out.println("Select Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",checkbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkbox);
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable enter_examDate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Enter From Date
		js.executeScript("arguments[0].scrollIntoView();",examDate);
		js.executeScript("arguments[0].value = arguments[1]",examDate, "01/03/2026");
		System.out.println("Enter Exam Date: 14/03/2024");	
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable select_slot() {
		Select slot = new Select(slot_dropdown);
		slot.selectByVisibleText("AN");
		System.out.println("Select Slot: AN");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTable click_submit_button() throws InterruptedException {
		click(sbmit_btn);
		
		Thread.sleep(6000); 
	    Alert alert =  driver.switchTo().alert();
	    String Expected_Msg = "Exam Date Saved Successfully!"; 
	    String Actual_Msg = alert.getText();
	    Assert.assertEquals(Actual_Msg , Expected_Msg );
	    System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	    alert.accept();
		System.out.println("Click on Submit button");
		return this;
	}
	
	public AL_Examination_PEA_ExamTimeTable Click_ExamTimeTableReportBtn() throws InterruptedException, AWTException, IOException {
		System.out.println("Click on Exam Time Table Report Btn");
		click(examtimetablerptbtn);
		
		Thread.sleep(6000);
		pdfutility =new PDFUtility(driver);
		String parent = driver.getWindowHandle();
	    Set<String> s =driver.getWindowHandles();
	    Iterator<String> I1= s.iterator();
	    while(I1.hasNext())
	    {
		    String child_window=I1.next();
		    if(!parent.equals(child_window))
		    {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getTitle());
			    Thread.sleep(2000);
				System.out.println("Inside child window");
			   
			    pdfutility.downloadPDF(driver, "Exmination - Exam Time Table Report");
				pdfutility.readPDF("Exmination - Exam Time Table Report", "Environment");
		    }
		   
	    }
	    driver.switchTo().window(parent);
	    System.out.println("Inside main browser");
		return this;
	}
	
	public AL_Examination_PEA_ExamTimeTable Click_BranchWiseTimeTableReportBtn() throws InterruptedException, AWTException, IOException {
		System.out.println("click branch wise Time table Report");
		click(branchwisebtn);
		
		Thread.sleep(6000);
		pdfutility =new PDFUtility(driver);
		String parent = driver.getWindowHandle();
	    Set<String> s =driver.getWindowHandles();
	    Iterator<String> I1= s.iterator();
	    while(I1.hasNext())
	    {
		    String child_window=I1.next();
		    if(!parent.equals(child_window))
		    {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getTitle());
			    Thread.sleep(2000);
				System.out.println("Inside child window");
			   
				pdfutility.downloadPDF(driver, "Exmination - Branchwise Time Table Report");
				pdfutility.readPDF("Exmination - Branchwise Time Table Report", "Environment");
		    }
		   
	    }
	    driver.switchTo().window(parent);
	    System.out.println("Inside main browser");
		return this;
	}
	
}
