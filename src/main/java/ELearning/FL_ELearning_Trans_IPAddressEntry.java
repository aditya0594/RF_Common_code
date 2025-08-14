package ELearning;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class FL_ELearning_Trans_IPAddressEntry extends BaseClass{

	public FL_ELearning_Trans_IPAddressEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "IP Address Entry") private WebElement iPAddressEntry_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtcompterName") private WebElement computerName_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtipaddress") private WebElement ipAddress_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmitentry") private WebElement submit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIpAdd_ctrl0_imgbtnedit") private WebElement edit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIpAdd_ctrl0_imgdelete") private WebElement delete_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement deleteOk_button;
	@FindBy(xpath = "//*[@id=\"DataTables_Table_1_filter\"]/label/input") private WebElement search_txtbox;

	/*
	 * (xpath = "//button[normalize-space()='OK']")
	 * 
	 * @FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnOkDel'])[1]")
	 */

	
	 Random random = new Random();
	 int randomNumber = random.nextInt(100) + 1;
	 String randomText = "Testing" + randomNumber;
	
	
	public FL_ELearning_Trans_IPAddressEntry click_iPAddressEntry_link() {
		System.out.println("Click on IPAddress Entry link ");
		click(iPAddressEntry_link);
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry enter_computerName() {
		System.out.println("Enter Computer Name");
		computerName_inputfield.sendKeys(randomText);
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry enter_ipAdress() {
		System.out.println("Enter IP Address");
		ipAddress_inputfield.sendKeys(randomText);
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry click_submit_btn() {
		System.out.println("Click on Submit Button");
		submit_btn.click();
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry edit_ipAdrress() {
		System.out.println("Enter IP Address");	
		edit_button.click();
		ipAddress_inputfield.clear();
		 int randomNumber = random.nextInt(100) + 1;
		 randomText = "Testing" + randomNumber;
		ipAddress_inputfield.sendKeys(randomText);
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry delete_ipAddress() {
		System.out.println("Click on Discussion Forum ");
		click(delete_btn);
		click(deleteOk_button);
		return this;
	}
	
	public FL_ELearning_Trans_IPAddressEntry searchtxt() {
		System.out.println("Click on Discussion Forum ");
		sendKeys(search_txtbox,"Testing");
		return this;
	}
	public FL_ELearning_Trans_IPAddressEntry login() {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
	//Thread.sleep(1000);
	System.out.println("Enter Master Captcha -> 4321"); 
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

	//Thread.sleep(1000);
	System.out.println("Click on Login Button");
	driver.findElement(By.id("btnLogin")).click();
	
	//Thread.sleep(1000);
	try 
	{
		//check if the skip button is present
		WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
		if(skipButton != null && skipButton.isDisplayed())
		{
			skipButton.click();System.out.println("Click on Skip Notice / News");
		}
		else
		{
			System.out.println("Skip Button is not Prescent");
		}
		//check weather the Notice Modal is present or not
		Thread.sleep(2000);
		WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"notice\"]/div/div/div[1]/button/span"));
		if (closeButton != null && closeButton.isDisplayed())
		{
			closeButton.click();
			System.out.println("Click on close button of, Notice Modal");
		}
		else
		{
			System.out.println("Notice Modal close button is not prescent");
		}
	} 
	catch (Exception e) 
	{
		// TODO: handle exception
		System.out.println("Something went wrong");
	}
	return this;
	}
	
}
