package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_Transaction_HostelRoomBookingFlow01_1 extends BaseClass {

	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement HostelSession;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostel-container")
	private WebElement HostelName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDeg-container")
	private WebElement Degree;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container")
	private WebElement Semester;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement Showroombtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRow_2_Col_2")
	private WebElement ClickonRoom;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearchStud")
	private WebElement SearchStudent;
	@FindBy(id = "btnSearchStud")
	private WebElement SearchStudbtn;
	@FindBy(id = "chkSelect")
	private WebElement SelectStudent;	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_txtJoinDate")
	private WebElement DOJ;
	@FindBy(id = "btnAllotRoom")
	private WebElement AllotRoomBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_imbClose")
	private WebElement CloseBtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 HostelSessionddl()
	{
		System.out.println("Selected Hostel Session -> 2023-2024 ");
		click(HostelSession);
		sendKeys(SearchBoxOfDropDown, "2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 HostelNameddl()
	{
		System.out.println("Selected Hostel Name -> CRESCENT HOSTEL");
		click(HostelName);
		sendKeys(SearchBoxOfDropDown, "CRESCENT HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 Degreeddl()
	{
		System.out.println("Selected Degree -> Bachelor of Pharmacy");
		click(Degree);
		sendKeys(SearchBoxOfDropDown, "Bachelor of Pharmacy");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 Semesterddl()
	{
		System.out.println("Selected Semester -> III");
		click(Semester);
		sendKeys(SearchBoxOfDropDown, "III");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 ShowRoombutton()
	{
		System.out.println("Click on Show button");
		click(Showroombtn);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 ClickOnRoom()
	{
		System.out.println("Click on crescent-room2");
		click(ClickonRoom);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 SearchStudentText()
	{
		System.out.println("Search Student -> 218021601059");
		sendKeys(SearchStudent, "218021601059");
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 SearchStudentButton()
	{
		System.out.println("Click on Search Student Button");
		click(SearchStudbtn);
		return this;
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 SelectStudent()
	{
		System.out.println("Select Student");
		js.executeScript("arguments[0].scrollIntoView();",SelectStudent);
		js.executeScript("arguments[0].click();", SelectStudent);
//		click(SelectStudent);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 doj()
	{
		System.out.println("Select Date of Joining -> 30/10/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]",DOJ, "16/07/2025");
  		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 AllotRoomButton()
	{
		System.out.println("Click on Allot Room Button");
		click(AllotRoomBtn);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 ClosePopupButton()
	{
		System.out.println("Close the pop up window");
		click(CloseBtn);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 Transaction() 
	{
		System.out.println("Click on Transaction");
		WebElement subMenu = driver.findElement(By.linkText("Transaction"));
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_Transaction_HostelRoomBookingFlow01_1 Hostel_Room_Booking() 
	{
		System.out.println("Click on Hostel Room Booking");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Room Booking"));
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}
}
