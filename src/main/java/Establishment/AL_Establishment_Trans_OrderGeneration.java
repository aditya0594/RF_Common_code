package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_OrderGeneration extends BaseClass
{
	
	public AL_Establishment_Trans_OrderGeneration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(xpath = "//a[@href='https://rfcautomationuat.mastersofterp.in/ESTABLISHMENT/LEAVES/Transactions/ordergenerate.aspx?pageno=1310']") private WebElement OrderGeneration;
	@FindBy(id = "ctl00_ctl00_repLinks_ctl16_lbLink") private WebElement OrderGeneration;
	//AL_Establishment_Trans_OrderGenerationTest
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegeName;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffType") private WebElement staffName;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	
	
	public AL_Establishment_Trans_OrderGeneration Click_OrderGeneration() throws InterruptedException {
		System.out.println("Click on Order Generation");
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",OrderGeneration); 

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", OrderGeneration);
		
		return this;
	} 	

	
	public AL_Establishment_Trans_OrderGeneration Select_College_name() {
		System.out.println("Select College_name => Crescent School of Architecture");
		Select select = new Select(collegeName);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Select_Stafff_Type() {
		System.out.println("Select Session => Teaching Staff");
		Select select = new Select(staffName);
		select.selectByVisibleText("Teaching Staff"); 
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Set_OrderDate() throws InterruptedException {
		System.out.println("Set Order Date => 25/11/2025");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalOrddt"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceOrddt_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceOrddt_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceOrddt_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceOrddt_month_2_2"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceOrddt_day_4_2"));
		click(date_select);
		
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Click_CheckBox() {
		System.out.println("Click on Checkbox ");
		WebElement chkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		click(chkBox);
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Click_SaveOrder() {
		System.out.println("Click on Save Order ");
		WebElement odr = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOrder"));
		click(odr);
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Click_Report() {
		System.out.println("Click on Report ");
		WebElement rpt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(rpt);
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Select_College_name_for_Report() {
		System.out.println("Select College name for Report=> Crescent School of Architecture");
		WebElement clg2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlcollege2"));
		Select select = new Select(clg2);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Select_Staff_name_for_Report() {
		System.out.println("Select Staff name for Report=> Crescent School of Architecture");
		WebElement staf2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlstafftype2"));
		Select select = new Select(staf2);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Select_Employee_name_for_Report() {
		System.out.println("Select Employee name for Report=> VENKATESAN  MURTHY");
		WebElement empName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEname"));
		Select select = new Select(empName);
		select.selectByValue("58");
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Select_Order_No_for_Report() {
		System.out.println("Select Order No. for Report=> LEAVE ORDER/2024/12/00063");
		WebElement empName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlOrder"));
		Select select = new Select(empName);
		select.selectByValue("63");
		return this;
	}
	
	public AL_Establishment_Trans_OrderGeneration Click_Report_btn_For_Report() {
		System.out.println("Click on Report btn");
		WebElement rpt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnInd"));
		click(rpt);
		return this;
	}
}
