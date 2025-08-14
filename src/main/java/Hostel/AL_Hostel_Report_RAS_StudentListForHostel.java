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
public class AL_Hostel_Report_RAS_StudentListForHostel extends BaseClass{
	public AL_Hostel_Report_RAS_StudentListForHostel(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement Hostel;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnShow")
	private WebElement reportbtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudFromDate")
	private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement todate;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Hostel_Report_RAS_StudentListForHostel sessionddl() 
	{
		System.out.println("Selected Session -> 2023-2024");
		click(Session);
		sendKeys(SearchBoxOfDropDown,"2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public AL_Hostel_Report_RAS_StudentListForHostel hostelddl() 
	{
		System.out.println("Selected Hostel -> KBA MENS HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown,"KBA MENS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public AL_Hostel_Report_RAS_StudentListForHostel showbutton() 
	{
		System.out.println("Click on the Show button");
		click(reportbtn);	
		return this;
	}
	
	public AL_Hostel_Report_RAS_StudentListForHostel HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Report_RAS_StudentListForHostel Report() 
	{
		System.out.println("Click on Report");
		WebElement subMenu = driver.findElement(By.linkText("Report"));
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}
	public AL_Hostel_Report_RAS_StudentListForHostel Hostel_Studentlistforhostel() 
	{
		System.out.println("Click on Student hostel list");
		WebElement subMenu = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlRptType-container"));
		subMenu.click();
		WebElement searchbox = driver.findElement(By.xpath("//*[@class=\"select2-search__field\"]"));
		searchbox.sendKeys("Student List For Hostel",Keys.ENTER);
		return this;
	}
	public AL_Hostel_Report_RAS_StudentListForHostel Select_FromDate() {
		System.out.println("Enter From Date");
		js.executeScript("arguments[0].value='01/01/2021';", fromdate);
		return this;
	}

	public AL_Hostel_Report_RAS_StudentListForHostel Select_ToDate() {
		System.out.println("Enter To Date");
		js.executeScript("arguments[0].value='19/12/2024';", todate);
		return this;
	}
}
