package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_LockUnlockEmployee extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_BD_LockUnlockEmployee(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlDeptmon") private WebElement dept;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnShow") private WebElement showBtn;
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee LockUnlockEmployee() throws InterruptedException {
		System.out.println("Click Lock/Unlock Employee ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement lock_emp = driver.findElement(By.id("ctl00_repLinks_ctl06_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",lock_emp);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", lock_emp);
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Select_College() {
		System.out.println("Select College => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Select_Staff() {
		System.out.println("Select Staff =>  Admin NTS ");
		Select select = new Select(staff);
		select.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Select_Department() {
		System.out.println("Select Department =>  dept Library ");
		Select select = new Select(dept);
		select.selectByVisibleText("dept Library");
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Select_OrderBy() {
		System.out.println("Select Order By =>  IDNO ");
		Select select = new Select(orderby);
		select.selectByValue("1");
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Click_ShowBtn() {
		System.out.println("Click on Show Btn =>  IDNO ");
		click(showBtn);
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Click_LockUnlockCheckBox() {
		System.out.println("Click on Lock/Unlock Check Box ");
		WebElement chkBox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_chkEmployeeLockUnlock"));
		click(chkBox);
		return this;
	}
	
	public AL_Payroll_Trans_BD_LockUnlockEmployee Click_Submit_btn() throws InterruptedException {
		System.out.println("Click on Submit btn ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		js.executeScript("arguments[0].scrollIntoView();",submit);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit);
		return this;
	}
}
