package Stores;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import StoresTest.$missing$;
import utility.BaseClass;

public class AL_Stores_Rpt_SER_VendorPaymentReport extends BaseClass {

	
	@FindBy(xpath = "(//a[contains(text(),'STORES')])[1]") private WebElement Stores;
	@FindBy(xpath = "(//a[contains(text(),'Reports')])[1]") private WebElement Reports;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlReport") private WebElement ReportType;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlStoreName") private WebElement StoreName;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement todate;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnRpt") private WebElement ShowReport;
	@FindBy(xpath="(//span[@id='select2-ctl00_ContentPlaceHolder1_ddlStoreName-container'])[1]") private WebElement storeNamesearch;
	@FindBy(xpath="//input[@role='textbox']") private WebElement StoreNameDropdown;

	
//	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public  AL_Stores_Rpt_SER_VendorPaymentReport (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public AL_Stores_Rpt_SER_VendorPaymentReport Click_STORES() {
		System.out.println("Click On Stores");
		Actions action = new Actions(driver); 
		action.moveToElement(Stores).build().perform();
		return this;
	}
	
	public AL_Stores_Rpt_SER_VendorPaymentReport Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}   
	
	
	public AL_Stores_Rpt_SER_VendorPaymentReport Select_ReportType() {
		System.out.println("Admin Examination menu selected > Select Report Type");
		Select select = new Select(ReportType);
		select.selectByVisibleText("Vendor Payment Report");
		return this;
	}    
	  
	public AL_Stores_Rpt_SER_VendorPaymentReport Select_StoreName() throws InterruptedException {
		System.out.println("Admin Examination menu selected > Select Store Name => CRESCENT INST or Main Store");
		click(storeNamesearch);
		Thread.sleep(2000);
		StoreNameDropdown.sendKeys("in");
		StoreNameDropdown.sendKeys(Keys.ENTER);
		
//		Select select = new Select(StoreName);
//		select.selectByVisibleText("CRESCENT INST");
		return this;
	}   
	
	public AL_Stores_Rpt_SER_VendorPaymentReport Click_ShowBtn() {
		System.out.println("Click Show Button");
		click(ShowReport);
		return this;
	}
}
