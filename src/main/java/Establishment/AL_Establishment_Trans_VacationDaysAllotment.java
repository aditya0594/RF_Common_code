package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_VacationDaysAllotment extends BaseClass
{
	@FindBy(xpath = "(//a[@id='ctl00_ctl00_repLinks_ctl15_lbLink'])[1]") private WebElement VacationDaysAllotment;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegeName;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStafftype") private WebElement staffName;

	public AL_Establishment_Trans_VacationDaysAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_VacationDaysAllotment Click_VacationDaysAllotment() throws InterruptedException {
		System.out.println("Click on Vacation Days Allotment");
		js.executeScript("arguments[0].scrollIntoView();",VacationDaysAllotment);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", VacationDaysAllotment);
	//	leaveCancel.click();
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Select_College_name() {
		System.out.println("Select College_name => Crescent School of Architecture");
		Select select = new Select(collegeName);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Select_Stafff_Type() {
		System.out.println("Select Session => Teaching Staff");
		Select select = new Select(staffName);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Click_CheckBox() {
		System.out.println("Click on Check Box");
		WebElement chkBox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_chkID"));
		click(chkBox);
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Set_FromDate() throws InterruptedException {
		System.out.println("Set From Date ==> 05/05/2024");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_imgCalholidayDt"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_ceholidayDt_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_ceholidayDt_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_ceholidayDt_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_ceholidayDt_month_1_0"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_ceholidayDt_day_1_1"));
		click(date_select);
		
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Set_ToDate() throws InterruptedException {
		System.out.println("Set To Date ==> 09/05/2024");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_imgCalToDt"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_CalendarExtender1_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_CalendarExtender1_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_CalendarExtender1_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_CalendarExtender1_month_1_0"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_CalendarExtender1_day_1_5"));
		click(date_select);
		
		return this;
	}
	
	public AL_Establishment_Trans_VacationDaysAllotment Click_Submit_btn() {
		System.out.println("Click on Submit btn");
		WebElement submitbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(submitbtn);
		return this;
	}
}
