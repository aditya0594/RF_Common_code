package Payroll;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_BulkPhotoUpdate extends BaseClass
{
	public AL_Payroll_Trans_BD_BulkPhotoUpdate(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement BulkPhotoUpdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffName") private WebElement staffScheme;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
//	@FindBy(id = "ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl0_fuEmpPhoto") private WebElement ChooseFile1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl0_fuEmpSignature") private WebElement Singnature1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl1_fuEmpPhoto") private WebElement ChooseFile2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl1_fuEmpSignature") private WebElement Singnature2;


	public AL_Payroll_Trans_BD_BulkPhotoUpdate Click_BulkPhotoUpdate() {
		System.out.println(" Click on Bulk Photo Update");
		Actions action = new Actions(driver);
		action.moveToElement(BulkPhotoUpdate).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdate Select_CollegeName() {
		System.out.println(" Select College Name ==> Crescent School of Architecture");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdate Select_StaffScheme() {
		System.out.println(" Select Staff/Scheme Name ==> Teaching Staff");
		Select select = new Select(staffScheme);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdate Click_Show_Btn() {
		System.out.println("Click on Show Btn");
		click(showbtn);
		return this;     
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdate Click_ChooseFile1() throws InterruptedException, AWTException {
		System.out.println("Click on Choose File1 Btn");
		WebElement ChooseFile1 = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl0_fuEmpPhoto"));
	//	WebElement file = driver.findElement(By.cssSelector("#ctl00_ctl00_ContentPlaceHolder1_sbctp_fuUploadImage"));
		js.executeScript("arguments[0].click();", ChooseFile1);

		Thread.sleep(2000);
		Path relativePath = Paths.get("src\\test\\resources\\documentsForTesting\\MalePic.jpg");
        String absolutePath = relativePath.toAbsolutePath().toString();
        ChooseFile1.sendKeys(absolutePath);

		System.out.println("File Added added Successfully");
		
		Thread.sleep(3000);
		
		return this;	   
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdate Click_Submit_Btn() {
		System.out.println("Click on Submit Btn");
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		return this;     
	}
}
