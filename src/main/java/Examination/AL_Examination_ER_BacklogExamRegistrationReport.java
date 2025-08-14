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

public class AL_Examination_ER_BacklogExamRegistrationReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;

	
	public AL_Examination_ER_BacklogExamRegistrationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_ER_BacklogExamRegistrationReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport EXAMINATION_REPORT() {
		System.out.println("Click on Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Click_BacklogExamRegistrationReport() throws InterruptedException {
		System.out.println("Click on Backlog Exam Registration Report ");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement backlog_exam = driver.findElement(By.id("ctl00_repLinks_ctl06_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",backlog_exam);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", backlog_exam);
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Select_College_Scheme() {
		System.out.println("Select College and Scheme");
		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Select_Session() {
		System.out.println("Select Session => May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Select_Semister() {
		System.out.println("Select Semister => II");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Select_Course() {
		System.out.println("Select Course => GEC 1211-Basic Engineering Mechanics");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCourses"));
		Select select = new Select(semister);
		select.selectByVisibleText("GEC 1211-Basic Engineering Mechanics");
		return this;
	}
	
	public AL_Examination_ER_BacklogExamRegistrationReport Click_StudentBackLogList_btn() {
		System.out.println("Click StudentBackLogList btn");
		WebElement btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBacklogSubjects"));
		click(btn);
		return this;
	}
}
