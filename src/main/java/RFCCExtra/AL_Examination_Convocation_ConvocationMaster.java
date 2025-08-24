package RFCCExtra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Examination_Convocation_ConvocationMaster extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Convocation") private WebElement convocation;

	
	public AL_Examination_Convocation_ConvocationMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_Convocation_ConvocationMaster EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_Convocation_ConvocationMaster Click_Convocation() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(convocation).click().build().perform();
		return this;
	}
	
	public AL_Examination_Convocation_ConvocationMaster Click_Edit_btn() {
		System.out.println("Click on Edit btn");
		WebElement edit_btn=driver.findElement(By.xpath("(//input[@type='image'])[2]"));
		click(edit_btn);
		return this;
	}
	
	public AL_Examination_Convocation_ConvocationMaster Click_ActiveSatatus_chkBox() {
		System.out.println("Click on Active Satatus chk box");
		WebElement active_status=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucmaster_chkColumn1"));
		click(active_status);
		return this;
	}
	
	public AL_Examination_Convocation_ConvocationMaster Click_Submit_btn() {
		System.out.println("Click on Submit btn");
		WebElement submit_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucmaster_btnSubmit"));
		click(submit_btn);
		return this;
	}
}
