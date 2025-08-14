package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_MarkEntryLockEntryNotDoneReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Marks Entry/Lock Entry Not Done Report") private WebElement mark_entry_lock_entry;
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Mark_Entry_Lock_Entry() {
		System.out.println(" Click On > Mark_Entry_Lock_Entry_Not_Done_Report");
		Actions action = new Actions(driver);
		action.moveToElement(mark_entry_lock_entry).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Session() {
		System.out.println("Select Session");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSessionID']"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport College() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Semister() {
		System.out.println("Select Semister");
		WebElement semister=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSemester']"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Course_type() {
		System.out.println("Select Course_type");
		WebElement course = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSubType']"));
		Select select = new Select(course);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Exam_pattern() {
		System.out.println("Select Exam_pattern");
		WebElement exam_pattrn=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPattern']"));
		Select select = new Select(exam_pattrn);
		select.selectByVisibleText("DCOE");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Exam_name() {
		System.out.println("Select Exam_name");
		WebElement exam_name=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlTest']"));
		Select select = new Select(exam_name);
		select.selectByVisibleText("EXTERNAL");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Sub_Exam() {
		System.out.println("Select Sub_Exam");
		WebElement sub_exam=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSubExam']"));
		Select select = new Select(sub_exam);
		select.selectByVisibleText("END SEM");
		return this;
	}
	
	public AL_Examination_ER_MarkEntryLockEntryNotDoneReport Mark_entry_not_don_repo_btn() {
		System.out.println("Click Mark Entry Not Done Report btn");
		WebElement mark_entry_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport2"));
		click(mark_entry_btn);
		return this;
	}

}
