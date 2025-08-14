package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AM_ScheduleandRoomOccupancy extends BaseClass{

	public AL_Academic_AM_ScheduleandRoomOccupancy(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl15_lbLink") private WebElement scheduleAndRoomOccupancy_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSelect") private WebElement select_dropdown;
	@FindBy(xpath = "//i[@class='fa fa-calendar text-blue']") private WebElement calenderIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_CalendarExtender2_today") private WebElement currentDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlType") private WebElement type_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(xpath = "(//td[normalize-space()='1ST-FLOOR'])[1]") private WebElement text;

	
	
	public AL_Academic_AM_ScheduleandRoomOccupancy click_scheduleAndRoomOccupancy_link() 
	{
		System.out.println("Click Redo Course Regestration List Report Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				scheduleAndRoomOccupancy_link
				);

		// Optionally, interact with the target element
		click(scheduleAndRoomOccupancy_link);
		//attendanceEmailTrigger_link.click();
		
		return this;
	}
	public AL_Academic_AM_ScheduleandRoomOccupancy select_scheduleAndRoomOccupancy() 
	{
		System.out.println("Select Schedule and Room Occupancy");
		Select options = new Select(select_dropdown);
		options.selectByVisibleText("Schedule and Room Occupancy");
		return this;
	}
	public AL_Academic_AM_ScheduleandRoomOccupancy enter_fromDate() throws InterruptedException 
	{
		System.out.println("Enter Current date");
		click(calenderIcon);
		Thread.sleep(2000);
		click(currentDate);
		return this;
	}
	public AL_Academic_AM_ScheduleandRoomOccupancy select_type() 
	{
		Select options = new Select(type_dropdown);
		options.selectByVisibleText("Room Occupancy");
		return this;
	}
	public AL_Academic_AM_ScheduleandRoomOccupancy click_show_button() 
	{
		show_button.click();
		return this;
	}
	
	public String  getTextFromElement() {
		text.getText();
		return text.getText(); // Retrieves the text from the located element
	}
	
	
}
