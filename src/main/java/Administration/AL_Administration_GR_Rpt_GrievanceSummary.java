package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_GR_Rpt_GrievanceSummary  extends BaseClass {
	
	
	public  AL_Administration_GR_Rpt_GrievanceSummary(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id = "ctl00_repLinks_ctl01_lbLink")
	private WebElement GrievanceSummary;
	
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSDate")
	private WebElement FromDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDate") 
	private WebElement EndDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlGrivType")
	private WebElement GrievanceType; 
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment")
	private WebElement Department; 
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement ShowBtn; 
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrApplication_ctrl2_btnPrint")
	private WebElement PrintBtn; 
	
	
	
	
	
	public AL_Administration_GR_Rpt_GrievanceSummary ClickOn_GrievanceSummary() {
		System.out.println("Click on GrievanceSummary ");
		GrievanceSummary.click();
		return this;
	}

	
	public AL_Administration_GR_Rpt_GrievanceSummary Select_FromDate() throws InterruptedException {
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
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_0"));
		year_select.click(); //year = 2023
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_1_3"));
		month_select.click();  // month=Aug
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_3_2"));
		date_select.click();    // day=22
		return this;
	}
	
	public  AL_Administration_GR_Rpt_GrievanceSummary Select_ToDate() throws InterruptedException {
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
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_0_3"));
		month_select.click();  // month=April
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_4_3"));
		date_select.click();    // day=30  
		return this;
	}
	
	
	
	public AL_Administration_GR_Rpt_GrievanceSummary Select_GrievanceType() {
		System.out.println("Select Grievance Type");
		Select select = new Select(GrievanceType);
		select.selectByVisibleText("Academic");
		return this;
	}    
	
	
	public AL_Administration_GR_Rpt_GrievanceSummary Select_Department() {
		System.out.println("Select Department");
		Select select = new Select(Department);
		select.selectByVisibleText("Department of Mechanical Engineering");
		return this;
	}    
	
	
	

	public AL_Administration_GR_Rpt_GrievanceSummary ClickOn_ShowButton() {
		System.out.println("Click on ShowButton ");
		ShowBtn.click();
		return this;
	}
	
	
	public AL_Administration_GR_Rpt_GrievanceSummary ClickOn_PrintButton() {
		System.out.println("Click on PrintBtn ");
		PrintBtn.click();
		return this;
	}
	   
	
	
	

}
