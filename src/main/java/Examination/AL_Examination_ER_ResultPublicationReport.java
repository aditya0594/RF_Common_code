package Examination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class AL_Examination_ER_ResultPublicationReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
//	@FindBy(linkText = "Result Publication Report") private WebElement result_pub;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;


	
	public AL_Examination_ER_ResultPublicationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_ResultPublicationReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport Click_ResultPublicationReport() throws InterruptedException {
		System.out.println(" Click On > Result Publication Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement result_pub = driver.findElement(By.id("ctl00_repLinks_ctl12_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",result_pub);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", result_pub);
		return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport Select_Session() {
		System.out.println("Select Session => DEC 2021");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("DEC 2021");
		return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport Select_CollegeScheme() throws InterruptedException {
		System.out.println("Select College and Scheme=> SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		WebElement collgescheme=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));

		Select select = new Select(collgescheme);
		select.selectByValue("59");
    	return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport Select_Semister() {
		System.out.println("Select Semister => I");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select select = new Select(semister);
		select.selectByVisibleText("I");
		return this;
	}
	
	public AL_Examination_ER_ResultPublicationReport Click_Report_btn() {
		System.out.println("Click Report btn");
		WebElement repot_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrint"));
		click(repot_btn);
		return this;
	}
}
