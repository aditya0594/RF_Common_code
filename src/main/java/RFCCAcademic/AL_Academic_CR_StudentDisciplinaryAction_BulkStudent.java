package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_StudentDisciplinaryAction_BulkStudent extends BaseClass
{
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Student Disciplinary Action") private WebElement StudentDisciplinaryAction;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSelect") private WebElement bulkStudentDisciplinaryAction;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollegeBulk") private WebElement schoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionBulk") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegreeBulk") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowBulk") private WebElement showdetailbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudentBulk_cbHead") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitBulk") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRemarks") private WebElement remarks;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Click_StudentDisciplinaryAction() throws InterruptedException {
		System.out.println("Click on Student Disciplinary Action");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",StudentDisciplinaryAction);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", StudentDisciplinaryAction);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_BulkStudentDisciplinaryAction() throws InterruptedException {
		System.out.println("Select Bulk Student Disciplinary Action ");
		Select select = new Select(bulkStudentDisciplinaryAction);
		select.selectByVisibleText("Bulk Student Disciplinary Action");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School Institute ==> Crescent School of Architecture");
		Select select = new Select(schoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> 2023-2024");
		Select select = new Select(session);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Click_ShowDetailsBtn() throws InterruptedException {
		System.out.println("Click on Show Details btn");
		click(showdetailbtn);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_Remarks() throws InterruptedException {
		System.out.println("Select Remarks ==> Poor performance");
		Select select = new Select(remarks);
		select.selectByVisibleText("Poor performance");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_FromDate() throws InterruptedException {
		System.out.println("Select From Date");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgFromDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_0"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_3"));
		date_select.click();    // day=1
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Select_ToDate() throws InterruptedException {
		System.out.println("Select To Date");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_month_2_3"));
		month_select.click();  // month=Dec
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_day_4_3"));
		date_select.click();    // day=31
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Click_CheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		click(chkbox);
		return this;
	}
	
	
	public AL_Academic_CR_StudentDisciplinaryAction_BulkStudent Click_Submitbtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		return this;
	}
}
