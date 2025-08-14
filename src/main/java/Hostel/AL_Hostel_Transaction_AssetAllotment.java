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

public class AL_Hostel_Transaction_AssetAllotment extends BaseClass {

	public AL_Hostel_Transaction_AssetAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="select2-ctl00_ContentPlaceHolder1_ddlHostel-container")
	private WebElement Hostel;
	@FindBy(id ="select2-ctl00_ContentPlaceHolder1_ddlBlock-container")
	private WebElement Block;
	@FindBy(id ="select2-ctl00_ContentPlaceHolder1_ddlFloor-container")
	private WebElement Floor;
	@FindBy(id ="select2-ctl00_ContentPlaceHolder1_ddlRoom-container")
	private WebElement Room;
	@FindBy(id ="select2-ctl00_ContentPlaceHolder1_ddlAsset-container")
	private WebElement Asset;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtAssetQty")
	private WebElement AssetQTY;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtAllotmentDate")
	private WebElement AllotmentDate;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnSave")
	private WebElement Submitbtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_lvAssetAllotment_ctrl0_btnEdit")
	private WebElement Editbtn;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	public AL_Hostel_Transaction_AssetAllotment Editbutton() {
		
		System.out.println("Click on Edit");
		click(Editbtn);
		return this;
	}

	public AL_Hostel_Transaction_AssetAllotment Hostelddl() {
	
		System.out.println("Selected Hostel Name -> TEST GIRLS HOSTEL");
		click(Hostel);
		sendKeys(SearchBoxOfDropDown, "TEST GIRLS HOSTEL");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_AssetAllotment Blockddl() {
		
		System.out.println("Selected Block -> ASSETBLOCK");
		click(Block);
		sendKeys(SearchBoxOfDropDown, "ASSETBLOCK");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_AssetAllotment Floorddl() {
		
		System.out.println("Selected Floor -> ASSETFLOOR");
		click(Floor);
		sendKeys(SearchBoxOfDropDown, "ASSETFLOOR");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Hostel_Transaction_AssetAllotment Roomddl() {
		
		System.out.println("Selected Room -> ASSETROOM");
		click(Room);
		sendKeys(SearchBoxOfDropDown, "ASSETROOM");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
    public AL_Hostel_Transaction_AssetAllotment Assetddl() {
		
		System.out.println("Selected Asset -> PLANTS");
		click(Asset);
		sendKeys(SearchBoxOfDropDown, "PLANTS");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
    
    public AL_Hostel_Transaction_AssetAllotment AssetQuantity() {
		
  		System.out.println("Entered Asset Quantity -> 2");
  		AssetQTY.clear();
  		sendKeys(AssetQTY, "1");
  		return this;
  	}
	
    public AL_Hostel_Transaction_AssetAllotment AssetAllotmentDate() throws Exception {
    	
//    	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//  		Date date = new Date();
//  		Thread.sleep(3000);
//  		String date1= dateFormat.format(date);
    	System.out.println("Selected Asset Allotment Date -> 25/10/2024");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]", AllotmentDate, "25/10/2024");
  		return this;
  	}
    
   public AL_Hostel_Transaction_AssetAllotment Submitbutton() {
		
		System.out.println("Click on Submit Button");
		click(Submitbtn);
		return this;
	}
    
	public AL_Hostel_Transaction_AssetAllotment HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Transaction_AssetAllotment Transaction() 
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
	
	public AL_Hostel_Transaction_AssetAllotment Asset_Allotment() 
	{
		System.out.println("Click on Asset Allotment");
		WebElement subMenu = driver.findElement(By.linkText("Asset Allotment"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
