package Hostel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
public class AL_Hostel_Report_HostelStudentAddress extends BaseClass{
	public AL_Hostel_Report_HostelStudentAddress(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlHostelSessionNo-container")
	private WebElement Session;
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement Hostel;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnReport")
	private WebElement reportbtn;
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlDegree-container")
	private WebElement degree;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Report_HostelStudentAddress sessionddl() 
	{
		System.out.println("Selected Hostel Session -> 2023-2024");
		click(Session);
		sendKeys(SearchBoxOfDropDown,"2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public AL_Hostel_Report_HostelStudentAddress hostelddl() 
	{
		System.out.println("Selected Hostel Name -> Test Boys Hostel");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown,"Test Boys Hostel");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public AL_Hostel_Report_HostelStudentAddress Degreeddl() 
	{
		System.out.println("Selected Degree -> Bachelor of Architecture");
		click(degree);
		sendKeys(SearchBoxOfDropDown,"Bachelor of Architecture");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public AL_Hostel_Report_HostelStudentAddress showbutton() 
	{
		System.out.println("Click on the Report button");
		click(reportbtn);	
		return this;
	}
	
	public AL_Hostel_Report_HostelStudentAddress HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Report_HostelStudentAddress Report() 
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
	
	public AL_Hostel_Report_HostelStudentAddress HostelStudentAddress() 
	{
		System.out.println("Click on Hostel Student Address ");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Student Address"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
