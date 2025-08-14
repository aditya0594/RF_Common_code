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

public class AL_Payroll_Rpt_OtherSalaryHeadReports extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_OtherSalaryHeadReports(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports OtherSalaryHeadReport() throws InterruptedException {
		System.out.println("Click Other Salary Head Reports ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement oth_sal_hd = driver.findElement(By.id("ctl00_repLinks_ctl06_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",oth_sal_hd);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", oth_sal_hd);
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Select_month() throws InterruptedException {
		System.out.println("Select Month => Aug2022");
		WebElement month=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonth"));
		Select select = new Select(month);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Select_college() throws InterruptedException {
		System.out.println("Select college => Crescent School of Architecture");
		Thread.sleep(4000);
		WebElement college_name=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select select = new Select(college_name);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Select_Staff() throws InterruptedException{
		System.out.println("Select staff => Admin NTS");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo"));
		Select staf= new Select(staff);
		staf.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Select_ShowInReport() throws InterruptedException{
		System.out.println("Select staff => PF No.");
		WebElement show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlShowInReport"));
		Select staf= new Select(show);
		staf.selectByVisibleText("PF No.");
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Select_PayHeads_PAY() throws InterruptedException{
		System.out.println("Select staff => BASIC ");
		
		WebElement base_clk = driver.findElement(By.xpath("//span[@class='multiselect-selected-text']"));
		click(base_clk);
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control multiselect-search']"));
		click(search);
		sendKeys(search, "PAY");
		WebElement pay = driver.findElement(By.xpath("//input[@value='PAY']"));
		click(pay);
		
		return this;
	}
	
	public AL_Payroll_Rpt_OtherSalaryHeadReports Click_ShowReport_btn() throws IOException, InterruptedException {
		System.out.println("Click=> Show Report button");
		WebElement shwrepo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport"));
		click(shwrepo);
		Thread.sleep(2000);	
		return this;
	}
}
