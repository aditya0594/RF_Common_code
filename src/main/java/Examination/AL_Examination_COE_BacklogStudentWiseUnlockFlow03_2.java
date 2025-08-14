package Examination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 extends BaseClass
{
   
    @FindBy(linkText = "Student Wise Unlock") private WebElement studentWiseUnlock;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement collegeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement sessionDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semesterDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlsub") private WebElement subjectTypeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamType") private WebElement examTypeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubExam1") private WebElement subExamDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement courseDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlStuType") private WebElement studenttype;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlFac") private WebElement facultyDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showButton;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvStudList_ctrl0_chklckStud") private WebElement studentCheckbox;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement unlockButton;

    @FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlFac-container") private WebElement Selectfaculty;
	@FindBy(xpath="//input[@class='select2-search__field']") private WebElement searchFaculty;
	
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
   
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Click_StudentWiseUnlock() {
        System.out.println("Click On > Student Wise Unlock");
        Actions action = new Actions(driver);
        action.moveToElement(studentWiseUnlock).click().build().perform();
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_College() {
        System.out.println("Select College==> SMS - B.Tech.-Mechanical Engineering-2017-18-Department of Mechanical Engineering (Old Scheme)");
        Select select = new Select(collegeDropdown);
        select.selectByVisibleText("SMS - B.Tech.-Mechanical Engineering-2017-18-Department of Mechanical Engineering (Old Scheme)");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_Session() {
        System.out.println("Select Session==> May 2022");
        Select select = new Select(sessionDropdown);
        select.selectByVisibleText("May 2022");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_Semester() {
        System.out.println("Select Semester==> VII");
        Select select = new Select(semesterDropdown);
        select.selectByVisibleText("VII");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_SubjectType() {
        System.out.println("Select Subject Type==> Theory with Tutorial");
        Select select = new Select(subjectTypeDropdown);
        select.selectByVisibleText("Theory with Tutorial");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_ExamType() {
        System.out.println("Select Exam Type==> EXTERNAL");
        Select select = new Select(examTypeDropdown);
        select.selectByVisibleText("EXTERNAL");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_SubExam() {
        System.out.println("Select Sub Exam==> END SEM");
        Select select = new Select(subExamDropdown);
        select.selectByVisibleText("END SEM");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_Course() {
        System.out.println("Select Course==> MECX 32 - Automobile Engineering");
        Select select = new Select(courseDropdown);
        select.selectByVisibleText("MECX 32 - Automobile Engineering");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_StudentType() {
        System.out.println("Select Student Type==> Backlog");
        Select select = new Select(studenttype);
        select.selectByVisibleText("Backlog");
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_Faculty() throws InterruptedException {
       
    		System.out.println("Select Faculty => Mr. SAIBULLA  A");
    		
    		Selectfaculty.click();
    		Thread.sleep(2000);
    		searchFaculty.sendKeys("SAI");
    		searchFaculty.sendKeys(Keys.ENTER);
    		return this;
    	
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Click_Show() {
        System.out.println("Click Show button");
        click(showButton);
        return this;
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Select_Student() {
        System.out.println("Select Student");
    	js.executeScript("arguments[0].click();", studentCheckbox);
      
        return this;
    }
    
    public AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 Click_Unlock() throws InterruptedException {
        System.out.println("Click Unlock button");
        click(unlockButton);
        
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Student Unlocked Successfully!!!"; 
        String Actual_Msg = alert.getText();
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
}
