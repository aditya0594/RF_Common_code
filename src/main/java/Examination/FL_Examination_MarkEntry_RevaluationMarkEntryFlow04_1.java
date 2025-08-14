package Examination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 extends BaseClass
{
	
	@FindBy(linkText = "Mark Entry") private WebElement mark_entry;
	@FindBy(linkText = "Revaluation Mark Entry") private WebElement reval_mark_entry;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_lnkbtnCourse") private WebElement course;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvStudent_ctl02_txtESMarks") private WebElement endsemmarks;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnLastSave") private WebElement savebtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnFacultyLock") private WebElement lockbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRevalMarkRpt") private WebElement markentryreport;

	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Login_Faculty() throws InterruptedException {
		System.out.println("Enter login credentials");
		System.out.println("Enter UserName -> 2006031");
		driver.findElement(By.id("txt_username")).sendKeys("2006031");

		Thread.sleep(2000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");

		///// captchaHandle();
		Thread.sleep(2000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(2000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_MarkEntry() {
		System.out.println("Admin Examination menu selected > Mark Entry ");
		Actions action = new Actions(driver);
		action.moveToElement(mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_revaluationMarkEntry() {
		System.out.println(" Click On > Revaluation Mark Entry");
		Actions action = new Actions(driver);
		action.moveToElement(reval_mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Select_Session() {
		System.out.println("Select Session==> May 2022 - School of Mechanical Sciences");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022 - School of Mechanical Sciences");
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_Course() {
		System.out.println("Click Course");
		click(course);
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Enter_EndSemMarks() throws InterruptedException {
		System.out.println("Enter End Sem Marks");
		clearText(endsemmarks);
		Thread.sleep(2000);
		sendKeys(endsemmarks, "49");
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_Save_btn() throws InterruptedException {
		System.out.println("Click Save btn");
		click(savebtn);
		
		threadWait1();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Saved Successfully!!!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_Lock_btn() throws InterruptedException {
		System.out.println("Click Lock btn");
		click(lockbtn);
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Locked Successfully!!!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
		return this;
	}
	
	public FL_Examination_MarkEntry_RevaluationMarkEntryFlow04_1 Click_MarkEntryReport() {
		System.out.println("Click Mark Entry Report");
		click(markentryreport);
		return this;
	}
	
}
