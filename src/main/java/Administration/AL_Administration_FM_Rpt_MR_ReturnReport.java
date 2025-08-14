package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_FM_Rpt_MR_ReturnReport  extends BaseClass {
	
	public AL_Administration_FM_Rpt_MR_ReturnReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(id="ctl00_repLinks_ctl00_lbLink")
	private WebElement MovementReports;
	
	@FindBy(id= "ctl00_ContentPlaceHolder1_ddlReport")
	private WebElement ReportStatus;
	
	@FindBy(id= "ctl00_ContentPlaceHolder1_ddlSection")
	private WebElement Section;
	
	@FindBy(id= "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowReport;
	
	
	
	public AL_Administration_FM_Rpt_MR_ReturnReport ClickOn_MovementReports() {
		System.out.println("Click on Movement Reports ");
		MovementReports.click();
		return this;
	}
	
	public AL_Administration_FM_Rpt_MR_ReturnReport Select_ReportStatusDropdown() {
		System.out.println("Select Report Status Dropdown");
		Select select = new Select(ReportStatus);
		select.selectByVisibleText("Return");
		return this;
	}
	
	public AL_Administration_FM_Rpt_MR_ReturnReport Select_SectionDropdown() {
		System.out.println("Select Section Dropdown");
		Select select = new Select(Section);
		//select.selectByVisibleText("VENKATESAN  MURTHY");
		select.selectByValue("3");
		return this;
	}
	
	public AL_Administration_FM_Rpt_MR_ReturnReport Select_FromDate() throws InterruptedException {
		System.out.println("Enter From Date");
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImgBntCalc"));
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
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_3"));
		month_select.click(); // month=Apr
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_4"));
		date_select.click(); // day=01
		return this;
	}
	
	
	public AL_Administration_FM_Rpt_MR_ReturnReport Select_ToDate() throws InterruptedException {
		System.out.println("Enter To Date");
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
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_1_1"));
		month_select.click(); // month=June
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_2_1"));
		date_select.click(); // day=09
		return this;
	}
	
	public AL_Administration_FM_Rpt_MR_ReturnReport ClickOn_ShowReport() {
		System.out.println("Click on Show Report ");
		ShowReport.click();
		return this;
	}


}
