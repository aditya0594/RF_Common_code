package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 extends BaseClass {

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"ctl00_mainMenu\"]/ul/li[5]/a")
	private WebElement ESTBALISHMENT;
	
	@FindBy(linkText="Transactions")
	private WebElement Transaction;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvLeaveinfo_ctrl0_btnApply")
	private WebElement ApplyLeave;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rblleavetype_0")
	private WebElement LeaveType;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromdt")
	private WebElement FromDate;

	@FindBy(id= "ctl00_ContentPlaceHolder1_txtTodt")
	private WebElement Todate;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_txtReason\"]")
	private WebElement Reason;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtcharge\"]")
	private WebElement AlternateArran;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	private WebElement SubmitButton;

	JavascriptExecutor js2 = (JavascriptExecutor) driver;

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 ESTBALISHMENT() {
		System.out.println("Click on ESTBALISHMENT");
		Actions action = new Actions(driver);
		action.moveToElement(ESTBALISHMENT).build().perform();
		//ESTBALISHMENT.click();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 Transaction() {
		System.out.println("Click on Transactions ");
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 LeaveAlloment() throws Exception {
		System.out.println("Click on Leave Alloment");
		WebElement optn = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		Thread.sleep(2000);
		// js2.executeScript("arguments[0].scrollIntoView();", optn);
		Thread.sleep(2000);
		js2.executeScript("arguments[0].click;", optn);
		optn.click();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 ApplyLeave() {
		System.out.println("Click on  ApplyLeave");
		ApplyLeave.click();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 LeaveType() {
		System.out.println("Click on  LeaveType");
		LeaveType.click();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 FromDate() throws InterruptedException {
		System.out.println("Click on  FromDate => 30/12/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromdt"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_month_2_3"));
		month_select.click();  // month=Dec
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_day_4_2"));
		date_select.click();    // day=30
		return this;
	}
	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 Todate() throws InterruptedException {
		System.out.println("Click on  Todate =>30/12/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalTodt"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_month_2_3"));
		month_select.click();  // month=Dec
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_day_4_2"));
		date_select.click();    // day=30
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 Reason() {
		System.out.println("Enter Reason Button => Testing Automation");
		Reason.click();
		Reason.sendKeys("Testing Automation");
		return this;
	}
	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 AlternateArran() {
		System.out.println("Enter Alternate Arrangement => Sachin Tendulkar");
		AlternateArran.click();
		AlternateArran.sendKeys("Sachin Tendulkar");
		return this;
	}
	
	
	public FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 SubmitButton() {
		System.out.println("Click on Submit Button ");
		SubmitButton.click();
		return this;
	}
	
	
//	public ApproveLeaveStudent SelectSession() throws InterruptedException {
//		System.out.println("Session -> DEC 2021");
//		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
//		Select sessn = new Select(session);
//		sessn.selectByVisibleText("DEC 2021");
//		return this;
//	}

}