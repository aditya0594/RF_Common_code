package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_Master_HostelAttendanceIncharge extends BaseClass {
	public AL_Hostel_Master_HostelAttendanceIncharge(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	public AL_Hostel_Master_HostelAttendanceIncharge HOSTEL() {
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Hostel_Master_HostelAttendanceIncharge Master() {
		System.out.println("Click on Masters");
		WebElement subMenu = driver.findElement(By.linkText("Masters"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

	public AL_Hostel_Master_HostelAttendanceIncharge HostelStaffInformation() {
		System.out.println("Click on Hostel Attendance Incharge");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Attendance Incharge"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_Master_HostelAttendanceIncharge HostelName() {
		System.out.println("Click on Hostel Name");
		System.out.println("Selected Hostel -> KBA MENS HOSTEL");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlHostelName-container")).click();
		sendKeys(SearchBoxOfDropDown,"KBA MENS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Master_HostelAttendanceIncharge BlockName() throws Exception {
		System.out.println("Click on Hostel Name");
		System.out.println("Selected Hostel -> DEMO-BLOCK");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBlock-container")).click();
		sendKeys(SearchBoxOfDropDown,"A BLOCK");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Master_HostelAttendanceIncharge InchargeName() {
		System.out.println("Click on Hostel Name");
		System.out.println("Selected Hostel -> hodit->hodit");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlIncharge-container")).click();
		sendKeys(SearchBoxOfDropDown,"hodit->hodit");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Master_HostelAttendanceIncharge submit() {
		System.out.println("Click on submit");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
		return this;
	}
}
