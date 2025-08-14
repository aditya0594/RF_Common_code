package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_DonationEntry extends BaseClass
{
	public AL_Payroll_Trans_MW_DonationEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement DonationEntry;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement addNewBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtdays") private WebElement given_days;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement PayheadForTransferSalary;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement submitbtn;

	public AL_Payroll_Trans_MW_DonationEntry Click_DonationEntry() {
		System.out.println(" Click on Donation Entry");
		Actions action = new Actions(driver);
		action.moveToElement(DonationEntry).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Click_AddNewBtn() {
		System.out.println("Click on Add New Btn");
		click(addNewBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Set_MonthForSalaryDonation() throws InterruptedException {
		System.out.println("  Select Month For Salary Donation => 06/01/2025");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImgMonYear"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_month_0_0"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_day_1_1"));
		click(date_select);
		
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Select_CollegeName() {
		System.out.println(" Select College Name ==> Crescent School of Architecture");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Select_StaffScheme() {
		System.out.println(" Select Staff/Scheme Name ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Enter_GiveDaysOfSalaryDeduct() {
		System.out.println(" Enter  Give Days Of Salary Deduct ==>  4");
		sendKeys(given_days, "4");
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Select_PayheadForTransferSalary() {
		System.out.println(" Select Payhead For Transfer Salary==> OTHERS");
		Select select = new Select(PayheadForTransferSalary);
		select.selectByVisibleText("OTHERS");
		return this;
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Click_Submit_Btn() {
		System.out.println("Click on Submit Btn");
		click(submitbtn);
		return this;     
	}
	
	public AL_Payroll_Trans_MW_DonationEntry Click_DeleteRecord() throws InterruptedException {
		System.out.println("Click on Delete Record btn to delete record");
		WebElement delete_icon = driver.findElement(By.xpath("//input[@alt='Delete Record']"));
		click(delete_icon);
		return this;
	}
}
