package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_SupplementryWiseReport extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	
	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]") private WebElement Report;
	
//	@FindBy(linkText = "Supplementry Wise Report") private WebElement SuppWiseReport;
	
	
	public AL_Payroll_Rpt_SupplementryWiseReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport SupplementryWiseReport() throws InterruptedException {
		System.out.println(" Report > Click On Supplementry Wise Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement supplereport = driver.findElement(By.id("ctl00_repLinks_ctl15_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",supplereport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", supplereport);
		return this;
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Select_Month_year() {
		System.out.println("Select Month and Year  >  Sep2022 ");
		WebElement mothYear = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonthYear"));
		Select c1 = new Select(mothYear);
		c1.selectByVisibleText("Sep2022");
		return this;		
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Select_College() {
		System.out.println("Select College  > All selected (15)");
		WebElement clg_click = driver.findElement(By.xpath("//span[text()='None selected']"));
		clg_click.click();
		WebElement multiselect = driver.findElement(By.xpath("//a[@class='multiselect-all']"));
		multiselect.click();
		return this;	
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Select_SupplymentryHead() {
		System.out.println("Select Supplementry Head  >  Surplus Budget ");
		WebElement head = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSuppliHead"));
		Select c1 = new Select(head);
		c1.selectByVisibleText("Surplus Budget");
		return this;	
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Select_OrderBy() {
		System.out.println("Select Order By  >  65465 ");
		WebElement orderby = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlOrderBy"));
		Select c1 = new Select(orderby);
		c1.selectByVisibleText("65465");
		return this;	
	}
	
	public AL_Payroll_Rpt_SupplementryWiseReport Click_Reportbtn() {
		System.out.println("Click On Report Button");
		WebElement rptbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSuppWiseRpt"));
		click(rptbtn);
		return this;
	}
	
}
