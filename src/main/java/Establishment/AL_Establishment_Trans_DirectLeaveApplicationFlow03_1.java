package Establishment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 extends BaseClass {
	
	@FindBy(xpath = "(//a[contains(@class,'popout level1 static')][normalize-space()='ESTABLISHMENT'])[1]")
	private WebElement Establishment;
	@FindBy(linkText = "Transactions")
	private WebElement Transactions;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlLeaveType-container")
	private WebElement SelectLeaveType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromdt")
	private WebElement FromDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt")
	private WebElement ToDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtReason")
	private WebElement Reason;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement submit;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;
	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_imgCalFromdt")
//	private WebElement FromDateCalenderIcon;
//	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_imgCalTodt")
//	private WebElement ToDateCalenderIcon;
//	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_ceFromdt_nextArrow")
//	private WebElement NextIconFromDate;
//	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_CeTodt_nextArrow")
//	private WebElement NextIconToDate;
//	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_ceFromdt_day_1_3")
//	private WebElement SelectFromDate;
//	
//	@FindBy(id = "ctl00_ContentPlaceHolder1_ceFromdt_day_1_3")
//	private WebElement SelectToDate;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 click_Establishment() throws InterruptedException {
		System.out.println("click on Establishment");
		Actions action = new Actions(driver);
		action.moveToElement(Establishment).build().perform();
		Thread.sleep(3000);
		// Establishment.click();
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 Transactions() {
		System.out.println("Click on Transactions");
		Transactions.click();
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 DirectLeaveApplication() throws InterruptedException {
		System.out.println("Click on Direct Approval of Leave");
		Thread.sleep(2000);
		
		WebElement Directleave = driver.findElement(By.linkText("Direct Leave Application"));
		js.executeScript("arguments[0].scrollIntoView();", Directleave);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Directleave);
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 Select_college() throws InterruptedException, IOException {
		System.out.println("Fill details");
		// college name
		System.out.println("Select college name");
//		WebElement clg = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege-container"));
//		Select typ_clg = new Select(clg);
//		typ_clg.selectByVisibleText("Crescent School of Architecture");
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege-container"));
		Session.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Architecture",
				Keys.ENTER);
		System.out.println("Select_college - > Crescent School of Architecture");
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 Selec_staff() {
		// Select staff type
		System.out.println("Select Staff type");
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStafftype-container"));
		Session.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Teaching Staff", Keys.ENTER);
		System.out.println("Select Staff Type - > Admin NTS");
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 EmployeeName() {
		// select Department
		System.out.println("Select EmployeeName");
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlEmp-container"));
		Session.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("2021008 - VENKATESAN  MURTHY", Keys.ENTER);
		System.out.println("Select Employee Name - > 020227 - SANKETpw SANKET sanket");
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 SelectLeaveName() {
		// select Department
		System.out.println("Select SelectLeaveType");
//		Select typ_dept = new Select(SelectLeaveType);
//		typ_dept.selectByVisibleText("SelectLeaveType");
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlLName-container"));
		Session.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Casual Leave- YEARLY", Keys.ENTER);
		System.out.println("Select Leave Type - > Casual Leave");
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 FromDate() throws Throwable {
		// select month and year
		System.out.println("FromDate");
		Thread.sleep(2000);
		WebElement FromDateCalenderIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromdt"));
		click(FromDateCalenderIcon);
		Thread.sleep(2000);
		WebElement yearTitle = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_title"));
		click(yearTitle);
		Thread.sleep(2000);
		click(yearTitle);
		Thread.sleep(2000);
		WebElement yearSelct = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_year_1_3"));
		click(yearSelct);//year select = 2026
		Thread.sleep(2000);
		WebElement monthSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_month_0_1"));
		click(monthSelect); //year select = Feb
		Thread.sleep(2000);
		WebElement dateSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_day_1_3"));
		click(dateSelect); //year day = 4
		
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 ToDate() throws Throwable {
		// select month and year
		System.out.println("ToDate");
		Thread.sleep(2000);
		WebElement FromDateCalenderIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalTodt"));
		click(FromDateCalenderIcon);
		Thread.sleep(2000);
		WebElement yearTitle = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_title"));
		click(yearTitle);
		Thread.sleep(2000);
		click(yearTitle);
		Thread.sleep(2000);
		WebElement yearSelct = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_year_1_3"));
		click(yearSelct);//year select = 2026
		Thread.sleep(2000);
		WebElement monthSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_month_0_1"));
		click(monthSelect); //year select = Feb
		Thread.sleep(2000);
		WebElement dateSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_day_1_3"));
		click(dateSelect); //year day = 4
		return this;
	}
	
	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 Reason() throws InterruptedException {
		// select month and year
		System.out.println("Enter Reason");
		Reason.click();
		
		Thread.sleep(2000);
		Reason.clear();
		Reason.sendKeys("Test");
		return this;
	}

	public AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 submit() throws InterruptedException, IOException {
		// Generate report
		System.out.println("Click on show");
		submit.click();
		return this;
	}
}
