package Payroll;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder extends BaseClass
{
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink") private WebElement BulkPhotoUpdatefromfolder;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lnkUploadBulkPhoto") private WebElement uploadbulkphoto;
	@FindBy(xpath = "(//select[@id='ctl00_ContentPlaceHolder1_ddlcategory'])[1]") private WebElement photcategory;
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuStudPhoto") private WebElement selectimage;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement upload;
	@FindBy(id = "ctl00_ContentPlaceHolder1_Button1") private WebElement closebtn;


	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_BulkPhotoUpdate() throws InterruptedException {
		System.out.println(" Click on Bulk Photo Update from folder");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",BulkPhotoUpdatefromfolder);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", BulkPhotoUpdatefromfolder);
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_UploadBulkPhoto() {
		System.out.println(" Click on Upload Bulk Photo");
		click(uploadbulkphoto);
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Select_PhotoCategory() {
		System.out.println(" Select Photo Category ==> Employee Photo");
		Select select = new Select(photcategory);
		select.selectByValue("1");
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_SelectImage() throws InterruptedException {
		System.out.println(" Click on Select Image");
		js.executeScript("arguments[0].click();", selectimage);

		Thread.sleep(2000);
		Path relativePath = Paths.get("src\\test\\resources\\documentsForTesting\\MalePic.jpg");
        String absolutePath = relativePath.toAbsolutePath().toString();
        selectimage.sendKeys(absolutePath);

		System.out.println("File Added added Successfully");
		
		Thread.sleep(3000);
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_Showbtn() {
		System.out.println(" Click on Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_UploadBtn() {
		System.out.println(" Click on Upload btn");
		click(upload);
		return this;
	}
	
	public AL_Payroll_Trans_BD_BulkPhotoUpdateFromFolder Click_CloseBtn() {
		System.out.println(" Click on Close btn");
		click(closebtn);
		return this;
	}
}
