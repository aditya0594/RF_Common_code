package Hostel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_HGP_GatePassRequestFlow02_2 extends BaseClass
{
	public AL_Hostel_HGP_GatePassRequestFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl03_lbLink") private WebElement GatePassRequest;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnGatePassRequest")private WebElement applygatepassBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtoutDate")private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtinDate")private WebElement todate;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnSearch'])[1]")private WebElement searchbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch")private WebElement studentselect;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStuType")private WebElement studenttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAM_PM1")private WebElement OutdateAmPM;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAM_PM2")private WebElement InDateAMPM;

	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]")private WebElement SearchBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPurpose")private WebElement purpose;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")private WebElement submitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 GatePassRequest() {
		System.out.println("Click on Gate Pass Request");
		click(GatePassRequest);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Click_ApplyGatePassBtn() {
		System.out.println("Click on Apply Gate Pass");
		click(applygatepassBtn);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_Student() {
		System.out.println("Select Student => 200071601010 - ABDULLAHMOHAMED. M");
		Select select = new Select(studentselect);
		select.selectByVisibleText("200071601010 - ABDULLAHMOHAMED. M");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_StudentType() {
		System.out.println("Select Student Type => General");
		Select select = new Select(studenttype);
		select.selectByVisibleText("General");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_OutDatee() {
		// Get current date using Java 8 LocalDate
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		// Format date as dd/MM/yyyy
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		
		System.out.println("Select Out Date => Current date: " + formattedDate);
		
		// Set the current date in the date field using JavaScript
		js.executeScript("arguments[0].value = arguments[1]", fromdate, formattedDate);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_OUTAMPM() {
		System.out.println("Select Out AM/PM ");
		Select select = new Select(OutdateAmPM);
		select.selectByVisibleText("PM");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_InDate() {
		// Get current date using Java 8 LocalDate
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		// Add one day to get next day's date
		java.time.LocalDate nextDay = currentDate.plusDays(1);
		// Format date as dd/MM/yyyy
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = nextDay.format(formatter);
		
		System.out.println("Select In Date => Next day: " + formattedDate);
		
		// Set the next day date in the date field using JavaScript
		js.executeScript("arguments[0].value = arguments[1]", todate, formattedDate);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_INAMPM() {
		System.out.println("Select IN AM/PM ");
		Select select = new Select(InDateAMPM);
		select.selectByVisibleText("PM");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Select_Purpose() {
		System.out.println("Select Purpose => OUTING");
		Select select = new Select(purpose);
		select.selectByVisibleText("OUTING");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestFlow02_2 Click_SubmitBtn() {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		return this;
	}
	
}
