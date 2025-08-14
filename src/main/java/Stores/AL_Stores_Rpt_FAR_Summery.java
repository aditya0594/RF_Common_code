package Stores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_FAR_Summery extends BaseClass {
	
	@FindBy(id = "ctl00_repLinks_ctl03_lbLink")
	private WebElement FixedAssetReport;
	

	

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubCategory")
	private WebElement SubCategory;
	
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlItem")
	private WebElement SelectItem;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt")
	private WebElement ShowReport;
	
	

	public  AL_Stores_Rpt_FAR_Summery(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public AL_Stores_Rpt_FAR_Summery Select_FixedReportTypeSummery() {
		System.out.println(" Click FixedReportType ");
		FixedAssetReport.click();
		return this;
	}
	
	
	

	

	public AL_Stores_Rpt_FAR_Summery Select_SubCategory() {
		System.out.println(" Select SubCategory");
		Select select = new Select(SubCategory);
		select.selectByVisibleText("TABLE");
		return this;
	}
	
	public AL_Stores_Rpt_FAR_Summery Select_SelectItem() {
		System.out.println(" Select SelectItem");
		Select select = new Select(SelectItem);
	    select.selectByVisibleText("WOOD CHAIRS");
		//select.selectByIndex(0);
		return this;
	}
	
	
	public AL_Stores_Rpt_FAR_Summery Select_FromDate() throws InterruptedException {
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
	
	
	public  AL_Stores_Rpt_FAR_Summery Select_ToDate() throws InterruptedException {
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
	
	public  AL_Stores_Rpt_FAR_Summery Click_ShowBtn() {
		System.out.println("Click Show Button");
		click(ShowReport);
		return this;
	}
	


		
	}    
	
	


