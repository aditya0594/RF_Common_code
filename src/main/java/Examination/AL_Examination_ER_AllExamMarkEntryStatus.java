package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_AllExamMarkEntryStatus extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(id="ctl00_repLinks_ctl09_lbLink") private WebElement allMarkEtrystatus;
	
	public AL_Examination_ER_AllExamMarkEntryStatus(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_ER_AllExamMarkEntryStatus EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Click_AllExamMarkEntryStatus() throws InterruptedException {
		System.out.println(" Click On > All Exam Mark Entry Status");
		Actions action = new Actions(driver);
		action.moveToElement(allMarkEtrystatus).click().build().perform();
		
	//	WebElement link_IPentry = driver.findElement(By.id("ctl00_repLinks_ctl08_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",allMarkEtrystatus);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", allMarkEtrystatus);
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Select_Session() {
		System.out.println("Select Session ==> May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Select_ExamPattern() {
		System.out.println("Select Exam Pattern ==> ARCH NEW ");
		WebElement pattern=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPattern"));
		Select select = new Select(pattern);
		select.selectByVisibleText("ARCH NEW");
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Select_ExamName() {
		System.out.println("Select Exam Name ==> END SEM ");
		WebElement exam=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExam"));
		Select select = new Select(exam);
		select.selectByVisibleText("END SEM");
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Select_SubExamName() {
		System.out.println("Select Sub Exam Name ==> END SEM - Theory with Tutorial ");
		WebElement subexam=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubExam"));
		Select select = new Select(subexam);
		select.selectByVisibleText("END SEM - Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_ER_AllExamMarkEntryStatus Click_ShowMarkEntryStatus_btn() {
		System.out.println("Click Show Mark Entry Status_btn");
		WebElement show_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(show_btn);
		return this;
	}
	
}
