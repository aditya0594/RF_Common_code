package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_IT_ITTransfer extends BaseClass
{
	public AL_Payroll_Trans_IT_ITTransfer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink") private WebElement ITTransfer;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement tranferitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Trans_IT_ITTransfer Click_ITTransfer() throws InterruptedException {
		System.out.println(" Click on IT Transfer");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",ITTransfer);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ITTransfer);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITTransfer Select_College() {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITTransfer Select_Staff() {
		System.out.println("Select Staff ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITTransfer Select_OrderBy() {
		System.out.println("Select Order By ==> Employee Code");
		Select select = new Select(orderby);
		select.selectByVisibleText("Employee Code");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITTransfer Click_TransferITAmountbtn() {
		System.out.println("Click on Transfer IT Amount btn");
		click(tranferitbtn);
		return this;
	}
}
