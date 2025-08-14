package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_AR_BulkUpdateOfPhoto extends BaseClass {

		public AL_Academic_AR_BulkUpdateOfPhoto(WebDriver rdriver) {
			driver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
		private WebElement School_Institute;
		@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")
		private WebElement Degree;
		@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container")
		private WebElement Programme_Branch;
		@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmbatch-container")
		private WebElement Admbatch;
		@FindBy(id = "ctl00_ContentPlaceHolder1_rboStudent_1")
		private WebElement Fphoto;
		@FindBy(id = "ctl00_ContentPlaceHolder1_rboStudent_2")
		private WebElement Sphoto;
		@FindBy(id = "ctl00_ContentPlaceHolder1_butShow")
		private WebElement Showbtn;
		
		@FindBy(css = "#ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl0_fuStudPhoto")
		private WebElement Choosebtn;
		
		@FindBy(id = "ctl00_ContentPlaceHolder1_butSubmit")
		private WebElement submitbtn;
		@FindBy(id = "ctl00_ContentPlaceHolder1_butReport")
		private WebElement Photreportbtn;
		@FindBy(id = "ctl00_ContentPlaceHolder1_btnSignReport")
		private WebElement Signreportbtn;
		@FindBy(className = "select2-search__field")
		private WebElement SearchBoxOfDropDown;
		
		public AL_Academic_AR_BulkUpdateOfPhoto School_Instituteddl() 
		{
			System.out.println("School/Institute -> Crescent School of Architecture - Chennai");
			click(School_Institute);
			sendKeys(SearchBoxOfDropDown, "Crescent School of Architecture - Chennai");
			SearchBoxOfDropDown.sendKeys(Keys.ENTER);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto Degreeddl() 
		{
			System.out.println("Degree -> Bachelor of Architecture");
			click(Degree);
			sendKeys(SearchBoxOfDropDown, "Bachelor of Architecture");
			SearchBoxOfDropDown.sendKeys(Keys.ENTER);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto Programme_Branchddl()
		{
			System.out.println("Programme/Branch -> Architecture");
			click(Programme_Branch);
			sendKeys(SearchBoxOfDropDown, "Architecture");
			SearchBoxOfDropDown.sendKeys(Keys.ENTER);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto AdmissionBatch() 
		{
			System.out.println("Admission Batch -> 2019-20");
			click(Admbatch);
			sendKeys(SearchBoxOfDropDown, "2019-20");
			SearchBoxOfDropDown.sendKeys(Keys.ENTER);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto FormatPhoto() {
			System.out.println("Select format-> Photo");
			click(Fphoto);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto Formatsignature() {
			System.out.println("Select format-> Signature");
			click(Sphoto);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto ShowButton() {
			System.out.println("Click on Show Button");
			click(Showbtn);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto ChoosePhoto() throws InterruptedException 
		{
			
			System.out.println("Select Photo");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement file = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_lvUpdatePhoto_ctrl0_fuStudPhoto"));
			Thread.sleep(3000);
			executor.executeScript("arguments[0].click();", file);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto submitbutton() 
		{
			System.out.println("click on Submit");
			click(submitbtn);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto Showphotoreport() 
		{
			System.out.println("click on Show Photo Report");
			click(Photreportbtn);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto Showsignreport() 
		{
			System.out.println("click on Show sign Report");
			click(Signreportbtn);
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto ACADEMIC() 
		{
			System.out.println("Click on Academic");
			WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
			Actions action = new Actions(driver);
			action.moveToElement(acad_ele).perform();
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto AdministrativeRelated() 
		{
			System.out.println("Click on Administrative Related");
			WebElement subMenu = driver.findElement(By.linkText("Administrative Related"));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click;", subMenu);
			Actions action = new Actions(driver);
			action.moveToElement(subMenu).perform();
			subMenu.click();
			// action.moveToElement(subMenu).click();
			return this;
		}
		
		public AL_Academic_AR_BulkUpdateOfPhoto BulkUpdateOfPhoto()
		{
			System.out.println("Click on Bulk Update Of Photo");
			WebElement optn = driver.findElement(By.linkText("Bulk Update Of Photo"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView();", optn);
			js2.executeScript("arguments[0].click;", optn);
			optn.click();
			return this;
		}
		
}
