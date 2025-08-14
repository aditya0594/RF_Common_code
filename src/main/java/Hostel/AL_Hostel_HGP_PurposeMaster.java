package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_HGP_PurposeMaster extends BaseClass {

	public AL_Hostel_HGP_PurposeMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPurposeName")
	private WebElement PurposeName;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvPurpose_ctl01_btnEdit")
	private WebElement EditIcon;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement submit;
	
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	public AL_Hostel_HGP_PurposeMaster EnterPurposeName() {
		System.out.println("PurposeName");
		PurposeName.clear();
		PurposeName.sendKeys("VISIT HOME Home");;
		return this;
	}
	
	public AL_Hostel_HGP_PurposeMaster ReEnterPurposeName() {
		System.out.println("PurposeName");
		PurposeName.clear();
		PurposeName.sendKeys("VISIT HOME");;
		return this;
	}

	public AL_Hostel_HGP_PurposeMaster submit() {
		System.out.println("Click on the submit Button");
		click(submit);
		return this;
	}
	
	public AL_Hostel_HGP_PurposeMaster Search() {
		System.out.println("Click on the Search Button");
		Search.clear();
		Search.sendKeys("VISIT HOME");
		return this;
	}
	
	public AL_Hostel_HGP_PurposeMaster Edit() {
		System.out.println("Click on the Edit Button");
		click(EditIcon);
		return this;
	}

	public AL_Hostel_HGP_PurposeMaster HOSTEL() {
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Hostel_HGP_PurposeMaster HostelGatePass() {
		System.out.println("Click on HostelGatePass");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Gate Pass"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

	public AL_Hostel_HGP_PurposeMaster PurposeMaster() {
		System.out.println("Click on Purpose Master");
		WebElement subMenu = driver.findElement(By.linkText("Purpose Master"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
