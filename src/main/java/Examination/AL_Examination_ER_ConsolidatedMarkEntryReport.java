package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_ConsolidatedMarkEntryReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Exam Reports") private WebElement con_mark_entry;
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Examination_ER_ConsolidatedMarkEntryReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Click_ConsolidatedMarkEntryReport() throws InterruptedException {
		System.out.println("Admin Examination menu selected > Consolidated Mark Entry Report ");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement consolidate = driver.findElement(By.id("ctl00_repLinks_ctl14_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",consolidate);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", consolidate);
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Select_College_Scheme() {
		System.out.println("Select College and Scheme");
		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlcollege"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Select_Session() {
		System.out.println("Select Session => May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Select_Semister() {
		System.out.println("Select Semister => II");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsemester"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Select_Mode() {
		System.out.println("Select Mode => Internal & External ");
		WebElement mode=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlmode"));
		Select select = new Select(mode);
		select.selectByVisibleText("Internal & External");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Select_Section() {
		System.out.println("Select Section => A ");
		WebElement sec=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsection"));
		Select select = new Select(sec);
		select.selectByVisibleText("A");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Click_Show_btn() {
		System.out.println("Click Show btn");
		WebElement showbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(showbtn);
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Set_PageResolution() {
		System.out.println("Set Page Resolution => A4");
		WebElement pg_resolution=driver.findElement(By.id("ctl00_ContentPlaceHolder1_resolution"));
		Select select = new Select(pg_resolution);
		select.selectByVisibleText("A4");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Set_PageOrientation() {
		System.out.println("Set Page Orientation => Portrait");
		WebElement pg_orientation=driver.findElement(By.id("ctl00_ContentPlaceHolder1_orientation"));
		Select select = new Select(pg_orientation);
		select.selectByVisibleText("Portrait");
		return this;
	}
	
	public AL_Examination_ER_ConsolidatedMarkEntryReport Click_GenerateReport_btn() throws InterruptedException {
		System.out.println("Click Generate Report btn");
		WebElement gen_repo=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btngeneratepdf"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",gen_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", gen_repo);
		return this;
		
	}
}
