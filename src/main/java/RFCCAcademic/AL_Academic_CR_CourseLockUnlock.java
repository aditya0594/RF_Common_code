package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_CourseLockUnlock extends BaseClass
{
	public AL_Academic_CR_CourseLockUnlock(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl27_lbLink") private WebElement CourseLockUnlock;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme") private WebElement schemePath;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowData") private WebElement showdataBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_cbRow") private WebElement chkBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnLock") private WebElement lockBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUnlock") private WebElement unLockBtn;
//	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowData") private WebElement showdataBtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_CourseLockUnlock Click_CourseLockUnlock()throws InterruptedException {
		System.out.println("Click on Course Lock Unlock");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",CourseLockUnlock);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CourseLockUnlock);
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Select_Degree()throws InterruptedException {
		System.out.println("Select Degree => Bachelor of Architecture");
		Thread.sleep(2000);

		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Select_SchemePath()throws InterruptedException {
		System.out.println("Select Scheme Path => B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		Thread.sleep(2000);

		Select select = new Select(schemePath);
		select.selectByValue("1");
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Select_Semister()throws InterruptedException {
		System.out.println("Select Semister => I");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='multiselect btn btn-default']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='1'])[1]")).click();
		
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Click_ShowDataBtn()throws InterruptedException {
		System.out.println("Click on Show Data Btn");
		click(showdataBtn);
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Click_CheckBox()throws InterruptedException {
		System.out.println("Click on Check Box");
		click(chkBox);
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Click_LockBtn()throws InterruptedException {
		System.out.println("Click on Lock Btn");
		click(lockBtn);
		return this;
	}
	
	public AL_Academic_CR_CourseLockUnlock Click_UnlockBtn()throws InterruptedException {
		System.out.println("Click on Unlock Btn");
		click(unLockBtn);
		return this;
	}
	
	
}
