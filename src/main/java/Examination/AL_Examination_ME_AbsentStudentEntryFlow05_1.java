package Examination;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ME_AbsentStudentEntryFlow05_1 extends BaseClass {
    
    @FindBy(linkText = "Absent Student Entry") private WebElement absentStudententry;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlcollege") private WebElement collegeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlsessionforabsent") private WebElement sessionDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamDate") private WebElement examDateDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlcourseforabset") private WebElement courseDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlexamnameabsentstudent") private WebElement examNameDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubexamnameabsentstudent") private WebElement subexam;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlexam_type") private WebElement examtype;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showButton;
    @FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchstudent;

    @FindBy(id = "ctl00_ContentPlaceHolder1_rpt_Success_ctl01_chk_Absent") private WebElement checkbox;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lblMessage") private WebElement successMessage;
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Click_AbsentStudentEntry() {
        System.out.println("Click on Absent Student Entry");
        absentStudententry.click();
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_College() {
        System.out.println("Select College => Crescent School of Law");
        Select select = new Select(collegeDropdown);
        select.selectByVisibleText("Crescent School of Law");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_Session() {
        System.out.println("Select Session => May 2022");
        Select select = new Select(sessionDropdown);
        select.selectByVisibleText("May 2022");
        return this;
    }
    

    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_Course() {
        System.out.println("Select Course => BLC 2103-Constitution Law - I-B.Com (LLB)");
        Select select = new Select(courseDropdown);
        select.selectByVisibleText("BLC 2103-Constitution Law - I-B.Com (LLB)");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_ExamName() {
        System.out.println("Select Exam Name => TEST 1");
        Select select = new Select(examNameDropdown);
        select.selectByVisibleText("TEST 1");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_ExamSubExam() {
        System.out.println("Select Sub Exam Name => TEST 1");
        Select select = new Select(subexam);
        select.selectByVisibleText("TEST 1");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Select_ExamType() {
        System.out.println("Select Exam Type => INTERNAL");
        Select select = new Select(examtype);
        select.selectByVisibleText("Regular");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Click_ShowButton() {
        System.out.println("Click on Show Button");
        showButton.click();
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Search_Student() {
        System.out.println("Click on search bar and Search Student => 171401601007");
        searchstudent.sendKeys("171401601007");
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Click_Checkbox() {
        System.out.println("Click on Checkbox");
        js.executeScript("arguments[0].click();", checkbox);
        return this;
    }
    
    public AL_Examination_ME_AbsentStudentEntryFlow05_1 Click_SubmitButton() {
        System.out.println("Click on Submit Button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
        return this;
    }
    
}
