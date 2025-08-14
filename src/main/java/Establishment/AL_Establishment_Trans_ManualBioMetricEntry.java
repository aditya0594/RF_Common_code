package Establishment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_ManualBioMetricEntry extends BaseClass
{
	public AL_Establishment_Trans_ManualBioMetricEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Manual Bio Metric Entry") private WebElement manualBioMetricEntry;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStafftype") private WebElement staffTypeDropdown;
	@FindBy(xpath = "(//i[@class='fa fa-calendar'])[1]") private WebElement calendarIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_cetxtStartDate_today") private WebElement todayButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmployee") private WebElement employeeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnshow") private WebElement showButton;
	
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//input[@type='checkbox']") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUploadExcel") private WebElement uploadbtn;

	@FindBy(xpath = "//input[@title='Enter  In-Time']") private WebElement intime;
	@FindBy(xpath = "//input[@title='Enter  Out-Time']") private WebElement outtime;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlEmployee-container") private WebElement employdropdwn;
	@FindBy(xpath = "//input[@class='select2-search__field']") private WebElement searchbox;



	public AL_Establishment_Trans_ManualBioMetricEntry Click_ManualBioMetricEntry() throws Exception {
		System.out.println("Click on Manual Bio Metric Entry");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", manualBioMetricEntry);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", manualBioMetricEntry);
		
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Select_College() throws Exception {
		System.out.println("Select College ==> Crescent School of Architecture");
		Thread.sleep(2000);
		Select select = new Select(collegeDropdown);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Select_StaffType() throws Exception {
		System.out.println("Select Staff Type ==> Teaching Staff");
		Thread.sleep(2000);
		Select select = new Select(staffTypeDropdown);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_CalendarIcon() throws Exception {
		System.out.println("Click on Calendar Icon");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", calendarIcon);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", calendarIcon);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", todayButton);
		return this;
	}

	
	public AL_Establishment_Trans_ManualBioMetricEntry Select_Employee() throws Exception {
		System.out.println("Select Employee ==> VENKATESAN  MURTHY - 2021008");
		click(employdropdwn);
		Thread.sleep(2000);
		sendKeys(searchbox, "VENKATESAN  MURTHY");
		searchbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_ChooseFile() throws Exception {
		System.out.println("Click on Choose File");
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ManualBioMetricEntry.xlsx");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_flUplaodPayheadExcel"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_UploadBtn() throws Exception {
		System.out.println("Click on Upload Btn");
		js.executeScript("arguments[0].click();", uploadbtn);
		acceptAlert();
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_ShowButton() throws Exception {
		System.out.println("Click on Show Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", showButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", showButton);
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Enter_InTime() throws Exception {
		System.out.println("Enter In time");
		js.executeScript("arguments[0].value = arguments[1]",intime, "10:00:00");	
		return this;
	}
	
	
	public AL_Establishment_Trans_ManualBioMetricEntry Enter_OutTime() throws Exception {
		System.out.println("Enter Out time");
		js.executeScript("arguments[0].value = arguments[1]",outtime, "19:00:00");
		return this;
	}
	
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_Checkbox() throws Exception {
		System.out.println("Click on Checkbox");
		
		js.executeScript("arguments[0].scrollIntoView();", employeeDropdown);
	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkbox);
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_SubmitButton() throws Exception {
		System.out.println("Click on Submit Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", submitButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitButton);
		
		return this;
	}
	
	public AL_Establishment_Trans_ManualBioMetricEntry Click_ReportBtn() throws Exception {
		System.out.println("Click on Report Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", reportbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", reportbtn);
		
		return this;
	}
}
