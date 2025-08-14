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

public class FL_Establishment_Trans_ODApplicationFlow04_1 extends BaseClass
{
	@FindBy(xpath="//div[@id='ctl00_mainMenu']//a[contains(@class,'popout level1 static')][normalize-space()='ESTABLISHMENT']") private WebElement Establishment;
	@FindBy(linkText="Transactions") private WebElement Transactions;
	@FindBy(linkText="OD Application") private WebElement OD_Application;
	@FindBy(id="ctl00_ContentPlaceHolder1_lnkNew") private WebElement NewOD_Application;

JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public FL_Establishment_Trans_ODApplicationFlow04_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 Enter_LoginDetails() throws InterruptedException { 
		System.out.println("Enter Login Details");
		Thread.sleep(2000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008");

		Thread.sleep(2000);
		System.out.println("Enter Password Live -> Admin@12345 || UAT -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		Thread.sleep(2000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321"); 

		Thread.sleep(2000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 click_Establishment() throws InterruptedException {
	
		System.out.println("click on Establishment");
		Actions action= new Actions(driver);
		action.moveToElement(Establishment).build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 click_Transaction() { 
		System.out.println("Click on Transactions");
		click(Transactions);
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 click_ODApplication() { 
		System.out.println("Click on OD Application");
		click(OD_Application);
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 click_New_OD_Application() { 
		System.out.println("Click on New OD Application");
		click(NewOD_Application);
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 click_ODApplication_FullDay() { 
		System.out.println("Click on OD Application Full Day radio btn");
		WebElement OD_FullDay = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblODType_1"));
		click(OD_FullDay);
		return this;
	}
	
	public FL_Establishment_Trans_ODApplicationFlow04_1 Set_From_Date() throws InterruptedException {
		System.out.println("Select From date ==> 09/03/2024");

		WebElement calender_icon = driver.findElement(By.xpath("//i[@id='ctl00_ContentPlaceHolder1_imgCalFromdt']"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cefromfate_title"));
		click(calender_title);
		Thread.sleep(2000);
		WebElement year_title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cefromfate_title"));
		click(year_title);
		Thread.sleep(2000);
		WebElement select_year = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cefromfate_year_1_3"));
		click(select_year);
		Thread.sleep(2000);
		WebElement select_month = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cefromfate_month_0_2"));
		click(select_month);
		Thread.sleep(2000);
		WebElement select_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cefromfate_day_2_1"));
		click(select_date);
		
		return this;	
	}
	
	public FL_Establishment_Trans_ODApplicationFlow04_1 Set_To_Date() throws InterruptedException {
		System.out.println("Select To Date ==> 12/03/2024");
		WebElement calender_icon = driver.findElement(By.xpath("//i[@id='ctl00_ContentPlaceHolder1_imgCalTodt']"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_title"));
		click(calender_title);
		Thread.sleep(2000);
		WebElement year_title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_title"));
		click(year_title);
		Thread.sleep(2000);
		WebElement select_year = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_year_1_3"));
		click(select_year);
		Thread.sleep(2000);
		WebElement select_month = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_month_0_2"));
		click(select_month);
		Thread.sleep(2000);
		WebElement select_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CeTodt_day_2_4"));
		click(select_date);
		
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 Select_Purpose() { 
		System.out.println("Select Purpose ==> Attending Seminar");
		WebElement purpose = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPurpose"));
		Select select = new Select(purpose);
		select.selectByVisibleText("Attending Seminar");
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 Select_EventType() { 
		System.out.println("Select Event Type ==> Workshop");
		WebElement event_type = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEventType"));
		Select select = new Select(event_type);
		select.selectByVisibleText("Workshop");
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 Enter_PlaceToVisit() { 
		System.out.println("Enter Place To Visit");
		WebElement place = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPlace"));
		sendKeys(place, "Nagpur");
		return this;
	}
	
	public  FL_Establishment_Trans_ODApplicationFlow04_1 Click_Submit_btn() throws InterruptedException { 
		System.out.println("Click Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		js.executeScript("arguments[0].scrollIntoView();",submit);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit);
		return this;
	}
}
