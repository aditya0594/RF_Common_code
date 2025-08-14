package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Establishment_Trans_LeaveCancellationFlow03_3 extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_Transactions() {
		System.out.println("Admin Examination menu selected > Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transaction).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_LeaveCancellation() throws InterruptedException {
		System.out.println(" Click On > Leave Cancellation");

		WebElement leaveCancel = driver.findElement(By.id("ctl00_ctl00_repLinks_ctl13_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",leaveCancel);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", leaveCancel);
	//	leaveCancel.click();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Select_College_name() {
		System.out.println("Select College_name => Crescent School of Architecture");
//		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		WebElement clg_field = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege-container"));
		click(clg_field);
		WebElement search_field = driver.findElement(By.className("select2-search__field"));
		search_field.sendKeys("Crescent School of Architecture",Keys.ENTER);
		System.out.println("Select_college - > Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Select_staff() {
		System.out.println("Select Staff type => Teaching Staff");
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStafftype-container"));
		click(Session);
		WebElement search = driver.findElement(By.className("select2-search__field"));
		search.sendKeys("Teaching Staff", Keys.ENTER);
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Select_LeaveDateFrom() throws InterruptedException {
System.out.println("FromDate ==> 04/02/2026 ");
		
		Thread.sleep(2000);
		WebElement FromDateCalenderIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromdt"));
		click(FromDateCalenderIcon);
		Thread.sleep(2000);
		WebElement yearTitle = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_title"));
		click(yearTitle);
		Thread.sleep(2000);
		click(yearTitle);
		Thread.sleep(2000);
		WebElement yearSelct = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_year_1_3"));
		click(yearSelct);//year select = 2026
		Thread.sleep(2000);
		WebElement monthSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_month_0_1"));
		click(monthSelect); //year select = Feb
		Thread.sleep(2000);
		WebElement dateSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromdt_day_1_3"));
		click(dateSelect); //year day = 4
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Select_LeaveType() {
		System.out.println("Select Leave type => Leave");
		WebElement leave = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblpo_0"));
		leave.click();
		return this;
	}
	
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_ClickToRestore_btn() {
		System.out.println("Click on => Click To Restore_btn");
		WebElement restore_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnRestore"));
		restore_btn.click();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_ShowReport_btn() {
		System.out.println("Click on => Show Report btn");
		WebElement repo_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnRestore"));
		repo_btn.click();
		return this;
	}
	
	public AL_Establishment_Trans_LeaveCancellationFlow03_3 Click_CheckBox() {
		System.out.println("Click on => Check Box");
		WebElement chk_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmployees_ctrl0_chkSelect"));
		chk_box.click();
		return this;
	}
}
