package RFCCExtra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.BaseClass;

public class AL_Establishment_Trans_LeaveApproval extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	
	public AL_Establishment_Trans_LeaveApproval(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"ctl00_mainMenu\"]/ul/li[8]/a")
	private WebElement Establishment;
	
//	@FindBy(linkText ="ESTABLISHMENT")
//	private WebElement Establishment;

	@FindBy(linkText = "Transactions")
	private WebElement Transaction;

	@FindBy(linkText = "Leave Approval")
	private WebElement LeaveApproval;

//	@FindBy(name="ctl00$ContentPlaceHolder1$lvPendingList$ctrl0$btnApproval")
//	private WebElement SelectLeave;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSelect")
	private WebElement RejectLeave;

//	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnSave'])[1]")
//	private WebElement SubmitButton;

	Actions action = new Actions(driver);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Establishment_Trans_LeaveApproval Establishment() {
		/*
		 * System.out.println("Click on ESTBALISHMENT Menu"); Actions action = new
		 * Actions(driver); action.moveToElement(Establishment).build().perform(); //
		 * Establishment.click();
		 */
		
		WebElement ele = driver.findElement(By.linkText("ESTABLISHMENT"));
		System.out.println("Main ESTABLISHMENT menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

//		WebElement element = driver.findElement(By.id("yourElementId"));
//		if (Establishment != null) {
//			Establishment.click();
//		}
		return this;
	}
	public AL_Establishment_Trans_LeaveApproval Transaction() {
		System.out.println("Click on Transactions ");
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		js.executeScript("arguments[0].click;", subMenu);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}
	public AL_Establishment_Trans_LeaveApproval LeaveApproval() throws InterruptedException {
		WebElement link_Lapprove = driver.findElement(By.linkText("Leave Approval"));
		System.out.println("Click on Leave Approval from submenu");
		link_Lapprove.click();
		return this;
	}
	public AL_Establishment_Trans_LeaveApproval SelectLeave() throws InterruptedException {
		System.out.println("Click on Select Leave");
		WebElement SelectLeave=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvPendingList_ctrl0_btnApproval"));
		Thread.sleep(2000);
		SelectLeave.click();
		//JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//js2.executeScript("arguments[0].click;", SelectLeave);
		///click(SelectLeave);
		return this;
	}
	public AL_Establishment_Trans_LeaveApproval RejectLeave() throws InterruptedException {
		System.out.println("Select - Reject ");
		WebElement RejectLeave = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelect"));
		Select aa = new Select(RejectLeave);
		aa.selectByVisibleText("Reject"); 
		return this;
	}
	public AL_Establishment_Trans_LeaveApproval SubmitButton() throws InterruptedException {
		System.out.println("Click on Submit");
		WebElement SubmitButton=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		//js.executeScript("arguments[0].click;", SubmitButton);
		SubmitButton.click();
		return this;
	}

	
//	public ApproveLeaveStudent SelectSession() throws InterruptedException {
//		System.out.println("Session -> DEC 2021");
//		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
//		Select sessn = new Select(session);
//		sessn.selectByVisibleText("DEC 2021");
//		return this;
//	}

}