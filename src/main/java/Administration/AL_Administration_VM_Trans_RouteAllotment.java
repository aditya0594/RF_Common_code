package Administration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Administration_VM_Trans_RouteAllotment extends BaseClass
{
	public AL_Administration_VM_Trans_RouteAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "Route Allotment") private WebElement routeAllotmentLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderByField;
	@FindBy(className = "select2-search__field") private WebElement searchField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmployee") private WebElement employeeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRoute") private WebElement routeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBoardingPoint") private WebElement boardingPointField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	
	/**
	 * Click on Route Allotment link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Click_RouteAllotmentLink() throws Exception {
		System.out.println("Click on Route Allotment link");
		js.executeScript("arguments[0].scrollIntoView();", routeAllotmentLink);
		js.executeScript("arguments[0].click();", routeAllotmentLink);
		return this;
	}
	
	/**
	 * Click on Order By field and select IDNO
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Select_OrderBy() throws Exception {
		System.out.println("Click on Order By field and select IDNO");
		Select select = new Select(orderByField);
		select.selectByVisibleText("IDNO");
		return this;
	}
	
	/**
	 * Click on Employee field and select Mr. ankit
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Select_Employee() throws Exception {
		System.out.println("Click on Employee field and select Mr. ankit");
		Select select = new Select(employeeField);
		select.selectByVisibleText("Mr. ankit  ");
		return this;
	}
	
	/**
	 * Click on Route field and select CA Road
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Select_Route() throws Exception {
		System.out.println("Click on Route field and select Main Office To MIhan");
		Select select = new Select(routeField);
		select.selectByVisibleText("Main Office To MIhan");
		return this;
	}
	
	/**
	 * Click on Boarding Point field and select T Point
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Select_BoardingPoint() throws Exception {
		System.out.println("Click on Boarding Point field and select South Airport");
		Select select = new Select(boardingPointField);
		select.selectByVisibleText("South Airport");
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	/**
	 * Verify alert message and accept it
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_RouteAllotment Verify_AlertMessage() throws Exception {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Record Save Successfully.";
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message - " + actualMsg + "\n" + "Expected Message - " + expectedMsg);
		alert.accept();
		return this;
	}
}
