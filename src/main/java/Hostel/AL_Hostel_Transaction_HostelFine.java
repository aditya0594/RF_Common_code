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


public class AL_Hostel_Transaction_HostelFine extends BaseClass {
	public AL_Hostel_Transaction_HostelFine(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostelSessionNo-container")
	private WebElement HostelSession;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlHostelNo-container")
	private WebElement HostelName;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBlockNo-container")
	private WebElement Hostelblock;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlFloor-container")
	private WebElement Hostelfloor;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDetails_ctrl1_chkReport")
	private WebElement checkstud;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDetails_ctrl1_btnEditFine")
	private WebElement selectstudent;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDetails_ctrl1_txtFine")
	private WebElement Fine;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement Reportbtn;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Transaction_HostelFine HostelSessionddl() {
	
		System.out.println("Selected Hostel Session -> 2023-2024");
		click(HostelSession);
		sendKeys(SearchBoxOfDropDown, "2023-2024");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_HostelFine HostelNameddl() {
		
		System.out.println("Selected Hostel -> CRESCENT HOSTEL");
		click(HostelName);
		sendKeys(SearchBoxOfDropDown, "CRESCENT HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
    public AL_Hostel_Transaction_HostelFine HostelBlockddl() {
		
		System.out.println("Selected Hostel Block -> CRES-B1");
		click(Hostelblock);
		sendKeys(SearchBoxOfDropDown, "CRES-B1");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

    public AL_Hostel_Transaction_HostelFine HostelFloorddl() {
		
		System.out.println("Selected Hostel Floor -> CRES-F1");
		click(Hostelfloor);
		sendKeys(SearchBoxOfDropDown, "CRES-F1");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
    
    public AL_Hostel_Transaction_HostelFine showbutton() {
		
		System.out.println("Click on show button");
		click(showbtn);
		return this;
	}
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    
    public AL_Hostel_Transaction_HostelFine SelectStudent() {
   		js.executeScript("arguments[0].scrollIntoView();",showbtn);
    	
  		System.out.println("Click on Edit button of student -> RUKKIAH SAJEENA. M");
  		click(selectstudent);
  		return this;
  	}
    
    public AL_Hostel_Transaction_HostelFine FineAmount() {
    	js.executeScript("arguments[0].scrollIntoView();",showbtn);
  		System.out.println("Entered Fine -> 70");
  		Fine.clear();
  		sendKeys(Fine, "70");
  		return this;
  	}
 
    public AL_Hostel_Transaction_HostelFine SelectCheckbox() {
		
		System.out.println("Click on the Checkbox");
		click(checkstud);
		return this;
	}
    
    public AL_Hostel_Transaction_HostelFine Submitbutton() {
		
		System.out.println("Click on the submit button");
		click(Submitbtn);
		return this;
	}
    
    public AL_Hostel_Transaction_HostelFine Reportbutton() {
		
  		System.out.println("Click on the Report button");
  		click(Reportbtn);
  		return this;
  	}
  	
    
	public AL_Hostel_Transaction_HostelFine HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Transaction_HostelFine Transaction() 
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

	public AL_Hostel_Transaction_HostelFine Hostel_Fine() 
	{
		System.out.println("Click on Hostel Fine");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Fine"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

	public AL_Hostel_Transaction_HostelFine AddEditStudentFine() 
	{
		System.out.println("Click on Add/Edit Student Fine");
		WebElement subMenu = driver.findElement(By.linkText("Add/Edit Student Fine"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

}
