package Establishment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Establishment_Trans_AttendanceLockUnlockFlow05_3 extends BaseClass
{
	public AL_Establishment_Trans_AttendanceLockUnlockFlow05_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	
	@FindBy(xpath ="//a[text()='Attendance Lock Unlock']") private WebElement attendLockUnlock;
	@FindBy(xpath ="(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbox;
	@FindBy(xpath ="//div[@class='table-responsive']//tbody//input") private WebElement LockBoxvalue;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnSave") private WebElement unlockattendancebtn;



	public AL_Establishment_Trans_AttendanceLockUnlockFlow05_3 Click_AttendanceLockUnlock() throws Exception {
		System.out.println("Click on Attendance Lock Unlock");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",attendLockUnlock);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", attendLockUnlock);
		
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceLockUnlockFlow05_3 Enter_ValueSearchbox() throws Exception {
		System.out.println("Enter Value in Search box ==> MAR2025");
		sendKeys(searchbox, "MAR2025");
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceLockUnlockFlow05_3 Enter_ValueLockBox() throws Exception {
		System.out.println("Enter value in Lock tab ==> N");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.contextClick(LockBoxvalue);
		Thread.sleep(1000);
		LockBoxvalue.sendKeys("N");
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceLockUnlockFlow05_3 Click_UnlockAttendanceBtn() throws Exception {
		System.out.println("Click on Unlock Attendance btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",unlockattendancebtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", unlockattendancebtn);
		return this;
	}
	
}
