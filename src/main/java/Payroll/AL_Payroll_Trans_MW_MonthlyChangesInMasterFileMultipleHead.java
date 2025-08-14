package Payroll;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_txtI4") private WebElement specialAllow;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement submitbtn;

	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead MonthlyChangesInMasterFileMultipleHead() throws InterruptedException {
		System.out.println("Click on Monthly Changes In Master File (Multiple head)");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement changes = driver.findElement(By.id("ctl00_repLinks_ctl05_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",changes);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", changes);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Select_College() {
		System.out.println("Select College => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Select_OrderBy() {
		System.out.println("Select Order By => IDNO ");
		Select select = new Select(orderby);
		select.selectByVisibleText("IDNO");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Click_Show_btn() {
		System.out.println("Click on Show btn ");
		click(showbtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Click_CheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement chkbox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_chkIno"));
		js.executeScript("arguments[0].scrollIntoView();",chkbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", chkbox);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Enter_SpecialAllo() throws InterruptedException {
		System.out.println("Enter Special Allo ==> 50");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",specialAllow);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", specialAllow);
		clearText(specialAllow);
		sendKeys(specialAllow, "50");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangesInMasterFileMultipleHead Click_Submit_btn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Do you want to save changes ?"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
		
		return this;
	}
}
