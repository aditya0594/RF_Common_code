package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
public class AL_Hostel_Report_AssetAllotmentReport extends BaseClass{

	public AL_Hostel_Report_AssetAllotmentReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlHostel-container")
	private WebElement Hostel;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnReport")
	private WebElement reportbtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Report_AssetAllotmentReport Hostelddl()
	{
		System.out.println("Selected Hostel -> KBA MENS HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown,"KBA MENS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Report_AssetAllotmentReport showbutton()
	{
		System.out.println("Click on the Show Button");
		click(reportbtn);
		return this;
	}
	
	public AL_Hostel_Report_AssetAllotmentReport HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Report_AssetAllotmentReport Report() 
	{
		System.out.println("Click on Report");
		WebElement subMenu = driver.findElement(By.linkText("Report"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_Report_AssetAllotmentReport Asset_Allotment_Report() 
	{
		System.out.println("Click on Asset Allotment Report");
		WebElement subMenu = driver.findElement(By.linkText("Asset Allotment Report"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
