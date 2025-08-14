package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 extends BaseClass
{
	@FindBy(xpath="//*[@id=\"ctl00_mainMenu\"]/ul/li[5]/a") private WebElement ESTBALISHMENT;
	@FindBy(linkText="Transactions") private WebElement Transaction;
	@FindBy(id ="ctl00_repLinks_ctl00_lbLink") private WebElement EmpLeaveCard;
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 FacultyLoginDetails() throws InterruptedException {
		System.out.println("Enter Faculty Login Details ");
		
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> Admin@12345 || UAT -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(1000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		return this;
	}
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 ESTBALISHMENT() {
		System.out.println("Click on ESTBALISHMENT");
		Actions action = new Actions(driver);
		action.moveToElement(ESTBALISHMENT).build().perform();
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 Transaction() {
		System.out.println("Click on Transactions ");
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 Click_EmployeeLeaveCard() {
		System.out.println("Click on Employee Leave Card ");
//		WebElement subMenu = driver.findElement(By.id(""));
//		js.executeScript("arguments[0].click;", EmpLeaveCard);
		Actions action = new Actions(driver);
		action.moveToElement(EmpLeaveCard).build().perform();
		EmpLeaveCard.click();
		return this;
	}
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 Click_LeaveApplicationStatus_btn() {
		System.out.println("Click on  Leave Application Status btn");
		WebElement Leave_app = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lnkbut"));
		Leave_app.click();
		return this;
	}
	
	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 Click_SearchBox() {
		System.out.println("Click on Search Box and Search date==> 04/02/2026");
		WebElement search_box = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));
		search_box.click();
		search_box.sendKeys("04/02/2026");
		return this;
	}

	public FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 Click_SendRequest_btn() {
		System.out.println("Click on Send Request btn");
		WebElement send_req = driver.findElement(By.xpath("//input[@title='Send Request']"));
		click(send_req);
		
		return this;
	}
}
