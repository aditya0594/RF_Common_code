package Payroll;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_ESIDeductionReport extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_ESIDeductionReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport ESIDeductionReport() throws InterruptedException {
		System.out.println("Click ESI Deduction Report ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement esi = driver.findElement(By.id("ctl00_repLinks_ctl07_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",esi);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", esi);
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport Select_month() throws InterruptedException {
		System.out.println("Select Month => Aug2022");
		WebElement month=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonthYear"));
		Select select = new Select(month);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport Select_college() throws InterruptedException {
		System.out.println("Select college => Crescent School of Architecture");
		Thread.sleep(4000);
		WebElement college_name=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege1"));
		Select select = new Select(college_name);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport Select_Scheme() throws InterruptedException{
		System.out.println("Select Scheme => Admin NTS");
		WebElement scheme = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo"));
		Select staf= new Select(scheme);
		staf.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_ESIDeductionReport Click_ESIC_Report_btn() throws IOException, InterruptedException {
		System.out.println("Click=> ESIC Report btn");
		WebElement ex_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnESIReport"));
		click(ex_btn);
		Thread.sleep(2000);	
		return this;
	}
}
