package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_Transaction_GuestRoomAllotment extends BaseClass {

	public AL_Hostel_Transaction_GuestRoomAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement AllotReport;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlGuestList-container")
	private WebElement SelectGuest;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	public AL_Hostel_Transaction_GuestRoomAllotment SelectGuest() {

		System.out.println("Click on SelectGuest - DEMOPERSON");
		click(SelectGuest);
		SearchBoxOfDropDown.sendKeys("himanshu", Keys.ENTER);
		return this;
	}

	public AL_Hostel_Transaction_GuestRoomAllotment AllotReport() {

		System.out.println("AllotReport");
		click(AllotReport);
		return this;
	}

	public AL_Hostel_Transaction_GuestRoomAllotment HOSTEL() {
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Hostel_Transaction_GuestRoomAllotment Transaction() {
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

	public AL_Hostel_Transaction_GuestRoomAllotment GuestRoomAllotment() {
		System.out.println("Click on Guest Room Allotment");
		WebElement subMenu = driver.findElement(By.linkText("Guest Room Allotment"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
