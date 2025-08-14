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

public class FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Mark Entry") private WebElement mark_entry;
	@FindBy(linkText = "End Sem Mark Entry") private WebElement end_sem_mark_entry;
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 FacultyLogin() throws InterruptedException {
		System.out.println("Enter UserName -> 2006031");
		driver.findElement(By.id("txt_username")).sendKeys("2006031");

		Thread.sleep(5000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");

		///// captchaHandle();
		Thread.sleep(5000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(5000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_MarkEntry() {
		System.out.println("Admin Examination menu selected > Mark Entry ");
		Actions action = new Actions(driver);
		action.moveToElement(mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_EndSemMarkEntry() {
		System.out.println(" Click On > End Sem Mark Entry");
		Actions action = new Actions(driver);
		action.moveToElement(end_sem_mark_entry).click().build().perform();
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Select_Session() {
		System.out.println("Select Session==> May 2022 - School of Computer Information and Mathematical Sciences");
		WebElement sesion=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(sesion);
		select.selectByVisibleText("May 2022 - School of Mechanical Sciences");
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_Course() {
		System.out.println("Click Course : END 1281 - English for Engineers  ");
		WebElement course=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl1_lnkbtnCourse"));
		click(course);
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Enter_EndSemMarks() throws InterruptedException {
		System.out.println("Click End Sem Marks");
		WebElement marks=driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvStudent_ctl02_txtESMarks"));
		clearText(marks);
		Thread.sleep(2000);
		sendKeys(marks, "50");
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_Save_btn() throws InterruptedException {
		System.out.println("Click Save btn");
		WebElement savebtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLastSave"));
		click(savebtn);
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Saved Successfully!!!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_Lock_btn() throws InterruptedException {
		System.out.println("Click Lock btn");
		WebElement lock_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLock"));
		click(lock_btn);
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Locked Successfully!!!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	
	public FL_Examination_MarkEntry_EndSemMarkEntryFlow02_1 Click_Format1() {
		System.out.println("Click Format1");
		WebElement course=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(course);
		return this;
	}
	
}
