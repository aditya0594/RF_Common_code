package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_IT_ITDeclaration extends BaseClass
{
	public AL_Payroll_Trans_IT_ITDeclaration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement ITDeclaration;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlemp") private WebElement employee;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlITRule") private WebElement ITrulename;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave0") private WebElement savebtn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Trans_IT_ITDeclaration Click_ITDeclaration() throws InterruptedException {
		System.out.println(" Click on IT Declaration");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",ITDeclaration);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ITDeclaration);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITDeclaration Select_College() {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITDeclaration Select_Employee() {
		System.out.println("Select Employee ==> NAZNEEN  M.Y[27]");
		Select select = new Select(employee);
		select.selectByValue("27");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITDeclaration Select_ITRuleName() {
		System.out.println("IT Rule 2022-23 (New scheme)");
		Select select = new Select(ITrulename);
		select.selectByValue("4");
		js.executeScript("arguments[0].scrollIntoView();",ITrulename);

		return this;
	}
	
	public AL_Payroll_Trans_IT_ITDeclaration Select_ReportedAsOnDate() throws InterruptedException {
		System.out.println("Enter date in Reported as on date");
		

		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("imgdate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_2_3"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_0_1"));
		date_select.click();    // day=1
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITDeclaration Click_Savebtn() throws InterruptedException {
		System.out.println("Click Save btn");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",savebtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", savebtn);
		return this;
	}
}
