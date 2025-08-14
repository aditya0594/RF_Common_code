package Establishment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Rpt_BiometricSummaryReport extends BaseClass 
{
	@FindBy(xpath="(//a[contains(@class,'popout level1 static')][normalize-space()='ESTABLISHMENT'])[1]") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Report;
//	@FindBy(id="ctl00_repLinks_ctl13_lbLink") private WebElement BiometricSummaryReport;
//	@FindBy(xpath="/html[1]/body[1]/form[1]/div[6]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]") private WebElement collegeName;
//	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlStaffType-container") private WebElement staffType;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddldept']") private WebElement Department;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtMonthYear']") private WebElement monthYear;
	@FindBy(xpath="(//input[@id='ctl00_ContentPlaceHolder1_btnReport'])[1]") private WebElement report;
	
	public AL_Establishment_Rpt_BiometricSummaryReport(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport click_Establishment() throws InterruptedException {
		System.out.println("click on Establishment");
		Actions action= new Actions(driver);
		action.moveToElement(Establishment).build().perform();
		Thread.sleep(3000);
	//	Establishment.click();
		return this;	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport click_Report() {
		System.out.println("Click on Report");
		Report.click();
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport click_BiometricSummaryReport() throws InterruptedException {
		System.out.println("Click on Biometric summary report");

//		WebElement searchBox = driver.findElement(By.xpath("(//input[@placeholder='search'])[1]"));
//		searchBox.sendKeys("Biometric");
//		WebElement BioSumm = driver.findElement(By.linkText("Biometric Summary Report"));
//		click(BioSumm);
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement link_IPentry = driver.findElement(By.id("ctl00_repLinks_ctl13_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",link_IPentry);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", link_IPentry);
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport Select_college() throws InterruptedException, IOException {
		System.out.println("Fill details");
		//college name
		System.out.println("Select college name");
		
		WebElement clg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlcollege"));
		Select typ_clg = new Select(clg);
		typ_clg.selectByVisibleText("Crescent School of Architecture");
		return this; 
	}
		
	public AL_Establishment_Rpt_BiometricSummaryReport Selec_staff() {
		// Select staff type
		System.out.println("Select Staff type");
		
		WebElement staff_type = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStaffType']"));
		Select typ_staff=new Select(staff_type);
		typ_staff.selectByVisibleText("Teaching Staff");
//		staff_type.sendKeys("Non Teaching");
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport Select_Department() {
		
		//select Department
		System.out.println("Select Department");
		
		Select typ_dept= new Select(Department);
		typ_dept.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport Select_month_year() {
		//select month and year
		System.out.println("Select month and year");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",monthYear, "11/2024");
		return this;
		
	}
	
	public AL_Establishment_Rpt_BiometricSummaryReport click_reportBtn() throws InterruptedException, IOException {
		//Generate report
		System.out.println("Click on report");
		report.click();
		
		return this;
	}
}
