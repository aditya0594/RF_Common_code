package Hostel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_HGP_GatePassApprovalFlow02_3 extends BaseClass
{
	public AL_Hostel_HGP_GatePassApprovalFlow02_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Gate Pass Approval") private WebElement gatePassApproval;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDateSearch") private WebElement fromDateSearch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDateSearch") private WebElement toDateSearch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement searchBtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchBox;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input[@value='Show']") private WebElement showBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStatus") private WebElement statusDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 clickGatePassApproval() {
		System.out.println("Click on Gate Pass Approval");
		click(gatePassApproval);
		return this;
	}
	
	public String getCurrentDate() {
		DateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy"); // dd-MM-yyyy
		Date date = new Date();
		String date1 = dateFormate.format(date);
		return date1;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 enterFromDate() {
//		String fromDate = "01/01/2025";
		System.out.println("Enter From Date: " + getCurrentDate());
		js.executeScript("arguments[0].value='" + getCurrentDate() + "';", fromDateSearch);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 enterToDate() {
//		String toDate = "01/01/2027";
		System.out.println("Enter To Date: " + getCurrentDate());
		js.executeScript("arguments[0].value='" + getCurrentDate() + "';", toDateSearch);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 clickSearchBtn() {
		System.out.println("Click on Search Button");
		click(searchBtn);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 searchCurrentDate() {
		System.out.println("Searching for current date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = dateFormat.format(new Date());
		sendKeys(searchBox, currentDate);
//		sendKeys(searchBox, "MOHAMED FAISAL");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 clickShowBtn() {
		System.out.println("Click on Show Button");
		click(showBtn);
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 selectStatus() {
		System.out.println("Select status: Approved");
		Select statusSelect = new Select(statusDropdown);
		statusSelect.selectByVisibleText("Approved");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassApprovalFlow02_3 clickSubmitBtn() {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();",submitBtn);
		click(submitBtn);
		return this;
	}
}
