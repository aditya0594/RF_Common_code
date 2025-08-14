package Payroll;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Payroll_Rpt_EmployeeJoiningReport extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_EmployeeJoiningReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_EmployeeJoiningReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeJoiningReport Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeJoiningReport EmployeeJoiningReport() throws InterruptedException {
		System.out.println("Click Employee Joining Report ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement emp_join = driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",emp_join);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", emp_join);
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeJoiningReport Click_AAFREEN_BANU() throws IOException, InterruptedException {
		System.out.println("Click => AAFREEN  BANU");
		WebElement banu = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListView1_ctrl747_lnkId"));
		click(banu);
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeJoiningReport Click_JoiningReport_btn() throws IOException, InterruptedException {
		System.out.println("Click => Joining Repor");
		WebElement banu = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(banu);
		return this;
	}
}
