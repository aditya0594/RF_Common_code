package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.qa.pages.academic.AL_Acadm_CR_BulkCourseRegistration;

import utility.BaseClass;

public class AL_Examination_PEA_InvigilatorEntry extends BaseClass
{
	@FindBy(linkText="EXAMINATION") private WebElement Examination;
	@FindBy(linkText ="Invigilator Entry") private WebElement InvigilatoryEntry;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl0_cbRow") private WebElement checkBox_NishaKhanam;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl1_cbRow") private WebElement checkBox_DrSathickbasha;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl2_cbRow") private WebElement checkBox_Saibulla;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl3_cbRow") private WebElement checkBox_MrThilakvathi;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl4_cbRow") private WebElement checkBox_madumathi;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl4_cbRow") private WebElement checkBox_venkatesaran;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl6_cbRow") private WebElement checkBox_jayaLaskshmi;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl7_cbRow") private WebElement checkBox_DiwarisudanDiran;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl8_cbRow") private WebElement checkBox_scSaritha;

	@FindBy(id="ctl00_ContentPlaceHolder1_lvInvigilator_ctrl2_txtDuties") private WebElement Duties_saiBulla;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSubmit") private WebElement SubmitBtn;

	public AL_Examination_PEA_InvigilatorEntry(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public AL_Examination_PEA_InvigilatorEntry Examination() {
		System.out.println("Click on Examination");
		WebElement bdc_ele = driver.findElement(By.linkText("EXAMINATION"));
		Actions action=new Actions(driver);
		action.moveToElement(bdc_ele).perform();
		return this;
	}
	
	public AL_Examination_PEA_InvigilatorEntry PreExaminationActivity() throws InterruptedException {
		System.out.println("Click on PreExaminationActivity");
		Thread.sleep(3000);
		WebElement subMenu_ele = driver.findElement(By.linkText("Pre Examination Activities"));
		//Actions action=new Actions(driver);
		//action.moveToElement(subMenu_ele).perform();
		subMenu_ele.click();
		return this;
	}
	
	public AL_Examination_PEA_InvigilatorEntry InvigilatorEntry() {
		System.out.println("Click on InvigilatorEntry");
		InvigilatoryEntry.click();
		return this;
	}
	
	public AL_Examination_PEA_InvigilatorEntry InvigilatorMaster() {
		System.out.println("Uncheck all masters");
		if(!checkBox_NishaKhanam.isSelected())
		checkBox_NishaKhanam.click();
		
		if(!checkBox_NishaKhanam.isSelected())
		checkBox_DrSathickbasha.click();
		
		if(!checkBox_Saibulla.isSelected())
		checkBox_Saibulla.click();
		
		if(!checkBox_MrThilakvathi.isSelected())
		checkBox_MrThilakvathi.click();
		
		if(!checkBox_madumathi.isSelected())
		checkBox_madumathi.click();
		
		if(!checkBox_venkatesaran.isSelected())
		checkBox_venkatesaran.click();
		
		if(!checkBox_jayaLaskshmi.isSelected())
		checkBox_jayaLaskshmi.click();
		
		if(!checkBox_DiwarisudanDiran.isSelected())
		checkBox_DiwarisudanDiran.click();
		
		if(!checkBox_scSaritha.isSelected())
		checkBox_scSaritha.click();
		
		System.out.println("Select one entry");
		checkBox_Saibulla.click();
		
		Duties_saiBulla.clear();
		Duties_saiBulla.sendKeys("4");
		
//		SubmitBtn.click();
		
		return this;
	}
	
	public AL_Examination_PEA_InvigilatorEntry SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit button");
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", SubmitBtn);
		js2.executeScript("arguments[0].click;", SubmitBtn);
		SubmitBtn.click();
		return this;
		
	}
	
}
