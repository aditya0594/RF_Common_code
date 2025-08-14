package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_GR_Rpt_GSR_InprocessCGR extends BaseClass {

	public AL_Administration_GR_Rpt_GSR_InprocessCGR(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement ClgOrDeptWiseItemReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSDate")
	private WebElement FromDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDate")
	private WebElement EndDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlstatusG")
	private WebElement GrievanceDropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnConsolidated")
	private WebElement CGRReports;

	public AL_Administration_GR_Rpt_GSR_InprocessCGR Select_FromDate() throws InterruptedException {
		System.out.println("Enter From Date");
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("//i[@id='ctl00_ContentPlaceHolder1_ImgBntCalc']"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click();
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click();
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_0_2"));
		year_select.click(); // year = 2021
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_0"));
		month_select.click(); // month=jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_5"));
		date_select.click(); // day=01
		return this;
	}

	public AL_Administration_GR_Rpt_GSR_InprocessCGR Select_EndDate() throws InterruptedException {
		System.out.println("Enter to Date");
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Image1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click();
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click();
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_1_2"));
		year_select.click(); // year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_1_0"));
		month_select.click(); // month=may
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_0_4"));
		date_select.click(); // day=01
		return this;
	}

	public AL_Administration_GR_Rpt_GSR_InprocessCGR Select_GrievanceDropdown() {
		System.out.println("Select Grievance Dropdown");
		Select select = new Select(GrievanceDropdown);
		select.selectByVisibleText("In Process");
		return this;
	}

	public AL_Administration_GR_Rpt_GSR_InprocessCGR ClickOn_CGRReports() {
		System.out.println("Click on  Consolidated Grievance Report ");
		CGRReports.click();
		return this;
	}

}
