package Establishment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.Screenshot;

public class FL_Establishment_Trans_PermissionEntryFlow02_1 extends BaseClass
{
	
	
	//repository
	@FindBy(xpath="//div[@id='ctl00_mainMenu']//a[contains(@class,'popout level1 static')][normalize-space()='ESTABLISHMENT']") private WebElement Establishment;
	@FindBy(linkText="Transactions") private WebElement Transactions;
	@FindBy(linkText ="Permission Entry") private WebElement permissionEntry;
	@FindBy(id="ctl00_ContentPlaceHolder1_lnkNew") private WebElement NewApplication;
	@FindBy(xpath="(//a[normalize-space()='Application Status'])[1]") private WebElement ApplicationSatus;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']") private WebElement applicationSubmitBtn;
//	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtFromDate']") private WebElement Date;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtreson']") private WebElement reason;

	@FindBy(id="ctl00_ContentPlaceHolder1_rblleavetype_0") private WebElement FirstHalf;
	@FindBy(xpath="//tbody//tr//td[2]") private WebElement SeondHalf;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnSubmit']") private WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$lvCPDA$ctrl5$btnReport']") private WebElement reportStaus;
	@FindBy(xpath="//input[@class='form-control form-control-sm']") private WebElement Search_field_status;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public FL_Establishment_Trans_PermissionEntryFlow02_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 click_Establishment() throws InterruptedException {
	
		System.out.println("click on Establishment");
		Actions action= new Actions(driver);
		action.moveToElement(Establishment).build().perform();
		Thread.sleep(3000);
	//	Establishment.click();
		return this;
	}
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 click_Transaction() { 
		System.out.println("Click on Transactions");
		Transactions.click();
		return this;
	}
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 click_PermissionEntry() throws InterruptedException {
		System.out.println("Click on Permission Entry");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",permissionEntry);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", permissionEntry);

		return this;	
	}
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 click_NewApplication() {
		System.out.println("Click on New Application");
		NewApplication.click();
		return this;
	}
	

	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 Set_Date() throws InterruptedException {
		System.out.println("Set Date => ");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("//i[@class='fa fa-calendar text-blue']"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement currentDate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_today"));
		currentDate.click(); 
//		Thread.sleep(2000);
//		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_title"));
//		year_ttl.click(); 
//		Thread.sleep(2000);
//		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_year_1_2"));
//		year_select.click(); //year = 2025
//		Thread.sleep(2000);
//		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_month_0_3"));
//		month_select.click();  // month=april
//		Thread.sleep(2000);
//		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDate_day_0_5"));
//		date_select.click();    // day=4

		return this;
	}
	
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 Select_Reason() throws InterruptedException, IOException {
		System.out.println("Select reason => Automation");
		sendKeys(reason, "Automation");
				
		return this;
	}
	
	public  FL_Establishment_Trans_PermissionEntryFlow02_1 Click_SubmitBtn() throws InterruptedException, IOException {
		System.out.println("Click On Submit Btn");
		click(submitBtn);
				
		return this;
	}
	

}
