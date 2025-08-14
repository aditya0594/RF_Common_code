package Administration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class AL_Administration_VM_Trans_ArrivalTimeEntry extends BaseClass
{
	public AL_Administration_VM_Trans_ArrivalTimeEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Define web elements using locators provided
	@FindBy(linkText = "Arrival Time Entry") private WebElement arrivalTimeEntryLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ceFromdate_today") private WebElement  currentdate;
	@FindBy(xpath = "//i[@class='fa fa-calendar text-blue']") private WebElement calendericon;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRouteNo") private WebElement routeNumberDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtArrivalTime") private WebElement arrivalTimeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement addBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAcbus38") private WebElement acBus38CountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAcbus55") private WebElement acBus55CountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDedicatedbus") private WebElement dedicatedBusCountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtbus") private WebElement busCountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnreport_show") private WebElement showReportBtn;
	
	// File to store the last used date
	private final String DATE_FILE = System.getProperty("user.dir") + "/last_arrival_date.txt";
	
	/**
	 * Click on Arrival Time Entry link
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Click_ArrivalTimeEntryLink() throws Exception {
		System.out.println("Click on Arrival Time Entry link");
		js.executeScript("arguments[0].scrollIntoView();", arrivalTimeEntryLink);
		js.executeScript("arguments[0].click();", arrivalTimeEntryLink);
		return this;
	}

	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_ArrivalDate() throws Exception {
		System.out.println("Enter Arrival Date => current date");
		calendericon.click();
		Thread.sleep(2000);
		currentdate.click();
		return this;
	}

	public AL_Administration_VM_Trans_ArrivalTimeEntry Select_Route() throws Exception {
		System.out.println("Select Route => Main Office To MIhan");
		Select select = new Select(routeNumberDropdown);
		select.selectByVisibleText("Main Office To MIhan");
		return this;
	}
	
	/**
	 * Enter arrival time
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_ArrivalTime() throws Exception {
		System.out.println("Enter Arrival Time => 07:00 AM");
//		js.executeScript("arguments[0].scrollIntoView();", arrivalTimeField);
		arrivalTimeField.clear();
		js.executeScript("arguments[0].value = arguments[1]",arrivalTimeField, "07:00 AM");
		return this;
	}
	
	/**
	 * Click on Add button
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Click_AddBtn() throws Exception {
		System.out.println("Click on Add button");
//		js.executeScript("arguments[0].scrollIntoView();", addBtn);
//		js.executeScript("arguments[0].click();", addBtn);
		addBtn.click();
		return this;
	}
	
	/**
	 * Enter AC Bus 38 count
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_ACBus38Count() throws Exception {
		System.out.println("Enter AC Bus 38 Count => 1");
//		js.executeScript("arguments[0].scrollIntoView();", acBus38CountField);
		acBus38CountField.clear();
		acBus38CountField.sendKeys("1");
		return this;
	}
	
	/**
	 * Enter AC Bus 55 count
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_ACBus55Count() throws Exception {
		System.out.println("Enter AC Bus 55 Count => 0");
//		js.executeScript("arguments[0].scrollIntoView();", acBus55CountField);
		acBus55CountField.clear();
		acBus55CountField.sendKeys("0");
		return this;
	}
	
	/**
	 * Enter Dedicated Bus count
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_DedicatedBusCount() throws Exception {
		System.out.println("Enter Dedicated Bus Count => 0");
//		js.executeScript("arguments[0].scrollIntoView();", dedicatedBusCountField);
		dedicatedBusCountField.clear();
		dedicatedBusCountField.sendKeys("0");
		return this;
	}
	
	/**
	 * Enter Bus count
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Enter_BusCount() throws Exception {
		System.out.println("Enter Bus Count => 0");
//		js.executeScript("arguments[0].scrollIntoView();", busCountField);
		busCountField.clear();
		busCountField.sendKeys("0");
		return this;
	}
	
	/**
	 * Click on Submit button
	 * @return this page object
	 */
	public AL_Administration_VM_Trans_ArrivalTimeEntry Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit button");
//		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	

	public AL_Administration_VM_Trans_ArrivalTimeEntry Click_ShowReportBtn() throws Exception {
		System.out.println("Click on Show Report button");
//		js.executeScript("arguments[0].scrollIntoView();", showReportBtn);
		js.executeScript("arguments[0].click();", showReportBtn);
		return this;
	}
}
