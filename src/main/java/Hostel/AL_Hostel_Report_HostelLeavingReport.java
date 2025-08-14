package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
public class AL_Hostel_Report_HostelLeavingReport extends BaseClass {

	private static final String classname = null;
	public AL_Hostel_Report_HostelLeavingReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement Hostel;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnstud")
	private WebElement btnsubmit;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Report_HostelLeavingReport Sessionddl() 
	{
		System.out.println("Selected Session -> 2023-2024");
		click(Session);
		sendKeys(SearchBoxOfDropDown,"2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	public AL_Hostel_Report_HostelLeavingReport Hostelddl() 
	{
		System.out.println("Selected Hostel -> KBA MENS HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown,"KBA MENS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Hostel_Report_HostelLeavingReport StudentListForHostelbtn() 
	{
		System.out.println("click on the Student List For Hostel");
		click(btnsubmit);
		return this;
	}
	
	public AL_Hostel_Report_HostelLeavingReport HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Report_HostelLeavingReport Report() 
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
	
	public AL_Hostel_Report_HostelLeavingReport Hostel_Leaving_Report() 
	{
		System.out.println("Click on Hostel Leaving Report");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Leaving Report"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
