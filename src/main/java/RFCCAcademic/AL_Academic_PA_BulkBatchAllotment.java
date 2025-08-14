package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import RFCCAcademic.AL_Academic_AR_BulkUpdateOfPhoto;
import utility.BaseClass;

public class AL_Academic_PA_BulkBatchAllotment extends BaseClass{

	public AL_Academic_PA_BulkBatchAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Bulk Batch & Year Allotment") private WebElement bulkBatchAndYearAllotment_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmBatchctl00_ContentPlaceHolder1_ddlAdmBatch") private WebElement admissionBatch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAcdBatch") private WebElement academicBatch_dropdown;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input[@type='checkbox']") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	
	
	
	public AL_Academic_PA_BulkBatchAllotment click_bulkBatchAndYearAllotment_link() throws InterruptedException 
	{
		System.out.println("Click on Bulk Batch And Year Allotment link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
        actions.moveToElement(menuScroll).perform();

        // Use JavaScript to scroll the menu to the target element
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll inside the menu until the element is visible
        js.executeScript(
            "arguments[0].scrollTop = arguments[1].offsetTop;", 
            menuScroll, 
            bulkBatchAndYearAllotment_link
        );

        // Optionally, interact with the target element
        bulkBatchAndYearAllotment_link.click();
		return this;
	}
	public AL_Academic_PA_BulkBatchAllotment select_admissionBatch() 
	{
		System.out.println("Select Admission Batch");
		Select opt = new Select(admissionBatch_dropdown);
		opt.selectByVisibleText("2022-23");
		
		
		return this;
	}
	public AL_Academic_PA_BulkBatchAllotment select_school() 
	{
		System.out.println("Select College > Crescent School of Law");
		Select opt = new Select(college_dropdown);
		opt.selectByVisibleText("Crescent School of Law");
		return this;
	}
	public AL_Academic_PA_BulkBatchAllotment click_show_button() 
	{
		System.out.println("Click on show button");
		show_button.click();
		return this;
	}
	public AL_Academic_PA_BulkBatchAllotment select_academicBatch() 
	{
		System.out.println("Select Academic Batch");
		Select opt = new Select(academicBatch_dropdown);
		opt.selectByVisibleText("2023-24");
		return this;
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Academic_PA_BulkBatchAllotment check_checkbox() 
	{
		System.out.println("Click on checkbox");
		js.executeScript("arguments[0].scrollIntoView();",show_button);
		checkbox.click();
		return this;
	}
	public AL_Academic_PA_BulkBatchAllotment click_submit_button() 
	{
		System.out.println("Click on submit button");
		js.executeScript("arguments[0].scrollIntoView();",admissionBatch_dropdown);
		submit_button.click();
		return this;
	}
	
	
}
