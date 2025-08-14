package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_DemandModification extends BaseClass
{
	public AL_Academic_FR_DemandModification(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl06_lbLink") private WebElement DemandModification;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch") private WebElement searchcriteria;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDropdown") private WebElement branch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_Button1") private WebElement searchBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement adharkartick;
	@FindBy(xpath = "//input[@title='Edit Demand']") private WebElement editAdharKartick;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_DemandModification Click_DemandModification() throws InterruptedException {
		System.out.println("Click on Demand Modification");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DemandModification);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DemandModification);
		return this;
	}
	
	public AL_Academic_FR_DemandModification Select_SearchCriteria() throws InterruptedException {
		System.out.println("Select Search Criteria ==> BRANCH");
		Select select = new Select(searchcriteria);
		select.selectByVisibleText("BRANCH");
		return this;
	}
	
	public AL_Academic_FR_DemandModification Select_Branch() throws InterruptedException {
		System.out.println("Select Branch ==> Architecture");
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_FR_DemandModification Click_SearchBtn() throws InterruptedException {
		System.out.println("Click on Search btn");
		click(searchBtn);
		return this;
	}
	
	public AL_Academic_FR_DemandModification Click_NameofStudent() throws InterruptedException {
		System.out.println("Click on Name of Student");
		click(adharkartick);
		
		System.out.println("Click on Edit btn");
		click(editAdharKartick);
		return this;
	}
	
	public AL_Academic_FR_DemandModification Enter_CautionDeposit() throws InterruptedException {
		System.out.println("Click on Demand Modification");
		Thread.sleep(2000);
		WebElement deposit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFeeItems_ctrl3_txtFeeItemAmount"));
		js.executeScript("arguments[0].scrollIntoView();",deposit);

		Thread.sleep(2000);
		clearText(deposit);
		sendKeys(deposit, "100");
		return this;
	}
	
	public AL_Academic_FR_DemandModification Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		return this;
	}
}
