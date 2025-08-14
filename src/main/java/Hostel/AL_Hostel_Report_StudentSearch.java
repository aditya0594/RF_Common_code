package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_Report_StudentSearch extends BaseClass{
	public AL_Hostel_Report_StudentSearch(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
   @FindBy(id="ctl00_ContentPlaceHolder1_imgSearch")
   private WebElement searchicon;
   @FindBy(id="ctl00_ContentPlaceHolder1_txtSearch")
   private WebElement searchtext;
   @FindBy(id="ctl00_ContentPlaceHolder1_btnSearch")
   private WebElement searchbtn; 
   @FindBy(id="ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")
   private WebElement selectstudent; 
   @FindBy(id="ctl00_ContentPlaceHolder1_lblSessions")
   private WebElement session;  
 
   public AL_Hostel_Report_StudentSearch searchstudent()
	{
	   System.out.println("Click on Search Icon");
	   click(searchicon);
	   return this;
	}

   public AL_Hostel_Report_StudentSearch searchtext()
	{
	   System.out.println("Entered search text -> 230873601001");
	   sendKeys(searchtext,"230873601001");
	   return this;
	}
   
   public AL_Hostel_Report_StudentSearch searchbutton()
	{
	   System.out.println("Click on Search Button");
	   click(searchbtn);
	   return this;
	}
   
   public AL_Hostel_Report_StudentSearch selectstud() throws Exception
	{
	   System.out.println("Click on Student -> JAY T");
	   click(selectstudent);
	   Thread.sleep(2000);
	   System.out.println("Click on Personal Details");
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("arguments[0].scrollIntoView(true);",session);
	   return this;
	}
   
   public AL_Hostel_Report_StudentSearch HostelDetails()
  	{
  	   System.out.println("Click on Hostel Details");
		WebElement subMenu = driver.findElement(By.linkText("Hostel Details"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
  	}
   
   public AL_Hostel_Report_StudentSearch AssetDetails()
 	{
 	   System.out.println("Click on Asset Details");
		WebElement subMenu = driver.findElement(By.linkText("Asset Details"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
 	}
   
   public AL_Hostel_Report_StudentSearch AttendanceDetails()
	{
	   System.out.println("Click on Attendance Details");
		WebElement subMenu = driver.findElement(By.linkText("Attendance Details"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
   
   public AL_Hostel_Report_StudentSearch EmergencyContactDetails()
  	{
  	   System.out.println("Click on Emergency Contact Details");
  		WebElement subMenu = driver.findElement(By.linkText("Emergency Contact Details"));
//  		JavascriptExecutor js = (JavascriptExecutor) driver;
//  		js.executeScript("arguments[0].click;", subMenu);
  		Actions action = new Actions(driver);
  		action.moveToElement(subMenu).perform();
  		subMenu.click();
  		// action.moveToElement(subMenu).click();
  		return this;
  	}
   
	public AL_Hostel_Report_StudentSearch HOSTEL() 
	{
		System.out.println("Click on Hostel");
		WebElement acad_ele = driver.findElement(By.linkText("HOSTEL"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Hostel_Report_StudentSearch Report() 
	{
		System.out.println("Click on Report");
		WebElement subMenu = driver.findElement(By.linkText("Report"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_Report_StudentSearch StudentSearch() 
	{
		System.out.println("Click on Student Search");
		WebElement subMenu = driver.findElement(By.linkText("Student Search"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
}
