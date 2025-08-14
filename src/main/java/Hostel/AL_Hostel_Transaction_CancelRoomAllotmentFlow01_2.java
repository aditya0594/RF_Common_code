package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 extends BaseClass {
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_chkrommwise")
	private WebElement RoomWiseCancel;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlsessionroom-container")
	private WebElement Session;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement Hostel;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBlock-container")
	private WebElement Block;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlFloor-container")
	private WebElement Floor;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlroomno-container")
	private WebElement Room;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkCancelDemand")
	private WebElement ChxCancelDemand;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnshowstudlist")
	private WebElement btnshow1;
	@FindBy(id = "chkSelect")
	private WebElement StudentSelect1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btncancelroomallotment")
	private WebElement StudentSubmitcan;
	
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input[@type='text']")
	private WebElement Reasonofcancel;
	@FindBy(xpath= "//*[@id=\"table2_filter\"]/label/input")
	private WebElement Searchstudent;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	@FindBy(className ="form-control")
	private WebElement cancelreason;

	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 RoomWiseCancellation()
	{
		System.out.println("Click on Cancel Room Allotment");
		click(RoomWiseCancel);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Sessionddl() 
	{
		System.out.println("Selected Session -> 2023-2024 ");
		click(Session);
		sendKeys(SearchBoxOfDropDown, "2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Hostelddl()
	{
		System.out.println("Selected Hostel -> CRESCENT HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown, "CRESCENT HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Blockddl()
	{
		System.out.println("Selected Block -> CRES-B1");
		click(Block);
		sendKeys(SearchBoxOfDropDown, "CRES-B1");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Floorddl()
	{
		System.out.println("Selected Floor -> CRES-F1");
		click(Floor);
		sendKeys(SearchBoxOfDropDown, "CRES-F1");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Roomddl()
	{
		System.out.println("Selected Room -> crescent-room2");
		click(Room);
		sendKeys(SearchBoxOfDropDown, "crescent-room2");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 CancelDemand()
	{
		System.out.println("Click on Cancel Demand Check box");
		click(ChxCancelDemand);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 ShowButton1()
	{
		System.out.println("Click on Show Button");
		click(btnshow1);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Searchingrid()
	{
		System.out.println("Search student -> 218021601059");
		sendKeys(Searchstudent, "218021601059");
		Searchstudent.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 StudentSelectCancel()
	{
		System.out.println("Select Student -> 210071601082");
		click(StudentSelect1);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 ReasonforCancellation()
	{
		System.out.println("Entered Reason for Cancellation -> Fees Not Paid");
	    sendKeys(Reasonofcancel, "Fees Not Paid by student");
		return this;
	}

	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 StudentSubmitCancelbtn()
	{
		System.out.println("Click on Submit button");
		click(StudentSubmitcan);
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Transaction() 
	{
		System.out.println("Click on Transaction");
		WebElement subMenu = driver.findElement(By.linkText("Transaction"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 Cancel_Room_Allotment() 
	{
		System.out.println("Click on Cancel Room Allotment");
		WebElement subMenu = driver.findElement(By.linkText("Cancel Room Allotment"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
