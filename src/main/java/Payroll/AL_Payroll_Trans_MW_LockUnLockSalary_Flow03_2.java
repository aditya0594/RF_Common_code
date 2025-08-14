package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 extends BaseClass
{
	JavascriptExecutor js = (JavascriptExecutor)driver;

	@FindBy(linkText = "Lock/UnLock Salary")
	private WebElement lockUnlockSalaryLink;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollegeFilter-container")
	private WebElement collegeFilterDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchCollege;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchBar;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvLockUnlock_ctrl0_txtYesNo")
	private WebElement lockStatusField;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement saveBtn;

	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 Click_LockUnlockSalary() throws Exception {
		System.out.println("Click Lock/UnLock Salary");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", lockUnlockSalaryLink);
		threadWait1();
		js.executeScript("arguments[0].click();", lockUnlockSalaryLink);
		return this;
	}
	
	
	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 Select_College() throws Exception {
		System.out.println("Select College");
//		js.executeScript("arguments[0].scrollIntoView();", collegeFilterDropdown);
		collegeFilterDropdown.click();
		Thread.sleep(1000);
		searchCollege.sendKeys("Mechanical");
		searchCollege.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 Enter_SearchText() throws Exception {
		System.out.println("Enter text in search bar");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", searchBar);
		searchBar.sendKeys("Sep2022 Admin NTS");
		return this;
	}
	
	
	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 DoubleClick_LockStatusField() throws Exception {
		System.out.println("Double click on lock status field");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", lockStatusField);
		threadWait1();
		Actions actions = new Actions(driver);
		actions.doubleClick(lockStatusField).perform();
		sendKeys(lockStatusField, "N");
		return this;
	}
	

	public AL_Payroll_Trans_MW_LockUnLockSalary_Flow03_2 Click_SaveButton() throws Exception {
		System.out.println("Click on save button");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		threadWait1();
		js.executeScript("arguments[0].click();", saveBtn);
		threadWait1();
		return this;
	}
}
