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

public class AL_Payroll_Rpt_EmployeeCountReport extends BaseClass
{
@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	
	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]") private WebElement Report;
	
	@FindBy(id = "ctl00_repLinks_ctl16_lbLink") private WebElement empCountRepo;
	
	
	public AL_Payroll_Rpt_EmployeeCountReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Payroll_Rpt_EmployeeCountReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeCountReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		Actions action = new Actions(driver);
		action.moveToElement(Report).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeCountReport EmployeeCountReport() throws InterruptedException {
		System.out.println(" Report > Click On Employee Count Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		WebElement link_IPentry = driver.findElement(By.id("ctl00_repLinks_ctl08_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",empCountRepo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", empCountRepo);
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeCountReport Select_Date() throws InterruptedException {
		System.out.println(" Select Date ==> 01/01/2022");
	
/*		Thread.sleep(3000);
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDate")), "01/04/2021");
*/
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromDate1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_0_3"));
		year_select.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_0_6"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeeCountReport Select_College() throws InterruptedException {
		System.out.println("Select College  > All selected (15) ");
		WebElement click_search = driver.findElement(By.className("multiselect-selected-text"));
		click(click_search);
		Thread.sleep(2000);
		WebElement all_select = driver.findElement(By.xpath("//input[@value='multiselect-all']"));
		click(all_select);
		
		return this;	
	}
	
	public AL_Payroll_Rpt_EmployeeCountReport Click_ShowButtonBtn() throws InterruptedException {
		System.out.println("Click On Show Report Button");
		WebElement showbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",showbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", showbtn);
		return this;
	}
}
