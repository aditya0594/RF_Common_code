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

import utility.BaseClass;

public class AL_Administration_VM_Trans_Insurance extends BaseClass
{
	public AL_Administration_VM_Trans_Insurance(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Insurance") private WebElement insuranceLink;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddl-container") private WebElement vehicleSelectTab;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchTextbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtValid") private WebElement validForField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlyear-container") private WebElement yearMonthSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPolicyNo") private WebElement policyNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtInsDt") private WebElement insFromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtInsEndDt") private WebElement insToDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPrem") private WebElement premiumAmountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAgntNo") private WebElement agentNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAgntPh") private WebElement agentPhoneField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchVehicleField;
	@FindBy(xpath = "//input[@title='Delete Record']") private WebElement deleteIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement yesBtn;
	
	public AL_Administration_VM_Trans_Insurance Click_InsuranceLink() throws Exception {
		System.out.println("Click on Insurance link");
		js.executeScript("arguments[0].scrollIntoView();", insuranceLink);
		js.executeScript("arguments[0].click();", insuranceLink);
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => AS1421:Tata Bus");
		vehicleSelectTab.click();
		searchTextbox.sendKeys("AS1421:Tata Bus");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	
	public AL_Administration_VM_Trans_Insurance Enter_PolicyNumber() throws Exception {
		// Generate unique policy number using timestamp
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String policyNo = "POL" + now.format(formatter);
		
		System.out.println("Enter Policy Number => " + policyNo);
		policyNumberField.clear();
		policyNumberField.sendKeys(policyNo);
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Enter_InsFromDate() throws Exception {
		System.out.println("Enter Insurance From Date => 01/01/2025");
		insFromDateField.clear();
		insFromDateField.sendKeys("01/01/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Enter_InsToDate() throws Exception {
		System.out.println("Enter Insurance To Date => 01/08/2025");
		insToDateField.clear();
		insToDateField.sendKeys("01/08/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Enter_PremiumAmount() throws Exception {
		System.out.println("Enter Premium Amount => 2105");
		premiumAmountField.clear();
		premiumAmountField.sendKeys("2105");
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Enter_AgentNumber() throws Exception {
		System.out.println("Enter Agent Number => 7575");
		agentNumberField.clear();
		agentNumberField.sendKeys("7575");
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Enter_AgentPhone() throws Exception {
		System.out.println("Enter Agent Phone => 1234567809");
		agentPhoneField.clear();
		agentPhoneField.sendKeys("1234567809");
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Search_Vehicle() throws Exception {
		System.out.println("Search Vehicle => AS1421:Tata Bus");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", searchVehicleField);
		searchVehicleField.clear();
		searchVehicleField.sendKeys("AS1421:Tata Bus");
		searchVehicleField.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Click_DeleteIcon() throws Exception {
		System.out.println("Click on Delete Icon");
		js.executeScript("arguments[0].click();", deleteIcon);
		return this;
	}
	
	public AL_Administration_VM_Trans_Insurance Click_YesBtn() throws Exception {
		System.out.println("Click on Yes button to confirm deletion");
		js.executeScript("arguments[0].click();", yesBtn);
		return this;
	}
	
	public String Get_AlertText() throws Exception {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void Accept_Alert() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
