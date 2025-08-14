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

public class AL_Payroll_Rpt_PTPFDeductionReport_PTReport extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport PF_PT_Deduction_Repo() throws InterruptedException {
		System.out.println("Click PT/ PF Deduction Report ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement pfpt = driver.findElement(By.id("ctl00_repLinks_ctl14_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",pfpt);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", pfpt);
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Select_month() throws InterruptedException {
		System.out.println("Select Month => Aug2022");
		WebElement month=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonth"));
		Select select = new Select(month);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Select_college() throws InterruptedException {
		System.out.println("Select college => Crescent School of Architecture");
		Thread.sleep(4000);
		WebElement college_name=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege1"));
		Select select = new Select(college_name);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Select_Staff() throws InterruptedException{
		System.out.println("Select staff => Admin NTS");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo"));
		Select staf= new Select(staff);
		staf.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Click_PTReport_btn() throws IOException, InterruptedException {
		System.out.println("Click=> PT Report button");
		WebElement Ptrepo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPTReport"));
		click(Ptrepo);
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		return this;
	}
	
	public AL_Payroll_Rpt_PTPFDeductionReport_PTReport Click_EPFReport_btn() throws IOException, InterruptedException {
		System.out.println("Click=> EPF Report button");
		WebElement Ptrepo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEPFReport"));
		click(Ptrepo);
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		return this;
	}
}
