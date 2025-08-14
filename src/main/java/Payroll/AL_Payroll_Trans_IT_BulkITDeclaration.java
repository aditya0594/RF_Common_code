package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_IT_BulkITDeclaration extends BaseClass
{
	public AL_Payroll_Trans_IT_BulkITDeclaration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlITRule") private WebElement ITrulename;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement savebtn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Trans_IT_BulkITDeclaration Select_College() {
		System.out.println("Select College ==> Crescent Institute");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent Institute");
		return this;
	}
	
	public AL_Payroll_Trans_IT_BulkITDeclaration Select_Staff() {
		System.out.println("Select Staff ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_IT_BulkITDeclaration Select_ITSchemeRule() {
		System.out.println("Select IT Scheme/Rule ==>IT Rule 2024-25 (New)");
		Select select = new Select(ITrulename);
		select.selectByVisibleText("IT Rule 2024-25 (New)");
		return this;
	}
	
	public AL_Payroll_Trans_IT_BulkITDeclaration Click_Submitbtn() throws InterruptedException {
		System.out.println("Click Submit btn");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",savebtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", savebtn);
		return this;
	}
}
