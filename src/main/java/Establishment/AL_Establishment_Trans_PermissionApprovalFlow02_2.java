package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_PermissionApprovalFlow02_2 extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	@FindBy(id = "ctl00_ctl00_repLinks_ctl25_lbLink") private WebElement permission_approval;

	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transaction).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_PermissionApproval() throws InterruptedException {
		System.out.println("Click Permission Approval");
//		WebElement leaveCancel = driver.findElement(By.id("ctl00_ctl00_repLinks_ctl13_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",permission_approval);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", permission_approval);
	//	leaveCancel.click();
		return this;
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_Select_btn() {
		System.out.println("Click on => Click To Select_btn");
		WebElement select_btn = driver.findElement(By.xpath("//input[@title='Select to Approve/Reject']"));
		click(select_btn);
		return this;
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_SelectStatus() {
		System.out.println("Click on Select Status=> Reject");
		WebElement status = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelect"));
		Select select = new Select(status);
		select.selectByVisibleText("Reject");
		return this;
	}
	
	public AL_Establishment_Trans_PermissionApprovalFlow02_2 Click_Submit_btn() {
		System.out.println("Click on Submit_btn");
		WebElement submit_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(submit_btn);
		return this;
	}
}
