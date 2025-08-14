package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
	public class AL_Academics_FR_ChallanReconciliation extends BaseClass {
		
		public AL_Academics_FR_ChallanReconciliation(WebDriver rdriver) {
			driver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		@FindBy(linkText="ACADEMIC")
		private WebElement ACADEMIC;

		@FindBy(linkText="Fee Related")
		private WebElement FeesRelated;
		
		@FindBy(linkText = "Chalan Reconciliation")
		private WebElement ChalanRecon;
		
		@FindBy(id="ctl00_ContentPlaceHolder1_btnview")
		private WebElement ViewChallan;
		

		@FindBy(id="ctl00_ContentPlaceHolder1_btnExcelReport")
		private WebElement PenChallanExcel;
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		public AL_Academics_FR_ChallanReconciliation ACADEMIC() {
			System.out.println("Admin ACADEMIC menu selected");
			Actions action = new Actions(driver);
			action.moveToElement(ACADEMIC).build().perform();	
			return this;
		}
		public AL_Academics_FR_ChallanReconciliation FeesRelated() {
			System.out.println("Fee Related submenu selected");
			Actions action = new Actions(driver);
			action.moveToElement(FeesRelated);
			action.click().build().perform();
			return this;
		}
		
		public AL_Academics_FR_ChallanReconciliation ChalanRecon() {
			System.out.println("click on Chalan Reconciliation");
			ChalanRecon.click();
			return this;
		}
		
		public AL_Academics_FR_ChallanReconciliation PendingChalan() {
			System.out.println("Select Pending Challans");
			WebElement stat = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlchalanstatus"));
			Select status = new Select(stat);
			status.selectByVisibleText("Pending Challans");
			return this;
		}
		public AL_Academics_FR_ChallanReconciliation ViewChallan() {
			System.out.println("Click on view Challan Button");
			ViewChallan.click();
			return this;
		}
		
		public AL_Academics_FR_ChallanReconciliation PenChallanExcel() {
			System.out.println("Click on Pending Challan Excel");
			PenChallanExcel.click();
			return this;
		}
		
		
}
