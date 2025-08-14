package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AM_CancelTimeTableFlow08_2 extends BaseClass{

	public AL_Academic_AM_CancelTimeTableFlow08_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl05_lbLink") private WebElement cancelTimeTable_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchoolInstitute") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSlotType") private WebElement slotType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStartDate") private WebElement startDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDate") private WebElement endDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvTimeTable_chkheader") private WebElement selectAll_checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCancel") private WebElement submit_btn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AM_CancelTimeTableFlow08_2 click_cancelTimeTable_link() throws InterruptedException 
	{
		System.out.println("Click Time Table Link");
		//timeTable_link.click();
		js.executeScript("arguments[0].scrollIntoView();",cancelTimeTable_link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", cancelTimeTable_link);
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_college() 
	{
		System.out.println("Select College > SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		Select options = new Select(college_dropdown);
		options.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_session() 
	{
		System.out.println("Select Session > May 2022");
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_department() 
	{
		System.out.println("Select Department > Department of Civil Engineering");
		Select options = new Select(department_dropdown);
		options.selectByVisibleText("Department of Civil Engineering");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_semester() 
	{
		System.out.println("Select Semester > IV");
		Select options = new Select(semester_dropdown);
		options.selectByVisibleText("IV");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_section() 
	{
		System.out.println("Select Section > A");
		Select options = new Select(section_dropdown);
		options.selectByVisibleText("A");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 select_slotType() 
	{
		System.out.println("Select Slot Type > Regular");
		Select options = new Select(slotType_dropdown);
		options.selectByVisibleText("Regular");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 enter_startDate() throws InterruptedException 
	{
		System.out.println("Enter Start Date > 31/01/2024 ");
		//js.executeScript("arguments[0].value = arguments[1]",startDate_inputfield, "31/01/2024");
		
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgStartDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_year_1_1"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_month_0_0"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_day_4_3"));
		date_select.click();
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 enter_endDate() 
	{
		System.out.println("Enter End Date > 01/01/2025");
		js.executeScript("arguments[0].value = arguments[1]",endDate_inputfield, "01/01/2025");
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 click_show_btn() 
	{
		System.out.println("Click show button");
		show_btn.click();
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 click_checkbox() throws InterruptedException 
	{
		System.out.println("Click show button");
		js.executeScript("arguments[0].scrollIntoView();",selectAll_checkbox);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectAll_checkbox);
		return this;
	}
	public AL_Academic_AM_CancelTimeTableFlow08_2 click_submit_btn() throws InterruptedException 
	{
		System.out.println("Click show button");
		js.executeScript("arguments[0].scrollIntoView();",submit_btn);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit_btn);
		//submit_btn
		return this;
	}
	
	
	
	
}
