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


public class AL_Establishment_Trans_LeaveAllotment extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	@FindBy(linkText = "Leave Allotment") private WebElement Leave_allotment;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_LeaveAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public AL_Establishment_Trans_LeaveAllotment Click_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transaction).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Click_Leave_allotment() {
		System.out.println(" Click On > Leave_allotment");
		Actions action = new Actions(driver);
		action.moveToElement(Leave_allotment).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Select_College_name() {
		System.out.println("Select College_name");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Select_Stafff_Type() {
		System.out.println("Select Session");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStafftype']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Select_Period() {
		System.out.println("Select Period");
		WebElement period=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPeriod']"));
		Select select = new Select(period);
		select.selectByVisibleText("YEARLY");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Select_Year() {
		System.out.println("Select Year");
		WebElement year=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlYear']"));
		Select select = new Select(year);
		select.selectByVisibleText("2024");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Set_From_Date() throws InterruptedException{
		System.out.println("Set Month Year");
		Thread.sleep(2000);
	
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMonthYear")), "02/2022");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Set_To_Date() throws InterruptedException{
		System.out.println("Set Month Year");
		Thread.sleep(2000);
	
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMonthYear")), "02/2022");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Select_Leave_name() {
		System.out.println("Select Leave_name");
		WebElement leave_name=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlLeavename']"));
		Select select = new Select(leave_name);
		select.selectByVisibleText("Casual Leave->NOT CARRY->ALL");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Click_Show_btn() throws InterruptedException{
		System.out.println("Click on show_btn");
		WebElement show_btn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShow']"));
		click(show_btn);
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Click_check_box() throws InterruptedException{
		System.out.println("Click check box");
		WebElement show_btn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShow']"));
		js.executeScript("arguments[0].scrollIntoView();",show_btn);

		WebElement check_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmployees_ctrl0_chkSelect"));
		click(check_box);
		return this;
	}
	
	public AL_Establishment_Trans_LeaveAllotment Click_Transfer_btn() throws InterruptedException{
		System.out.println("Click Transfer_btn");
		WebElement check_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(check_box);
		return this;
	}

}
