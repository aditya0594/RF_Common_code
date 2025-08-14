package RFCCExtra;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class SL_CDC_Trans_TPCategoryUpdate_CareerProfile extends BaseClass {
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this); 
	}
	
	
//	@FindBy(linkText="CDC")
//	private WebElement CDCclick;
//	
//	@FindBy(linkText="Transactions")
//	private WebElement Transaction;
//	
//	@FindBy(id="ctl00_ContentPlaceHolder1_ddlApplicationType")
//	private WebElement StuPlacement;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnTPSubmitType")
	private WebElement SubmitButton;
	
	@FindBy(id="ctl00_repLinks_ctl00_lbLink")
	private WebElement CareerProfile;
	
	@FindBy(xpath="(//a[normalize-space()='Confirmation'])[1]")
	private WebElement confirmation;
	
	
	@FindBy(id="ctl00_ContentPlaceHolder1_chkConfirm")
	private WebElement ConfirmCheckBox;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnProceed")
	private WebElement ProceedButton;
	
	
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile CDCclick() {
		WebElement Cdcele = driver.findElement(By.linkText("CDC"));
		System.out.println("Admin CDC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Cdcele).perform();	
		return this;
	}
	
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile Transaction() {
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Admin CDC Transaction submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(subMenu);
		action.click().build().perform();
		return this;
	}
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile StuPlacement(){
		System.out.println("Select Application Category Type : Placement");
		WebElement cate_typ = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlApplicationType-container"));
		Select app_cat_typ = new Select(cate_typ);
		app_cat_typ.selectByVisibleText("Placement");
		return this;
	}
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitButton.click();
		return this;
	}
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile CareerProfile() {
		System.out.println("Click on Career Profile");
		CareerProfile.click();
		return this;
	}
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile confirmation() {
		System.out.println("Click on confirmation SubMenu");
		confirmation.click();
		return this;
	}
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile ConfirmCheckBox() {
		System.out.println("Click on Confirm  CheckBox");
		ConfirmCheckBox.click();
		return this;
	}
	
	public SL_CDC_Trans_TPCategoryUpdate_CareerProfile ProceedButton() {
		System.out.println("Click on Proceed Button");
		ProceedButton.click();
		return this;
	}
	
	}


