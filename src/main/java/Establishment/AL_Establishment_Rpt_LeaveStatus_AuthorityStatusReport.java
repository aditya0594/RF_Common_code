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

public class AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
//	@FindBy(linkText = "Leave Status") private WebElement Leave_Status;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_Leave_status() throws InterruptedException {
		System.out.println(" Click On > Leave Status");
//		Actions action = new Actions(driver);
//		action.moveToElement(Leave_Status).click().build().perform();
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement leave_status = driver.findElement(By.id("ctl00_repLinks_ctl03_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",leave_status);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", leave_status);
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Select_College() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlstafftype']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	

	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_perticular_employee_check_btn() throws InterruptedException {
		System.out.println("Select Perticular Employee");
		WebElement perticular_emp_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblAllParticular_1"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", perticular_emp_btn);
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Select_employee() throws InterruptedException {
		System.out.println("Select Employee");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlEmp']"));
		Select select = new Select(staff);
		Thread.sleep(2000);
		select.selectByValue("548");
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Set_from_date() {
		System.out.println("Select From date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromdt")), "10/01/2022");
		return this;
	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Set_to_date() {
		System.out.println("Select To date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTodt")), "15/11/2024");
		return this;
	}
	
//	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_report_btn() {
//		System.out.println("Click Report Button");
//		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
//		click(repo_btn);
//		return this;
//	}
	
	public AL_Establishment_Rpt_LeaveStatus_AuthorityStatusReport Click_authority_satus_report_btn() {
		System.out.println("Click Authority Status Report btn");
		WebElement staus_repo=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReportnew"));
		click(staus_repo);
		return this;
	}
	
	

}
