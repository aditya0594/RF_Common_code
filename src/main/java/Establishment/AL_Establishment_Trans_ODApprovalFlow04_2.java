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

public class AL_Establishment_Trans_ODApprovalFlow04_2 extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	@FindBy(linkText = "OD Approval") private WebElement od_approval;

	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_ODApprovalFlow04_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transaction).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_ODApproval() throws InterruptedException {
		System.out.println("Click OD Approval");
		js.executeScript("arguments[0].scrollIntoView();",od_approval);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", od_approval);
		return this;
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_Select_btn() {
		System.out.println("Click on Select btn");
		WebElement select_btn = driver.findElement(By.xpath("//input[@title='Select to Approve/Reject']"));
		click(select_btn);
		return this;
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_SelectStatus() {
		System.out.println("Click on Select Status=> Reject");
		WebElement status = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelect"));
		Select select = new Select(status);
		select.selectByVisibleText("Reject");
		return this;
	}
	
	public AL_Establishment_Trans_ODApprovalFlow04_2 Click_Submit_btn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		js.executeScript("arguments[0].scrollIntoView();",submit_btn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit_btn);
		return this;
	}
}
