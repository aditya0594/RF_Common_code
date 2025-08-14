package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AL_Hostel_Report_RoomAllotmentStatus extends BaseClass {

	public AL_Hostel_Report_RoomAllotmentStatus(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement Hostel;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnstud")
	private WebElement studbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnvacantroom")
	private WebElement vacantbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnStudentAllotedReport")
	private WebElement allotbtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudFromDate")
	private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement todate;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Hostel_Report_RoomAllotmentStatus sessionddl() {
		System.out.println("Selected Session -> 2023-2024");
		click(Session);
		sendKeys(SearchBoxOfDropDown, "2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus hostelddl() {
		System.out.println("Selected Hostel -> KBA MENS HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown, "KBA MENS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus showbutton() {
		System.out.println("click on the show button");
		click(showbtn);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus StudentListForHostelbutton() {
		System.out.println("click on the Student List For Hostel");
		click(studbtn);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus VacantReportofRoombutton() {
		System.out.println("click on the Vacant Report of Room");
		click(vacantbtn);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus StudentAllotmentVacantReportbutton() {
		System.out.println("click on the Student Allotment Vacant Report");
		click(allotbtn);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus HOSTEL() {
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus Report() {
		System.out.println("Click on Report");
		WebElement subMenu = driver.findElement(By.linkText("Report"));
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus Room_Allotment_Status() {
		System.out.println("Click on Room Allotment Status");
		WebElement subMenu = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlRptType-container"));
		subMenu.click();
		WebElement subMenu1 = driver.findElement(By.xpath("//*[@class=\"select2-search__field\"]"));
		subMenu1.sendKeys("Room Allotment Status", Keys.ENTER);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus Select_FromDate() {
		System.out.println("Enter From Date");
		js.executeScript("arguments[0].value='01/01/2021';", fromdate);
		return this;
	}

	public AL_Hostel_Report_RoomAllotmentStatus Select_ToDate() {
		System.out.println("Enter To Date");
		js.executeScript("arguments[0].value='19/12/2024';", todate);
		return this;
	}
}
