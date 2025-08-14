package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_ChangeShiftTime extends BaseClass

{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	@FindBy(linkText = "Change Shift Time") private WebElement chang_shift_time;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlStafftype']") private WebElement staff;
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_ChangeShiftTime(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Click_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transaction).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Click_ChangeShiftTime() {
		System.out.println(" Click On > Change Shift Time");
		Actions action = new Actions(driver);
		action.moveToElement(chang_shift_time).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Select_College_name() {
		System.out.println("Select College_name => Crescent School of Architecture");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Select_Stafff_Type() {
		System.out.println("Select Session => Teaching Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStafftype']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Select_FromDate() {
		System.out.println("Select From Date => 02/09/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDt")), "02/09/2024");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Select_ToDate() {
		System.out.println("Select To Date => 15/11/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtToDt")), "15/11/2024");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Set_InTime() {
		System.out.println("Set In Time => 09:00 AM");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtInTime")), "09:00 AM");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Set_OutTime() {
		System.out.println("Set Out Time => 06:00 PM");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtOutTime")), "06:00 PM");
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Click_check_box() throws InterruptedException{
		System.out.println("Click check box to select Employee");
		WebElement check_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_chkID"));
		
		Thread.sleep(1000);
		// Scrolling down the page till the element is found		
//        js.executeScript("arguments[0].scrollIntoView();", check_box);
    	Thread.sleep(1000);
    	js.executeScript("arguments[0].click();", staff);
		click(check_box);
		return this;
	}
	
	public AL_Establishment_Trans_ChangeShiftTime Click_submit_btn() throws InterruptedException{
		System.out.println("Click Submit btn");
		WebElement sbmit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(sbmit);
		return this;
	}
}
