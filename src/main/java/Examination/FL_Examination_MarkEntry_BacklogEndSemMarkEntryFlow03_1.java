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

public class FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Mark Entry") private WebElement mark_entry;
	@FindBy(linkText = "BackLog End Sem Mark Entry") private WebElement backlog_end_sem_mark_entry;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl2_lnkbtnCourse") private WebElement course;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvStudent_ctl02_txtESMarks") private WebElement marks;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnLock") private WebElement lockbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;

	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Enter_FacultyLoginCreds() throws InterruptedException {
		System.out.println("Enter UserName -> 2006031 ");
		driver.findElement(By.id("txt_username")).sendKeys("2006031");

		threadWait1();
		System.out.println("Enter Password Live -> admin@123 || UAT -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");

		///// captchaHandle();
		threadWait1();
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		threadWait1();
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Click_MarkEntry() {
		System.out.println("Admin Examination menu selected > Mark Entry ");
		Actions action = new Actions(driver);
		action.moveToElement(mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Click_BacklogEndSemMarkEntry() {
		System.out.println(" Click On > BackLog End Sem Mark Entry");
		Actions action = new Actions(driver);
		action.moveToElement(backlog_end_sem_mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Select_Session() {
		System.out.println("Select Session==> May 2022 - School of Mechanical Sciences");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022 - School of Mechanical Sciences");
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Click_Course() {
		System.out.println("Click Course");
		click(course);
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Enter_BacklogEndSemMarks() throws InterruptedException {
		System.out.println("Enter Backlog End Sem Marks -> 29");
		clearText(marks);
		Thread.sleep(2000);
		sendKeys(marks, "29");
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Click_Lock_btn() throws InterruptedException {
		System.out.println("Click Lock btn");
		click(lockbtn);
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Marks Locked Successfully!!!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	
	public FL_Examination_MarkEntry_BacklogEndSemMarkEntryFlow03_1 Click_Reportbtn() {
		System.out.println("Click Report btn");
		click(reportbtn);
		return this;
	}
}
