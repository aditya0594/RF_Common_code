package Administration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Administration_VM_Trans_Fitness extends BaseClass
{
	public AL_Administration_VM_Trans_Fitness(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fitness") private WebElement fitnessLink;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddl-container") private WebElement vehicleSelectTab;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchTextbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFtDt") private WebElement fitnessTestDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFitNo") private WebElement fitnessNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchVehicleField;
	@FindBy(xpath = "//input[@title='Delete Record']") private WebElement deleteIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement yesBtn;
	
	public AL_Administration_VM_Trans_Fitness Click_FitnessLink() throws Exception {
		System.out.println("Click on Fitness link");
		js.executeScript("arguments[0].scrollIntoView();", fitnessLink);
		threadWait1();
		js.executeScript("arguments[0].click();", fitnessLink);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => AS1421:Tata Bus");
		vehicleSelectTab.click();
		threadWait1();
		searchTextbox.sendKeys("AS1421:Tata Bus");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Enter_FromDate() throws Exception {
		System.out.println("Enter From Date => 01/01/2025");
		js.executeScript("arguments[0].scrollIntoView();", fromDateField);
		threadWait1();
		fromDateField.clear();
		fromDateField.sendKeys("01/01/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Enter_ToDate() throws Exception {
		System.out.println("Enter To Date => 01/08/2025");
		toDateField.clear();
		toDateField.sendKeys("01/08/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Enter_FitnessTestDate() throws Exception {
		System.out.println("Enter Fitness Test Date => 01/01/2025");
		fitnessTestDateField.clear();
		fitnessTestDateField.sendKeys("01/01/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Enter_FitnessNumber() throws Exception {
		// Generate unique fitness number using timestamp
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String fitnessNo = "FIT" + now.format(formatter);
		
		System.out.println("Enter Fitness Number => " + fitnessNo);
		fitnessNumberField.clear();
		fitnessNumberField.sendKeys(fitnessNo);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Search_Vehicle() throws Exception {
		System.out.println("Search Vehicle => AS1421:Tata Bus");
		threadWait1();
		searchVehicleField.clear();
		searchVehicleField.sendKeys("AS1421:Tata Bus");
		searchVehicleField.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Click_DeleteIcon() throws Exception {
		System.out.println("Click on Delete Icon");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", deleteIcon);
		js.executeScript("arguments[0].click();", deleteIcon);
		return this;
	}
	
	public AL_Administration_VM_Trans_Fitness Click_YesBtn() throws Exception {
		System.out.println("Click on Yes button to confirm deletion");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", yesBtn);
		js.executeScript("arguments[0].click();", yesBtn);
		threadWait1();
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record deleted successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	

}
