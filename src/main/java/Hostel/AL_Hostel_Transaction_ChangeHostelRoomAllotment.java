package Hostel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class AL_Hostel_Transaction_ChangeHostelRoomAllotment extends BaseClass{
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_imgSearch")
	private WebElement Searchicon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch")
	private WebElement Searchtext;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch")
	private WebElement SearchBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")
	private WebElement Selectstud;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement HostelName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBlockName-container")
	private WebElement BlockName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlFloor-container")
	private WebElement FloorName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlRoomNo-container")
	private WebElement RoomName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlRoomType-container")
	private WebElement RoomType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRoomchangeDate")
	private WebElement RoomChangeDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkUpdateDemand")
	private WebElement updateDemand;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmit")
	private WebElement Submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement Reportbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lblmsg")
	private WebElement successmsg;
	@FindBy(id = "ctl00_ContentPlaceHolder1_updjoinDateClick")
	private WebElement updatejoindate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_textJoinDate")
	private WebElement JoiningDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUpdateJoinDate")
	private WebElement updatebtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Sessionddl() 
	{
		System.out.println("Selected Session -> 2023-2024");
		click(Session);
		sendKeys(SearchBoxOfDropDown, "2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Searchbox() 
	{
		System.out.println("Click on Preview icon to search student");
		click(Searchicon);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Searchstring() 
	{
		System.out.println("Entered Search string -> 210101601025");
		sendKeys(Searchtext, "210101601025");
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment SearchButton() 
	{
		System.out.println("Click on Search Button");
		click(SearchBtn);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment SelectStudent() 
	{
		System.out.println("Click on Student Name");
		click(Selectstud);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment HostelNameddl() 
	{
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", HostelName);
		js2.executeScript("arguments[0].click;", HostelName);
		
		System.out.println("Selected Hostel Name -> APNA Hostel");
		click(HostelName);
		sendKeys(SearchBoxOfDropDown, "APNA Hostel");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment BlockNameddl() 
	{
	
		System.out.println("Selected Block Name -> A BLOCK");
		click(BlockName);
		sendKeys(SearchBoxOfDropDown, "A BLOCK");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment FloorNameddl() 
	{
		System.out.println("Selected Floor Name -> FIRST FLOOR");
		click(FloorName);
		sendKeys(SearchBoxOfDropDown, "FIRST FLOOR");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment RoomNameddl() 
	{
		System.out.println("Selected Room -> AP-1");
		click(RoomName);
		sendKeys(SearchBoxOfDropDown, "AP-1");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment RoomTypeddl() 
	{
		System.out.println("Selected Room Type -> 4 Sharing Room");
		click(RoomType);
		sendKeys(SearchBoxOfDropDown, "4 Sharing Room");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment RoomChangeDate() 
	{
		System.out.println("Selected Room Change Date -> 10/10/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]", RoomChangeDate, "10/10/2024");
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Demandupdate() 
	{
		System.out.println("Click on Update Demand");
		click(updateDemand);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment SubmitButton() throws InterruptedException 
	{
		System.out.println("Click on Submit Button");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Submitbtn);
		Thread.sleep(2000);
		click(Submitbtn);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Successmessage() 
	{
		System.out.println(getText(successmsg));
		return this;
	}

	public AL_Hostel_Transaction_ChangeHostelRoomAllotment ReportButton() 
	{
		System.out.println("Click on Report Button");
		click(Reportbtn);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Forjoiningdateupdate() 
	{
		System.out.println("Click on For Joining Date Update");
		click(updatejoindate);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment JoiningDate() 
	{
		System.out.println("Selected Joining Date -> 10/10/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]",JoiningDate, "10/10/2024");
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", JoiningDate);
		js2.executeScript("arguments[0].click;", JoiningDate);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment updatebutton() 
	{
		System.out.println("click on update button");
		click(updatebtn);
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Transaction_ChangeHostelRoomAllotment Transaction() 
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
	

	public AL_Hostel_Transaction_ChangeHostelRoomAllotment ChangeRoomAllotment() 
	{
		System.out.println("Click on Change Hostel Room Allotment");
		WebElement subMenu = driver.findElement(By.linkText("Change Hostel Room Allotment"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

}
