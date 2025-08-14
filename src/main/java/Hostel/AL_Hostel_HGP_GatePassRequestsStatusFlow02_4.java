package Hostel;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 extends BaseClass {
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input")
	private WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr[1]//td[8]//select")
	private WebElement confirmWithParentSelect;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnParentSubmit")
	private WebElement submitbtn;
	
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 GatePassRequestStatus() {
		System.out.println("HostelGatePassReport");
		WebElement subMenu = driver.findElement(By.linkText("Gate Pass Requests Status"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 search() {
		System.out.println("Searching for current date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = dateFormat.format(new Date());
		sendKeys(searchBox, currentDate);
//		sendKeys(searchBox, "MOHAMED FAISAL 17");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 ClickCheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		click(checkbox);
		Thread.sleep(2000);
		search();
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 SelectParentApproval() throws InterruptedException {
		System.out.println("Select Select Parent Approval : Yes" );
		Select select = new Select(confirmWithParentSelect);
		select.selectByVisibleText("Yes");
		return this;
	}
	
	public AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 ClickSubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn" );
		click(submitbtn);
		return this;
	}
	
}
