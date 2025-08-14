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
public class Student_Cdc_Trance_Placement extends BaseClass {
	
	public Student_Cdc_Trance_Placement(WebDriver rdriver) {
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
	
	
	
	public Student_Cdc_Trance_Placement CDCclick() {
		WebElement Cdcele = driver.findElement(By.linkText("CDC"));
		System.out.println("Admin CDC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Cdcele).perform();	
		return this;
	}
	
	
	public Student_Cdc_Trance_Placement Transaction() {
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Admin CDC Transaction submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(subMenu);
		action.click().build().perform();
		return this;
	}
	
	public Student_Cdc_Trance_Placement StuPlacement(){
		System.out.println("Select Application Category Type : Placement");
		WebElement cate_typ = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlApplicationType-container"));
		Select app_cat_typ = new Select(cate_typ);
		app_cat_typ.selectByVisibleText("Placement");
		return this;
	}
	
	public Student_Cdc_Trance_Placement SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitButton.click();
		return this;
	}

	Alert alert =  driver.switchTo().alert();
	
//	String Expected_Msg = "Are you sure you want to Submit !";
//	String Actual_Msg =alert.getText();
//	Thread.sleep(2000);
//	Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
//	alert.accept();
//	
//	Thread.sleep(2000);
//	String Expected_Msgs = "You Are Not Eligible For Application Category Registration !";
//	String Actual_Msgs =alert.getText();
//	Thread.sleep(2000);
//	Assert.assertEquals(Actual_Msgs, Expected_Msgs, "Actual and Expected Msg matched");
//	alert.accept();
//	
	/////////////////////////////////////////////////////
	
	//refresh
	
	/////////////////////
	
	public Student_Cdc_Trance_Placement CareerProfile() {
		System.out.println("Click on Career Profile");
		CareerProfile.click();
		return this;
	}
	
	public Student_Cdc_Trance_Placement confirmation() {
		System.out.println("Click on confirmation SubMenu");
		confirmation.click();
		return this;
	}
	public Student_Cdc_Trance_Placement ConfirmCheckBox() {
		System.out.println("Click on Confirm  CheckBox");
		ConfirmCheckBox.click();
		return this;
	}
	
	public Student_Cdc_Trance_Placement ProceedButton() {
		System.out.println("Click on Proceed Button");
		ProceedButton.click();
		return this;
	}
	
	
	
	
	
	
	
	
	}


