package Stores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Stores_Rpt_CDWR_MainStore_SummaryReport   extends BaseClass {
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement ClgOrDeptWiseItemReport;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSummaryRpt")
	private WebElement SummeryReport;
	
	

	public  AL_Stores_Rpt_CDWR_MainStore_SummaryReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public AL_Stores_Rpt_CDWR_MainStore_SummaryReport ClickOn_ClgOrDeptWiseItemReport1() {
		System.out.println(" College Or Department Wise Item Report ");
		ClgOrDeptWiseItemReport.click();
		return this;
	}
	

	
	

	public AL_Stores_Rpt_CDWR_MainStore_SummaryReport Select_FromDate() throws InterruptedException {
		System.out.println("Enter From Date"); 
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("(//i[@class='fa fa-calendar text-blue'])[1]"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_title"));
		year_ttl.click(); 
    	Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_year_0_2"));
		year_select.click(); //year = 2021
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_month_0_1"));
		month_select.click();  // month=feb
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_day_3_3"));
		date_select.click();    // day=19*/
		return this;
	}
	
	public  AL_Stores_Rpt_CDWR_MainStore_SummaryReport Select_ToDate() throws InterruptedException {
		System.out.println("Enter to Date"); 
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("(//i[@class='fa fa-calendar text-blue'])[2]"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_year_1_1"));
		year_select.click(); //year = 2024
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_month_0_1"));
		month_select.click();  // month=feb
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_day_4_4"));
		date_select.click();    // day=29   
		return this;
	}
	
	
	public AL_Stores_Rpt_CDWR_MainStore_SummaryReport ClickOn_ClgOrDeptWiseItemReportSummery() {
		System.out.println(" Click ClgOrDeptWiseItemReport Summery Report ");
		SummeryReport.click();
		return this;
	}
	

}
