package Administration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_VM_Trans_LogbookEntry extends BaseClass
{
	public AL_Administration_VM_Trans_LogbookEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Logbook Entry") private WebElement logbookEntryLink;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlVehicle-container") private WebElement vehicleSelectTab;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchTextbox;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlTripTypr-container") private WebElement tripTypeSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTourDate") private WebElement tourDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDepTime") private WebElement departureTimeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromLoc") private WebElement fromLocationField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToLoc") private WebElement toLocationField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSMeterReading") private WebElement startMeterReadingField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDriver-container") private WebElement driverSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_lvFitness_FilterData2'])[1]") private WebElement searchVehicleField;
	@FindBy(xpath = "//input[@title='Delete Record']") private WebElement deleteIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement yesBtn;
	
	public AL_Administration_VM_Trans_LogbookEntry Click_LogbookEntryLink() throws Exception {
		System.out.println("Click on Logbook Entry link");
		js.executeScript("arguments[0].scrollIntoView();", logbookEntryLink);
		threadWait1();
		js.executeScript("arguments[0].click();", logbookEntryLink);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => AS1421:Tata Bus");
		vehicleSelectTab.click();
		searchTextbox.sendKeys("AS1421:Tata Bus");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Select_TripType() throws Exception {
		System.out.println("Select Trip Type => industrial vist");
		tripTypeSelectTab.click();
		searchTextbox.sendKeys("industrial vist");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Enter_TourDate() throws Exception {
		System.out.println("Enter Tour Date => 01/01/2025");
		js.executeScript("arguments[0].value = arguments[1]",tourDateField, "01/01/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Enter_DepartureTime() throws Exception {
		System.out.println("Enter Departure Time => 07:00");
		js.executeScript("arguments[0].value = arguments[1]",departureTimeField, "07:00");

		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Enter_FromLocation() throws Exception {
		System.out.println("Enter From Location => Nagpur");
		fromLocationField.clear();
		fromLocationField.sendKeys("Nagpur");
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Enter_ToLocation() throws Exception {
		// Generate random destination
		String[] destinations = {"Mumbai", "Delhi", "Pune", "Bangalore", "Chennai"};
		int randomIndex = (int)(Math.random() * destinations.length);
		String toLocation = destinations[randomIndex];
		
		System.out.println("Enter To Location => " + toLocation);
		toLocationField.clear();
		toLocationField.sendKeys(toLocation);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Enter_StartMeterReading() throws Exception {
		System.out.println("Enter Start Meter Reading => 10455");
		startMeterReadingField.clear();
		startMeterReadingField.sendKeys("10455");
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Select_Driver() throws Exception {
		System.out.println("Select Driver => Amisha patel");
		driverSelectTab.click();
		threadWait1();
		searchTextbox.sendKeys("Amisha patel");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Search_Vehicle() throws Exception {
		System.out.println("Search Vehicle => AS1421:Tata Bus");
		js.executeScript("arguments[0].scrollIntoView();", searchVehicleField);
		searchVehicleField.clear();
		searchVehicleField.sendKeys("AS1421:Tata Bus");
		WebElement searchtab = driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]"));
		searchtab.click();
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Click_DeleteIcon() throws Exception {
		System.out.println("Click on Delete Icon");
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", deleteIcon);
		return this;
	}
	
	public AL_Administration_VM_Trans_LogbookEntry Click_YesBtn() throws Exception {
		System.out.println("Click on Yes button to confirm deletion");
		threadWait1();
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
